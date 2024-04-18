package entities.models;

import interfaces.Entity;

public abstract class Entities implements Entity {
    private Integer maxLife;
    private LifeBar lifeBar;
    private String name;

    public Integer getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(Integer maxLife) {
        this.maxLife = maxLife;
    }

    public LifeBar getLifeBar() {
        return lifeBar;
    }

    public void setLifeBar(LifeBar lifeBar) {
        this.lifeBar = lifeBar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
