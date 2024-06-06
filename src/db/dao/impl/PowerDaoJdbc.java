package db.dao.impl;

import db.dao.PowerDao;
import entities.models.Power;
import exceptions.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PowerDaoJdbc implements PowerDao {
    Connection connection;

    public PowerDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Power power) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Powers (id,name,category,powerType,akumaID,description) "
                            +   "VALUES (?,?,?,?,?,?) ",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setInt(1,power.getId());
            preparedStatement.setString(2,power.getName());
            preparedStatement.setInt(3,power.getCategory());
            preparedStatement.setString(4,power.getPowerType().toString());
            preparedStatement.setInt(5,power.getAkumaID());
            preparedStatement.setString(6,power.getDescription());

            int generatedKey = preparedStatement.executeUpdate();
            if (generatedKey > 0) {
                System.out.println("Power: " + generatedKey + " has added in Powers list");
            } else {
                System.out.println("Power no has added on Powers list");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void remove(Power power) {

    }

    @Override
    public Power findById(Integer id) {
        return null;
    }

    @Override
    public List<Power> findAll() {
        return List.of();
    }
}
