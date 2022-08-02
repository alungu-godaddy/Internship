package ioc_di.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotations/applicationContext.xml");
        // retrieve bean from container
        Coach coach = context.getBean("tennisCoach", Coach.class);
        // call methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        Coach soccerCoach = context.getBean("soccerCoach", Coach.class);
        System.out.println(soccerCoach.getDailyWorkout());
        System.out.println(soccerCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
