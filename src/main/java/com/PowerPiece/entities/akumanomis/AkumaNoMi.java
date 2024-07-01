package com.PowerPiece.entities.akumanomis;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.interfaces.Fruit;
import com.PowerPiece.entities.models.Power;
import com.PowerPiece.enums.AkumasType;

import java.util.HashMap;
import java.util.Map;

public abstract class AkumaNoMi implements Fruit {
    protected String name;
    protected AkumasType type;
    protected Integer id;
    protected Map<Integer, Power> powers = new HashMap<>();

    public AkumaNoMi(AkumasType akumasType) {
        this.type = akumasType;
    }
    public AkumaNoMi(String name,Integer id, AkumasType type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }
    public AkumaNoMi(String name, Integer id, AkumasType type, Map<Integer, Power> powers) {
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

    public Map<Integer, Power> getPowers() {
        return powers;
    }

    public void setPowers(Map<Integer, Power> powers) {
        this.powers = powers;
    }

    public Power getPower(Integer powerId) {
        return powers.get(powerId);
    }

    @Override
    public String getOption() {
        return "(" + id + "): " + TextDecorations.RED + type + " " + TextDecorations.PURPLE + name;
    }

    @Override
    public String toString() {
        return name + ": (id = " + id + ", type = " + type + ", powers = " + powers + ")";
    }
}
