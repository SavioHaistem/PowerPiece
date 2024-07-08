package com.PowerPiece.entities.dungeos;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.interfaces.Optionable;

import java.util.*;

public class Dungeon implements Optionable {
    protected Integer id;
    protected String name;
    protected Enemy endBoss;
    protected Map<Integer,Enemy> enemies = new HashMap<>();

    public Dungeon() {
    }

    public Dungeon(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dungeon(Integer id, String name, Map<Integer,Enemy> enemies) {
        this.id = id;
        this.name = name;
        this.enemies = enemies;
    }

    public Dungeon(Integer id, String name, Enemy endBoss, Map<Integer,Enemy> enemies) {
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

    public void removeEnemy(int id) {
        this.enemies.remove(id);
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

    public Map<Integer,Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(Map<Integer,Enemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.id;
    }

    @Override
    public String getOption() {
        return TextDecorations.GREEN + "(" + id + "): " +
                TextDecorations.YELLOW + name;
    }
}
