package com.PowerPiece.db.dao.impl;

import com.PowerPiece.db.DB;
import com.PowerPiece.db.dao.PowerDao;
import com.PowerPiece.entities.models.Power;
import com.PowerPiece.enums.PowerType;
import com.PowerPiece.exceptions.DbException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class PowerDaoJdbc implements PowerDao {
    Connection connection;

    public PowerDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Power power) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Powers (id,name,category,powerType,akumaID,description) "
                            +   "VALUES (?,?,?,?,?,?) ",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1,power.getId());
            statement.setString(2,power.getName());
            statement.setInt(3,power.getCategory());
            statement.setString(4,power.getPowerType().toString());
            statement.setInt(5,power.getAkumaID());
            statement.setString(6,power.getDescription());
            int generatedKey = statement.executeUpdate();
            if (generatedKey > 0) {
                System.out.println("Power: " + generatedKey + " has added in Powers list");
            } else {
                System.out.println("Power no has added on Powers list");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(statement);
        }
    }

    @Override
    public void removeById(Integer powerID) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM Powers WHERE id = ? "
            );
            statement.setInt(1,powerID);
            int deletedKey = statement.executeUpdate();
            if (deletedKey > 0) {
                System.out.println("Power: " + powerID + " has removed");
            } else {
                System.out.println("Power wasn't removed");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(statement);
        }
    }

    @Override
    public Power findById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT Powers.* FROM Powers WHERE Powers.id = ? "
            );
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return instantiatePower(resultSet);
            } else {
                throw new DbException("power not searched");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(statement);
            DB.closeResultSet(resultSet);
        }
    }

    public Power instantiatePower(ResultSet resultSet) {
        try {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Integer category = resultSet.getInt("category");
            PowerType powerType = PowerType.valueOf(resultSet.getString("powerType"));
            Integer akumaID = resultSet.getInt("akumaID");
            String description = resultSet.getString("description");
            return new Power(id,name,category,powerType,akumaID,description);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Map<Integer, Power> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Map<Integer,Power> powers = new HashMap<>();
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM Powers "
            );
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Power power = instantiatePower(resultSet);
                powers.put(power.getId(),power);
            }
            return powers;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(statement);
            DB.closeResultSet(resultSet);
        }
    }
}
