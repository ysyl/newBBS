package bbs.shop.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.shop.entity.Keyword;
import bbs.shop.entity.UserPerference;
import bbs.shop.mybatis.entity.TUserPerference;
import bbs.shop.mybatis.mapper.TUserPerferenceMapper;

@Component
public class UserPerferenceDAO {
	
	private TUserPerferenceMapper mapper;  
	
	private KeywordDAO keywordDAO;

	@Autowired
	public UserPerferenceDAO(TUserPerferenceMapper mapper, KeywordDAO keywordDAO) {
		super();
		this.mapper = mapper;
		this.keywordDAO = keywordDAO;
	}

	public void saveKeywordStatistics(long uid, Keyword keyword) throws DataIntegrityViolationException {
		// TODO Auto-generated method stub
		Long keywordId = null;
		TUserPerference entity = new TUserPerference();
		entity.setUserId(uid);
		try {
			keywordId = keywordDAO.save(keyword);
		} catch (DataIntegrityViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
			MyLogger.info(this.getClass(), "尝试插入的关键词已存在");
			keywordId = keywordDAO.getKeywordByKeywordContent(keyword.getContent()).getId();
		} 
		entity.setKeywordId(keywordId);
		
		mapper.insertSelective(entity);
	}

	public UserPerference getUserPerferenceByUid(long uid) {
		// TODO Auto-generated method stub
		return mapper.selectUserPerferenceByUid(uid);
	}

	public void updateKeywordStatistics(long uid, Keyword keyword) {
		// TODO Auto-generated method stub
		mapper.updateFrequencyByUidAndKeywordContent(uid, keyword.getContent());
	}

}
