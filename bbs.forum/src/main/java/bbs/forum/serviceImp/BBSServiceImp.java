package bbs.forum.serviceImp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbs.form.utils.PageParam;
import bbs.forum.DAO.AnnounceDAO;
import bbs.forum.DAO.ForumDAO;
import bbs.forum.DAO.PostDAO;
import bbs.forum.DAO.TopicDAO;
import bbs.forum.DAO.UserDAO;
import bbs.forum.DTO.Announce;
import bbs.forum.DTO.Forum;
import bbs.forum.DTO.Post;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;
import bbs.forum.form.ForumForm;
import bbs.forum.form.ModifyPostForm;
import bbs.forum.form.PubAnnounceForm;
import bbs.forum.form.PubPostForm;
import bbs.forum.form.PubTopicForm;
import bbs.forum.form.UpdateUserProfileForm;
import bbs.forum.mapper.TUserPrincipalForumMapper;
import bbs.forum.service.BBSService;

@Service
@Transactional
public class BBSServiceImp implements BBSService {
	
	private ForumDAO forumDAO;
	
	private TopicDAO topicDAO;
	
	private PostDAO postDAO;
	
	private UserDAO userDAO;
	
	private AnnounceDAO announceDAO;
	
	private TUserPrincipalForumMapper upMapper;

	@Autowired
	public BBSServiceImp(ForumDAO forumDAO, TopicDAO topicDAO, PostDAO postDAO, UserDAO userDAO,
			AnnounceDAO announceDAO, TUserPrincipalForumMapper upMapper) {
		super();
		this.forumDAO = forumDAO;
		this.topicDAO = topicDAO;
		this.postDAO = postDAO;
		this.userDAO = userDAO;
		this.announceDAO = announceDAO;
		this.upMapper = upMapper;
	}

	@Override
	public List<Forum> getAllForums() {
		// TODO Auto-generated method stub
		List<Forum> forumList = forumDAO.findAllForums();
		return forumList;
	}

	@Override
	public List<Topic> getTopicListByForumId(int forumId, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Topic> topicList = topicDAO.getAllTopicByForumId(forumId, pageParam);
		return topicList;
	}

	@Override
	public List<Post> getPostList(long topicId, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Post> postList = postDAO.findAllPostByTopicId(topicId, pageParam);
		return postList;
	}

	@Override
	public int saveForum(ForumForm forumForm) {
		// TODO Auto-generated method stub
		int forumId = forumDAO.save(forumForm);
		return forumId;
	}

	@Override
	public long saveTopic(long uid, PubTopicForm topicForm) {
		long topicId = topicDAO.save(uid, topicForm);
		return topicId;
	}

	@Override
	public long savePost(long uid, long topicId, PubPostForm postForm) {
		// TODO Auto-generated method stub
		long postId = postDAO.save(uid, topicId, postForm);
		return postId;
	}

	@Override
	public void updateForum(ForumForm forumForm) {
		// TODO Auto-generated method stub
		//todo
	}

	@Override
	public void updatePost(long uid, long postId, ModifyPostForm postForm) {
		// TODO Auto-generated method stub
		postDAO.update(uid, postId, postForm);
	}

	@Override
	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
		return forumDAO.get(forumId);
	}

	@Override
	public Topic getTopic(long topicId) {
		// TODO Auto-generated method stub
		return topicDAO.get(topicId);
	}

	@Override
	public Post getPost(long postId) {
		// TODO Auto-generated method stub
		return postDAO.get(postId);
	}

	@Override
	public User getUser(long uid) {
		// TODO Auto-generated method stub
		return userDAO.get(uid);
	}

	@Override
	public void removeForum(int forumId) {
		// TODO Auto-generated method stub
		forumDAO.remove(forumId);
	}

	@Override
	public void removeTopic(long topicId) {
		// TODO Auto-generated method stub
		topicDAO.remove(topicId);
	}

	@Override
	public void removePost(long postId) {
		// TODO Auto-generated method stub
		postDAO.remove(postId);
	}

	@Override
	public User getUser(String nickname) {
		// TODO Auto-generated method stub
		return userDAO.get(nickname);
	}

	@Override
	public List<Post> searchPost(String content, PageParam pageParam) {
		// TODO Auto-generated method stub
		return postDAO.searchPost(content, pageParam);
	}

	@Override
	public List<Topic> searchTopic(String title, PageParam pageParam) {
		// TODO Auto-generated method stub
		return topicDAO.searchTopic(title, pageParam);
	}

	@Override
	public List<Post> getPostByUid(long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		return postDAO.getByUid(uid, pageParam);
	}

	@Override
	public List<Post> getReply(long postId, PageParam pageParam) {
		// TODO Auto-generated method stub
		return postDAO.getReply(postId, pageParam);
	}

	@Override
	public Post getMainPost(long topicId) {
		// TODO Auto-generated method stub
		return postDAO.getMainPost(topicId);
	}

	@Override
	public void likeTopic(long topicId) {
		// TODO Auto-generated method stub
		topicDAO.likeTopic(topicId);
	}

	@Override
	public void likePost(long postId) {
		// TODO Auto-generated method stub
		postDAO.likePost(postId);
	}

	@Override
	public int saveAnnounce(long managerId, PubAnnounceForm pubAnnounceForm) {
		// TODO Auto-generated method stub
		return announceDAO.saveAnnounce(managerId, pubAnnounceForm);
	}

	@Override
	public List<Announce> getAllAnnounceByForumId(Integer forumId, PageParam pageParam) {
		// TODO Auto-generated method stub
		return announceDAO.selectAllAnnounceByForumId(forumId, pageParam);
	}

	@Override
	public List<Topic> getTopicListByUid(Long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		return topicDAO.getAllByUid(uid, pageParam);
	}

	@Override
	public void updateUserProfile(Long uid, UpdateUserProfileForm updateUserProfileForm) {
		// TODO Auto-generated method stub
		userDAO.update(uid, updateUserProfileForm);
	}

	@Override
	public String getUsername(long uid) {
		// TODO Auto-generated method stub
		return upMapper.selectByPrimaryKey(uid).getUsername();
	}

	@Override
	public boolean isMyTopic(Long uid, long topicId) {
		// TODO Auto-generated method stub
		return topicDAO.isMyTopic(uid, topicId);
	}

	@Override
	public boolean isMyPost(Long uid, long postId) {
		// TODO Auto-generated method stub
		return postDAO.isMyPost(uid, postId);
	}

	@Override
	public Map<Integer, Post> getLastPostInForum() {
		// TODO Auto-generated method stub
		Map<Integer, Post> lastPostForumMap = new HashMap<>();
		lastPostForumMap = postDAO.getLastPostInForum();
		return lastPostForumMap;
	}
}
