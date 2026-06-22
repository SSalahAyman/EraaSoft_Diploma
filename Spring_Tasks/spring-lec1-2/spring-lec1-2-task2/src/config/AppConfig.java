package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.AccountService;
import service.UserService;
import service.impl.AccountServiceImpl;
import service.impl.PersonServiceImpl;


@Configuration
public class AppConfig {

    @Bean
    public UserService personService(){
        return new PersonServiceImpl();
    }

    @Bean
    public AccountService accountService(){
        return new AccountServiceImpl(personService());
    }
}
