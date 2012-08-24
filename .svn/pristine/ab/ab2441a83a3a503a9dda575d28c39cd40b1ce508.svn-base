package net.stsmedia.financemanager.web.mvc;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import net.stsmedia.financemanager.domain.Cash;
import net.stsmedia.financemanager.domain.Loan;
import net.stsmedia.financemanager.domain.ManagedFund;
import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.domain.Product;
import net.stsmedia.financemanager.service.PersonService;
import net.stsmedia.financemanager.service.ProductService;
import net.stsmedia.financemanager.web.editors.PersonEditor;
import net.stsmedia.financemanager.web.editors.ProductEditor;

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
 * This is a Controller for the {@link Product} domain object. It demonstrates
 * the use of the new Spring 3.0 REST support.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@Controller
@RequestMapping("/product/**")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private PersonService personService;

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("products", productService.findAll());
		return "product/list";
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) {
		Assert.notNull(id, "Identifier must be provided.");
		modelMap.addAttribute("product", productService.find(id));
		return "product/show";
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id, ModelMap modelMap) {
		Assert.notNull(id, "Identifier must be provided.");
		try {
			productService.remove(productService.find(id));
		} catch (DataIntegrityViolationException e) {
			modelMap.addAttribute("integrityViolation", "Could not delete " + "this person as it is connected to an account. Please delete " + "the relevant account(s) first.");
		}
		return "redirect:/product";
	}

	@RequestMapping(value = "/product/form/{type}", method = RequestMethod.GET)
	public String form(@PathVariable("type") String type, ModelMap modelMap) {
		if ("cash".equals(type)) {
			modelMap.addAttribute("cash", new Cash());
		} else if ("managedFund".equals(type)) {
			modelMap.addAttribute("managedFund", new ManagedFund());
		} else if ("loan".equals(type)) {
			modelMap.addAttribute("loan", new Loan());
			modelMap.addAttribute("lenders", personService.findAll());
		}
		return "product/create";
	}

	@RequestMapping(value = "/product/cash", method = RequestMethod.POST)
	public String createCash(@ModelAttribute("cash") Cash product, BindingResult result) {
		Assert.notNull(product, "Product must be provided.");
		for (ConstraintViolation<Cash> constraint : validator.validate(product)) {
			result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
		}
		if (result.hasErrors())
			return "product/create";
		productService.persist(product);
		return "redirect:/product/" + product.getId();
	}

	@RequestMapping(value = "/product/managedFund", method = RequestMethod.POST)
	public String createManagedFund(@ModelAttribute("managedFund") ManagedFund product, BindingResult result) {
		Assert.notNull(product, "Product must be provided.");
		for (ConstraintViolation<ManagedFund> constraint : validator.validate(product)) {
			result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
		}
		if (result.hasErrors())
			return "product/create";
		productService.persist(product);
		return "redirect:/product/" + product.getId();
	}

	@RequestMapping(value = "/product/loan", method = RequestMethod.POST)
	public String createLoan(@ModelAttribute("loan") Loan product, BindingResult result) {
		Assert.notNull(product, "Product must be provided.");
		for (ConstraintViolation<Loan> constraint : validator.validate(product)) {
			result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
			System.err.println("\n\n " + constraint.getMessage() + "\n\n");
		}
		if (result.hasErrors())
			return "product/create";
		productService.persist(product);
		return "redirect:/product/" + product.getId();
	}

	@RequestMapping(value = "/product/{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		Assert.notNull(id, "Identifier must be provided.");
		modelMap.addAttribute("product", productService.find(id));
		return "product/update";
	}

	@RequestMapping(value = "/product/Cash", method = RequestMethod.PUT)
	public String updateCash(@ModelAttribute("cash") Cash product, BindingResult result) {
		Assert.notNull(product, "product must be provided.");
		for (ConstraintViolation<Cash> constraint : validator.validate(product)) {
			result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
		}
		if (result.hasErrors())
			return "product/update";
		productService.merge(product);
		return "redirect:/product/" + product.getId();
	}

	@RequestMapping(value = "/product/ManagedFund", method = RequestMethod.PUT)
	public String updateManagedFund(@ModelAttribute("ManagedFund") ManagedFund product, BindingResult result) {
		Assert.notNull(product, "product must be provided.");
		for (ConstraintViolation<ManagedFund> constraint : validator.validate(product)) {
			result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
		}
		if (result.hasErrors())
			return "product/update";
		productService.merge(product);
		return "redirect:/product/" + product.getId();
	}

	@RequestMapping(value = "/product/Loan", method = RequestMethod.PUT)
	public String updateLoan(@ModelAttribute("loan") Loan product, BindingResult result) {
		Assert.notNull(product, "product must be provided.");
		for (ConstraintViolation<Loan> constraint : validator.validate(product)) {
			result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
		}
		if (result.hasErrors())
			return "product/update";
		productService.merge(product);
		return "redirect:/product/" + product.getId();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Product.class, new ProductEditor(productService));
		binder.registerCustomEditor(Person.class, new PersonEditor(personService));
	}
}
