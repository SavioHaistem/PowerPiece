package application;
import entities.Player;
import entities.dungeos.Dungeon;
import entities.dungeos.Hanchinosu;
import entities.models.LifeBar;

import java.util.HashMap;
import java.util.Map;

public class GameInterface {
    public static void main(String[] args) {
        Player sinkOne = new Player(1,"SinkOne",new LifeBar(100),new HashMap<>());
        Player sinkTwo = new Player(2,"SinkTwo",new LifeBar(100),new HashMap<>());
        Dungeon hachinosu = new Hanchinosu(1,"Hachinosu");
        while (hachinosu.isActive()) {
            System.out.println("is active");

        }
    }
}
