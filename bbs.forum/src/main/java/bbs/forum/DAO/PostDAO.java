package bbs.forum.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.Post;
import bbs.forum.entity.TPost;
import bbs.forum.form.ModifyPostForm;
import bbs.forum.form.PubPostForm;
import bbs.forum.mapper.TPostMapper;
import bbs.helper.PageParam;

@Component
public class PostDAO {

	private TPostMapper tPostMapper;
	
	public long save(long uid, long topicId, PubPostForm pubPostForm) {
		Long replyId = pubPostForm.getReplyPostId();
		String content = pubPostForm.getContent();
		
		TPost tPost = new TPost(content, uid, replyId, topicId);
		tPost.setHtmlContent(pubPostForm.getHtmlContent());
		
		tPostMapper.insertSelective(tPost);
		
		return tPost.getId();
	}
	
	public Post get(long postId) {
		Post post = tPostMapper.selectPostById(postId);
		return post;
	}
	
	public void remove(long postId) {
		tPostMapper.deleteByPrimaryKey(postId);
	}

	public TPostMapper gettPostMapper() {
		return tPostMapper;
	}

	@Autowired
	public void settPostMapper(TPostMapper tPostMapper) {
		this.tPostMapper = tPostMapper;
	}
	public List<Post> findAllPostByTopicId(long topicId, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Post> postList = tPostMapper.selectAllPostByTopicId(topicId, pageParam);
		return postList;
	}

	public void update(long postId, ModifyPostForm form) {
		// TODO Auto-generated method stub
		TPost tPost = new TPost();
		tPost.setId(postId);
		tPost.setContent(form.getContent());
		tPostMapper.updateByPrimaryKeySelective(tPost);
	}

	public List<Post> searchPost(String content, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Post> postList = tPostMapper.searchAll(content, pageParam);
		return postList;
	}

	public List<Post> getByUid(long uid, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Post> postList = tPostMapper.selectAllPostByAuthorId(uid, pageParam);
		return postList;
	}

	public List<Post> getReply(long postId, PageParam pageParam) {
		// TODO Auto-generated method stub
		List<Post> postList = tPostMapper.selectAllReply(postId, pageParam);
		return postList;
	}

	public Post getMainPost(long topicId) {
		// TODO Auto-generated method stub
		Post post = tPostMapper.selectMainPost(topicId);
		return post;
	}

	public void likePost(long postId) {
		// TODO Auto-generated method stub
		tPostMapper.likesPlusOne(postId);
	}

	public long update(long uid, long postId, ModifyPostForm postForm) {
		// TODO Auto-generated method stub
		String content = postForm.getContent();
		
		TPost tPost = new TPost();
		tPost.setAuthorId(uid);
		tPost.setContent(content);
		tPost.setId(postId);
		tPost.setLastModifiedTime(new Date());
		tPostMapper.updateByPrimaryKeySelective(tPost);
		return tPost.getId(); 
	}
}
