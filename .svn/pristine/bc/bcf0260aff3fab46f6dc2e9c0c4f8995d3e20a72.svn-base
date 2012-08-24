package net.stsmedia.financemanager.web.converters;

import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.service.PersonService;

import org.springframework.binding.convert.converters.TwoWayConverter;

/**
 * A editor which allows the translation between {@link String} and
 * {@link Person}.
 * 
 * 
 * @author Stefan Schmidt
 * @since 0.3
 * 
 */
public class StringToPerson implements TwoWayConverter {

	private PersonService personService;

	public StringToPerson(PersonService personService) {
		this.personService = personService;
	}	

	public Object convertTargetToSourceClass(Object target, Class sourceClass)
			throws Exception {
		String stringSource = (String) target;
		if (stringSource != null && stringSource.length() > 0) {
			return personService.find(Long.valueOf(stringSource));
		} else {
			return null;
		}
	}

	public Object convertSourceToTargetClass(Object source, Class targetClass)
			throws Exception {
		if(source != null)
			return ((Person) source).toString();
		else return null;
	}

	public Class getSourceClass() {
		return String.class;
	}

	public Class getTargetClass() {
		return Person.class;
	}

}
