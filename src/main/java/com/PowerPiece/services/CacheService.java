package com.PowerPiece.services;

import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.dungeos.Dungeon;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.Power;

import java.util.Map;

public class CacheService {
    Map<Integer, Power> powers = null;
    Map<Integer, AkumaNoMi> akumanomis = null;
    Map<Integer, Enemy> enemies = null;
    Map<Integer, Dungeon> dungeons = null;
}
