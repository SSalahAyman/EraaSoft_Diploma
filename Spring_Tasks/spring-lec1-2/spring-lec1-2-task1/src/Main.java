import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.impl.MangerServiceImpl;
import service.impl.PersonServiceImpl;


public class Main {
    public static void main(String[] args) {

        //--------------------------------(get two bean with "ClassPathXmlApplicationContext" that is used when we config spring container with XML)-------------------------//
        ApplicationContext context1 = new ClassPathXmlApplicationContext("config/applicationContext.xml");

        UserService person1 = context1.getBean("personService", UserService.class);
        person1.save("Salah");
        person1.update("Salah");
        System.out.println();
        UserService manger1= context1.getBean("mangerService",UserService.class);
        manger1.save("Ahmed");
        manger1.update("Ahmed");

        System.out.println();
        //--------------------------------(get two bean with "AnnotationConfigApplicationContext" that is used when we config spring container with no XML)-------------------------//
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService person2 = context2.getBean("personService" , UserService.class);
        person2.save("Mohamed");
        person2.update("Mohamed");
        System.out.println();
        UserService manger2= context1.getBean("mangerService",UserService.class);
        manger2.save("Mostafa");
        manger2.update("Mostafa");


    }
}