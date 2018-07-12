package bbs.subscriptionsystem.subscription.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.form.PubTopicForm;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

@Component
@Aspect
@Transactional
public class TopicSubscriptionMonitor extends AbstractSubscriptionMonitor {
	
	private SubscriptionManager manager;

	public SubscriptionManager getManager() {
		return manager;
	}

	@Autowired
	public void setManager(SubscriptionManager manager) {
		this.manager = manager;
	}

	@AfterReturning( value = "execution(* bbs.forum.service.BBSService.saveTopic(..))"
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

}
