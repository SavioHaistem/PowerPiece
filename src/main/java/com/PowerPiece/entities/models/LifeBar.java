package com.PowerPiece.entities.models;

import com.PowerPiece.entities.TextDecorations;

import java.util.ArrayList;
import java.util.List;

public class LifeBar {
    protected Integer maxLife;
    protected Integer currentLife;
    protected ArrayList<Character> healthBar = new ArrayList<>();

    public LifeBar() {}
    public LifeBar(Integer maxLife) {
        this.maxLife = maxLife;
        this.currentLife = maxLife;
    }
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

    public void minusLife(int minusLifeValue) {
        currentLife -= minusLifeValue;
    }

    public void plusLife(Integer plusLifeValue) {
        currentLife += plusLifeValue;
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
    }

    @Override
    public String toString() {
        StringBuilder stringLifeBar = new StringBuilder();
        getLifeBar().forEach(
                character -> {
                    if (character == '█') {
                        stringLifeBar.append(TextDecorations.GREEN);
                        stringLifeBar.append('█');
                    } else {
                        stringLifeBar.append(TextDecorations.RED);
                        stringLifeBar.append('█');
                    }
                }
        );
        stringLifeBar.append(TextDecorations.RESET).append('\n');

        return stringLifeBar.toString();
    }
}
