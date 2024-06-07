package application;

import db.dao.DaoFactory;
import db.dao.impl.PowerDaoJdbc;
import entities.models.Power;
import enums.PowerType;

public class GameInterface {
    public static void main(String[] args) {
        PowerDaoJdbc powerDao = DaoFactory.createPowerDao();
        Power elasticDick = new Power(1,"elastic dick",3,PowerType.PARAMECIA,1,"cum in enemy");
        Power pistol = new Power(2,"pistol",1,PowerType.PARAMECIA,1,"Shots target with pistol gum");
        Power cataling = new Power(3,"cataling",2,PowerType.PARAMECIA,1,"Shots multiple times target with pistols gum");
        powerDao.add(elasticDick);
        System.out.println(powerDao.findById(elasticDick.getId()));
        powerDao.add(pistol);
        powerDao.add(cataling);
        System.out.println(powerDao.findAll());
        powerDao.removeById(pistol.getId());
        powerDao.removeById(cataling.getId());
    }
}
