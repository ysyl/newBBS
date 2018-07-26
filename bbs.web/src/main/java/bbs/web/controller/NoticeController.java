package bbs.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbs.security.utils.HasNotLoginException;
import bbs.security.utils.IAuthenticationFacade;
import bbs.subscriptionsystem.notice.entity.BbsTrendNotice;
import bbs.subscriptionsystem.notice.service.NoticeResultMap;
import bbs.subscriptionsystem.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private NoticeService noticeService;
	
	private IAuthenticationFacade authenticationFacade;

	@Autowired
	public NoticeController(NoticeService noticeService, IAuthenticationFacade authenticationFacade) {
		super();
		this.noticeService = noticeService;
		this.authenticationFacade = authenticationFacade;
	}


	//ajax拉取通知，用于第一次点开通知面版, 会刷新订阅时间
	@GetMapping("/trend/all")
	@ResponseBody
	public NoticeResultMap getNotices(HttpServletRequest req) throws HasNotLoginException {
		Long uid = authenticationFacade.getUserId();
		NoticeResultMap notices = noticeService.getNoticeByUid(uid);
		return notices;
	}
	
	@GetMapping("/trend/count")
	@ResponseBody
	public int getNoticesCount() throws HasNotLoginException {
		Long uid = authenticationFacade.getUserId();
		return noticeService.getNoticeCountByUid(uid);
	}
	
	@GetMapping("/trend/freshLastReadTime")
	@ResponseBody
	public String freshTrendLastReadTime() throws HasNotLoginException {
		Long uid = authenticationFacade.getUserId();
		boolean isFreshed = noticeService.freshLastReadTime(uid);
		return isFreshed ? "SUCCESS":"FAILURE";
	}
}
