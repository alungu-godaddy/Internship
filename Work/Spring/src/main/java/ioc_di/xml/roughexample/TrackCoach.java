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

    // init hook
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside init method");
    }

    // destroy hook
    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: inside destroy method");
    }
}
