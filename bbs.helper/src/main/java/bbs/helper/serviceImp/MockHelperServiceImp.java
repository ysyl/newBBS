package bbs.helper.serviceImp;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import bbs.helper.service.HelperService;

@Service
@Profile("dev")
public class MockHelperServiceImp implements HelperService {

	@Override
	public String getCurrentUsername() {
		// TODO Auto-generated method stub
		String username = getMockUsername();
		return username;
	}

	@Override
	public Long getCurrentUserId() {
		// TODO Auto-generated method stub
		return 1L;
	}
	
	private String getMockUsername() {
		return "verrickt";
	}

}
