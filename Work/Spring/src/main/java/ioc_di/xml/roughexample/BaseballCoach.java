package ioc_di.xml.roughexample;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
