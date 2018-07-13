package bbs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbs.helper.service.HelperService;
import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.usercenter.service.UserCenterService;

@Controller
@RequestMapping("/collect")
public class CollectController {
	
	private HelperService helperService;
	
	private UserCenterService userCenterService;

	@Autowired
	public CollectController(HelperService helperService, UserCenterService userCenterService) {
		super();
		this.helperService = helperService;
		this.userCenterService = userCenterService;
	}


	@GetMapping("/post/{postId}")
	@ResponseBody
	public String collectPost(@PathVariable("postId") long postId) throws RepetitiveCollectException {
		System.out.println(postId + "\n\n\n");
		Long uid = helperService.getCurrentUserId();
		userCenterService.collectPost(uid, postId);
		return "SUCCESS";
	}
	
}
