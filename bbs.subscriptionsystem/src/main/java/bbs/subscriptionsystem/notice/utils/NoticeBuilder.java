package bbs.subscriptionsystem.notice.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.BbsTrendAction;
import bbs.subscriptionsystem.action.entity.BeFollowedAction;
import bbs.subscriptionsystem.action.entity.CommodyCommentAction;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.entity.BbsTrendNotice;
import bbs.subscriptionsystem.notice.entity.BeFollowedNotice;
import bbs.subscriptionsystem.notice.entity.CommodyCommentNotice;
import bbs.subscriptionsystem.notice.entity.PostTrendNotice;
import bbs.subscriptionsystem.notice.entity.TopicTrendNotice;
import bbs.subscriptionsystem.notice.entity.UserTrendNotice;

public class NoticeBuilder {

	public static List<BaseNotice> transActionListToNotice(List<BaseAction> actions) {
		List<BaseNotice> notices = new ArrayList<>();
		for (BaseAction action : actions ) {
			notices.add(transActionToNotice(action));
		}
		return notices;
	}
	
	public static BaseNotice transActionToNotice(BaseAction action) {
		BaseNotice resultNotice = null;
			if (action instanceof PostTrendAction) {
				resultNotice = new PostTrendNotice((PostTrendAction) action);
			}
			else if (action instanceof TopicTrendAction) {
				resultNotice = new TopicTrendNotice((TopicTrendAction) action);
			}
			else if (action instanceof UserTrendAction) {
				resultNotice = new UserTrendNotice((UserTrendAction) action);
			}
			else if (action instanceof BeFollowedAction) {
				resultNotice = new BeFollowedNotice((BeFollowedAction) action);
			}
			else if (action instanceof CommodyCommentAction) {
				resultNotice = new CommodyCommentNotice((CommodyCommentAction) action);
			}
			return resultNotice;
	}
}
