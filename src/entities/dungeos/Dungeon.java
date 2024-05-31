package entities.dungeos;
import entities.enemies.Enemy;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class Dungeon {
    protected Integer id;
    protected String name;
    protected Enemy endBoss;
    protected Deque<Chamber> instances = new ArrayDeque<>();

    public Dungeon() {
    }

    public Dungeon(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dungeon(Integer id, String name, Deque<Chamber> instances) {
        this.id = id;
        this.name = name;
        this.instances = instances;
    }

    public Dungeon(Integer id, String name, Enemy endBoss, Deque<Chamber> instances) {
        this.id = id;
        this.name = name;
        this.endBoss = endBoss;
        this.instances = instances;
    }

    public boolean isActive() {
        return !instances.isEmpty();
    }

    public void quitDungeon() {
        this.instances = new ArrayDeque<>();
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

    public Deque<Chamber> getInstances() {
        return instances;
    }

    public void setInstances(Deque<Chamber> instances) {
        this.instances = instances;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.id;
    }
}
