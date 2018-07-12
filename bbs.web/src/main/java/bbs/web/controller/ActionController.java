package bbs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bbs.subscriptionsystem.service.SubscribedActionService;
import bbs.subscriptionsystem.action.entity.BaseAction;

@Controller
@RequestMapping("/action")
public class ActionController {

	private SubscribedActionService subService;
	
	@Autowired
	public ActionController(SubscribedActionService subService) {
		super();
		this.subService = subService;
	}

	@GetMapping("/test")
	@ResponseBody
	public List<BaseAction> getAllAction(@RequestParam("userId") long uid) {
		System.out.println("\n\n测试action控制器123124");
		return subService.getAllActionByUid(uid);   
	}
}
