package ioc_di.annotations;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SoccerCoach  implements Coach {
    @Autowired @Qualifier("randomFortuneService")
    FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Do a flip!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
