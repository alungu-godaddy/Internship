package ioc_di.xml.roughexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xml/applicationContext.xml");
        // retrieve bean from container
        CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
        // call methods on the bean
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());
        // call injected literal values.
        System.out.println(coach.getEmailAddress());
        // close application context
        context.close();
    }
}
