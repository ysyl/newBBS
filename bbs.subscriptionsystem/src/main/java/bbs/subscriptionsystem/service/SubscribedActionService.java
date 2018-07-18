package bbs.subscriptionsystem.service;

import java.util.Date;
import java.util.List;

import bbs.forum.form.PubPostForm;
import bbs.helper.PageParam;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;

public interface SubscribedActionService {

	List<TopicTrendAction> getAllTopicTrendActionByIdAfterTime(Long id, Date pubTime, PageParam pageParam);

	List<UserTrendAction<?>> getAllUserTrendActionByUidAfterTime(Long id, Date pubTime, PageParam pageParam);
	
	Integer countActionsByUid(long uid);

	
	List<BaseAction> getAllActionByUid(long uid);

	boolean freshLastReadTime(long uid);
}
