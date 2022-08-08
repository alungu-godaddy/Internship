package aop;

import aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        // get bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate an exception.
            theAccounts = theAccountDAO.findAccounts(true);
        } catch (Exception exc) {
            System.out.println("\n\n Main Program ... caught exception: " + exc);
        }

        System.out.println("\n\n Main program: After Throwing: ");
        System.out.println("-----");

        System.out.println(theAccounts);

        // close spring context
        context.close();
    }
}
