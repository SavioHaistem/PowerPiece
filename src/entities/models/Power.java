package entities.models;

import enums.PowerType;
import interfaces.Atackable;
import interfaces.Attack;

public class Power implements Attack {
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
    public void inflictDamage(Atackable entity, Integer damage) {

    }

    @Override
    public String toString() {
        return "Power (id: " + id + ", name: " + name + ")";
    }
}
