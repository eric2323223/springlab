package net.stsmedia.financemanager.service;

import static org.junit.Assert.assertEquals;
import net.stsmedia.financemanager.domain.Person;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * A simple integration test for PersonService.
 * 
 * @author Stefan Schmidt
 * @since 0.1
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration(locations = { "classpath:FinanceManager-test.xml" })
public class PersonServiceTest {

	@Autowired
	private PersonService personService;
	
	@Before
	public void setup(){
		Authentication authRequest = new UsernamePasswordAuthenticationToken("ignored", "ignored", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
	    SecurityContextHolder.getContext().setAuthentication(authRequest);

	}

	@Test
	@Rollback
	public void testPersist() {
		Person homer = DataSeeder.generatePerson();
		homer.setEmail(null);
		personService.persist(homer);
		assertEquals("Homer", personService.find(homer.getId()).getFirstName());
	}

	@Test
	@Rollback
	public void testUpdate() {
		Person person = DataSeeder.generatePerson();
		personService.persist(person);
		person.setFirstName("Marge");
		personService.merge(person);
		assertEquals("Marge", personService.find(person.getId()).getFirstName());
	}

	@Test
	@Rollback
	public void testDelete() {
		Person homer = DataSeeder.generatePerson();
		personService.persist(homer);
		personService.remove(homer);
		assertEquals(1l, personService.findAll().size());
	}

	@Test
	@Rollback
	public void testRead() {
		Person homer = DataSeeder.generatePerson();
		personService.persist(homer);
		Person result = personService.find(homer.getId());
		assertEquals("Homer", result.getFirstName());
		assertEquals("Simpson", result.getLastName());
		assertEquals("homer@simpsons.com", result.getEmail());
		assertEquals("Evergreen Terrace", result.getAddress().getStreetName());
		assertEquals("99a", result.getAddress().getStreetNumber());
		assertEquals("Springfield", result.getAddress().getCity());
		assertEquals("57657", result.getAddress().getZipCode());
		assertEquals("Ohio", result.getAddress().getState());
		assertEquals("USA", result.getAddress().getCountry());
	}

	@Test
	@Rollback
	public void testFindByLastName() {
		personService.persist(DataSeeder.generatePerson());
		assertEquals("Homer", personService.findByLastName("Simpson").get(0).getFirstName());
	}
	
	@After
	public void tearDown(){
		SecurityContextHolder.clearContext();
	}
}
