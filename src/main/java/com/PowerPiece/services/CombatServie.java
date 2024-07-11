package com.PowerPiece.services;
import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.Power;

public final class CombatServie {
    public static void killEntity(Entity entity) {
        entity.setLifeBar(null);
    }

    public static void hitEntity(Entity entity, Power power) {
        entity.takeDamage(power.getCategory() * 10);
    }
}
