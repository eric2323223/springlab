package com.eric.mvnlab.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/3/12
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE", length = 100, nullable = false)
    private String title;
    @Column(name = "BEGIN_DATE")
    private Date beginDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "FEE")
    private int fee;
// Constructors, Getters and Setters
}
