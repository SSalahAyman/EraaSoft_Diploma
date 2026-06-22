package service.impl;

import org.springframework.stereotype.Component;
import service.UserService;

@Component("personService")
public class PersonServiceImpl implements UserService {

    @Override
    public void save(String name) {
        System.out.println("PersonService: Saving person with name = " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("PersonService: Updating person with name = " + name);
    }
}
