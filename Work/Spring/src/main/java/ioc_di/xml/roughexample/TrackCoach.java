package ioc_di.xml.roughexample;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
