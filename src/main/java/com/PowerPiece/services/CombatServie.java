package com.PowerPiece.services;
import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.models.Power;

public final class CombatServie {
    private static boolean playerTurn;
    public static void killEntity(Entity entity) {
        entity.setLifeBar(null);
    }

    public static void hitEntity(Entity entity, Power power) {
        int damage = power.getCategory() * 10;
        entity.takeDamage(damage);
        if (entity.getLifeBar().getCurrentLife() <= 10) {
            killEntity(entity);
        }
        InterfaceService.tellerSays(entity.getName() + " has take damage: -" + damage + " life points ");
    }

    public static void healEntity(Entity entity, int lifeHeal) {
        entity.takeHeal(lifeHeal);
    }

    public static boolean isPlayerTurn() {
        playerTurn = !playerTurn;
        return playerTurn;
    }
}
