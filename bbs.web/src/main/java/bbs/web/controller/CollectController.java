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

import bbs.security.helper.SecurityHelper;
import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.usercenter.service.UserCenterService;

@Controller
@RequestMapping("/collect")
public class CollectController {
	
	private SecurityHelper helperService;
	
	private UserCenterService userCenterService;
	
	private Long uid;

	@Autowired
	public CollectController(SecurityHelper helperService, UserCenterService userCenterService) {
		super();
		this.helperService = helperService;
		this.userCenterService = userCenterService;
	}


	@PostMapping("/post/{postId}")
	@ResponseBody
	public String collectPost(@PathVariable("postId") long postId) throws RepetitiveCollectException {
		Long uid = helperService.getCurrentUserId();
		userCenterService.collectPost(uid, postId);
		return "SUCCESS";
	}
	
	@DeleteMapping("/post/{postId}")
	@ResponseBody
	public String uncollectPost(@PathVariable("postId") long postId) {
		Long uid = helperService.getCurrentUserId();
		userCenterService.uncollectPost(uid, postId);
		return "SUCCESS";
	}
	
	@PostMapping("/topic/{topicId}")
	@ResponseBody
	public String collectTopic(@PathVariable("topicId") long topicId) throws RepetitiveCollectException {
		Long uid = helperService.getCurrentUserId();
		userCenterService.collectTopic(uid, topicId);
		return "SUCCESS";
	}
	
	@DeleteMapping("/topic/{topicId}")
	@ResponseBody
	public String uncollectTopic(@PathVariable("topicId") long topicId) {
		long uid = helperService.getCurrentUserId();
		userCenterService.uncollectTopic(uid, topicId);
		return "SUCCESS";
	}
	
	@PostMapping("/forum/{forumId}")
	@ResponseBody
	public String collectForum(@PathVariable("forumId") int forumId) {
		long uid = helperService.getCurrentUserId();
		userCenterService.collectForum(uid, forumId);
		return "SUCCESS";
	}
	
	@DeleteMapping("/forum/{forumId}")
	@ResponseBody
	public String uncollectForum(@PathVariable("forumId") int forumId) {
		long uid = helperService.getCurrentUserId();
		userCenterService.uncollectForum(uid, forumId);
		return "SUCCESS";
	}
	
	@PostMapping("/user/{followingId}")
	@ResponseBody
	public String follow(@PathVariable("followingId") long followingId) {
		long uid = helperService.getCurrentUserId();
		userCenterService.collectUser(uid, followingId);
		return "SUCCESS";
	}
	
	@DeleteMapping("/user/{followingId}")
	@ResponseBody
	public String unfollow(@PathVariable("followingId") long followingId) {
		long uid = helperService.getCurrentUserId();
		userCenterService.uncollectUser(uid, followingId);
		return "SUCCESS";
	}
	
}
