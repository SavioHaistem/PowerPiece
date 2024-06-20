package com.PowerPiece.entities.dungeos;
import com.PowerPiece.entities.enemies.Enemy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Dungeon {
    protected Integer id;
    protected String name;
    protected Enemy endBoss;
    protected List<Enemy> enemies = new ArrayList<>();

    public Dungeon() {
    }

    public Dungeon(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dungeon(Integer id, String name, List<Enemy> enemies) {
        this.id = id;
        this.name = name;
        this.enemies = enemies;
    }

    public Dungeon(Integer id, String name, Enemy endBoss, List<Enemy> enemies) {
        this.id = id;
        this.name = name;
        this.endBoss = endBoss;
        this.enemies = enemies;
    }

    public boolean isActive() {
        return !enemies.isEmpty();
    }

    public Enemy endBoss() {
        return this.endBoss;
    }

    public void quitDungeon() {
        this.enemies = null;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enemy getEndBoss() {
        return endBoss;
    }

    public void setEndBoss(Enemy endBoss) {
        this.endBoss = endBoss;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.id;
    }
}
