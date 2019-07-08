package com.mavenit.selenium.training.utils;

import java.util.Random;

public class Helpers {

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int randomNumberGenerator(int size) {
        Random random = new Random();
        return random.nextInt(size - 1);
    }
}
