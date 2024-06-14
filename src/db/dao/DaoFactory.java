package db.dao;
import db.DB;
import db.dao.impl.*;
import entities.enemies.Enemy;

//TODO: game party method;
//TODO: auto instance dungeon method;
//TODO: create DungeonsDAO;
//TODO: create EnemysDAO;
//TODO: create RewardsDAO;
//TODO: gameParty database;

public class DaoFactory {
    public static AkumaDaoJdbc createAkumaDao() {
        return new AkumaDaoJdbc(DB.getConnection());
    }

    public static PowerDaoJdbc createPowerDao() {
        return new PowerDaoJdbc(DB.getConnection());
    }

    public static ChamberDaoJdbc createChamberDao() {
        return new ChamberDaoJdbc(DB.getConnection());
    }

    public static EnemyDaoJdbc createEnemyDao() {
        return new EnemyDaoJdbc(DB.getConnection());
    }

    public static TransformationDaoJdbc createTransformationDaoJdbc() {
        return new TransformationDaoJdbc(DB.getConnection());
    }
}