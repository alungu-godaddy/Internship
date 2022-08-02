package ioc_di.xml.roughexample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
public class CricketCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
