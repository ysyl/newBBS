package bbs.subscriptionsystem.action.pusher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.action.DAO.CommodyCommentActionDAO;
import bbs.subscriptionsystem.action.DAO.ForumTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.PostTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.TopicTrendActionDAO;
import bbs.subscriptionsystem.action.DAO.UserTrendActionDAO;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.BbsTrendAction;
import bbs.subscriptionsystem.action.entity.BeFollowedAction;
import bbs.subscriptionsystem.action.entity.CollectUserAction;
import bbs.subscriptionsystem.action.entity.CommodyCommentAction;
import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.action.pusher.constant.PusherConstant;
import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.entity.BeFollowedNotice;
import bbs.subscriptionsystem.notice.utils.NoticeBuilder;

@Component
public class ActionPusher {

	private UserTrendActionDAO userTrendActionDAO;
	private TopicTrendActionDAO topicTrendActionDAO;
	private PostTrendActionDAO postTrendActionDAO;
	private ForumTrendActionDAO forumTrendActionDAO;
	private CommodyCommentActionDAO commodyCommentActionDAO; 
	private SimpMessagingTemplate template;
	private SubscriptionMatcherHolder subscriptionMatcherHolder;

	@Autowired
	public ActionPusher(UserTrendActionDAO userTrendActionDAO, TopicTrendActionDAO topicTrendActionDAO,
			PostTrendActionDAO postTrendActionDAO, ForumTrendActionDAO forumTrendActionDAO,
			CommodyCommentActionDAO commodyCommentActionDAO, SimpMessagingTemplate template,
			SubscriptionMatcherHolder subscriptionMatcherHolder) {
		super();
		this.userTrendActionDAO = userTrendActionDAO;
		this.topicTrendActionDAO = topicTrendActionDAO;
		this.postTrendActionDAO = postTrendActionDAO;
		this.forumTrendActionDAO = forumTrendActionDAO;
		this.commodyCommentActionDAO = commodyCommentActionDAO;
		this.template = template;
		this.subscriptionMatcherHolder = subscriptionMatcherHolder;
	}

	//先过滤出collectUserAction，新建一个beFollowedAction 用于匹配，如果返回正确，则
	//同时再推送一个BeFollowedAction, 如果不匹配，则只发布CollectUserAction;
	private void matchAndSendToUser(BaseAction action) {
		for (Entry<String, SubscriptionMatcher> matcherEntry : subscriptionMatcherHolder.entrySet()) {
			String username = matcherEntry.getKey();
			SubscriptionMatcher matcher = matcherEntry.getValue();
		
			MyLogger.info("获取到动作"
					+ action.getClass().getSimpleName()
					+ "，在发送给用户"
					+ username
					+ "之前匹配matcher:");
			//Matcher遇到collectAction时会修改原有的action，因此需要传入map而不是action，使得matcher能修改传入的变量
			Map<String, BaseAction> inOutMatcherActionParam = new HashMap<>();
			inOutMatcherActionParam.put("raw", action);
			inOutMatcherActionParam.put("new", null);
			
			Map<String, BaseAction> matchResult = matcher.match(inOutMatcherActionParam);
			
			boolean isMatch = matchResult.get("new") != null;
			
			MyLogger.info("动作为 : "
					+ action.getClass().getSimpleName()
					+ "  是否匹配成功: "
					+ isMatch);
			if (isMatch) {
				MyLogger.info("\n\n\n\n\n匹配动作成功， 向用户" + username + "发布通知\n\n\n");
				BaseNotice notice = NoticeBuilder.transActionToNotice(matchResult.get("new"));
				MyLogger.info("通知内容为: " + notice);
				this.template.convertAndSendToUser(username, PusherConstant.SEND_NOTICE_TO_USER_URL,
						notice);
				break;
			}
		}
	}

	public void pushUserTrendAction(long actionId) {
		UserTrendAction<?> action = userTrendActionDAO.selectById(actionId);
		matchAndSendToUser(action);
	}

	public void pushTopicTrendAction(long actionId) {
		TopicTrendAction action = topicTrendActionDAO.selectById(actionId);
		matchAndSendToUser(action);
	}

	public void pushPostTrendAction(long actionId) {
		PostTrendAction action = postTrendActionDAO.selectById(actionId);
		matchAndSendToUser(action);
	}

	public void pushForumTrendAction(long actionId) {
		ForumTrendAction action = forumTrendActionDAO.selectById(actionId);
		matchAndSendToUser(action);
	}

	public void pushCommodyCommentAction(long commodyCommentActionId) {
		// TODO Auto-generated method stub
		CommodyCommentAction action = commodyCommentActionDAO.getCommentActionById(commodyCommentActionId);
		matchAndSendToUser(action);
	}
}
