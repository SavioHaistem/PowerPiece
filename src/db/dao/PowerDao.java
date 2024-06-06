package db.dao;

import entities.dungeos.Dungeon;
import entities.models.Power;

import java.util.List;

public interface PowerDao {
    void add(Power power);
    void remove(Power power);
    Power findById(Integer id);
    List<Power> findAll();
}
