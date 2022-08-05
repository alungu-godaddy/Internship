package aop.dao;

import aop.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter @Getter
public class AccountDAO {
    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT!");
    }

    public void doWork() {
        System.out.println(getClass() + ": DOING SOME WORK");
    }
}
