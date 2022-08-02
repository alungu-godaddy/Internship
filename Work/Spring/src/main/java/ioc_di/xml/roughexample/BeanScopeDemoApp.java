package ioc_di.xml.roughexample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xml/beanScope-applicationContext.xml");
        // retrieve beans from container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach =  context.getBean("myCoach", Coach.class);

        // check if they are the same
        boolean result = (theCoach == alphaCoach);

        System.out.println(result);

        // print memory references
        System.out.println(theCoach);

        System.out.println(alphaCoach);
    }
}
