package bbs.shop.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bbs.helper.utils.MyLogger;
import bbs.shop.entity.Commody;
import bbs.shop.entity.Keyword;
import bbs.shop.keyword.extractor.KeywordExtractor;
import bbs.shop.mybatis.entity.TCommody;
import bbs.shop.mybatis.mapper.TCommodyMapper;

@Repository
public class CommodyDAO {
	
	private TCommodyMapper tCommodyMapper;

	private CommodyImgDAO imgDAO;
	
	private KeywordDAO keywordDAO;
	
	private KeywordExtractor keywordExtractor;
	
	private SubClassDAO subClassDAO;

	@Autowired
	public CommodyDAO(TCommodyMapper tCommodyMapper, CommodyImgDAO imgDAO, KeywordDAO keywordDAO,
			KeywordExtractor keywordExtractor, SubClassDAO subClassDAO) {
		super();
		this.tCommodyMapper = tCommodyMapper;
		this.imgDAO = imgDAO;
		this.keywordDAO = keywordDAO;
		this.keywordExtractor = keywordExtractor;
		this.subClassDAO = subClassDAO;
	}

	public Long save(long uid, String title, String description, Integer price, List<String> imgFileNames, int commodyClassificationId, List<Integer> subClassIdList) {
		TCommody entity = new TCommody();
		entity.setClassificationId(commodyClassificationId);
		entity.setDescription(description);
		entity.setTitle(title);
		entity.setUserId(uid);
		entity.setPrice(price);
		
		tCommodyMapper.insertSelective(entity);

		Long commodyId = entity.getId();
		
		for(String imgFilename: imgFileNames) {
			imgDAO.saveImgToCommody(commodyId, imgFilename);
		}
		
		for(Integer subClassId : subClassIdList) {
			subClassDAO.associateSubClassToCommody(subClassId, commodyId);
		}
		
		Set<Keyword> keywords = keywordExtractor.seg(title + " / " + description);
		System.out.println(keywords.size());
		for(Keyword keyword : keywords) {
			MyLogger.info("关键词："+keyword.getClass());
			keywordDAO.saveKeywordToCommody(commodyId, keyword);
		}
		
		return commodyId;
	}
	
	public void update(long commodyId, String title, String description, Integer price, List<String> imgFileNames, int commodyClassificationId, List<Integer> subClassIdList) {
		TCommody entity = new TCommody();
		entity.setClassificationId(commodyClassificationId);
		entity.setDescription(description);
		entity.setTitle(title);
		entity.setId(commodyId);
		entity.setPrice(price);
		entity.setLastModifiedTime(new Date());
		
		//更新图片前先删除相关的img
		imgDAO.deleteByCommodyId(commodyId);

		for(String imgFilename: imgFileNames) {
			imgDAO.saveImgToCommody(commodyId, imgFilename);
		}
		
		tCommodyMapper.updateByPrimaryKeySelective(entity);
		
		for(Integer subClassId : subClassIdList) {
			subClassDAO.unassociateSubClassToCommody(subClassId, commodyId);
		}
		
		for(Integer subClassId : subClassIdList) {
			subClassDAO.associateSubClassToCommody(subClassId, commodyId);
		}
		
		//清除关键词记录
		keywordDAO.clearKeywordAboutCommody(commodyId);
		Set<Keyword> keywords = keywordExtractor.seg(title + " / " + description);
		
		for(Keyword keyword : keywords) {
			keywordDAO.saveKeywordToCommody(commodyId, keyword);
		}
		
		tCommodyMapper.updateByPrimaryKeySelective(entity);
	
	}
	
	public Commody get(Long commodyId) {
		return tCommodyMapper.selectCommodyById(commodyId);
	}
	
	public List<Commody> getCommodyBySellerId(Long userId) {
		return tCommodyMapper.selectCommodyByUserId(userId);
	}
	
	public List<Commody> search(String titleKey) {
		return tCommodyMapper.searchCommodyByTitleKey(titleKey);
	}

	public List<Commody> getHotCommodyByClassifitionId(int classificationId) {
		return tCommodyMapper.selectHotCommodyListByClassificationId(classificationId);
	}

	public List<Commody> getAll() {
		return tCommodyMapper.selectAllCommody();
	}

	public void updateViews(long commodyId) {
		tCommodyMapper.updateViews(commodyId);
	}

	public void updateReplies(Long commodyId) {
		tCommodyMapper.updateReplies(commodyId);
	}

	public List<Commody> searchCommodyByClassificationId(Integer classificationId) {
		return tCommodyMapper.searchCommodyByClassificationId(classificationId);
	}

	public List<Commody> searchCommodyBySubClassId(int subClassId) {
		// TODO Auto-generated method stub
		return tCommodyMapper.searchCommodyBySubClassId(subClassId);
	}

	public List<Commody> searchByKeyword(String titleKeyword) {
		// TODO Auto-generated method stub
		return tCommodyMapper.searchCommodyByKeyword(titleKeyword);
	}
}
