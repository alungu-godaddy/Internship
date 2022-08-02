package ioc_di.xml.roughexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
        // retrieve beans from container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        context.close();
    }
}
