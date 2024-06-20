package com.PowerPiece.db.dao.impl;

import com.PowerPiece.db.dao.DungeonDao;
import com.PowerPiece.entities.dungeos.Dungeon;

import java.sql.Connection;
import java.util.List;

public class DungeonDaoJdbc implements DungeonDao {
    private Connection connection = null;

    public DungeonDaoJdbc(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Dungeon dungeon) {

    }

    @Override
    public void remove(Dungeon dungeon) {

    }

    @Override
    public Dungeon findById(Integer id) {
        return null;
    }

    @Override
    public List<Dungeon> findAll() {
        return List.of();
    }
}
