package net.stsmedia.financemanager.security;

import javax.annotation.PostConstruct;

import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.service.AuthorityService;
import net.stsmedia.financemanager.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * A simple data seeder which populates the db with a single 
 * user with admin priviliges.
 * 
 * @author Stefan Schmidt
 * @since 0.4
 * 
 */
@Component
public class SeedAdminData {
	
	@Autowired private PersonService personService;
	@Autowired private AuthorityService authorityService;
	
	@Value("#{adminUser}") private Person admin;
	@Value("#{adminAuthority}") private Authorities adminAuthorities;

	@PostConstruct
	private void seedAdmin() {
        // Set a dummy admin account that will create the actual admin
        Authentication authRequest = new UsernamePasswordAuthenticationToken("ignored", "ignored", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        SecurityContextHolder.getContext().setAuthentication(authRequest);

		personService.persist(admin);		
		authorityService.persist(adminAuthorities);
		
		SecurityContextHolder.clearContext();
	}
}