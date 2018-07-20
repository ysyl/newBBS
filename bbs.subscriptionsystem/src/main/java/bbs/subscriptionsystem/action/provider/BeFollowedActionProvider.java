package bbs.subscriptionsystem.action.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.User;
import bbs.subscriptionsystem.action.DAO.UserTrendActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.BeFollowedAction;
import bbs.subscriptionsystem.action.entity.CollectUserAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.BeFollowedSubscription;

@Component
public class BeFollowedActionProvider implements ActionProvider {
	
	private UserTrendActionDAO userTrendActionDAO;

	@Autowired
	public BeFollowedActionProvider(UserTrendActionDAO userTrendActionDAO) {
		super();
		this.userTrendActionDAO = userTrendActionDAO;
	}

	@Override
	public List<? extends BaseAction> getAllActionBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<? extends BaseSubscription<?>>) subscription.getClass()))
			throw new IllegalArgumentException("订阅必须是BeFollowedSubscription");
		BeFollowedSubscription beFollowedSubscription = (BeFollowedSubscription) subscription;
		Long myUid = subscription.getUser().getId();
		//先取出收藏target是自己的 userTrendAction, 再创建 beFollowedAction;
		//必须是beFollowedSubscription 最后阅读时间以后的，以免取到旧的 UserTrendAction
		List<CollectUserAction> collectUserActionList = userTrendActionDAO.selectAllByFollowingIdAfterLastReadTime(myUid, subscription.getLastReadTime());
		
		List<BeFollowedAction> beFollowedActionList = new ArrayList<>();
		//循环创建BeFollowedAction
		for(CollectUserAction collectUserAction : collectUserActionList) {
			beFollowedActionList.add(new BeFollowedAction(collectUserAction));
		}
		
		return beFollowedActionList;
	}

	@Override
	public Integer getActionCountBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		return userTrendActionDAO.countByFollowingIdAfterLastReadTime(subscription.getUser().getId(), subscription.getLastReadTime());
	}

	@Override
	public boolean support(Class<? extends BaseSubscription<?>> subscriptionClass) {
		// TODO Auto-generated method stub
		return subscriptionClass.equals(BeFollowedSubscription.class);
	}

}
