package aop;

import aop.dao.AccountDAO;
import aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        // get bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        // call business method
        Account account = new Account();
        account.setLevel("10");
        account.setName("Madhu");
        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWork();

        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        System.out.println(theAccountDAO.getName());
        System.out.println(theAccountDAO.getServiceCode());

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        membershipDAO.addAccount();
        membershipDAO.goToSleep();

        // close spring context
        context.close();
    }
}
