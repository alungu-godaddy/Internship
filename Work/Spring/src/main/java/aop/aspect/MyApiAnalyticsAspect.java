package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {
    @Before("aop.aspect.Pointcuts.forDaoPackageNoGetterSetter()")
    public void performAPIAnalytics() {
        System.out.println("\n======>>>> Performing API analytics");
    }
}
