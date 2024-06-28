package com.PowerPiece.db.dao;
import com.PowerPiece.entities.dungeos.Dungeon;

import java.util.Map;

public interface DungeonDao {
    void add(Dungeon dungeon);
    void removeById(int id);
    Dungeon findById(Integer id);
    Map<Integer, Dungeon> findAll();
}
