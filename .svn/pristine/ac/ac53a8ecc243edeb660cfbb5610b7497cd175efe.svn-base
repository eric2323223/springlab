package net.stsmedia.financemanager.web.mvc;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.security.Authorities;
import net.stsmedia.financemanager.service.AuthorityService;
import net.stsmedia.financemanager.service.PersonService;
import net.stsmedia.financemanager.web.editors.PersonEditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * This is a Controller for the {@link Person} domain object. It demonstrates
 * the use of the new Spring 3.0 REST support.
 * 
 * @author Stefan Schmidt
 * @since 0.1
 * 
 */
@Controller
@RequestMapping("/person/**")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private AuthorityService authorityService;

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) {
		Assert.notNull(id, "Identifier must be provided.");
		modelMap.addAttribute("person", personService.find(id));
		return "person/show";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("people", personService.findAll());
		return "person/list";
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id, ModelMap modelMap) {
		Assert.notNull(id, "Identifier must be provided.");
		try {
			personService.remove(personService.find(id));
		} catch (DataIntegrityViolationException e) {
			modelMap.addAttribute("integrityViolation", "Could not delete " + "this person as it is connected to an account. Please delete " + "the relevant account(s) first.");
		}
		return "redirect:/person";
	}

	@RequestMapping(value = "/person/form", method = RequestMethod.GET)
	public String form(ModelMap modelMap) {
		modelMap.addAttribute("person", new Person());
		return "person/create";
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String create(@ModelAttribute("person") Person person, BindingResult result) {
		Assert.notNull(person, "Person must be provided.");
		
		//create 'user' role authority for this user
		Authorities authorities = new Authorities();
		authorities.setUsername(person.getEmail());
		authorities.setAuthority("ROLE_USER");
		authorityService.persist(authorities);
		
		for (ConstraintViolation<Person> constraint : validator.validate(person)) {
			result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
		}
		if (result.hasErrors())
			return "/person/create";
		personService.persist(person);
		return "redirect:/person/" + person.getId();
	}

	@RequestMapping(value = "/person/{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		Assert.notNull(id, "Identifier must be provided.");
		modelMap.addAttribute("person", personService.find(id));
		return "person/update";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(@ModelAttribute("person") Person person, BindingResult result) {
		Assert.notNull(person, "Person must be provided.");
		for (ConstraintViolation<Person> constraint : validator.validate(person)) {
			result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
		}
		if (result.hasErrors())
			return "person/update";
		personService.merge(person);
		return "redirect:/person/" + person.getId();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Person.class, new PersonEditor(personService));
	}
}
