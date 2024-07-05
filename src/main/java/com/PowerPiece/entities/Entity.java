package com.PowerPiece.entities;

import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.interfaces.Atackable;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.entities.models.Power;

import java.util.HashMap;
import java.util.Map;

public abstract class Entity implements Atackable {
    protected LifeBar lifeBar;
    protected AkumaNoMi akumaNoMi;
    protected Integer entityId;
    protected String name;
    protected Map<Integer,Power> powers = new HashMap<>();

    public Entity() {
    }

    public Entity(Integer entityId, String name, LifeBar lifeBar) {
        this.lifeBar = lifeBar;
        this.name = name;
        this.entityId = entityId;
    }

    public Entity(Integer entityId, String name, LifeBar lifeBar, AkumaNoMi akumaNoMi) {
        this.entityId = entityId;
        this.lifeBar = lifeBar;
        this.name = name;
        this.akumaNoMi = akumaNoMi;
        this.powers = akumaNoMi.getPowers();
    }

    public Entity(Integer entityId, String name, LifeBar lifeBar, Map<Integer, Power> powers) {
        this.entityId = entityId;
        this.lifeBar = lifeBar;
        this.name = name;
        this.powers = powers;
    }

    public LifeBar getLifeBar() {
        return lifeBar;
    }

    public boolean isLive() {
        return lifeBar.getCurrentLife() > 0;
    }

    public String getPowersIDs() {
        StringBuilder powerString = new StringBuilder();
        if (!powers.isEmpty()) {
            for (Power power : powers.values()) {
                powerString.append(power.getId());
                powerString.append(',');
            }
        } else {
            return null;
        }
        powerString.deleteCharAt(powerString.lastIndexOf(","));
        return powerString.toString();
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

    public Map<Integer, Power> getPowers() {
        return powers;
    }

    public void setPowers(Map<Integer, Power> powers) {
        this.powers = powers;
    }

    public AkumaNoMi getAkumaNoMi() {
        return akumaNoMi;
    }

    public void setAkumaNoMi(AkumaNoMi akumaNoMi) {
        this.akumaNoMi = akumaNoMi;
        this.powers = akumaNoMi.getPowers();
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public void Say(String sayed) {
        System.out.println("((( " + name + " say: " + sayed + " )))");
    }

    @Override
    public String toString() {
        StringBuilder entity = new StringBuilder();
        entity.append("---------------").append('\n');
        entity.append(name).append(" (").append(entityId).append(")").append('\n');
        entity.append(lifeBar);
        entity.append("---------------").append('\n');
        return entity.toString();
    }

    @Override
    public void takeDamage(Integer damage) {
        lifeBar.receiveDamage(damage);
    }
}
