package ioc_di.xml.roughexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xml/applicationContext.xml");
        // retrieve bean from container
        Coach coach = context.getBean("myCoach", Coach.class);
        // call methods on the bean
        System.out.println(coach.getDailyWorkout());
        // call method of injected object
        System.out.println(coach.getDailyFortune());
        // Practice once again
        Coach tennisCoach = context.getBean("myTennisCoach", Coach.class);
        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());
        // close the context
        context.close();
    }
}
