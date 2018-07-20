package bbs.subscriptionsystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.form.utils.PageParam;
import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.action.DAO.TopicTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.UserTrendActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.BaseTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.action.manager.ActionManager;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

@Component
public class SubscribedActionServiceImp implements SubscribedActionService {
	
	private TopicTrendActionDAO topicTrendActionDAO;
	
	private UserTrendActionDAO userTrendActionDAO;
	
	private SubscriptionManager subscriptionManager;
	
	private ActionManager actionManager;

	public TopicTrendActionDAO getTopicTrendActionDAO() {
		return topicTrendActionDAO;
	}

	@Autowired
	public void setTopicTrendActionDAO(TopicTrendActionDAO topicTrendActionDAO) {
		this.topicTrendActionDAO = topicTrendActionDAO;
	}

	public UserTrendActionDAO getUserTrendActionDAO() {
		return userTrendActionDAO;
	}

	@Autowired
	public void setUserTrendActionDAO(UserTrendActionDAO userTrendActionDAO) {
		this.userTrendActionDAO = userTrendActionDAO;
	}

	public SubscriptionManager getSubscriptionManager() {
		return subscriptionManager;
	}

	@Autowired
	public void setSubscriptionManager(SubscriptionManager subscriptionManager) {
		this.subscriptionManager = subscriptionManager;
	}

	public ActionManager getActionManger() {
		return actionManager;
	}

	@Autowired
	public void setActionManger(ActionManager actionManger) {
		this.actionManager = actionManger;
	}

	@Override
	public List<TopicTrendAction> getAllTopicTrendActionByIdAfterTime(Long topicId, Date lastReadTime, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<TopicTrendAction> actions = topicTrendActionDAO
				.selectAllByIdAfterLastReadTime(topicId, lastReadTime, pageParam);
		return actions;
	}

	@Override
	public List<UserTrendAction<?>> getAllUserTrendActionByUidAfterTime(Long uid, Date pubTime, PageParam pageParam) {
		// TODO Auto-generated method stub
		//暂且保留分页参数
		List<UserTrendAction<?>> actions = userTrendActionDAO.selectAllByUidAfterLasterReadTime(uid, pubTime);
		return actions;
	}
	
	private void freshLastReadTime(BaseSubscription<?> subscription) {
		MyLogger.info("\n\n\n刷新订阅时间\n\n\n");
		subscriptionManager.updateLastReadTime(subscription);
	}

	@Override
	public List<BaseAction> getAllActionByUid(long uid) {
		// TODO Auto-generated method stub
		List<BaseSubscription<?>> subscriptions = subscriptionManager.getAllSubscriptions(uid);
		List<BaseAction> actions = new ArrayList<>();
		for (BaseSubscription<?> subscription : subscriptions ) {
			actions.addAll(actionManager.getAllActionBySubscription(subscription));
			freshLastReadTime(subscription);
		}
		return actions;
	}

	@Override
	public Integer countActionsByUid(long uid) {
		// TODO Auto-generated method stub
		List<BaseSubscription<?>> subscriptions = subscriptionManager.getAllSubscriptions(uid);
		Integer count = 0;
		for (BaseSubscription<?> subscription : subscriptions ) {
			count += actionManager.countActionBySubscription(subscription);
		}
		return count;
	}

	@Override
	public boolean freshLastReadTime(long uid) {
		// TODO Auto-generated method stub
		List<BaseSubscription<?>> subscriptions = subscriptionManager.getAllSubscriptions(uid);
		for(BaseSubscription<?> subscription : subscriptions) {
			freshLastReadTime(subscription);
		}
		return true;
	}

}
