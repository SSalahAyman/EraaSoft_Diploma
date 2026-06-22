package service.impl;

import service.UserService;

public class PersonServiceImpl implements UserService {

    @Override
    public void save(String name) {
        System.out.println("Person '" + name + "' has been saved successfully.");
    }
}
