package bbs.forum.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.form.utils.PageParam;
import bbs.forum.DTO.Topic;
import bbs.forum.entity.TPost;
import bbs.forum.entity.TTopic;
import bbs.forum.form.PubPostForm;
import bbs.forum.form.PubTopicForm;
import bbs.forum.mapper.TPostMapper;
import bbs.forum.mapper.TTopicMapper;
import bbs.forum.service.BbsService;

@Component
@Transactional
public class TopicDAO {

	private TTopicMapper tTopicMapper;
	
	private PostDAO postDAO;

	@Autowired
	public TopicDAO(TTopicMapper tTopicMapper, PostDAO postDAO) {
		super();
		this.tTopicMapper = tTopicMapper;
		this.postDAO = postDAO;
	}

	public Long save(long uid, PubTopicForm topicForm) {
		String content = topicForm.getContent();
		String htmlContent = topicForm.getHtmlContent();
		int forumId = topicForm.getForumId();
		String title = topicForm.getTitle();
		Date now = new Date();
		
		TTopic tTopic = new TTopic();
		tTopic.setAuthorId(uid);
		tTopic.setForumId(forumId);
		tTopic.setMainPostId(null);
		tTopic.setTitle(title);
		
		tTopicMapper.insertSelective(tTopic);

		PubPostForm pubPostForm = new PubPostForm();
		pubPostForm.setContent(content);
		pubPostForm.setHtmlContent(htmlContent);
		pubPostForm.setReplyPostId(null);
		
		long postId = postDAO.save1L(uid, tTopic.getId(), pubPostForm);
		
		tTopic.setMainPostId(postId);
		tTopic.setLastReplyPostId(postId);
		
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

	public boolean isMyTopic(Long uid, long topicId) {
		// TODO Auto-generated method stub
		return tTopicMapper.countByUidAndTopicId(uid, topicId) == 1;
	}
	
}
