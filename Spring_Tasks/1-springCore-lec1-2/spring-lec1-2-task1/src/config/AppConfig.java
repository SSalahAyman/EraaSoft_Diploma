package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.UserService;
import service.impl.MangerServiceImpl;
import service.impl.PersonServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public UserService personService(){
        return new PersonServiceImpl();
    }

    @Bean public UserService mangerService(){
        return new MangerServiceImpl();
    }
}
