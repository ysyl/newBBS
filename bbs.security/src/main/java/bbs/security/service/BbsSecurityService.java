package bbs.security.service;

import bbs.security.form.BbsUserForm;
import security.core.DTO.UserPrincipal;

public interface BbsSecurityService {

	void register(BbsUserForm form);

	void getCurrentUid();

	UserPrincipal getUserPrincipal(String username);
}
