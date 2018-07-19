package bbs.usercenter.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MatcherFreshAspect {
	
	private CollectMatcher collectMatcher;
	
	@Autowired
	public MatcherFreshAspect(CollectMatcher collectMatcher) {
		super();
		this.collectMatcher = collectMatcher;
	}

	//这里可能会匹配到int的forum
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collect*(..))"
			+ " && args(uid, targetId)")
	public void collect(long uid, long targetId) {}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collectForum(..))"
			+ " && args(uid, forumId)")
	public void collectForum(long uid, int forumId) {}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.uncollect*(..))"
			+ " && args(uid, targetId)")
	public void uncollect(long uid, long targetId) {}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.uncollectForum(..))"
			+ " && args(uid, forumId)")
	public void uncollectForum(long uid, int forumId) {}
	
//	@Pointcut("execution(* bbs.forum.service.BBSService.getPostList(..))")
//	public void getPostList() {}
//	
//	@Pointcut("execution(* bbs.forum.service.BBSService.getTopicList(..))")
//	public void getTopicList() {}
//
//	@Pointcut("execution(* bbs.forum.service.BBSService.getTopic(..))")
//	public void getTopic() {}
	
	@After("collect(uid, targetId)")
	public void freshCollectionAfterCollect(long uid, long targetId) {
		collectMatcher.freshCollections(uid);
	}

	@After("collectForum(uid, forumId)")
	public void freshCollectionAfterCollectForum(long uid, int forumId) {
		collectMatcher.freshCollections(uid);
	}
	
	@After("uncollect(uid, targetId)")
	public void freshAfterUncollect(long uid, long targetId) {
		collectMatcher.freshCollections(uid);
	}

	@After("uncollectForum(uid, forumId)")
	public void freshAfterUncollect(long uid, int forumId) {
		collectMatcher.freshCollections(uid);
	}
	
//	@After("getPostList()")
//	public void freshAfterViewTopic() {
//		collectMatcher.freshCollections(helperService.getCurrentUserId());
//	}
//
//	@After("getTopicList()")
//	public void freshAfterViewForum() {
//		collectMatcher.freshCollections(helperService.getCurrentUserId());
//	}
}
