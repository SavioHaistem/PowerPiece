package entities.dungeos;

import entities.enemies.Enemy;

import java.util.Map;

public class Hanchinosu extends Dungeon {
    public Hanchinosu() {
    }

    public Hanchinosu(Integer id, String name) {
        super(id, name);
    }

    public Hanchinosu(Integer id, String name, Enemy endboss, Map<Integer, Enemy> enemys) {
        super(id, name, endboss, enemys);
    }
}
