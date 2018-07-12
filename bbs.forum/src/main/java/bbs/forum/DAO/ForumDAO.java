package bbs.forum.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.forum.DTO.Forum;
import bbs.forum.entity.TForum;
import bbs.forum.form.ForumForm;
import bbs.forum.mapper.TForumMapper;

@Component
public class ForumDAO {

	private TForumMapper tForumMapper;
	
	public int save(ForumForm forumForm) {
		return 0;
		//todo
	}
	
	public Forum get(int forumId) {
		Forum forum = tForumMapper.selectForumById(forumId);
		return forum;
	}
	
	public void remove(int forumId) {
		tForumMapper.deleteByPrimaryKey(forumId);
	}

	public TForumMapper gettForumMapper() {
		return tForumMapper;
	}

	public List<Forum> findAllForums() {
		// TODO Auto-generated method stub
		List<Forum> forumList = tForumMapper.selectAllForum();
		return forumList;
	}

	public void update(Forum forum) {
		// TODO Auto-generated method stub
	}

	@Autowired
	public void settForumMapper(TForumMapper tForumMapper) {
		this.tForumMapper = tForumMapper;
	}
	
}
