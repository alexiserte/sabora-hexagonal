package org.example.Utils;

import java.util.Random;

public class IDGenerator {
    public static String generateID(){
        int[] asciiTotal = new int[10 + 26 + 26]; int index = 0;
        String res = "";
        Random r = new Random();
        for (int i = 0; i < 10; i++) asciiTotal[index++] = '0' + i;
        for (int i = 0; i < 26; i++) asciiTotal[index++] = 'A' + i;
        for (int i = 0; i < 26; i++) asciiTotal[index++] = 'a' + i;

        for(int i = 0; i < 64;i++) res += (char) asciiTotal[r.nextInt(0,asciiTotal.length)];
        return res;
    }
}
