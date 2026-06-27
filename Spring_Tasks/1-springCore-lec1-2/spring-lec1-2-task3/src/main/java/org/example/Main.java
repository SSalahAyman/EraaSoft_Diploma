package org.example;
import org.example.config.AppConfig;
import org.example.service.impl.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        //--------------------- (container with XML configuration) ---------------------------//
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

         PersonService personService = context.getBean("personService", PersonService.class);
         personService.save("salah");

        System.out.println();
        //--------------------- (java based container configuration) ---------------------------//
        AnnotationConfigApplicationContext context2= new AnnotationConfigApplicationContext(AppConfig.class);

        PersonService personService1 = context2.getBean("personService", PersonService.class);
        personService1.save("Ahmed");

        context.close();
        context2.close();
    }
}