package entities.models;

import java.util.ArrayList;
import java.util.List;

public class LifeBar {
    protected List<Character> lifeBar = new ArrayList<>();
    protected Character tinyHealth = '█';
    protected Character tinyUnHealth = '░';
    protected Integer maxLife;
    protected Integer currentLife;

    public LifeBar() {}
    public LifeBar(Integer maxLife) {
        this.maxLife = maxLife;
    }

    public List<Character> getLifeBar() {
        return lifeBar;
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
}
