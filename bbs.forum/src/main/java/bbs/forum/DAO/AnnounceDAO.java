package bbs.forum.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bbs.form.utils.PageParam;
import bbs.forum.DTO.Announce;
import bbs.forum.entity.TAnnounce;
import bbs.forum.form.PubAnnounceForm;
import bbs.forum.mapper.TAnnounceMapper;

@Repository
public class AnnounceDAO {
	
	private TAnnounceMapper tAnnounceMapper;

	public TAnnounceMapper gettAnnounceMapper() {
		return tAnnounceMapper;
	}

	@Autowired
	public void settAnnounceMapper(TAnnounceMapper tAnnounceMapper) {
		this.tAnnounceMapper = tAnnounceMapper;
	}

	public int saveAnnounce(long managerId, PubAnnounceForm pubAnnounceForm) {
		// TODO Auto-generated method stub
		TAnnounce entity = new TAnnounce();
		entity.setContent(pubAnnounceForm.getContent());
		entity.setForumId(pubAnnounceForm.getForumId());
		entity.setPublisherId(managerId);
		entity.setTitle(pubAnnounceForm.getTitle());
		tAnnounceMapper.insertSelective(entity);
		return entity.getId(); 
	}

	public List<Announce> selectAllAnnounceByForumId(Integer forumId, PageParam pageParam) {
		// TODO Auto-generated method stub
		return tAnnounceMapper.selectAllAnnounceByForumId(forumId, pageParam);
	}

}
