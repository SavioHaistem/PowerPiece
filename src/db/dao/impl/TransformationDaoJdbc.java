package db.dao.impl;

import db.DB;
import db.dao.TransformationDao;
import entities.models.Transformation;
import exceptions.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransformationDaoJdbc implements TransformationDao {
    Connection connection = DB.getConnection();
    @Override
    public void add(Transformation form) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Transformations (id, name, life, powers) "
                    +   "VALUES (?,?,?,?) "
            );
            statement.setInt(1,form.getEntityId());
            statement.setString(2, form.getName());
            statement.setInt(3,form.getLifeBar().getMaxLife());
            statement.setString(4,form.getPowers().toString());
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Transformation findById(int id) {
        return null;
    }

    @Override
    public Transformation findByForm(Transformation form) {
        return null;
    }

    @Override
    public List<Transformation> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Transformation instantiateForm(ResultSet resultSet) {
        return null;
    }
}
