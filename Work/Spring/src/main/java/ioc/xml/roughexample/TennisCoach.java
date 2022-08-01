package ioc.xml.roughexample;

public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Let's go play some tennis!";
    }
}
