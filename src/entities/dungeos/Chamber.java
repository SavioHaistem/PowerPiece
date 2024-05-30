package entities.dungeos;

import entities.Player;
import entities.enemies.Enemy;

import java.util.List;

public class Chamber {
    private Integer id;
    private String name;
    private List<Enemy> enemies;
    private Player instancePlayer = null;
    private boolean complete = false;

    public Chamber() {}
    public Chamber(Integer id, String name, List<Enemy> enemies) {
        this.id = id;
        this.name = name;
        this.enemies = enemies;
    }
}
