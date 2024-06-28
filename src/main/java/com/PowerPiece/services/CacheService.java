package com.PowerPiece.services;

import com.PowerPiece.db.dao.*;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.Power;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public final class CacheService {
    private static PowerDao powerDao = DaoFactory.createPowerDao();
    private static AkumaDao akumaDao = DaoFactory.createAkumaDao();
    private static EnemyDao enemyDao = DaoFactory.createEnemyDao();
    private static TransformationDao transformationDao = DaoFactory.createFormDao();
    private static DungeonDao dungeonDao = DaoFactory.createDungeonDao();
    private static Map<Integer, Power> powers = null;
    private static Map<Integer, AkumaNoMi> akumanomis = null;
    private static Map<Integer, Enemy> enemies = null;
    private static Map<Integer, Dungeon> dungeons = null;
}
