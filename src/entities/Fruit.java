package entities;

import enums.fruits.FruitType;

public class Fruit {
    protected final FruitType fruitType;

    public Fruit(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public FruitType getFruitType() {
        return fruitType;
    }
}
