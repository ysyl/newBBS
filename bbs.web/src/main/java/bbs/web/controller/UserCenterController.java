package bbs.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bbs.form.utils.PageParam;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;
import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;
import bbs.security.utils.PrincipalChecker;
import bbs.usercenter.collection.DAO.entity.CommodyCollection;
import bbs.usercenter.service.UserCenterService;

@Controller
@RequestMapping("/usercenter")
public class UserCenterController {
	
	private BbsService bbsService;
	
	private UserCenterService userCenterService;
	
	private PrincipalChecker principalChecker;

	@Autowired
	public UserCenterController(BbsService bbsService, UserCenterService userCenterService,
			PrincipalChecker principalChecker) {
		super();
		this.bbsService = bbsService;
		this.userCenterService = userCenterService;
		this.principalChecker = principalChecker;
	}

	@GetMapping("/user/{userId}")
	public String usercenter(@PathVariable("userId") long userId, Model model) {
		User user = bbsService.getUser(userId);
		//temp
		PageParam pageParam = new PageParam(0, 20);
		List<Topic> topics = bbsService.getTopicListByUid(userId, pageParam);
		List<CommodyCollection> commodyCollections = userCenterService.getAllCommodyCollectionByUserId(userId);
		Map<Long, Boolean> commodyCollectedSituation = new HashMap<>();

		List<Long> commodyIdList = commodyCollections.parallelStream().map( collection -> collection.getCommody().getId())
				.collect(Collectors.toList());
		if (commodyIdList != null && !commodyIdList.isEmpty())
			commodyCollectedSituation = userCenterService.isCollectedCommodyList(user.getId(), commodyIdList);

		MyLogger.info(topics.size() + " \n\n\n");
		model.addAttribute("user", user);
		model.addAttribute("topics", topics);
		model.addAttribute("commodyCollections", commodyCollections);
		model.addAttribute("commodyCollectedSituation", commodyCollectedSituation);
		model.addAttribute("principalChecker", principalChecker);
		return "usercenter";
	}
	
}
