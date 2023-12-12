package entities.fruits;

import entities.stats.Buff;
import entities.stats.Debuff;
import enums.fruits.FruitType;

import java.util.ArrayList;

public class Fruit {
    private FruitType fruitType;
    private ArrayList<Buff> fruitBuffs = new ArrayList<>();
    private ArrayList<Debuff> fruitDebuffs = new ArrayList<>();

    public Fruit(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public Fruit(FruitType fruitType, ArrayList<Buff> fruitBuffs, ArrayList<Debuff> fruitDebuffs) {
        this.fruitType = fruitType;
        this.fruitBuffs = fruitBuffs;
        this.fruitDebuffs = fruitDebuffs;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public ArrayList<Buff> getFruitBuffs() {
        return fruitBuffs;
    }

    public void setFruitBuffs(ArrayList<Buff> fruitBuffs) {
        this.fruitBuffs = fruitBuffs;
    }

    public ArrayList<Debuff> getFruitDebuffs() {
        return fruitDebuffs;
    }

    public void setFruitDebuffs(ArrayList<Debuff> fruitDebuffs) {
        this.fruitDebuffs = fruitDebuffs;
    }
}
