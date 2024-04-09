package entities;

import interfaces.Fruit;

public class Smile implements Fruit {
    @Override
    public void Eat() {
        System.out.println("Eating Smile...");
    }
}
