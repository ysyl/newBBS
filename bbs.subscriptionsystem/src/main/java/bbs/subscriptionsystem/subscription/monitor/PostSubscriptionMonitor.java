package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.Post;
import bbs.forum.form.PubPostForm;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

//鏀惰棌鍙婂彂甯冨悗璁㈤槄
@Order(2)
@Component
@Aspect
public class PostSubscriptionMonitor extends AbstractSubscriptionMonitor {
	
	private SubscriptionManager subscriptionManager;
	
	public SubscriptionManager getSubscriptionManager() {
		return subscriptionManager;
	}

	@Autowired
	public void setSubscriptionManager(SubscriptionManager subscriptionManager) {
		this.subscriptionManager = subscriptionManager;
	}

	//鍏虫敞鍥炲
	@AfterReturning(value = "execution(* bbs.usercenter.service.UserCenterService.collectPost(..))"
			+ " && args(uid, postId)")
	public void monitor(long uid, long postId) {
		subscriptionManager.subscribePost(uid, postId);
	}
	
	//鍙戝竷鍥炲鍚庡叧娉ㄨ嚜宸辩殑鍥炲
	@AfterReturning( value = "execution(* bbs.forum.service.BBSService.savePost(..))"
			+ " && args(uid, topicId, postForm)", returning = "pubPostId")
	public void monitor(long uid, long topicId, PubPostForm postForm, long pubPostId) {
		subscriptionManager.subscribePost(uid, pubPostId);
	}
	
	//鍥炲鏌愪釜鍥炲鍚庯紝鍏虫敞鑷繁鐨勫洖澶�
	@AfterReturning(value = "execution(* bbs.forum.service.BBSService.reply(..))"
			+ " && args(uid, topicId, targetPostId, postForm)", returning = "pubPostId")
	public void monitor(long uid, long topicId, long targetPostId, PubPostForm postForm, long pubPostId) {
		subscriptionManager.subscribePost(uid, pubPostId);
	}

}
