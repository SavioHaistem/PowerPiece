package com.PowerPiece.services;

import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.entities.enemies.Enemy;

//TODO: COMPLETE DUNGEON NAVIGATOR
//TODO: GETNEXT ENEMY METHOD
//TODO: transfer navigate methods of Dungeon object to here
public class DungeonNavigator {
    private Dungeon currentDungeon;

    public DungeonNavigator() {}

    public DungeonNavigator(Dungeon currentDungeon) {
        this.currentDungeon = currentDungeon;
    }

    public DungeonNavigator(Dungeon currentDungeon, Entity currentPlayer) {
        this.currentDungeon = currentDungeon;
        currentDungeon.setPlayer(currentPlayer);
    }

    public void comeInDungeon(Player player) {
        currentDungeon.comeInDungeon(player);
    }

    public void quitOfDungeon() {
        currentDungeon.quitDungeon();
    }

    public Enemy getNextEnemy() {
        return new Enemy();
    }
}
