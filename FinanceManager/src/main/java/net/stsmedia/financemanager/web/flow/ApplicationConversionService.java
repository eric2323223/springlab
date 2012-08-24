package net.stsmedia.financemanager.web.flow;

import net.stsmedia.financemanager.service.PersonService;
import net.stsmedia.financemanager.service.ProductService;
import net.stsmedia.financemanager.web.converters.LongToPerson;
import net.stsmedia.financemanager.web.converters.LongToProduct;
import net.stsmedia.financemanager.web.converters.StringToPerson;
import net.stsmedia.financemanager.web.converters.StringToProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.convert.converters.StringToDate;
import org.springframework.binding.convert.service.DefaultConversionService;
import org.springframework.stereotype.Component;

/**
 * Conversion service registration point for Spring Web Flow.
 * 
 * @author Stefan Schmidt
 * @since 0.3
 *
 */
@Component("conversionService")
public class ApplicationConversionService extends DefaultConversionService {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ProductService productService;

    @Override
    protected void addDefaultConverters() {
		super.addDefaultConverters();
		StringToDate dateConverter = new StringToDate();
		dateConverter.setPattern("MM/dd/yyyy");
		addConverter("shortDate", dateConverter);
		addConverter(new LongToPerson(personService));
		addConverter(new StringToProduct(productService));
		addConverter(new StringToPerson(personService));
		addConverter(new LongToProduct(productService));
    }

}