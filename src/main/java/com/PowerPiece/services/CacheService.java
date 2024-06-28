package com.PowerPiece.services;

import com.PowerPiece.db.dao.*;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.Power;
import com.PowerPiece.entities.models.Transformation;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public final class CacheService {
    private static final PowerDao powerDao = DaoFactory.createPowerDao();
    private static final AkumaDao akumaDao = DaoFactory.createAkumaDao();
    private static final EnemyDao enemyDao = DaoFactory.createEnemyDao();
    private static final TransformationDao formDao = DaoFactory.createFormDao();
    private static final DungeonDao dungeonDao = DaoFactory.createDungeonDao();
    private static final Map<Integer, Power> powers = powerDao.findAll();
    private static final Map<Integer, AkumaNoMi> akumanomis = akumaDao.findAll();
    private static final Map<Integer, Enemy> enemies = enemyDao.findAll();
    private static final Map<Integer, Transformation> transformations = formDao.findAll();
    private static final Map<Integer, Dungeon> dungeons = dungeonDao.findAll();

    public static Map<Integer, Power> getPowers() {
        return powers;
    }

    public static Map<Integer, AkumaNoMi> getAkumanomis() {
        return akumanomis;
    }

    public static Map<Integer, Enemy> getEnemies() {
        return enemies;
    }

    public static Map<Integer, Transformation> getTransformations() {
        return transformations;
    }

    public static Map<Integer, Dungeon> getDungeons() {
        return dungeons;
    }
}
