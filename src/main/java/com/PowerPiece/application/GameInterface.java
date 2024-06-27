package com.PowerPiece.application;
import com.PowerPiece.db.dao.*;

public class GameInterface {
    public static void main(String[] args) {
        PowerDao powerDao = DaoFactory.createPowerDao();
        AkumaDao akumaDao = DaoFactory.createAkumaDao();
        EnemyDao enemyDao = DaoFactory.createEnemyDao();
        TransformationDao transformationDao = DaoFactory.createFormDao();
        DungeonDao dungeonDao = DaoFactory.createDungeonDao();
        System.out.println("AkumaNoMis: ");
        akumaDao.findAll().forEach(System.out::println);
        System.out.println("Powers: ");
        powerDao.findAll().forEach(System.out::println);
        System.out.println("Transformations: ");
        transformationDao.findAll().forEach(System.out::println);
        System.out.println("Enemies: ");
        enemyDao.findAll().forEach(System.out::println);
        System.out.println("Dungeons: ");
        dungeonDao.findAll().forEach(System.out::println);
    }
}
