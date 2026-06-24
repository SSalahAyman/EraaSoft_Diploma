package service.impl;

import org.springframework.stereotype.Component;
import service.UserService;


public class MangerServiceImpl implements UserService {

    @Override
    public void save(String name) {
        System.out.println("ManagerService: Saving manager with name = " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("ManagerService: Updating manager with name = " + name);
    }
}
