package com.PowerPiece.entities;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.entities.models.Power;

import java.util.Map;

public class Player extends Entity {
    public Player() {
    }

    public Player(Integer playerId, String name, LifeBar lifeBar) {
        super(playerId,name,lifeBar);
    }

    public Player(Integer playerId, String name, LifeBar lifeBar, Map<Integer, Power> powers) {
        super(playerId,name,lifeBar,powers);
    }

    @Override
    public String toString() {
        StringBuilder powerList = new StringBuilder();
        for (Power power : powers.values()) {
            powerList.append("(").append(power.getId()).append(") ")
                    .append(power.getName()).append(": ")
                    .append(power.getDescription()).append('\n');
        }
        return super.toString() + powerList.toString();
    }
}