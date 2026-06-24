package service.impl;

import service.AccountService;
import service.UserService;

public class AccountServiceImpl implements AccountService {

    private UserService userService;

    public AccountServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getSavePerson(String name) {
        userService.save(name);
    }
}
