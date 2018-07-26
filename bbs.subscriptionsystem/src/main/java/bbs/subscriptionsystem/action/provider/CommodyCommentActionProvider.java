package bbs.subscriptionsystem.action.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.action.DAO.CommodyCommentActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.CommodyCommentSubscription;
import bbs.subscriptionsystem.subscription.entity.CommodySubscription;

@Component
public class CommodyCommentActionProvider implements ActionProvider {

	private CommodyCommentActionDAO commentActionDAO;

	@Autowired
	public CommodyCommentActionProvider(CommodyCommentActionDAO commentActionDAO) {
		super();
		this.commentActionDAO = commentActionDAO;
	}

	@Override
	public List<? extends BaseAction> getAllActionBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		if (!support((Class<? extends BaseSubscription<?>>) subscription.getClass())) throw new IllegalArgumentException();
		
		if (subscription instanceof CommodySubscription) {
			return this.getAllActionByCommodySubscription((CommodySubscription) subscription);
		} 
		else if (subscription instanceof CommodyCommentSubscription) {
			return this.getAllActionByCommodyCommentSubscription((CommodyCommentSubscription) subscription);
		}
		throw new IllegalArgumentException();
	}

	@Override
	public Integer getActionCountBySubscription(BaseSubscription<?> subscription) {
		// TODO Auto-generated method stub
		Long commodyId = ((CommodySubscription) subscription).getTarget().getId();
		Date lastReadTime = subscription.getLastReadTime();
		return commentActionDAO.countCommentActionByCommodyIdAfterLastReadTime(commodyId, lastReadTime);
	}

	@Override
	public boolean support(Class<? extends BaseSubscription<?>> subscriptionClass) {
		// TODO Auto-generated method stub
		return CommodySubscription.class.isAssignableFrom(subscriptionClass) 
				|| CommodyCommentSubscription.class.isAssignableFrom(subscriptionClass);
	}
	
	private List<? extends BaseAction> getAllActionByCommodySubscription(CommodySubscription subscription) {
		// TODO Auto-generated method stub
		Long commodyId = subscription.getTarget().getId();
		Date lastReadTime = subscription.getLastReadTime();
		return commentActionDAO.getAllCommentActionByCommodyIdAfterLastReadTime(commodyId, lastReadTime);
	}	
	
	private List<? extends BaseAction> getAllActionByCommodyCommentSubscription(CommodyCommentSubscription subscription) {
		// TODO Auto-generated method stub
		Long commentId = subscription.getTarget().getId();
		Date lastReadTime = subscription.getLastReadTime();
		return commentActionDAO.getAllCommentActionByCommentIdAfterLastReadTime(commentId, lastReadTime);
	}	
	
}
