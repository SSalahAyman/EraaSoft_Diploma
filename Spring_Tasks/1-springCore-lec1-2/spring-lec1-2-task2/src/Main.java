import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;
import service.impl.AccountServiceImpl;


public class Main {
    public static void main(String[] args) {

        //--------------------- (container with XML configuration) ---------------------------//
        ApplicationContext context1 = new ClassPathXmlApplicationContext("config/applicationContext.xml");

        AccountService accountService = context1.getBean("accountService", AccountService.class);
        accountService.getSavePerson("Salah");

        System.out.println();
        //--------------------- (java based container configuration) ---------------------------//
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService accountService1 = context2.getBean("accountService" , AccountService.class);
        accountService.getSavePerson("Ahmed");
    }
}