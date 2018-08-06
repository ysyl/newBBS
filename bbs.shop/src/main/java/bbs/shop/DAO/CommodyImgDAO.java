package bbs.shop.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.shop.mybatis.entity.TCommodyImg;
import bbs.shop.mybatis.mapper.TCommodyImgMapper;

@Component
public class CommodyImgDAO {  
	
	private TCommodyImgMapper mapper;

	@Autowired
	public CommodyImgDAO(TCommodyImgMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public void save(Long commodyId, String imgFilename) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByCommodyId(Object common) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByCommodyId(long commodyId) {
		// TODO Auto-generated method stub
		mapper.deleteByCommodyId(commodyId);
	}

	public void saveImgToCommody(Long commodyId, String imgFilename) {
		// TODO Auto-generated method stub
		TCommodyImg entity = new TCommodyImg();
		entity.setCommodyId(commodyId);
		entity.setFilename(imgFilename);
		mapper.insert(entity);
	}

}
