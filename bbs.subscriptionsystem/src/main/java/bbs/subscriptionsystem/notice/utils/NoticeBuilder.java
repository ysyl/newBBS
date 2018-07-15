package bbs.subscriptionsystem.notice.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.entity.PostTrendNotice;
import bbs.subscriptionsystem.notice.entity.TopicTrendNotice;
import bbs.subscriptionsystem.notice.entity.UserTrendNotice;

@Component
public class NoticeBuilder {

	public List<BaseNotice> transActionListToNotice(List<BaseAction> actions) {
		List<BaseNotice> notices = new ArrayList<>();
		for (BaseAction action : actions ) {
			if (action instanceof PostTrendAction) {
				notices.add(new PostTrendNotice((PostTrendAction) action));
			}
			else if (action instanceof TopicTrendAction) {
				notices.add(new TopicTrendNotice((TopicTrendAction) action));
			}
			else if (action instanceof UserTrendAction) {
				notices.add(new UserTrendNotice((UserTrendAction<?>) action));
			}
		}
		return notices;
	}
}
