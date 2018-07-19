package bbs.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbs.security.helper.SecurityHelper;
import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private NoticeService noticeService;
	
	private SecurityHelper helperService;

	@Autowired
	public NoticeController(NoticeService noticeService, SecurityHelper helperService) {
		super();
		this.noticeService = noticeService;
		this.helperService = helperService;
	}
	
	private class NoticeResult {
		private String contextPath;
		private List<BaseNotice> notices;
		
		public NoticeResult(String contextPath, List<BaseNotice> notices) {
			super();
			this.contextPath = contextPath;
			this.notices = notices;
		}
		public String getContextPath() {
			return contextPath;
		}
		public void setContextPath(String contextPath) {
			this.contextPath = contextPath;
		}
		public List<BaseNotice> getNotices() {
			return notices;
		}
		public void setNotices(List<BaseNotice> notices) {
			this.notices = notices;
		}
		
	}


	//ajax拉取通知，用于第一次点开通知面版, 会刷新订阅时间
	@GetMapping("/trend/all")
	@ResponseBody
	public NoticeResult getNotices(HttpServletRequest req) {
		Long uid = helperService.getCurrentUserId();
		List<BaseNotice> notices = noticeService.getAllNoticeByUid(uid);
		return new NoticeResult(req.getContextPath(), notices);
	}
	
	@GetMapping("/trend/count")
	@ResponseBody
	public int getNoticesCount() {
		Long uid = helperService.getCurrentUserId();
		return noticeService.getNoticeCountByUid(uid);
	}
	
	@GetMapping("/trend/freshLastReadTime")
	@ResponseBody
	public String freshTrendLastReadTime() {
		Long uid = helperService.getCurrentUserId();
		boolean isFreshed = noticeService.freshLastReadTime(uid);
		return isFreshed ? "SUCCESS":"FAILURE";
	}
}
