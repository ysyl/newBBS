package bbs.web.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bbs.form.utils.PageParam;
import bbs.forum.DTO.Announce;
import bbs.forum.DTO.Forum;
import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;
import bbs.forum.form.PubPostForm;
import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;
import bbs.security.utils.HasNotLoginException;
import bbs.security.utils.IAuthenticationFacade;
import bbs.subscriptionsystem.action.entity.BaseTrendAction;
import bbs.subscriptionsystem.notice.entity.BaseTrendNotice;
import bbs.subscriptionsystem.notice.service.NoticeService;
import bbs.subscriptionsystem.notice.utils.NoticeBuilder;
import bbs.subscriptionsystem.service.SubscribedActionService;
import bbs.usercenter.service.UserCenterService;
import bbs.usercenter.util.CollectMatcher;
import bbs.web.utils.OwnChecker;
import security.core.DTO.CustomUser;

@Controller
@RequestMapping("/forum")
public class ForumController {
	
	private BbsService bbsService;
	
	private SubscribedActionService subService;
	
	private UserCenterService userCenterService;
	
	private CollectMatcher collectMatcher;
	
	private NoticeService noticeService;
	
	private OwnChecker ownChecker;
	
	private IAuthenticationFacade authenticationFacade;
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
	public ForumController(BbsService bbsService, SubscribedActionService subService,
			UserCenterService userCenterService, CollectMatcher collectMatcher, NoticeService noticeService,
			OwnChecker ownChecker, IAuthenticationFacade authenticationFacade) {
		super();
		this.bbsService = bbsService;
		this.subService = subService;
		this.userCenterService = userCenterService;
		this.collectMatcher = collectMatcher;
		this.noticeService = noticeService;
		this.ownChecker = ownChecker;
		this.authenticationFacade = authenticationFacade;
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
	//todo: 移除获取uid
	@GetMapping("/topic/{topicId}")
	public String topic(@PathVariable("topicId") long topicId,
			@RequestParam(value="pageNo", defaultValue="0") int pageNo, Model model) {
		Long uid;

		PageParam pageParam = new PageParam(pageNo, 20);
		Topic topic = bbsService.getTopic(topicId);
		List<Post> posts = bbsService.getPostList(topicId, pageParam);
		Map<Long, Boolean> postCollectStatus = new HashMap<>();
		Map<Long, Boolean> userCollectStatus = new HashMap<>(); 
		Boolean isTopicCollected = false;
		Map<Long, Boolean> postOwnStatus = new HashMap<>();
		Boolean isMyTopic = false;
		try {
			uid = authenticationFacade.getUserId();
			postCollectStatus = collectMatcher.checkPostCollectStatus(posts, uid);
			userCollectStatus = collectMatcher.checkUserCollectStatus(posts, uid);
			isTopicCollected = collectMatcher.checkTopicIsCollected(topicId);
			postOwnStatus = ownChecker.checkPostListOwnStatus(posts);
			isMyTopic	= ownChecker.isMyTopic(topicId);
		} catch (HasNotLoginException e) {
			// TODO Auto-generated catch block
			for (Post post : posts) {
				postCollectStatus.put(post.getId(), false);
				userCollectStatus.put(post.getId(), false);
				postOwnStatus.put(post.getId(), false);
			}
		}
		
		MyLogger.info("\n\n post收藏情况：" + postCollectStatus);
		MyLogger.info("\n\n user收藏情况：" + userCollectStatus);
		
		model.addAttribute("topic", topic);
		model.addAttribute("posts", posts);
		model.addAttribute("postCollectionStatus", postCollectStatus);
		model.addAttribute("userCollectionStatus", userCollectStatus);
		model.addAttribute("postOwnStatus", postOwnStatus);
		model.addAttribute("isMyTopic", isMyTopic);
		model.addAttribute("collectMatcher", collectMatcher);
		model.addAttribute("isTopicCollected", isTopicCollected);
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
		MyLogger.info(topics.size() + " \n\n\n");
		model.addAttribute("user", user);
		model.addAttribute("topics", topics);
		return "usercenter";
	}

	
}
