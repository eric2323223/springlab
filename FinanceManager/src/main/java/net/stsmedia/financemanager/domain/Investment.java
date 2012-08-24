package net.stsmedia.financemanager.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * A JPA entity for the Investment domain object.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@Entity
public class Investment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@NotNull
	@Min(value = 1, message = "You must buy 1 or more units")
	private Double unit;

	@NotNull
	@Min(value = 0, message = "Unit price should be positive")
	private Float initialUnitPrice;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;

	@NotNull
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

	public Float getInitialUnitPrice() {
		return initialUnitPrice;
	}

	public void setInitialUnitPrice(Float initialUnitPrice) {
		this.initialUnitPrice = initialUnitPrice;
	}

	public java.util.Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(java.util.Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(product);
		string.append(", units: "+ unit);
		string.append(", price: " + initialUnitPrice);
		string.append(", date: " + transactionDate);
		return string.toString();
	}
}
