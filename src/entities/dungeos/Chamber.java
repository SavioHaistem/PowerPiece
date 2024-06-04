package entities.dungeos;

import entities.Entity;
import entities.Player;
import entities.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Chamber {
    private Integer id;
    private String name;
    private List<Enemy> enemies = new ArrayList<>();
    private Integer dungeonID = null;
    private boolean complete = false;

    public Chamber() {}

    public Chamber(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Chamber(Integer id, String name, List<Enemy> enemies) {
        this.id = id;
        this.name = name;
        this.enemies = enemies;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
