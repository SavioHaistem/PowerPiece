package db.dao;

import entities.dungeos.Dungeon;
import entities.models.Power;

import java.util.List;

public interface PowerDao {
    void add(Power power);
    void removeById(Integer power);
    Power findById(int id);
    List<Power> findAll();
}
