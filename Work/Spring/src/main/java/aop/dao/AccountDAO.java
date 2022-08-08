package aop.dao;

import aop.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Setter @Getter
public class AccountDAO {
    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Tripwire is true!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT!");
    }

    public void doWork() {
        System.out.println(getClass() + ": DOING SOME WORK");
    }
}
