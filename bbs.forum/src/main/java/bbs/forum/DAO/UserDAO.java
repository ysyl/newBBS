package bbs.forum.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.DTO.User;
import bbs.forum.entity.TUser;
import bbs.forum.form.UserProfileForm;
import bbs.forum.mapper.TUserMapper;

@Transactional
@Component
public class UserDAO {
	
	private TUserMapper tUserMapper;

	public void save(long uid, UserProfileForm form) {
		// TODO Auto-generated method stub
		TUser tUser = new TUser();
		tUser.setId(uid);
		tUser.setNickname(form.getNickname());
		tUser.setSex(form.getSex());
		
		tUserMapper.insert(tUser);
	}

	public User get(long uid) {
		// TODO Auto-generated method stub
		User user = tUserMapper.selectUserByid(uid);
		return user;
	}

	public TUserMapper gettUserMapper() {
		return tUserMapper;
	}

	@Autowired
	public void settUserMapper(TUserMapper tUserMapper) {
		this.tUserMapper = tUserMapper;
	}

	public User get(String nickname) {
		// TODO Auto-generated method stub
		User user = tUserMapper.selectUserByNickname(nickname);
		return user;
	}
}
