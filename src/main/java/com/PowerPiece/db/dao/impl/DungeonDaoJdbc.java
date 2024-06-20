package com.PowerPiece.db.dao.impl;

import com.PowerPiece.db.DB;
import com.PowerPiece.db.dao.DaoFactory;
import com.PowerPiece.db.dao.DungeonDao;
import com.PowerPiece.db.dao.EnemyDao;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.exceptions.DbException;
import com.PowerPiece.services.InstantiateFromString;

import java.sql.*;
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
        Dungeon dungeon = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM Dungeons WHERE id = ? "
            );
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                     dungeon = instantiateDungeon(resultSet);
                }
            }
            return dungeon;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dungeon instantiateDungeon(ResultSet resultSet) {
        try {
            EnemyDao enemyDao = DaoFactory.createEnemyDao();
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int endbossID = resultSet.getInt(3);
            String enemiesID = resultSet.getString(4);
            return new Dungeon(id,name, enemyDao.findById(endbossID),InstantiateFromString.enemyList(enemiesID,enemyDao));
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Dungeon> findAll() {
        return List.of();
    }
}
