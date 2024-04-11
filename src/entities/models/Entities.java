package entities.models;

import interfaces.Entity;

public abstract class Entities implements Entity {
    private Integer life;
    private String name;

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
