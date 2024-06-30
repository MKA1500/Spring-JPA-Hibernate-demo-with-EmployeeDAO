package com.demo.juneTwentyFour.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "I'm a baseball coach";
    }
}
