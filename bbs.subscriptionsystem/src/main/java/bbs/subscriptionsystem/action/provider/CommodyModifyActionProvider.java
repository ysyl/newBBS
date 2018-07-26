package bbs.subscriptionsystem.action.provider;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.action.DAO.CommodyCommentActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.manager.ActionManager;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.CommodySubscription;

public class CommodyModifyActionProvider implements ActionProvider {

	@Override
	public List<? extends BaseAction> getAllActionBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getActionCountBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean support(Class<? extends BaseSubscription<?>> subscriptionClass) {
		// TODO Auto-generated method stub
		return CommodySubscription.class.isAssignableFrom(subscriptionClass);
	}

}
