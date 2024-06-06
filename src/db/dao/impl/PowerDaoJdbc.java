package db.dao.impl;

import db.dao.PowerDao;
import entities.models.Power;

import java.sql.Connection;
import java.util.List;

public class PowerDaoJdbc implements PowerDao {
    Connection connection;

    public PowerDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Power power) {

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
