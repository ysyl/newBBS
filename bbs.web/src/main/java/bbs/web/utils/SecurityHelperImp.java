package bbs.security.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import security.core.serviceImp.UserDetailsServiceImp;

@Service
@Profile("prod")
public class SecurityHelperImp implements SecurityHelper {
	
	private UserDetailsServiceImp userDetailsService;

	@Autowired
	public SecurityHelperImp(UserDetailsServiceImp userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Override
	public String getCurrentUsername() {
		// TODO Auto-generated method stub
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@Override
	public Long getCurrentUserId() {
		// TODO Auto-generated method stub
		Long uid = userDetailsService.getUserPrincipalByUsername(getCurrentUsername()).getId();
		return uid;
	}


}
