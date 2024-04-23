package entities;

import entities.models.LifeBar;
import interfaces.AtackableEntity;

public abstract class Entity implements AtackableEntity {
    private Integer maxLife;
    private LifeBar lifeBar;
    private String name;

    public Entity() {
    }

    public Entity(Integer maxLife, LifeBar lifeBar, String name) {
        this.maxLife = maxLife;
        this.lifeBar = lifeBar;
        this.name = name;
    }

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

    @Override
    public String toString() {
        StringBuilder entity = new StringBuilder();
        entity.append("{{{--------()--------}}").append('\n');
        entity.append(name).append('\n');
        entity.append(lifeBar.getCurrentLife()).append('\n');
        entity.append("{{{--------()--------}}").append('\n');
        return entity.toString();
    }
}
