package bbs.subscriptionsystem.action.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.form.PubPostForm;
import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.action.DAO.ForumTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.PostTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.TopicTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.UserTrendActionDAO;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.BaseTrendAction;
import bbs.subscriptionsystem.action.provider.ActionProvider;
import bbs.subscriptionsystem.enuma.UserTrendActionTargetType;
import bbs.subscriptionsystem.enuma.UserTrendActionType;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;

@Component
public class ActionManager {

	private TopicTrendActionDAO topicTrendActionDAO;
	
	private UserTrendActionDAO userTrendActionDAO;
	
	private PostTrendActionDAO postTrendActionDAO;
	
	private ForumTrendActionDAO forumTrendActionDAO;

	private List<ActionProvider> actionProviders;

	@Autowired
	public ActionManager(TopicTrendActionDAO topicTrendActionDAO, UserTrendActionDAO userTrendActionDAO,
			PostTrendActionDAO postTrendActionDAO, ForumTrendActionDAO forumTrendActionDAO,
			List<ActionProvider> actionProviders) {
		super();
		this.topicTrendActionDAO = topicTrendActionDAO;
		this.userTrendActionDAO = userTrendActionDAO;
		this.postTrendActionDAO = postTrendActionDAO;
		this.forumTrendActionDAO = forumTrendActionDAO;
		this.actionProviders = actionProviders;
	}
	
	public Long addUserTrendAction(UserTrendActionType actionType, UserTrendActionTargetType targetType,
			long uid, long targetId) {
		return userTrendActionDAO.saveUserTrendAction(actionType, targetType, uid, targetId);
	}

	public Long addTopicTrendAction(long uid, Long topicId, long replyId) {
		// TODO Auto-generated method stub
		return topicTrendActionDAO.saveTopicTrendAction(uid, topicId, replyId);
	}

	public Long addPostTrendAction(long uid, long topicId, Long replyPostId, long postId) {
		// TODO Auto-generated method stub
		return postTrendActionDAO.savePostTrendAction(uid, topicId,  postId, replyPostId);
	}
	
	public Long addForumTrendAction(long managerId, int forumId, int announceId) {
		return forumTrendActionDAO.saveForumTrendAction(managerId, forumId, announceId);
	}
	
	public List<? extends BaseAction> getAllActionBySubscription(BaseSubscription<?> subscription) {
		List<BaseAction> actions = new ArrayList<>();
		for (ActionProvider provider : actionProviders) {
			if (provider.support((Class<? extends BaseSubscription<?>>) subscription.getClass())) {
				actions.addAll(provider.getAllActionBySubscription(subscription));
			}
		}
		return actions;
	}
	
	public Integer countActionBySubscription(BaseSubscription<?> subscription) {
		Integer count = 0;
		for (ActionProvider provider : actionProviders) {
			MyLogger.info("进入provider foreach" + provider.getClass().getName() +"\n" + subscription.getClass().getName());
			if (provider.support((Class<? extends BaseSubscription<?>>) subscription.getClass())) {
				MyLogger.info("\n\n\n进入" + subscription.getClass().getName());
				count += provider.getActionCountBySubscription(subscription);
			}
		}
		return count;
	}

	

}
