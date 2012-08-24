package net.stsmedia.financemanager.service;

import java.util.List;

import net.stsmedia.financemanager.dao.GenericDAOWithJPA;
import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.service.impl.PersonServiceImpl;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a service layer interface (actually more of a simple facade). Note
 * that most of these methods are implemented by {@link GenericDAOWithJPA}.
 * 
 * The findByLastName method has been added to demonstrate how a custom method
 * is implemented in {@link PersonServiceImpl}.
 * 
 * @author Stefan Schmidt
 * @since 0.1
 * 
 */
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public interface PersonService {

	@PostFilter("filterObject.email == principal.username or hasRole('ROLE_ADMIN')")
	List<Person> findAll();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	List<Person> findByLastName(String lastName);

	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	void persist(Person entity);

	@PreFilter("filterObject.email == principal.username")
	@Transactional
	void merge(Person entity);


	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	void remove(Person entity);

	Person find(Long id);
}
