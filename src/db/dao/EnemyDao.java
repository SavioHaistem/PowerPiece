package db.dao;
import entities.dungeos.Dungeon;
import entities.enemies.Enemy;

import java.sql.ResultSet;
import java.util.List;

public interface EnemyDao {
    void add(Enemy enemy);
    void removeById(int id);
    Enemy findById(int id);
    List<Enemy> findAll();
    Enemy instantiateEnemy(ResultSet resultSet);
}
