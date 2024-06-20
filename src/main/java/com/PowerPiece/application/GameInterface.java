package com.PowerPiece.application;
import com.PowerPiece.db.dao.DaoFactory;
import com.PowerPiece.db.dao.PowerDao;

public class GameInterface {
    public static void main(String[] args) {
        PowerDao newPowerDao = DaoFactory.createPowerDao();
        newPowerDao.findAll().forEach(System.out::println);
    }
}
