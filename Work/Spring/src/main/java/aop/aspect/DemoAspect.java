package aop.aspect;

import aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class DemoAspect {

    @After("execution(* aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* aop.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n======>>> The exception is: " + theExc);
    }

    @Before("aop.aspect.Pointcuts.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("Testing");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);
        // display method arguments
        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account theAccount) {
                // downcast and print Account specific stuff

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* aop.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====> Result is: " + result);

        // let's post process the data, modify it before it goes back to client code.
        convertAccountNamesToUppercase(result);

        System.out.println("\n====> Uppercase results " + result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }
    }
}
