package com.PowerPiece.entities;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.entities.models.Power;

import java.util.Map;

public class Player extends Entity {
    public Player() {
    }

    public Player(Integer playerId, String name, LifeBar lifeBar) {
        super(playerId,name,lifeBar);
    }

    public Player(Integer entityId, String name, LifeBar lifeBar, AkumaNoMi akumaNoMi) {
        super(entityId, name, lifeBar, akumaNoMi);
    }

    public Player(Integer playerId, String name, LifeBar lifeBar, Map<Integer, Power> powers) {
        super(playerId,name,lifeBar,powers);
    }

    public String toStringWithPowers() {
        StringBuilder powerList = new StringBuilder();
        for (Power power : powers.values()) {
            powerList.append(TextDecorations.CYAN).append("(").append(power.getId()).append(") ")
                    .append(power.getName()).append(": ").append(TextDecorations.YELLOW)
                    .append(power.getDescription()).append(TextDecorations.RESET).append('\n');
        }
        return super.toString() + powerList;
    }
}