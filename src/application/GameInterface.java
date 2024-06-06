package application;

import db.dao.DaoFactory;
import db.dao.impl.PowerDaoJdbc;
import entities.models.Power;
import enums.PowerType;

public class GameInterface {
    public static void main(String[] args) {
        PowerDaoJdbc powerDao = DaoFactory.createPowerDao();
        Power elastickDick = new Power(1,"elastic dick",3,PowerType.PARAMECIA,1,"cum in enemy");
        powerDao.add(elastickDick);
    }
}
