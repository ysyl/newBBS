package bbs.shop.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.shop.entity.Keyword;
import bbs.shop.mybatis.entity.TKeyword;
import bbs.shop.mybatis.mapper.TKeywordMapper;

@Component
public class KeywordDAO {
	
	private TKeywordMapper tKeywordMapper;
	
	@Autowired
	public KeywordDAO(TKeywordMapper tKeywordMapper) {
		super();
		this.tKeywordMapper = tKeywordMapper;
	}

	public void saveKeywordToCommody(Long commodyId, Keyword keyword) {
		// TODO Auto-generated method stub
		Long kid;
		try {
			kid = this.save(keyword);
		} catch (DataIntegrityViolationException e) {
			// TODO Auto-generated catch block
			kid = this.getKeywordByKeywordContent(keyword.getContent()).getId();
		}
		
		tKeywordMapper.associateKeywordToCommody(kid, commodyId);
	}

	public void clearKeywordAboutCommody(long commodyId) {
		// TODO Auto-generated method stub
		tKeywordMapper.clearKeywordAboutCommody(commodyId);
	}

	public Long save(Keyword keyword) throws DataIntegrityViolationException {
		// TODO Auto-generated method stub
		TKeyword entity = new TKeyword();
		entity.setValue(keyword.getContent());
		
		tKeywordMapper.insertSelective(entity);
		return entity.getId();
	}

	public Keyword getKeywordByKeywordContent(String content) {
		// TODO Auto-generated method stub
		return tKeywordMapper.selectKeywordByKeywordContent(content);  
	}

}
