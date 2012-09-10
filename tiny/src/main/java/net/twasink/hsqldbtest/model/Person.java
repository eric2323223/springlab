package net.twasink.hsqldbtest.model;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/5/12
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Persons")
@NamedQueries({
        @NamedQuery(name="Person.findByName",query = "select c from Person c where c.firstName = :firstname") ,
        @NamedQuery(name="Person.getRichest", query = "select c from Person c order by c.money")
})
public class Person {
    @javax.persistence.Id
    @Column(name = "Id_P")
    int id_p;

    @Column(name = "LastName")
    String lastName;
    @Column(name = "FirstName")
    String firstName;
    @Column(name = "Address")
    String address;

    @Column(name="City")
    String city;

    @Column(name="Money")
    int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId_p() {

        return id_p;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return this.firstName+" "+this.lastName +" has "+ this.money+" bucks";
    }
}
