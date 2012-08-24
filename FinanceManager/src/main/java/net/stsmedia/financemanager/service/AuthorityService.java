package net.stsmedia.financemanager.service;

import net.stsmedia.financemanager.security.Authorities;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

/**
 * A simple service layer for the authorities table
 * used by Spring Security. If desired this service 
 * can be expanded to allow full management of user
 * permissions.
 * 
 * @author Stefan Schmidt
 * @since 0.4
 * 
 */
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface AuthorityService {

	@Transactional	
	void persist(Authorities entity);
}
