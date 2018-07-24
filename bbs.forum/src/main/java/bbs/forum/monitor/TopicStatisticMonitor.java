package bbs.forum.monitor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.DAO.TopicDAO;
import bbs.forum.DTO.Topic;
import bbs.forum.form.PubPostForm;

@Aspect
@Component
public class TopicStatisticMonitor {
	
	private TopicDAO topicDAO;

	@Autowired
	public TopicStatisticMonitor(TopicDAO topicDAO) {
		super();
		this.topicDAO = topicDAO;
	}

	@Pointcut("execution(* bbs.forum.service.BbsService.getTopic(..))"
			+ " && args(topicId)")
	public void getTopic(long topicId) {};
	
	@Pointcut("execution(* bbs.forum.service.BbsService.savePost(..))"
			+ " && args(uid, topicId, pubPostForm)")
	public void pubPost(long uid, long topicId, PubPostForm pubPostForm) {}
	
	@AfterReturning(pointcut = "getTopic(topicId)", returning = "topic")
	public void monitorViewTopic(long topicId, Topic topic) {
		topicDAO.viewsTopic(topicId);
	}
	
	@AfterReturning(pointcut = "pubPost(uid, topicId, pubPostForm)", returning = "postId")
	public void monitorReplyTopic(long uid, long topicId, PubPostForm pubPostForm, long postId) {
		topicDAO.replyTopic(topicId);
	}

}
