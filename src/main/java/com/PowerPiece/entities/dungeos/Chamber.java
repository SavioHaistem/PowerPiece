package com.PowerPiece.entities.dungeos;

import com.PowerPiece.entities.enemies.Enemy;

public class Chamber {
    private int id;
    private Enemy enemy;
    private Chamber next;

    public Chamber() {

    }
    public Chamber(int id, Enemy enemy) {
        this.id = id;
        this.enemy = enemy;
        this.next = null;
    }

    public Chamber(int id, Enemy enemy, Chamber next) {
        this.id = id;
        this.enemy = enemy;
        this.next = next;
    }
}
