package bbs.security.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import security.core.DTO.CustomUser;

@Component
public class AuthenticaFacede implements IAuthenticationFacade {

	@Override
	public Authentication getAuthentication() {
		// TODO Auto-generated method stub
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		String username = this.getAuthentication().getName();
		MyLogger.info(this.getClass(), "\n\n 获取用户名：" + username);
		return username;
	}

	@Override
	public Long getUserId() throws HasNotLoginException {
		// TODO Auto-generated method stub
		Authentication auth = this.getAuthentication();
		if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser user = (CustomUser) this.getAuthentication().getPrincipal();
			MyLogger.info("\n\n 返回user 的 id： " + user.getId());
			return user.getId();
		}
		throw new HasNotLoginException("当前是匿名登录");
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return this.getAuthentication() != null;
	}

}
