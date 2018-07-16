package bbs.subscriptionsystem.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.utils.NoticeBuilder;
import bbs.subscriptionsystem.service.SubscribedActionService;

@Service
public class NoticeServiceImp implements NoticeService {
	
	private SubscribedActionService subService;

	@Autowired
	public NoticeServiceImp(SubscribedActionService subService) {
		super();
		this.subService = subService;
	}

	@Override
	public List<BaseNotice> getAllNoticeByUid(long uid) {
		// TODO Auto-generated method stub
		return NoticeBuilder.transActionListToNotice(subService.getAllActionByUid(uid));
	}

}
