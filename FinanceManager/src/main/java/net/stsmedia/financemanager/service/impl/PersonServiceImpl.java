package net.stsmedia.financemanager.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityTransaction;

import net.stsmedia.financemanager.dao.GenericDAOWithJPA;
import net.stsmedia.financemanager.domain.Address;
import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.security.Authorities;
import net.stsmedia.financemanager.service.PersonService;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a service layer implementation for {@link PersonService}. Note that
 * most of these methods from the interface are implemented by
 * {@link GenericDAOWithJPA}.
 * 
 * The findByLastName method has been added to demonstrate how a custom method
 * is implemented in {@link PersonServiceImpl}.
 * 
 * This class also provides the functionality of the repository. More
 * information about this in my blog article entitled 'Spring Finance > Part 3:
 * DDD, JPA & Transactions' published at StSMedia.net
 * 
 * @author Stefan Schmidt
 * @since 0.1
 * 
 */
@Service("personService")
@Repository
public class PersonServiceImpl extends GenericDAOWithJPA<Person, Long> implements PersonService {

	// custom repository method
	public List<Person> findByLastName(String lastName) {
		return super.entityManager.createQuery("Select p from Person p where p.lastName = :lastName").setParameter("lastName", lastName).getResultList();
	}
}
