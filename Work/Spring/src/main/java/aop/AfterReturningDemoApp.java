package aop;

import aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        // get bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts = theAccountDAO.findAccounts(false);

        System.out.println("\n\n Main program: After Returning: ");
        System.out.println("-----");

        System.out.println(theAccounts);

        // close spring context
        context.close();
    }
}
