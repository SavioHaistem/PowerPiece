package application;

import db.dao.DaoFactory;
import db.dao.impl.AkumaDaoJdbc;
import db.dao.impl.PowerDaoJdbc;
import entities.akumanomis.AkumaNoMi;
import entities.akumanomis.Zoan;

public class GameInterface {
    public static void main(String[] args) {
        PowerDaoJdbc powerDao = DaoFactory.createPowerDao();
        AkumaDaoJdbc akumaDao = DaoFactory.createAkumaDao();
        AkumaNoMi zoan = new Zoan("Lepo Lepo no mi",31);
        akumaDao.findAll().forEach(System.out::println);
        akumaDao.add(zoan);
        System.out.println(akumaDao.findById(31));
        akumaDao.remove(zoan);
        akumaDao.findAll().forEach(System.out::println);
    }
}
