/**
 * 
 */
package name.brucephillips.springjpaexample.action;

import name.brucephillips.springjpaexample.model.Person;
import name.brucephillips.springjpaexample.service.PersonService;

import com.opensymphony.xwork2.ActionSupport;


/**
 * Acts as the controller for handling user
 * requests to edit a Person object.
 * @author brucephillips
 *
 */
public class PersonUpdater extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient PersonService personService;
	
	private Person person ;
	
	private Long emplid ;
	
	/**
	 * Use the emplid value that was provided
	 * when the user clicked on the edit link
	 * get the associated Person object.
	 * 
	 */
	public String input() throws Exception {
		
		person = personService.findByEmplid(emplid);
		
		return INPUT ;
		
	}
	
	
	/**
	 * Use the state of the Person 
	 * object (which was updated by the 
	 * user in the view) to update 
	 * the data repository.
	 */
	public String execute() throws Exception {

		personService.update(person);
		
		return SUCCESS;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getEmplid() {
		return emplid;
	}

	public void setEmplid(Long emplid) {
		this.emplid = emplid;
	}
	

}
