package com.PowerPiece.services;
import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.entities.models.Power;

import java.util.List;
import java.util.Map;

public final class CombatServie {
    private static void killEntity(Integer entityID, Map<Integer,Entity> locale) {
        locale.remove(entityID);
    }

    private static void hitEntity(Entity entity, Power power) {
        entity.takeDamage(power.getCategory() * 10);
    }

}
