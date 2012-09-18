package com.eric.mvnlab.controller;

import com.eric.mvnlab.model.Person;
import com.eric.mvnlab.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/18/12
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="/person")
public class PersonController {

    @Inject
    PersonService personService;

    public String createPerson(Model model, Person person) {
        model.addAttribute(person);
        return "personList";
    }

    @RequestMapping(value = "/create")
    public String listPerson(Model model) {
        model.addAttribute(new Person());
        return "createPerson";
    }

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public String handleSubmit(Person person){
        personService.createPerson(person);
        return "personList";
    }


}
