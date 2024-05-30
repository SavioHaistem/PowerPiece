package entities.dungeos;

import entities.Entity;
import entities.Player;
import entities.enemies.Enemy;

import java.util.List;

public class Chamber {
    private Integer id;
    private String name;
    private List<Entity> enemies;
    private Player instancePlayer = null;
    private boolean complete = false;

    public Chamber() {}
    public Chamber(Integer id, String name, List<Entity> enemies) {
        this.id = id;
        this.name = name;
        this.enemies = enemies;
    }
}
