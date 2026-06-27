package org.example.service.impl;

import org.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("personService")
public class PersonService implements UserService {

    private boolean connection = false;

    @Override
    public void save(String name) {
        if (connection) {
            System.out.println("Person '" + name + "' has been saved successfully.");
        } else{
            System.out.println("no connection found");
        }

    }

    @PostConstruct
    public void openConnection(){
        System.out.println("connection will open");
        connection = true;
    }

    @PreDestroy
    public void closeConnection(){
        System.out.println("connection will close");
        connection = false;
    }
}
