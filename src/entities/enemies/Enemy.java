package entities.enemies;

import entities.Entity;
import entities.models.LifeBar;
import entities.models.Power;

import java.util.Map;

public class Enemy extends Entity {
    private Integer enemyCategory;

    // category Boss: 4,
    // category Epic: 3,
    // category Rare: 2,
    // category common: 1,

    public Enemy() {

    }

    public Enemy(Integer entityId, String name, LifeBar lifeBar) {
        super(entityId, name, lifeBar);
    }

    public Enemy(Integer entityId, String name, LifeBar lifeBar, Map<Integer, Power> powers) {
        super(entityId, name, lifeBar, powers);
    }

    public Integer getEnemyCategory() {
        return enemyCategory;
    }

    public void setEnemyCategory(Integer enemyCategory) {
        this.enemyCategory = enemyCategory;
    }

    @Override
    public String say(String sayed) {
        return sayed;
    }
}
