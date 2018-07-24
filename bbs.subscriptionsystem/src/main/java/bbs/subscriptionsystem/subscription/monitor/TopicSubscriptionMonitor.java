package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.form.PubTopicForm;
import bbs.subscriptionsystem.service.SubscriptionService;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;

@Component
@Aspect
@Transactional
public class TopicSubscriptionMonitor  {
	
	private SubscriptionService manager;
	
	@Autowired
	public TopicSubscriptionMonitor( SubscriptionService manager) {
		super();
		this.manager = manager;
	}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.uncollectTopic(..))"
			+ " && args(uid, topicId)")
	public void uncollect(long uid, long topicId) {};

	@AfterReturning( value = "execution(* bbs.forum.service.BbsService.saveTopic(..))"
			+ " && args(uid, topicForm)", returning = "topicId")
	public void monitor(long uid, PubTopicForm topicForm, long topicId) {
		// TODO Auto-generated method stub
		manager.subscribeTopic(uid, topicId);
	}
	
	@AfterReturning( value = "execution(* bbs.usercenter.service.UserCenterService.collectTopic(..))"
			+ " && args(uid, topicId)")
	public void monitor(long uid, long topicId) {
		manager.subscribeTopic(uid, topicId);
	}
	
	@AfterReturning("uncollect(uid, topicId)")
	public void monitorUncollect(long uid, long topicId) {
		manager.unsubscribeTopic(uid, topicId);
	}

}
