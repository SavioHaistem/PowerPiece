package db.dao;
import entities.dungeos.Dungeon;
import java.util.List;

public interface EnemyDao {
    void add(Dungeon dungeon);
    void remove(Dungeon dungeon);
    Dungeon findById(Integer id);
    List<Dungeon> findAll();
}
