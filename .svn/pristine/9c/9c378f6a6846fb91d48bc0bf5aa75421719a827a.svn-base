package net.stsmedia.financemanager.service;

import net.stsmedia.financemanager.domain.Loan;
import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.domain.Product;

import static org.junit.Assert.*;

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
 * A simple integration test for {@link ProductService}.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration(locations = { "classpath:FinanceManager-test.xml" })
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private PersonService personService;

	private Product product;

	@Before
	public void setup() {
		Authentication authRequest = new UsernamePasswordAuthenticationToken("ignored", "ignored", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
	    SecurityContextHolder.getContext().setAuthentication(authRequest);

		product = DataSeeder.generateProduct();

		if (product instanceof Loan) {
			for (Person person : ((Loan) product).getLenders()) {
				personService.persist(person);
			}
		}
	}

	@Test
	@Rollback
	public void testFindAll() {
		productService.persist(product);
		assertEquals(1, productService.findAll().size());
	}

	@Test
	@Rollback
	public void testPersist() {
		productService.persist(product);
		assertEquals(1, productService.findAll().size());
	}

	@Test
	@Rollback
	public void testMerge() {
		productService.persist(product);
		Product renamedProduct = productService.find(product.getId());
		renamedProduct.setName("New Name");
		assertEquals("New Name", productService.find(product.getId()).getName());
	}

	@Test
	@Rollback
	public void testRemove() {
		productService.persist(product);
		productService.remove(productService.find(product.getId()));
		assertEquals(0, productService.findAll().size());
	}

	@Test
	@Rollback
	public void testFind() {
		productService.persist(product);
		assertNotNull(productService.find(product.getId()));
	}
	
	@After
	public void tearDown(){
		SecurityContextHolder.clearContext();
	}
}
