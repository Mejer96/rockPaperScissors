package com.company;

import java.util.Random;

public class MethodsComputerGenerated {

    public static String generatePick(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length-1);
        String randomPick = array[index];

        return randomPick;
    }
}
