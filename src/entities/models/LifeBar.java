package entities.models;

import java.util.ArrayList;
import java.util.List;

public class LifeBar {
    protected Integer maxLife;
    protected Integer currentLife;
    protected ArrayList<Character> healthBar = new ArrayList<>();

    public LifeBar() {}
    public LifeBar(Integer maxLife, Integer currentLife) {
        this.maxLife = maxLife;
        this.currentLife = currentLife;
    }

    public List<Character> getLifeBar() {
        updateHealthBar();
        return healthBar;
    }

    public Integer getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(Integer maxLife) {
        this.maxLife = maxLife;
    }

    public Integer getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(Integer currentLife) {
        this.currentLife = currentLife;
    }

    public void receiveDamage(int damage) {
        currentLife -= damage;
    }

    public void updateHealthBar() {
        healthBar.removeAll(healthBar);
        for (int tiny = maxLife / 10; tiny <= maxLife; tiny += maxLife / 10) {
            if (currentLife >= tiny) {
                healthBar.add('█');
            } else {
                healthBar.add('░');
            }
        }
        System.out.println(healthBar.size());
    }

    @Override
    public String toString() {
        return getLifeBar().toString();
    }
}
