package ioc_di.noxml;

import ioc_di.annotations.Coach;
import ioc_di.annotations.FortuneService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@NoArgsConstructor
public class TennisCoach implements Coach {
    @Autowired @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // define my init method
    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println("Inside do my start up stuff");
    }
    // define my destroy method
    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("Inside do my clean up stuff!");
    }
}
