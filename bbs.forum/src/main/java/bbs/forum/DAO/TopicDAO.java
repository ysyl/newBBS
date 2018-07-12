package bbs.forum.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.Topic;
import bbs.forum.entity.TPost;
import bbs.forum.entity.TTopic;
import bbs.forum.form.PubTopicForm;
import bbs.forum.mapper.TPostMapper;
import bbs.forum.mapper.TTopicMapper;
import bbs.helper.PageParam;

@Component
public class TopicDAO {
	
	public TTopicMapper gettTopicMapper() {
		return tTopicMapper;
	}
	
	@Autowired
	public void settTopicMapper(TTopicMapper tTopicMapper) {
		this.tTopicMapper = tTopicMapper;
	}

	public TPostMapper gettPostMapper() {
		return tPostMapper;
	}
	
	@Autowired
	public void settPostMapper(TPostMapper tPostMapper) {
		this.tPostMapper = tPostMapper;
	}

	private TTopicMapper tTopicMapper;
	
	private TPostMapper tPostMapper;
	
	public Long save(long uid, PubTopicForm topicForm) {
		String content = topicForm.getContent();
		int forumId = topicForm.getForumId();
		String title = topicForm.getTitle();
		Date now = new Date();
		
		TTopic tTopic = new TTopic();
		tTopic.setAuthorId(uid);
		tTopic.setForumId(forumId);
		tTopic.setMainPostId(null);
		tTopic.setTitle(title);
		
		tTopicMapper.insertSelective(tTopic);
		
		TPost tPost = new TPost();
		tPost.setAuthorId(uid);
		tPost.setContent(content);
		tPost.setPubTime(now);
		tPost.setTopicId(tTopic.getId());

		tPostMapper.insertSelective(tPost);
		
		tTopic.setMainPostId(tPost.getId());
		tTopic.setLastReplyPostId(tPost.getId());
		
		tTopicMapper.updateByPrimaryKeySelective(tTopic);
		return tTopic.getId();
	}
	
	public Topic get(long topicId) {
		Topic topic = tTopicMapper.selectTopicById(topicId);
		return topic;
	}
	
	public void remove(long topicId) {
		tTopicMapper.deleteByPrimaryKey(topicId);
	}

	public List<Topic> getAllTopicByForumId(long forumId, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Topic> topicList = tTopicMapper.selectAllTopicByForumId(forumId, pageParam);
		return topicList;
	}
	public List<Topic> searchTopic(String title, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Topic> topicList = tTopicMapper.searchAllTopic(title, pageParam);
		return topicList;
	}

	public List<Topic> getAllByUid(Long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Topic> topicList = tTopicMapper.selectAllTopicByUid(uid, pageParam);
		return topicList;
	}

	public void likeTopic(long topicId) {
		// TODO Auto-generated method stub
		tTopicMapper.likesPlusOne(topicId);
	}
	
	public void viewsTopic(long topicId) {
		tTopicMapper.viewsPlusOne(topicId);
	}
	
	public void replyTopic(long topicId) {
		tTopicMapper.repliesPlusOne(topicId);
	}
	
}
