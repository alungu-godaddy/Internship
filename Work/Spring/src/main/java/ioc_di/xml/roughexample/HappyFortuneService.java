package ioc_di.xml.roughexample;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HappyFortuneService implements FortuneService {
    List<String> fortunes = Arrays.asList("Today is a great day!", "Be careful today!", "Time for work!");
    @Override
    public String getFortune() {
        Random random = new Random();

        int value = random.nextInt(3); // [0..2]

        return fortunes.get(value);
    }
}
