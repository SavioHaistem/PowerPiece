package entities;

import enums.fruits.FruitType;
import enums.smiles.SmileType;

public class Smile extends Fruit {
    protected final SmileType smileType;
    protected final String entity;
    public final String description;

    public Smile(SmileType smileType, String entity, String description) {
        super(FruitType.SMILE);
        this.smileType = smileType;
        this.entity = entity;
        this.description = description;
    }
}
