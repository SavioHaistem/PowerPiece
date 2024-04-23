package tests;

import java.util.*;

public class healthbar {
    public static void main(String[] args) {
        int maxPlayerLife = 100;
        int playerCurrentLife = 40;
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
        healthBar.forEach(System.out::print);
    }
}
