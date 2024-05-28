package interfaces;
import entities.models.LifeBar;

public interface Atackable {
    void takeDamage(Integer damage);
    String say(String sayed);
}