package bbs.security.helper;


import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MockHelperServiceImp implements SecurityHelper {

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
