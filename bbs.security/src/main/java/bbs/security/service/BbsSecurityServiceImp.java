package bbs.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbs.forum.DTO.User;
import bbs.helper.utils.MyLogger;
import bbs.security.form.BbsUserForm;
import bbs.usercenter.form.PubUserProfileForm;
import bbs.usercenter.service.UserCenterService;
import security.core.DTO.UserPrincipal;
import security.core.form.UserPrincipalForm;
import security.core.service.SecurityCoreService;

@Service
@Transactional
public class BbsSecurityServiceImp implements BbsSecurityService {
	
	private UserCenterService userCenterService;
	
	private SecurityCoreService securityCoreService;
	
	@Autowired
	public BbsSecurityServiceImp(UserCenterService userCenterService, SecurityCoreService securityCoreService) {
		super();
		this.userCenterService = userCenterService;
		this.securityCoreService = securityCoreService;
	}

	@Override
	public void register(BbsUserForm form) {
		// TODO Auto-generated method stub
		UserPrincipalForm userPrincipalForm = new UserPrincipalForm();
		userPrincipalForm.setEmail(form.getEmail());
		userPrincipalForm.setUsername(form.getUsername());
		userPrincipalForm.setPassword(form.getPassword());
		
		Long uid = securityCoreService.createUserPrincipal(userPrincipalForm);
		PubUserProfileForm userProfileForm = new PubUserProfileForm();
		userProfileForm.setId(uid);
		userProfileForm.setNickname(form.getNickname());
		userProfileForm.setSex(form.getSex());
		
		userCenterService.createUserProfile(userProfileForm);
	}


	@Override
	public UserPrincipal getUserPrincipal(String username) {
		// TODO Auto-generated method stub
		return securityCoreService.getUserPrincipalByUsername(username);
	}

}
