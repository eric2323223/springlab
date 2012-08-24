package net.stsmedia.financemanager.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.core.style.ToStringCreator;

/**
 * A JPA entity for the loan domain object.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@Entity
public class Loan extends Product {

	@NotNull()
	private Float interest;

	@NotNull
	private Double principal;

	@NotNull
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Person> lenders = new HashSet<Person>();

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Set<Person> getLenders() {
		return lenders;
	}

	public void setLenders(Set<Person> lenders) {
		this.lenders = lenders;
	}

	public String toString() {
		ToStringCreator tsc = new ToStringCreator(this);
		tsc.append("Name: " + getName());
		tsc.append("Description: " + getDescription());
		tsc.append("ManagementFee: " + getManagementFee());
		tsc.append("Interest: " + getInterest());
		tsc.append("Principal: " + getPrincipal());
		tsc.append("Lenders: " + lenders.size());
		return tsc.toString();
	}
}
