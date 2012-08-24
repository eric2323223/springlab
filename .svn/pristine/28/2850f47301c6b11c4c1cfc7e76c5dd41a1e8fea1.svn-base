package net.stsmedia.financemanager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.core.style.ToStringCreator;

/**
 * A JPA entity for the product domain object. This is an abstract class.
 * Concrete implementations are Loan, ManagedFund and Cash.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@Entity
public abstract class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private java.lang.Long id;

	@Version
	@Column(name = "version")
	private java.lang.Integer version;

	@NotNull
	@Size(min = 1, max = 30)
	@Pattern(regexp = ".+", message = "Name must not be empty!")
	private String name;

	private String description;

	@NotNull
	private Double managementFee;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.Double getManagementFee() {
		return managementFee;
	}

	public void setManagementFee(java.lang.Double managementFee) {
		this.managementFee = managementFee;
	}

	public java.lang.String toString() {
		ToStringCreator tsc = new ToStringCreator(this);
		tsc.append("Name: " + getName());
		tsc.append("Description: " + getDescription());
		tsc.append("ManagementFee: " + getManagementFee());
		return tsc.toString();
	}
}
