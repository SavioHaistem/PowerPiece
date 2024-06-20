package com.PowerPiece.db.dao.impl;

import com.PowerPiece.db.DB;
import com.PowerPiece.db.dao.DungeonDao;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.exceptions.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DungeonDaoJdbc implements DungeonDao {
    private Connection connection = null;

    public DungeonDaoJdbc(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Dungeon dungeon) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Dungeons (id,name,endbossID,enemiesID) "
                    +   "VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            int generatedRow = statement.executeUpdate();
            if (generatedRow > 0) {
                System.out.println("your Dungeon has added");
            } else {
                System.out.println("add dungeon error");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void removeById(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "REMOVE FROM Dungeons WHERE id = ?"
            );
            statement.setInt(1,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatment(statement);
        }
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
