package bbs.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import security.core.DTO.CustomUser;

@Component
public class PrincipalChecker {
	
	private IAuthenticationFacade authenticationFacade;

	@Autowired
	public PrincipalChecker(IAuthenticationFacade authenticationFacade) {
		super();
		this.authenticationFacade = authenticationFacade;
	}
	
	public boolean isMeByUsername(String username) {
		return username.equals(authenticationFacade.getUsername());
	}

	public boolean isMeByUid(long uid) {
		MyLogger.info("\n isMeByUid: " + uid);
		long myUid;
		try {
			myUid = authenticationFacade.getUserId();
		} catch (HasNotLoginException e) {
			// TODO Auto-generated catch block
			return false;
		}
		MyLogger.infoln(this.getClass(), "是本人吗：" + (uid == myUid));
		return uid == myUid;
	}

}
