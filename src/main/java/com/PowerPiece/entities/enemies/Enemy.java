package com.PowerPiece.entities.enemies;

import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.entities.models.Power;

import java.util.Map;

public class Enemy extends Entity {
    private int enemyCategory;

    // category Boss: 4,
    // category Epic: 3,
    // category Rare: 2,
    // category common: 1,

    public Enemy() {

    }

    public Enemy(Integer entityId, String name, LifeBar lifeBar, int enemyCategory) {
        super(entityId, name, lifeBar);
        this.enemyCategory = enemyCategory;
    }

    public Enemy(Integer entityId, String name, LifeBar lifeBar, Map<Integer, Power> powers, int enemyCategory) {
        super(entityId, name, lifeBar, powers);
        this.enemyCategory = enemyCategory;
    }

    public Integer getEnemyCategory() {
        return enemyCategory;
    }

    public void setEnemyCategory(Integer enemyCategory) {
        this.enemyCategory = enemyCategory;
    }

//    @Override
//    public String toString() {
//        return "(" + entityId + "): " + name;
//    }
}
