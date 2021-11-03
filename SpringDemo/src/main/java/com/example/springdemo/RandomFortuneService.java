package com.example.springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService{

    private List<String> fortunes = new ArrayList<>();
    private Random random = new Random();

    @Override
    public String getFortune() {

        fortunes.add("Beware of the wolf in sheep's clothing");
        fortunes.add("Diligence is the mother of good luck");
        fortunes.add("The journey is the reward");

        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
