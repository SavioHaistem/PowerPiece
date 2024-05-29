package entities.akumanomis;
import entities.models.Power;
import enums.AkumasType;
import interfaces.Fruit;

import java.util.HashMap;
import java.util.Map;

public abstract class AkumaNoMi implements Fruit {
    protected String name;
    protected AkumasType type;
    protected Integer id;
    protected Map<Integer, Power> powers = new HashMap<>();

    public AkumaNoMi(AkumasType akumasType) {}
    public AkumaNoMi(String name,Integer id, AkumasType type) {
        this.name = name;
        this.id = id;
        this.powers = powers;
    }
    public AkumaNoMi(String name, AkumasType type, Integer id, Map<Integer, Power> powers) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.powers = powers;
    }

    @Override
    public void Eat() {
        System.out.println("Eating Akuma no mi...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AkumasType getType() {
        return type;
    }

    public void setType(AkumasType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
