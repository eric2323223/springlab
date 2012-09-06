package net.twasink.hsqldbtest;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table
public class Foo {
    
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column
    private long id;
    
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    
    @Column(length = 200, nullable = true)
    private String description;
    
    Foo() {
        // for hibernate.
    }
    
    public Foo(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}