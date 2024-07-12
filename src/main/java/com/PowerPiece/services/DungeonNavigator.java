package com.PowerPiece.services;

import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.entities.enemies.Enemy;

import java.util.Iterator;

public class DungeonNavigator {
    private static Dungeon currentDungeon;
    private static Entity currentPlayer;
    private static Enemy currentEnemy;
    private static Iterator<Enemy> enemiesRoad;

    public DungeonNavigator() {}

    public static void comeInDungeon(Player player, Dungeon dungeon) {
        System.out.println("method exe: comeInDungeon");
        currentPlayer = player;
        InterfaceService.title("player " + player.getName() + " entrou na dungeon " + dungeon.getName());
        InterfaceService.timer(1);
        currentDungeon = dungeon;
        enemiesRoad = dungeon.getEnemies().iterator();
        InterfaceService.loadText("carregando inimigos");
        InterfaceService.timer(1);
    }

    public static void quitOfDungeon() {
        currentPlayer = null;
    }

    public static Enemy getCurrentEnemy() {
        return currentEnemy;
    }

    public static void setCurrentEnemy(Enemy currentEnemy) {
        DungeonNavigator.currentEnemy = currentEnemy;
    }

    public static Enemy getNextEnemy() {
        if (currentEnemy == null) {
            currentEnemy = enemiesRoad.next();
            return currentEnemy;
        }
        if (!currentEnemy.isLive() && enemiesRoad.hasNext()) {
            enemiesRoad.remove();
            currentEnemy = enemiesRoad.next();
            InterfaceService.title(currentEnemy.getName());
            return currentEnemy;
        } else if (currentEnemy.getLifeBar() == null && getBoss().isLive()) {
            System.out.println(TextDecorations.BG_RED + "!!!!!!!!!!!!!!!!!!!!!! KAIDO APPEAR !!!!!!!!!!!!!!!!!!!!!!!!!!!" + TextDecorations.RESET);
            return getBoss();
        } else {
            return null;
        }
    }

    public static Enemy getBoss() {
        return currentDungeon.endBoss();
    }

    public static Dungeon getCurrentDungeon() {
        return currentDungeon;
    }

    public static void setCurrentDungeon(Dungeon currentDungeon) {
        DungeonNavigator.currentDungeon = currentDungeon;
    }

    public static Entity getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Entity currentPlayer) {
        DungeonNavigator.currentPlayer = currentPlayer;
    }

    public static Iterator<Enemy> getEnemiesRoad() {
        return enemiesRoad;
    }

    public static void setEnemiesRoad(Iterator<Enemy> enemiesRoad) {
        DungeonNavigator.enemiesRoad = enemiesRoad;
    }
}
