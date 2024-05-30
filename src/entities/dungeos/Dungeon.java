package entities.dungeos;

import entities.enemies.Enemy;

import java.util.HashMap;
import java.util.Map;

public abstract class Dungeon {
    protected Integer id;
    protected String name;
    protected Enemy endBoss;
    protected Map<Integer,Enemy> enemys = new HashMap<>();

    public Dungeon() {
    }

    public Dungeon(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dungeon(Integer id, String name, Enemy endboss, Map<Integer, Enemy> enemys) {
        this.id = id;
        this.name = name;
        this.endBoss = endboss;
        this.enemys = enemys;
    }

    public boolean isActive() {
        return !enemys.isEmpty() && endBoss.isLive();
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

    public Map<Integer, Enemy> getEnemys() {
        return enemys;
    }

    public void setEnemys(Map<Integer, Enemy> enemys) {
        this.enemys = enemys;
    }
}
