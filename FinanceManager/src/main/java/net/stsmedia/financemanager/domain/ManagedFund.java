package net.stsmedia.financemanager.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A JPA entity for the managed fund domain object.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@Entity
public class ManagedFund extends Product {

	@NotNull
	@Size(min = 0, max = 15)
	private String fundId;

	private Double distribution;

	@NotNull
	private Float currentUnitPrice;

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public Double getDistribution() {
		return distribution;
	}

	public void setDistribution(Double distribution) {
		this.distribution = distribution;
	}

	public Float getCurrentUnitPrice() {
		return currentUnitPrice;
	}

	public void setCurrentUnitPrice(Float currentUnitPrice) {
		this.currentUnitPrice = currentUnitPrice;
	}

	public String toString() {
		org.springframework.core.style.ToStringCreator tsc = new org.springframework.core.style.ToStringCreator(this);
		tsc.append("Name: " + getName());
		tsc.append("Description: " + getDescription());
		tsc.append("ManagementFee: " + getManagementFee());
		tsc.append("FundId: " + getFundId());
		tsc.append("Distribution: " + getDistribution());
		tsc.append("CurrentUnitPrice: " + getCurrentUnitPrice());
		return tsc.toString();
	}
}
