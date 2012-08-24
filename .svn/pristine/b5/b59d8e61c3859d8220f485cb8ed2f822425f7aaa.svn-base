package net.stsmedia.financemanager.service;

import java.util.Date;
import java.util.HashSet;

import net.stsmedia.financemanager.domain.Account;
import net.stsmedia.financemanager.domain.Address;
import net.stsmedia.financemanager.domain.Investment;
import net.stsmedia.financemanager.domain.Loan;
import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.domain.Product;

/**
 * A simple data seeder for domain objects.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
public class DataSeeder {

	public static Account generateAccount() {
		Account account = new Account();
		account.setName("Homer Simpson House Loan");
		account.setManager(generatePerson());
		HashSet<Person> owners = new HashSet<Person>();
		owners.add(generatePerson());
		owners.add(generatePerson());
		account.setOwners(owners);
		HashSet<Investment> investments = new HashSet<Investment>();
		investments.add(generateInvestment());
		investments.add(generateInvestment());
		account.setInvestments(investments);
		return account;
	}

	public static Person generatePerson() {
		Person person = new Person();
		person.setFirstName("Homer");
		person.setLastName("Simpson");
		person.setEmail("homer@simpsons.com");
		person.setAddress(generateAddress());
		return person;
	}

	public static Investment generateInvestment() {
		Investment investment = new Investment();
		investment.setInitialUnitPrice(1.7f);
		investment.setUnit(100d);
		investment.setTransactionDate(new Date(System.currentTimeMillis()));
		investment.setProduct(generateProduct());
		return investment;
	}

	public static Product generateProduct() {
		Loan loan = new Loan();
		loan.setName("Home Loan");
		loan.setDescription("Real ripoff");
		loan.setInterest(25f);
		loan.setManagementFee(5d);
		HashSet<Person> lenders = new HashSet<Person>();
		lenders.add(generatePerson());
		lenders.add(generatePerson());
		loan.setLenders(lenders);
		return loan;
	}

	public static Address generateAddress() {
		return new Address("Evergreen Terrace", "99a", "Springfield", "57657", "Ohio", "USA");
	}
}
