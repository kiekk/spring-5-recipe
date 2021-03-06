package com.example.recipe284.sequence;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class NumberPrefixGenerator implements PrefixGenerator {

    @Override
    public String getPrefix() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        return String.format("%03d", randomInt);
    }
}
