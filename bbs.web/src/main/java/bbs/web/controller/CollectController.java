package bbs.web.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.usercenter.service.UserCenterService;
import bbs.security.utils.HasNotLoginException;
import bbs.security.utils.IAuthenticationFacade;

@Controller
@RequestMapping("/usercenter/collect")
public class CollectController {
	
	private UserCenterService userCenterService;
	
	private IAuthenticationFacade authenticationFacede;  
	
	@Autowired
	public CollectController(UserCenterService userCenterService, IAuthenticationFacade authenticationFacede) {
		super();
		this.userCenterService = userCenterService;
		this.authenticationFacede = authenticationFacede;
	}

	@PostMapping("/post/{postId}")
	@ResponseBody
	public String collectPost(@PathVariable("postId") long postId) throws RepetitiveCollectException, HasNotLoginException {
		Long uid = authenticationFacede.getUserId();
		userCenterService.collectPost(uid, postId);
		return "SUCCESS";
	}
	
	@DeleteMapping("/post/{postId}")
	@ResponseBody
	public String uncollectPost(@PathVariable("postId") long postId) throws HasNotLoginException {
		Long uid = authenticationFacede.getUserId();
		userCenterService.uncollectPost(uid, postId);
		return "SUCCESS";
	}
	
	@PostMapping("/topic/{topicId}")
	@ResponseBody
	public String collectTopic(@PathVariable("topicId") long topicId) throws RepetitiveCollectException, HasNotLoginException {
		Long uid = authenticationFacede.getUserId();
		userCenterService.collectTopic(uid, topicId);
		return "SUCCESS";
	}
	
	@DeleteMapping("/topic/{topicId}")
	@ResponseBody
	public String uncollectTopic(@PathVariable("topicId") long topicId) throws HasNotLoginException {
		long uid = authenticationFacede.getUserId();
		userCenterService.uncollectTopic(uid, topicId);
		return "SUCCESS";
	}
	
	@PostMapping("/forum/{forumId}")
	@ResponseBody
	public String collectForum(@PathVariable("forumId") int forumId) throws HasNotLoginException {
		long uid = authenticationFacede.getUserId();
		userCenterService.collectForum(uid, forumId);
		return "SUCCESS";
	}
	
	@DeleteMapping("/forum/{forumId}")
	@ResponseBody
	public String uncollectForum(@PathVariable("forumId") int forumId) throws HasNotLoginException {
		long uid = authenticationFacede.getUserId();
		userCenterService.uncollectForum(uid, forumId);
		return "SUCCESS";
	}
	
	@PostMapping("/user/{followingId}")
	@ResponseBody
	public String follow(@PathVariable("followingId") long followingId) throws HasNotLoginException {
		long uid = authenticationFacede.getUserId();
		userCenterService.collectUser(uid, followingId);
		return "SUCCESS";
	}
	
	@DeleteMapping("/user/{followingId}")
	@ResponseBody
	public String unfollow(@PathVariable("followingId") long followingId) throws HasNotLoginException {
		long uid = authenticationFacede.getUserId();
		userCenterService.uncollectUser(uid, followingId);
		return "SUCCESS";
	}
	
}
