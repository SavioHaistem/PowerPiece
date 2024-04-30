package interfaces;

import entities.Entity;

public interface AtackableEntity {
    void atack(Entity entity, int damage);
    String say(String sayed);
}