package bbs.shop.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.shop.entity.CommodyClassification;
import bbs.shop.mybatis.mapper.TCommodyClassificationMapper;

@Component
public class CommodyClassificationDAO {
	
	private TCommodyClassificationMapper mapper;

	@Autowired
	public CommodyClassificationDAO(TCommodyClassificationMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public List<CommodyClassification> getAllClassification() {
		// TODO Auto-generated method stub
		return mapper.selectAllClassification();
	}

	public CommodyClassification getById(Integer classificationId) {
		// TODO Auto-generated method stub
		return mapper.selectCommodyClassificationById(classificationId);
	}
	
}
