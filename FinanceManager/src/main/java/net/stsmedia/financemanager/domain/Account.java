package net.stsmedia.financemanager.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.core.style.ToStringCreator;

/**
 * A JPA entity for the account domain object.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@Entity
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@NotNull
	@Pattern(regexp = ".+", message = "Name must not be empty!")
	private String name;

	@NotNull
	@OneToMany
	private Set<Person> owners = new HashSet<Person>();

	@NotNull
	@ManyToOne
	@JoinColumn
	private Person manager;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Investment> investments = new HashSet<Investment>();

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getOwners() {
		return owners;
	}

	public void setOwners(Set<Person> owners) {
		this.owners = owners;
	}
	
	public void addOwner(Person person) {
		this.owners.add(person);
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public Set<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(Set<Investment> investments) {
		this.investments = investments;
	}

	public void addInvestment(Investment investment) {
		this.investments.add(investment);
	}

	public String toString() {
		ToStringCreator tsc = new ToStringCreator(this);
		tsc.append("Name: " + getName());
		tsc.append("Owners: " + owners.size());
		tsc.append("Manager: " + getManager());
		tsc.append("Investments: " + investments.size());
		return tsc.toString();
	}
}