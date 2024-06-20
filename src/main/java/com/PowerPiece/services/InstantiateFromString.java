package com.PowerPiece.services;

import com.PowerPiece.db.dao.DaoFactory;
import com.PowerPiece.db.dao.EnemyDao;
import com.PowerPiece.db.dao.PowerDao;
import com.PowerPiece.db.dao.impl.EnemyDaoJdbc;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.Power;

import java.util.*;

public class InstantiateFromString {
    public static Map<Integer, Power> powerMap(String stringIDs) {
        PowerDao powerDao = DaoFactory.createPowerDao();
        Map<Integer,Power> powerMap = new HashMap<>();
        String[] powersIds = stringIDs.split(",");

        for (String id : powersIds) {
            int intID = Integer.parseInt(id);
            powerMap.put(intID,powerDao.findById(intID));
        }

        return powerMap;
    }
    public static List<Enemy> enemyList(String StringEnemiesIDs) {
        EnemyDao enemyDao = DaoFactory.createEnemyDao();
        List<Enemy> enemies = new ArrayList<>();
        int[] enemiesIDs = Arrays.stream(StringEnemiesIDs.split(",")).mapToInt(Integer::parseInt).toArray();

        for (int id : enemiesIDs) {
            enemies.add(enemyDao.findById(id));
        }
        return enemies;
    }

    public static List<Enemy> enemyList(String StringEnemiesIDs, EnemyDao enemyDao) {
        List<Enemy> enemies = new ArrayList<>();
        int[] enemiesIDs = Arrays.stream(StringEnemiesIDs.split(",")).mapToInt(Integer::parseInt).toArray();

        for (int id : enemiesIDs) {
            enemies.add(enemyDao.findById(id));
        }
        return enemies;
    }
}
