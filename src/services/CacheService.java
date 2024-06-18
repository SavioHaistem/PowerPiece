package services;

import entities.akumanomis.AkumaNoMi;
import entities.dungeos.Dungeon;
import entities.enemies.Enemy;
import entities.models.Power;

import java.util.HashMap;
import java.util.Map;

public class CacheService {
    Map<Integer, Power> powers = null;
    Map<Integer, AkumaNoMi> akumanomis = null;
    Map<Integer, Enemy> enemies = null;
    Map<Integer, Dungeon> dungeons = null;
}
