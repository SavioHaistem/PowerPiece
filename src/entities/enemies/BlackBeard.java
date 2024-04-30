package entities.enemies;

import entities.Entity;
import entities.models.LifeBar;
import interfaces.AtackableEntity;

public class BlackBeard extends Entity {
    public BlackBeard() {
        super(new LifeBar(10000,10000),"Black Beard");
    }

    @Override
    public void atack(Entity entity,int damage) {
        entity.getLifeBar().receiveDamage(damage);
    }

    @Override
    public String say(String sayed) {
        return "zehahahaha! you will lost";
    }
}
