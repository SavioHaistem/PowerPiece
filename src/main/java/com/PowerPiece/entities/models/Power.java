package com.PowerPiece.entities.models;

import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.enums.PowerType;
import com.PowerPiece.interfaces.Optionable;

public class Power implements Optionable {
    protected Integer id;
    protected String name;
    protected Integer category;
    protected PowerType powerType;
    protected Integer akumaID;
    protected String description;

    public Power() {
    }

    public Power(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Power(Integer id, String name, Integer category, PowerType powerType, Integer akumaID, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.powerType = powerType;
        this.description = description;
        this.akumaID = akumaID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

    public Integer getAkumaID() {
        return akumaID;
    }

    public void setAkumaID(Integer akumaID) {
        this.akumaID = akumaID;
    }

    @Override
    public String toString() {
        return "Power (name: " + name + ") ";
    }

    @Override
    public String getOption(int value) {
        return TextDecorations.YELLOW + "(" + value + "): " + TextDecorations.CYAN + description + TextDecorations.RESET;
    }
}
