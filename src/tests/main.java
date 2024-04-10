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
            //if (maxPlayerLife)
            //TODO: planejar como a barra de vida vai ser refeita a cada dano;
            //teoria: checar se a barra de vida máxima menos a barra de vida atual é igual a zero
            //teoria2: preencha todos os campos da vida atual por '█', se no final ainda faltar pontos de vida
            //preencha o restante com '░';
            // maxLife (100) - currentLife (90) = 10;
        }

        int damage = 20;
        //healthBar.get()
        healthBar.forEach(System.out::print);
    }
}
