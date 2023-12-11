package entities.fruits;

import enums.fruits.FruitType;

public class Fruit {
    private FruitType fruitType;

    public Fruit() {}

    public Fruit(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public FruitType getFruitType() {
        return fruitType;
    }
}
