package net.stsmedia.financemanager.service;

import java.util.List;

import net.stsmedia.financemanager.dao.GenericDAOWithJPA;
import net.stsmedia.financemanager.domain.Account;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a service layer interface (actually more of a simple facade). Note
 * that most of these methods are implemented by {@link GenericDAOWithJPA}.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
public interface AccountService {

	//TODO:this does not work
	//@PostFilter("filterObject.owners.email == principal.username or hasRole('ROLE_ADMIN')")
	List<Account> findAll();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	void persist(Account entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	void merge(Account entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	void remove(Account entity);

	Account find(Long id);
}
