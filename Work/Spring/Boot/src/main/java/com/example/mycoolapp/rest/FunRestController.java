package com.example.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + " , Team name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on the server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "Run a harder 5k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Your lucky day";
    }
}
