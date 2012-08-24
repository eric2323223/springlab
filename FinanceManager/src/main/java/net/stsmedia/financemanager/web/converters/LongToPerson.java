package net.stsmedia.financemanager.web.converters;

import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.service.PersonService;

import org.springframework.binding.convert.converters.TwoWayConverter;

/**
 * A editor which allows the translation between {@link Long} and
 * {@link Person}.
 * 
 * 
 * @author Stefan Schmidt
 * @since 0.3
 * 
 */
public class LongToPerson implements TwoWayConverter {

	private PersonService personService;

	public LongToPerson(PersonService personService) {
		this.personService = personService;
	}	

	public Object convertTargetToSourceClass(Object target, Class sourceClass)
			throws Exception {
		Person person = (Person) target;
		return person.toString();
	}

	public Object convertSourceToTargetClass(Object source, Class targetClass)
			throws Exception {
		Long longSource = (Long) source;
		if (longSource != null && longSource > 0) {
			return personService.find(longSource);
		} else {
			return null;
		}
	}

	public Class getSourceClass() {
		return Long.class;
	}

	public Class getTargetClass() {
		return Person.class;
	}
}
