package bbs.shop.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bbs.shop.DTO.Commody;
import bbs.shop.entity.TCommody;
import bbs.shop.entity.TCommodyImg;
import bbs.shop.mapper.TCommodyImgMapper;
import bbs.shop.mapper.TCommodyMapper;

@Repository
@Transactional
public class CommodyDAO {
	
	private TCommodyMapper tCommodyMapper;

	private CommodyImgDAO imgDAO;

	@Autowired
	public CommodyDAO(TCommodyMapper tCommodyMapper, CommodyImgDAO imgDAO) {
		super();
		this.tCommodyMapper = tCommodyMapper;
		this.imgDAO = imgDAO;
	}

	public Long save(long uid, String title, String description, List<String> imgFileNames, int commodyClassificationId) {
		TCommody entity = new TCommody();
		entity.setClassificationId(commodyClassificationId);
		entity.setDescription(description);
		entity.setTitle(title);
		entity.setUserId(uid);
		
		tCommodyMapper.insertSelective(entity);

		Long commodyId = entity.getId();
		
		for(String imgFilename: imgFileNames) {
			imgDAO.save(imgFilename);
		}
		
		return entity.getId();
	}
	
	public void update(long commodyId, String title, String description, List<String> imgFileNames, int commodyClassificationId) {
		TCommody entity = new TCommody();
		entity.setClassificationId(commodyClassificationId);
		entity.setDescription(description);
		entity.setTitle(title);
		entity.setId(commodyId);
		
		//更新图片前先删除相关的img
		imgDAO.deleteByCommodyId(commodyId);

		for(String imgFilename: imgFileNames) {
			imgDAO.save(imgFilename);
		}
		
		tCommodyMapper.updateByPrimaryKeySelective(entity);
	
	}
	
	public Commody get(Long commodyId) {
		return tCommodyMapper.selectCommodyById(commodyId);
	}
	
	public List<Commody> search(String titleKey) {
		return tCommodyMapper.searchCommodyByTitleKey(titleKey);
	}
}
