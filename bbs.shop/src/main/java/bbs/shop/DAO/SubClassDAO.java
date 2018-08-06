package bbs.shop.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.shop.entity.SubClass;
import bbs.shop.mybatis.mapper.TSubClassMapper;

@Component
public class SubClassDAO {
	
	private TSubClassMapper tSubClassMapper;

	@Autowired
	public SubClassDAO(TSubClassMapper tSubClassMapper) {
		super();
		this.tSubClassMapper = tSubClassMapper;
	}

	public void associateSubClassToCommody(Integer subClassId, Long commodyId) {
		// TODO Auto-generated method stub
		tSubClassMapper.associateSubClassToCommody(subClassId, commodyId);
	}

	public void unassociateSubClassToCommody(Integer subClassId, long commodyId) {
		// TODO Auto-generated method stub
		tSubClassMapper.unassociateSubClassToCommody(subClassId, commodyId);
	}

	public SubClass getSubClass(int subClassId) {
		// TODO Auto-generated method stub
		return tSubClassMapper.selectSubClassById(subClassId);
	}

}
