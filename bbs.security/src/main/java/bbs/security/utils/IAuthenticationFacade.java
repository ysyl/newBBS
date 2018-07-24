package bbs.security.utils;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {

	public Authentication getAuthentication();
	
	public String getUsername();
	
	public Long getUserId() throws HasNotLoginException;

	public boolean isAuthenticated();
}
