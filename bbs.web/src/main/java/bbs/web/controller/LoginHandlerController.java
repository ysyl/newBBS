package bbs.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import bbs.forum.DTO.Announce;
import bbs.forum.DTO.Forum;
import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;
import bbs.forum.form.PubPostForm;
import bbs.forum.service.BBSService;
import bbs.helper.PageParam;
import bbs.helper.service.HelperService;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.service.NoticeService;
import bbs.subscriptionsystem.notice.utils.NoticeBuilder;
import bbs.subscriptionsystem.service.SubscribedActionService;
import bbs.usercenter.service.UserCenterService;
import bbs.usercenter.util.CollectMatcher;

@Controller
public class LoginHandlerController {
	
	private BBSService bbsService;
	
	private SubscribedActionService subService;
	
	private HelperService helperService;
	
	private UserCenterService userCenterService;
	
	private CollectMatcher collectMatcher;
	
	private NoticeService noticeService;
//	
//	@PostConstruct
//	public void init() {
//		//事先订阅
//		Long uid = helperService.getCurrentUserId();
//		userCenterService.collectTopic(uid, 1L);
//		//事先插入数据以使得产生通知
//		PubPostForm pubPostForm = new PubPostForm();
//		pubPostForm.setContent("新内容");
//		pubPostForm.setReplyPostId(null);
//		bbsService.savePost(uid, 1L, pubPostForm);
//
//	}
//	

	@Autowired
	public LoginHandlerController(BBSService bbsService, SubscribedActionService subService,
			HelperService helperService, UserCenterService userCenterService, CollectMatcher collectMatcher,
			NoticeService noticeService) {
		super();
		this.bbsService = bbsService;
		this.subService = subService;
		this.helperService = helperService;
		this.userCenterService = userCenterService;
		this.collectMatcher = collectMatcher;
		this.noticeService = noticeService;
	}


	@GetMapping("/")
	public String index(Model model) {
		Long uid = helperService.getCurrentUserId();
		List<Forum> forums = bbsService.getAllForums(); 
		List<BaseAction> actions = subService.getAllActionByUid(uid);
		model.addAttribute("forums", forums);
		model.addAttribute("actions", actions);
		System.out.println("\n\n\n: " + actions.size());
		return "index";
	}
	

	@GetMapping("/forum/{forumId}")
	public String forum(@PathVariable("forumId") int forumId, 
			@RequestParam(value="pageNo", defaultValue="0") int pageNo, Model model) {
		PageParam pageParam = new PageParam(pageNo, 20);
		List<Topic> topicList = bbsService.getTopicListByForumId(forumId, pageParam);
		List<Announce> announceList =bbsService.getAllAnnounceByForumId(forumId, pageParam);
		Forum forum = bbsService.getForum(forumId);
		model.addAttribute("forum", forum);
		model.addAttribute("topics", topicList);
		model.addAttribute("announces", announceList);
		return "forum";
	}
	
	@GetMapping("/topic/{topicId}")
	public String topic(@PathVariable("topicId") long topicId,
			@RequestParam(value="pageNo", defaultValue="0") int pageNo, Model model) {
		long uid = helperService.getCurrentUserId();
		PageParam pageParam = new PageParam(pageNo, 20);
		Topic topic = bbsService.getTopic(topicId);
		List<Post> posts = bbsService.getPostList(topicId, pageParam);
		Map<Post, Boolean> postCollectStatus = collectMatcher.checkPostCollectStatus(posts, uid);
		Boolean isTopicCollected = collectMatcher.checkTopicIsCollected(topicId);
		//获取通知
		List<BaseNotice> notices = noticeService.getAllNoticeByUid(uid);
		Map<String, List<BaseNotice>> noticeMap = new HashMap<>();
		noticeMap.put("trend", notices);
		
		model.addAttribute("topic", topic);
		model.addAttribute("posts", posts);
		model.addAttribute("postMap", postCollectStatus);
		model.addAttribute("collectMatcher", collectMatcher);
		model.addAttribute("isTopicCollected", isTopicCollected);
		model.addAttribute("noticeMap", noticeMap);
		return "topic";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(value="title", required = false) String title,
			@RequestParam(value="pageNo", defaultValue="0") int pageNo, Model model) {
		PageParam pageParam = new PageParam(pageNo, 20);
		List<Topic> resultTopics = bbsService.searchTopic(title, pageParam);
		model.addAttribute("resultTopics", resultTopics);
		model.addAttribute("key", title);
		return "search";
	}
	
	@GetMapping("/user/{userId}")
	public String usercenter(@PathVariable("userId") long userId, Model model) {
		User user = bbsService.getUser(userId);
		//temp
		PageParam pageParam = new PageParam(0, 20);
		List<Topic> topics = bbsService.getTopicListByUid(userId, pageParam);
		System.out.println(topics.size() + " \n\n\n");
		model.addAttribute("user", user);
		model.addAttribute("topics", topics);
		return "usercenter";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
