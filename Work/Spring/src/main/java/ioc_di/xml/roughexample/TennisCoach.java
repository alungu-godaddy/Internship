package ioc_di.xml.roughexample;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TennisCoach implements Coach {
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Let's go play some tennis!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
