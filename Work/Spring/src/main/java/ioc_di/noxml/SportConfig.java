package ioc_di.noxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan("ioc_di.noxml")
public class SportConfig {
    // define bean for out sad fortune
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }
    // define bean for our swim coach and inject dependencies
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
