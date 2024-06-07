package db.dao.impl;

import db.DB;
import db.dao.AkumaDao;
import entities.akumanomis.*;
import enums.AkumasType;
import exceptions.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AkumaDaoJdbc implements AkumaDao {
    Connection connection = null;
    public AkumaDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(AkumaNoMi akumaNoMi) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO AkumaNoMis "
                    +   "(id,name,type,powers) "
                    +   "VALUES (?,?,?,?) ",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1,akumaNoMi.getId());
            statement.setString(2,akumaNoMi.getName());
            statement.setString(3,akumaNoMi.getType().toString());
            statement.setString(4,akumaNoMi.getPowers().toString());
            int rowEffected = statement.executeUpdate();
            if (rowEffected > 0) {
                System.out.println("Akumanomi: " + rowEffected + " has added");
            } else {
                System.err.println("Your Akumanomi has not added");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(statement);
        }
    }

    @Override
    public void remove(AkumaNoMi akumaNoMi) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM AkumaNoMis WHERE id = ? AND name = ? ",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1,akumaNoMi.getId());
            statement.setString(2,akumaNoMi.getName());
            int rowsEffected = statement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Your Akumanomi: " + akumaNoMi.getName() + " has removed ");
            } else {
                System.err.println("Your Akumanomi has not removed");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(statement);
        }
    }

    @Override
    public AkumaNoMi findById(Integer id) {
        return null;
    }

    @Override
    public List<AkumaNoMi> findAll() {
        List<AkumaNoMi> akumaNoMis = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM AkumaNoMis"
            );
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                akumaNoMis.add(instantiateAkuma(resultSet));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return akumaNoMis;
    }

    @Override
    public List<AkumaNoMi> findByType(AkumasType type) {
        return List.of();
    }

    public AkumaNoMi instantiateAkuma(ResultSet resultSet) {
        //todo: create method to instantiate powers;
        try {
            Integer akumaId = resultSet.getInt(1);
            String akumaName = resultSet.getString(2);

            return switch (AkumasType.valueOf(resultSet.getString(3))) {
                case PARAMECIA -> new Paramecia(akumaName, akumaId);
                case ZOAN -> new Zoan(akumaName, akumaId);
                case LOGIA -> new Logia(akumaName, akumaId);
                case SMILE -> new Smile(akumaName, akumaId);
                case null, default -> throw new DbException("No valid AkumaNoMi type in instantiateAkuma");
            };
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
