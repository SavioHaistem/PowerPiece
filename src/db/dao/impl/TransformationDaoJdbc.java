package db.dao.impl;
import db.DB;
import db.dao.TransformationDao;
import entities.models.LifeBar;
import entities.models.Power;
import entities.models.Transformation;
import exceptions.DbException;
import services.InstantiateFromString;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransformationDaoJdbc implements TransformationDao {
    Connection connection = null;

    public TransformationDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Transformation form) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Transformations (id, name, life, powers) "
                    +   "VALUES (?,?,?,?) ",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1,form.getEntityId());
            statement.setString(2, form.getName());
            statement.setInt(3,form.getLifeBar().getMaxLife());
            statement.setString(4,form.getPowersString());
            int affectedRow = statement.executeUpdate();
            if (affectedRow > 0) {
                System.out.println("transformation: " + form.getName() + " has added");
            } else {
                throw new DbException("transformations: " + form.getName() + " no has added");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(statement);
        }
    }

    @Override
    public Transformation findById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Transformation form = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM Transformations WHERE id = ? "
            );
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    form = instantiateForm(resultSet);
                }
            }
            return form;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatment(statement);
        }
    }

    @Override
    public Transformation findByForm(Transformation form) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM Transformations WHERE id = ? AND name = ? "
            );
            statement.setInt(1,form.getEntityId());
            statement.setString(2,form.getName());
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                Transformation transformation = null;
                while (resultSet.next()) {
                    transformation = instantiateForm(resultSet);
                }
                return transformation;
            } else {
                throw new DbException("Transformations: " + form + " was not found");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatment(statement);
        }
    }

    @Override
    public List<Transformation> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Transformation> transformations = new ArrayList<>();
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM Transformations "
            );
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while(resultSet.next()) {
                    transformations.add(instantiateForm(resultSet));
                }
            } else {
                throw new DbException("any transformation was found");
            }
            return transformations;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM Transformations WHERE id = ? ",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1,id);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Transformation id: " + id + " has deleted");
            } else {
                throw new DbException("Transformation id: " + id + " no has deleted");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Transformation instantiateForm(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            LifeBar lifeBar = new LifeBar(resultSet.getInt("life"));
            Map<Integer, Power> powerMap = InstantiateFromString.powerMap(resultSet.getString("powers"));
            return new Transformation(id,name,lifeBar,null,powerMap);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
