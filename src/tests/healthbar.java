package tests;

import java.util.*;

public class main {
    public static void main(String[] args) {
        int maxPlayerLife = 100;
        int playerCurrentLife = 10;
        StringBuilder str = new StringBuilder();
        char tinyHealthBar = '█';
        char tinyLowHealthBar = '░';

        ArrayList<Character> healthBar = new ArrayList<>(maxPlayerLife);
        for (int tiny = maxPlayerLife / 10; tiny <= maxPlayerLife; tiny += 10) {
            if (playerCurrentLife >= tiny) {
                healthBar.add(tinyHealthBar);
            } else {
                healthBar.add(tinyLowHealthBar);
            }
        }

        int damage = 20;
        //healthBar.get()
        healthBar.forEach(System.out::print);
    }
}
