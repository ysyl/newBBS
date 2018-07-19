package bbs.security.helper;

import org.springframework.security.core.userdetails.User;

public interface SecurityHelper {

	String getCurrentUsername();
	
	Long getCurrentUserId();

}
