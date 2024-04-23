package entities.enemies;

import entities.Entity;
import entities.models.LifeBar;
import interfaces.AtackableEntity;

public class BlackBeard extends Entity {
    public BlackBeard() {
        super(10000,new LifeBar(100000),"Black Beard");
    }

    @Override
    public void atack(AtackableEntity atackableEntity) {

    }

    @Override
    public String say(String sayed) {
        return "Zehahahaha! you will lost";
    }
}
