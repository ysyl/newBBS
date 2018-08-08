package bbs.web.controller;

import java.util.List;

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
import bbs.usercenter.collection.DAO.entity.CommodyCollection;
import bbs.usercenter.service.UserCenterService;

@Controller
@RequestMapping("/usercenter")
public class UserCenterController {
	
	private BbsService bbsService;
	
	private UserCenterService userCenterService;

	@Autowired
	public UserCenterController(BbsService bbsService, UserCenterService userCenterService) {
		super();
		this.bbsService = bbsService;
		this.userCenterService = userCenterService;
	}



	@GetMapping("/user/{userId}")
	public String usercenter(@PathVariable("userId") long userId, Model model) {
		User user = bbsService.getUser(userId);
		//temp
		PageParam pageParam = new PageParam(0, 20);
		List<Topic> topics = bbsService.getTopicListByUid(userId, pageParam);
		List<CommodyCollection> commodyCollections = userCenterService.getAllCommodyCollectionByUserId(userId);
		MyLogger.info(topics.size() + " \n\n\n");
		model.addAttribute("user", user);
		model.addAttribute("topics", topics);
		model.addAttribute("commodyCollections", commodyCollections);
		return "usercenter";
	}
	
}
