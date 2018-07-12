package bbs.subscriptionsystem.base;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class TestChannelIntercepter extends ChannelInterceptorAdapter {
	
	private final BlockingQueue<Message<?>> messages = new ArrayBlockingQueue<>(100);
	
	private final List<String> destinationPatterns = new ArrayList<>();
	
	private final PathMatcher matcher = new AntPathMatcher();
	
	public void setIncludeDestinationPatterns(String... patterns) {
		this.destinationPatterns.addAll(Arrays.asList(patterns));
	}
	
	public Message<?> awaitMessage(long timeoutInSeconds) throws InterruptedException {
		return this.messages.poll(timeoutInSeconds, TimeUnit.SECONDS);
	}

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		// TODO Auto-generated method stub
		String mes = new String((byte[]) message.getPayload(), Charset.forName("utf-8"));
		System.out.println("\nintercepter presend :" + mes);
		if (this.destinationPatterns.isEmpty()) {
			this.messages.add(message);
		}
		else {
			StompHeaderAccessor headers = StompHeaderAccessor.wrap(message);
			if (headers.getDestination() != null) {
				for (String pattern : this.destinationPatterns) {
					if (this.matcher.match(pattern, headers.getDestination())) {
						this.messages.add(message);
						break;
					}
				}
			}
		}
		return message;
	}

}
