package application;

import db.dao.DaoFactory;
import db.dao.impl.PowerDaoJdbc;
import enums.PowerType;

public class GameInterface {
    public static void main(String[] args) {
        PowerDaoJdbc powerDao = DaoFactory.createPowerDao();
        powerDao.findAll().stream().filter(power -> power.getPowerType() == PowerType.TRANSFORMATION).forEach(System.out::println);
    }
}
