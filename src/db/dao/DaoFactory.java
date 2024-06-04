package db.dao;
import db.DB;
import db.dao.impl.AkumaDaoJdbc;

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
}