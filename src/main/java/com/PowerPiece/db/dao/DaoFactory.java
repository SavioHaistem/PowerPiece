package com.PowerPiece.db.dao;
import com.PowerPiece.db.dao.impl.*;
import com.PowerPiece.db.DB;
import com.PowerPiece.db.dao.impl.*;

import java.sql.Connection;

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

    public static TransformationDaoJdbc createFormDao() {
        return new TransformationDaoJdbc(DB.getConnection());
    }

    public static DungeonDao createDungeonDao() {
        return new DungeonDaoJdbc(DB.getConnection());
    }
}