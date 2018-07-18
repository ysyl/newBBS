package bbs.subscriptionsystem.action.provider;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.action.DAO.ForumTrendActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.ForumSubscription;

@Component
public class ForumTrendActionProvider implements ActionProvider {
	
	private ForumTrendActionDAO forumTrendActionDAO;

	public ForumTrendActionDAO getForumTrendActionDAO() {
		return forumTrendActionDAO;
	}

	@Autowired
	public void setForumTrendActionDAO(ForumTrendActionDAO forumTrendActionDAO) {
		this.forumTrendActionDAO = forumTrendActionDAO;
	}

	@Override
	public List<? extends BaseAction> getAllActionBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<? extends BaseSubscription<?>>) subscription.getClass())) throw new IllegalArgumentException();
		ForumSubscription forumSubscription = (ForumSubscription) subscription;
		Integer forumId = forumSubscription.getTarget().getId();
		Date lastReadTime = forumSubscription.getLastReadTime();
		List<ForumTrendAction> actions = forumTrendActionDAO.selectAllForumTrendActionByForumIdAfterLastReadTime(forumId, lastReadTime);
		return actions;
	}

	@Override
	public boolean support(Class<? extends BaseSubscription<?>> subscriptionClass) {
		// TODO Auto-generated method stub
		return subscriptionClass.isAssignableFrom(ForumSubscription.class);
	}

	@Override
	public Integer getActionCountBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<? extends BaseSubscription<?>>) subscription.getClass())) throw new IllegalArgumentException();
		ForumSubscription forumSubscription = (ForumSubscription) subscription;
		Integer count = forumTrendActionDAO.countByForumSubscription(forumSubscription);
		return count;
	}

}
