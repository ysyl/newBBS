package bbs.forum.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import bbs.form.utils.PageParam;
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

public
interface BBSService {

	List<Forum> getAllForums();
	
	List<Topic> getTopicListByForumId(int forumId, PageParam pageParam);
	
	List<Post> getPostList(long topicId, PageParam pageParam);
	
	int saveForum(ForumForm forumForm);
	
	long saveTopic(long uid, PubTopicForm topicForm);
	
	long savePost(long uid, long topicId, PubPostForm postForm);
	
	int saveAnnounce(long managerId, PubAnnounceForm pubAnnounceForm);
	
	void likeTopic(long topicId);
	
	void likePost(long postId);
	
	void updateForum(ForumForm forumForm);
	
	void updatePost(long uid, long postId, ModifyPostForm modifyPostForm);
	
	void updateUserProfile(Long uid, UpdateUserProfileForm updateUserProfileForm);
	
	Forum getForum(int forumId);
	
	Topic getTopic(long topicId);
	
	Post getPost(long postId);
	
	User getUser(long uid);
	
	void removeForum(int forumId);
	
	void removeTopic(long topicId);
	
	void removePost(long postId);
	
	User getUser(String nickname);

	List<Post> searchPost(String content, PageParam pageParam);
	
	List<Topic> searchTopic(String title, PageParam pageParam);

	List<Post> getPostByUid(long uid, PageParam pageParam);

	List<Post> getReply(long postId, PageParam pageParam);

	Post getMainPost(long topicId);

	List<Topic> getTopicListByUid(Long uid, PageParam pageParam);

	List<Announce> getAllAnnounceByForumId(Integer forumId, PageParam pageParam);
	
	String getUsername(long uid);

	boolean isMyTopic(Long uid, long topicId);

	boolean isMyPost(Long uid, long postId);

	Map<Integer, Post> getLastPostInForum();
	
}
