package net.stsmedia.financemanager.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.core.style.ToStringCreator;

/**
 * A JPA entity for the cash domain object.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@Entity
public class Cash extends Product {

	@NotNull
	@Min(0)
	private Float interest;

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public String toString() {
		ToStringCreator tsc = new ToStringCreator(this);
		tsc.append("Name: " + getName());
		tsc.append("Description: " + getDescription());
		tsc.append("ManagementFee: " + getManagementFee());
		tsc.append("Interest: " + getInterest());
		return tsc.toString();
	}
}
