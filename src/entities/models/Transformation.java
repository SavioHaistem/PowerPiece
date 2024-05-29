package entities.models;
import entities.Entity;
import entities.Player;

import java.util.Map;
public class Transformation extends Entity {
    private Player player = null;

    public Transformation() {}
    public Transformation(Integer entityId,String name, LifeBar lifeBar,Player player,Map<Integer,Power> powers) {
        super(entityId,name,lifeBar,powers);
        this.player = player;
    }

    public Player revertTransformation() {
        return player;
    }

    @Override
    public String say(String sayed) {
        return sayed;
    }
}
