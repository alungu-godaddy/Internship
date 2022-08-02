package ioc_di.annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    // create an array of strings
    private String[] data = {
            "Beware of the wolf is sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };
    // create a random number generator
    private Random random = new Random();

    // pick a random fortune.
    @Override
    public String getFortune() {
        int index = random.nextInt(data.length);

        return data[index];
    }
}
