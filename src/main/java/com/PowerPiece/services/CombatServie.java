package com.PowerPiece.services;
import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.Power;

public final class CombatServie {
    public static Dungeon currentDungeon = null;

    public static void killEntity(Integer entityID) {
        currentDungeon.removeEnemy(entityID);
    }

    public static void hitEntity(Entity entity, Power power) {
        entity.takeDamage(power.getCategory() * 10);
    }

    public static void setDungeon(Integer dungeonID) {
        currentDungeon = CacheService.getDungeons().get(dungeonID);
    }

    public static Enemy getEndBoss() {
        return currentDungeon.getEndBoss();
    }
}
