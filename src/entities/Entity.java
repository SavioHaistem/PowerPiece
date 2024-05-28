package entities;

import entities.models.LifeBar;
import interfaces.Atackable;

public abstract class Entity implements Atackable {
    protected LifeBar lifeBar;
    protected String name;

    public Entity() {
    }

    public Entity(LifeBar lifeBar, String name) {
        this.lifeBar = lifeBar;
        this.name = name;
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
        entity.append("==================").append('\n');
        entity.append(name).append('\n');
        for (Character health : lifeBar.getLifeBar()) {
            entity.append(health);
        }
        entity.append('\n');
        entity.append("==================").append('\n');
        return entity.toString();
    }

    @Override
    public void takeDamage(Integer damage) {
        lifeBar.receiveDamage(damage);
    }
}
