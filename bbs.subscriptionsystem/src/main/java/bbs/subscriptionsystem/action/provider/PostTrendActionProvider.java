package bbs.subscriptionsystem.action.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.action.DAO.PostTrendActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;

@Component
public class PostTrendActionProvider implements ActionProvider {
	
	private PostTrendActionDAO postTrendActionDAO;

	public PostTrendActionDAO getPostTrendActionDAO() {
		return postTrendActionDAO;
	}

	@Autowired
	public void setPostTrendActionDAO(PostTrendActionDAO postTrendActionDAO) {
		this.postTrendActionDAO = postTrendActionDAO;
	}

	@Override
	public List<? extends BaseAction> getAllActionBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<? extends BaseSubscription<?>>) subscription.getClass())) throw new IllegalArgumentException();
		
		List<PostTrendAction> actions = postTrendActionDAO.selectAllBySubscription((PostSubscription) subscription);
		return actions;
	}

	@Override
	public boolean support(Class<? extends BaseSubscription<?>> subscriptionClass) {
		// TODO Auto-generated method stub
		return PostSubscription.class.isAssignableFrom(subscriptionClass);
	}

}
