package entities.dungeos;

import entities.enemies.Enemy;

import java.util.Deque;
import java.util.Map;

public class Hanchinosu extends Dungeon {
    public Hanchinosu() {
    }

    public Hanchinosu(Integer id, String name) {
        super(id, name);
    }

    public Hanchinosu(Integer id, String name, Deque<Chamber> instances) {
        super(id, name, instances);
    }

    public Hanchinosu(Integer id, String name, Enemy endboss, Deque<Chamber> instances) {
        super(id, name, endboss, instances);
    }
}
