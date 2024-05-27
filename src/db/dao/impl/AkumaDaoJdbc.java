package db.dao.impl;

import db.dao.AkumaDao;
import entities.akumanomis.AkumaNoMi;
import entities.akumanomis.Paramecia;
import enums.AkumasType;

import java.sql.Connection;
import java.util.List;

public class AkumaDaoJdbc implements AkumaDao {
    Connection connection = null;
    public AkumaDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(AkumaNoMi akumaNoMi) {

    }

    @Override
    public void remove(AkumaNoMi akumaNoMi) {

    }

    @Override
    public AkumaNoMi findById(Integer id) {
        return null;
    }

    @Override
    public List<AkumaNoMi> findAll() {
        return List.of();
    }

    @Override
    public List<AkumaNoMi> findByType(AkumasType type) {
        return List.of();
    }

    public AkumaNoMi instanciateAkuma() {
        return new Paramecia("shoshonomi",1);
    }
}
