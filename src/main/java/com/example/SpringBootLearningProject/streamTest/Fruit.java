package com.example.SpringBootLearningProject.streamTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Fruit {



    public static String nullFriut(String fruitname) {
        String[] fruits = new String[] {
                "pomme", "abricot", "cerise", "poire"
        };
        for (String s: fruits) {

            if (Objects.equals(s, fruitname)) {

                return null;

            }
        }
        return fruitname;
    };

    public static void main(String[] args) {
        nullFriut("abricot");

        /*String[] fruits = new String[] {
                "pomme", "abricot", "cerise", "poire"
        };
        for (String s: fruits) {

               if (Arrays.asList(s).contains("abricot")) {

                   return null;

               } else {
                   System.out.print("fruit list is  not empty \n");

               }
        }*/

    }
}
