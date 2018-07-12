package bbs.helper.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bbs.forum.service.BBSService;
import bbs.helper.service.HelperService;

@Service
@Profile("prod")
public class HelperServiceImp implements HelperService {
	
	private BBSService bbsService;

	@Autowired
	public HelperServiceImp(BBSService bbsService) {
		super();
		this.bbsService = bbsService;
	}

	@Override
	public String getCurrentUsername() {
		// TODO Auto-generated method stub
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@Override
	public Long getCurrentUserId() {
		// TODO Auto-generated method stub
		Long uid = bbsService.getUser(getCurrentUsername()).getId();
		return uid;
	}

}
