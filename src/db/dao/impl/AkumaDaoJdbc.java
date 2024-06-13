package db.dao.impl;

import db.DB;
import db.dao.AkumaDao;
import db.dao.DaoFactory;
import db.dao.PowerDao;
import entities.akumanomis.*;
import entities.models.Power;
import entities.models.Transformation;
import enums.AkumasType;
import exceptions.DbException;

import java.sql.*;
import java.util.*;

public class AkumaDaoJdbc implements AkumaDao {
    Connection connection = null;
    PowerDao powerDao = DaoFactory.createPowerDao();
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
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        AkumaNoMi akumaNoMi = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM AkumaNoMis WHERE id = ? "
            );
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while(resultSet.next()) {
                    akumaNoMi = instantiateAkuma(resultSet);
                }
            } else {
                throw new DbException("your akumanomi no has searched");
            }
            return akumaNoMi;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatment(statement);
        }
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
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<AkumaNoMi> akumaNoMis = new ArrayList<>();
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM AkumaNoMis WHERE type = ? "
            );
            statement.setString(1,type.toString());
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while(resultSet.next()) {
                    akumaNoMis.add(instantiateAkuma(resultSet));
                }
                return akumaNoMis;
            } else {
                throw new DbException("no has found any AkumaNoMi with this status ");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatment(statement);
        }
    }

    public AkumaNoMi instantiateAkuma(ResultSet resultSet) {
        try {
            Integer akumaId = resultSet.getInt(1);
            String akumaName = resultSet.getString(2);
            String[] powersIDs = resultSet.getString(4).split(",");
            Map<Integer,Power> powerMap = new HashMap<>();
            Arrays.stream(powersIDs).forEach(powerId -> {
                powerMap.put(Integer.parseInt(powerId),powerDao.findById(Integer.parseInt(powerId)));
            });
            return switch (AkumasType.valueOf(resultSet.getString(3))) {
                case PARAMECIA -> new Paramecia(akumaName, akumaId,powerMap);
                case ZOAN -> new Zoan(akumaName,akumaId,Transformation.instantiateForm(powerMap));
                case LOGIA -> new Logia(akumaName, akumaId);
                case SMILE -> new Smile(akumaName, akumaId);
                case null, default -> throw new DbException("No valid AkumaNoMi type in instantiateAkuma");
            };
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
