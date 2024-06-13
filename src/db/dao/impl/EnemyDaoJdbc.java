package db.dao.impl;

import db.DB;
import db.dao.EnemyDao;
import entities.enemies.Enemy;
import exceptions.DbException;

import java.sql.*;
import java.util.List;

public class EnemyDaoJdbc implements EnemyDao {
    Connection connection = DB.getConnection();

    @Override
    public void add(Enemy enemy) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Enemies (id,name,life,powers,category) "
                    +   "VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1,enemy.getEntityId());
            statement.setString(2,enemy.getName());
            statement.setInt(3,enemy.getLifeBar().getMaxLife());
            statement.setString(4,enemy.getPowersIDs());
            statement.setInt(5,enemy.getEnemyCategory());
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public Enemy findById(int id) {
        return null;
    }

    @Override
    public List<Enemy> findAll() {
        return List.of();
    }

    @Override
    public Enemy instantiateEnemy(ResultSet resultSet) {
        return null;
    }
}
