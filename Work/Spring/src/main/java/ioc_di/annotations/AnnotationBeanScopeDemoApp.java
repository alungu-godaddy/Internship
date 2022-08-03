package ioc_di.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // load spring application context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotations/applicationContext.xml");
        // retrieve bean from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
        // check if they are the same
        boolean result = (coach == alphaCoach);

        System.out.println(result);

        context.close();
    }
}
