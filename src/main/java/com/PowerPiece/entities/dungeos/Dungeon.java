package com.PowerPiece.entities.dungeos;
import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.interfaces.Optionable;

import java.util.*;

public class Dungeon implements Optionable {
    protected Integer id;
    protected String name;
    protected Enemy endBoss;
    private List<Enemy> enemies;

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

    public Enemy endBoss() {
        return this.endBoss;
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

    public void setEnemies(Stack<Enemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.id;
    }

    @Override
    public String getOption(int value) {
        return TextDecorations.GREEN + "(" + value + "): " +
                TextDecorations.YELLOW + name;
    }
}
