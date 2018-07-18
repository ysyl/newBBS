package bbs.subscriptionsystem.action.provider;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.action.DAO.UserTrendActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.FollowingSubscription;

@Component
public class UserTrendActionProvider implements ActionProvider {
	
	private UserTrendActionDAO userTrendActionDAO;

	public UserTrendActionDAO getUserTrendActionDAO() {
		return userTrendActionDAO;
	}

	@Autowired
	public void setUserTrendActionDAO(UserTrendActionDAO userTrendActionDAO) {
		this.userTrendActionDAO = userTrendActionDAO;
	}

	@Override
	public List<? extends BaseAction> getAllActionBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<BaseSubscription<?>>) subscription.getClass())) throw new IllegalArgumentException();
		
		Long uid = subscription.getUser().getId();
		Date lastReadTime = subscription.getLastReadTime();
		List<UserTrendAction<?>> actions = userTrendActionDAO.selectAllByUidAfterLasterReadTime(uid, lastReadTime);
		return actions;
	}

	@Override
	public boolean support(Class<? extends BaseSubscription<?>> subscriptionClass) {
		// TODO Auto-generated method stub
		return FollowingSubscription.class.isAssignableFrom(subscriptionClass);
	}

	@Override
	public Integer getActionCountBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<BaseSubscription<?>>) subscription.getClass())) throw new IllegalArgumentException();
		
		Long uid = subscription.getUser().getId();
		Date lastReadTime = subscription.getLastReadTime();
		Integer count = userTrendActionDAO.countByUidAfterLastReadTime(uid, lastReadTime);
		return count;
	}

}
