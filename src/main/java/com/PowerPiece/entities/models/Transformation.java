package com.PowerPiece.entities.models;
import com.PowerPiece.entities.Entity;
import com.PowerPiece.entities.Player;

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

    public static Transformation instantiateForm(Transformation form,Map<Integer, Power> powerMap) {
        return new Transformation();
    }

    @Override
    public String toString() {
        return "Form: [" + name + ", " + entityId + "]";
    }
}
