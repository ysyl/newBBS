package bbs.usercenter.profile.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.DTO.User;
import bbs.forum.entity.TUser;
import bbs.forum.form.UpdateUserProfileForm;
import bbs.usercenter.form.PubUserProfileForm;
import bbs.usercenter.mybatis.entity.TUserProfile;
import bbs.usercenter.mybatis.mapper.TUserProfileMapper;

@Transactional
@Component
public class UserProfileDAO {
	
	private TUserProfileMapper tUserMapper;
	
	@Autowired
	public UserProfileDAO(TUserProfileMapper tUserMapper) {
		super();
		this.tUserMapper = tUserMapper;
	}

	public long save(PubUserProfileForm form) {
		// TODO Auto-generated method stub
		TUserProfile tUser = new TUserProfile();
		tUser.setNickname(form.getNickname());
		tUser.setSex(form.getSex());
		tUser.setId(form.getId());
		
		tUserMapper.insertSelective(tUser);
		return tUser.getId();
	}
	
	public void update(Long uid, PubUserProfileForm updateUserProfileForm) {
		TUserProfile tUser = new TUserProfile();
		tUser.setId(uid);
		tUser.setNickname(updateUserProfileForm.getNickname());
		tUser.setSex(updateUserProfileForm.getSex());
		tUser.setAvatar(updateUserProfileForm.getAvatar());
		
		tUserMapper.updateByPrimaryKeySelective(tUser);
	}
}
