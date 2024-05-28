package entities;
import entities.models.LifeBar;
import entities.models.Power;

import java.util.Map;

public class Player extends Entity {
    public Player() {
    }

    public Player(Integer playerId,String name,LifeBar lifeBar) {
        super(playerId,name,lifeBar);
    }

    public Player(Integer playerId, String name, LifeBar lifeBar, Map<Integer, Power> powers) {
        super(playerId,name,lifeBar,powers);
    }

    @Override
    public String say(String sayed) {
        return null;
    }
}