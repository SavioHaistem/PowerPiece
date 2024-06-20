package com.PowerPiece.db.dao.impl;

import com.PowerPiece.db.DB;
import com.PowerPiece.db.dao.EnemyDao;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.entities.models.Power;
import com.PowerPiece.exceptions.DbException;
import com.PowerPiece.services.InstantiateFromString;

import java.sql.*;
import java.util.*;

public class EnemyDaoJdbc implements EnemyDao {
    Connection connection = null;

    public EnemyDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Enemy enemy) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Enemies (id,name,life,powers,category) "
                    +   "VALUES (?,?,?,?,?) ",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1,enemy.getEntityId());
            statement.setString(2,enemy.getName());
            statement.setInt(3,enemy.getLifeBar().getMaxLife());
            statement.setString(4,enemy.getPowersIDs());
            statement.setInt(5,enemy.getEnemyCategory());
            int affectedRow = statement.executeUpdate();
            if (affectedRow > 0) {
                System.out.println("enemy: " + enemy.getName() + ", has added");
            } else {
                throw new DbException("enemy: " + enemy.getName() + "has not added");
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
                    "DELETE FROM Enemies WHERE id = ? ",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1,id);
            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("the enemy of id: " + id + " has removed");
            } else {
                throw new DbException("the enemy has not removed");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(statement);
        }
    }

    @Override
    public Enemy findById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM Enemies WHERE id = ? "
            );
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                Enemy enemy = null;
                while (resultSet.next()) {
                    enemy = instantiateEnemy(resultSet);
                }
                return enemy;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatment(statement);
        }
    }

    @Override
    public List<Enemy> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Enemy> enemies = new ArrayList<>();
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM Enemies "
            );
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while(resultSet.next()) {
                    enemies.add(instantiateEnemy(resultSet));
                }
            } else {
                throw new DbException("any enemy returned");
            }
            return enemies;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Enemy instantiateEnemy(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            LifeBar lifeBar = new LifeBar(resultSet.getInt(3));
            String powerIDs = resultSet.getString(4);
            Map<Integer, Power> powers = null;
            if (powerIDs != null) {
                powers = InstantiateFromString.powerMap(powerIDs);
            }
            int enemyCategory = resultSet.getInt(5);
            return new Enemy(id,name,lifeBar,powers,enemyCategory);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
