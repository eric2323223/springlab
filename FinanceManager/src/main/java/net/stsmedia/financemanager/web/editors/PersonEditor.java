package net.stsmedia.financemanager.web.editors;

import java.beans.PropertyEditorSupport;

import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.service.PersonService;

import org.springframework.beans.SimpleTypeConverter;

/**
 * A editor which allows the translation between {@link String} and
 * {@link Person}.
 * 
 * 
 * @author Stefan Schmidt
 * @since 0.1
 * 
 */
public class PersonEditor extends PropertyEditorSupport {

	private PersonService personService;

	public PersonEditor(PersonService personService) {
		super();
		this.personService = personService;
	}

	SimpleTypeConverter typeConverter = new SimpleTypeConverter();

	public String getAsText() {
		Object obj = getValue();
		if (obj == null) {
			return null;
		}
		return (String) typeConverter.convertIfNecessary(((Person) obj).getId(), String.class);
	}

	public void setAsText(String text) {
		if (text == null || text.length() == 0) {
			setValue(null);
			return;
		}

		Long identifier = (Long) typeConverter.convertIfNecessary(text, Long.class);
		if (identifier == null) {
			setValue(null);
			return;
		}

		setValue(personService.find(identifier));
	}
}
