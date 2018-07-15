package bbs.usercenter.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.helper.service.HelperService;

@Aspect
@Component
public class MatcherFreshAspect {
	
	private CollectMatcher collectMatcher;
	
	private HelperService helperService;
	
	@Autowired
	public MatcherFreshAspect(CollectMatcher collectMatcher, HelperService helperService) {
		super();
		this.collectMatcher = collectMatcher;
		this.helperService = helperService;
	}

	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collect*(..))")
	public void collect() {}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.collect*(..))")
	public void uncollect() {}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.follow(..))")
	public void follow() {}
	
	@Pointcut("execution(* bbs.usercenter.service.UserCenterService.unfollow(..))")
	public void unfollow() {}
	
	@Pointcut("execution(* bbs.forum.service.BBSService.getPostList(..))")
	public void getPostList() {}
	
	@Pointcut("execution(* bbs.forum.service.BBSService.getTopicList(..))")
	public void getTopicList() {}

	@Pointcut("execution(* bbs.forum.service.BBSService.getTopic(..))")
	public void getTopic() {}
	
	@After("collect()")
	public void freshCollectionAfterCollect() {
		Long uid = helperService.getCurrentUserId();
		collectMatcher.freshCollections(uid);
	}

	@After("follow()")
	public void freshCollectionAfterFollow() {
		Long uid = helperService.getCurrentUserId();
		collectMatcher.freshCollections(uid);
	}
	
	@After("uncollect()")
	public void freshAfterUncollect() {
		collectMatcher.freshCollections(helperService.getCurrentUserId());
	}
	
	@After("unfollow()")
	public void freshAfterUnfollow() {
		collectMatcher.freshCollections(helperService.getCurrentUserId());
	}
	
	@After("getPostList()")
	public void freshAfterViewTopic() {
		collectMatcher.freshCollections(helperService.getCurrentUserId());
	}

	@After("getTopicList()")
	public void freshAfterViewForum() {
		collectMatcher.freshCollections(helperService.getCurrentUserId());
	}
}
