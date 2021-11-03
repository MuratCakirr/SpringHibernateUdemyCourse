package com.example.springdemoannotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService{

    private FileReader fileReader;
    private List<String> fortunes = new ArrayList();
    private Random random = new Random();

    @PostConstruct
    public void readFortune(){
        System.out.println(">> TennisCoach: inside of readFortune()");
        try {
            fileReader = new FileReader("fortunes.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                fortunes.add(line);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }

}
