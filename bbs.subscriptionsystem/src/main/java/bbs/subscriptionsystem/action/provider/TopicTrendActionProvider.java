package bbs.subscriptionsystem.action.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.action.DAO.TopicTrendActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;

@Component
public class TopicTrendActionProvider implements ActionProvider {
	
	private TopicTrendActionDAO topicTrendActionDAO;

	public TopicTrendActionDAO getTopicTrendActionDAO() {
		return topicTrendActionDAO;
	}

	@Autowired
	public void setTopicTrendActionDAO(TopicTrendActionDAO topicTrendActionDAO) {
		this.topicTrendActionDAO = topicTrendActionDAO;
	}

	@Override
	public List<TopicTrendAction> getAllActionBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<? extends BaseSubscription<?>>) subscription.getClass())) throw new IllegalArgumentException();
		
		List<TopicTrendAction> actions = topicTrendActionDAO.selectAllBySubscription((TopicSubscription) subscription);
		return actions;
	}

	@Override
	public boolean support(Class<? extends BaseSubscription<?>> subscriptionClass) {
		// TODO Auto-generated method stub
		return TopicSubscription.class.isAssignableFrom(subscriptionClass);
	}

	@Override
	public Integer getActionCountBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<? extends BaseSubscription<?>>) subscription.getClass())) throw new IllegalArgumentException();
		MyLogger.info("\n\n topic count");
		Integer count = topicTrendActionDAO.CountBySubscription((TopicSubscription) subscription);
		MyLogger.info("\n\n topic count" + count);
		return count;
	}

}
