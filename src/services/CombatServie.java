package services;
import entities.Entity;

import java.util.List;

public class CombatServie {
    private static void killEntity(Entity entity, List<Entity> chamber) {
        chamber.remove(entity);
    }
    //TODO: add reward system;
}
