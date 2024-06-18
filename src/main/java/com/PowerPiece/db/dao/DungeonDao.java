package com.PowerPiece.db.dao;
import com.PowerPiece.entities.dungeos.Dungeon;
import java.util.List;

public interface DungeonDao {
    void add(Dungeon dungeon);
    void remove(Dungeon dungeon);
    Dungeon findById(Integer id);
    List<Dungeon> findAll();
}
