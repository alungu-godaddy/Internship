package ioc.xml.roughexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from container
        Coach coach = context.getBean("myCoach", Coach.class);
        // call methods on the bean
        System.out.println(coach.getDailyWorkout());
        // Practice once again
        Coach tennisCoach = context.getBean("myTennisCoach", Coach.class);
        System.out.println(tennisCoach.getDailyWorkout());
        // close the context
        context.close();
    }
}