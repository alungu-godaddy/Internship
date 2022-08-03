package ioc_di.noxml;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SwimCoach implements Coach {
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
