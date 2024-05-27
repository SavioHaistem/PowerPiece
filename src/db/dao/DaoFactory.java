package db.dao;

import db.DB;
import db.dao.impl.AkumaDaoJdbc;

public class DaoFactory {
    public static AkumaDaoJdbc createAkumaDao() {
        return new AkumaDaoJdbc(DB.getConnection());
    }
}
