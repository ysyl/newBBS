package bbs.subscriptionsystem.notice.service;

import java.util.List;

import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.entity.BaseTrendNotice;

public interface NoticeService {

	public NoticeResultMap getNoticeByUid(long uid);
	
	public Integer getNoticeCountByUid(long uid);

	boolean freshLastReadTime(long uid);
}
