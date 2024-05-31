package application;
import entities.Player;
import entities.dungeos.Chamber;
import entities.dungeos.Hanchinosu;
import entities.enemies.Enemy;
import entities.models.LifeBar;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class GameInterface {
    public static void main(String[] args) {
        //TODO: game party method;
        //TODO: auto instance dungeon method;

        Player sinkOne = new Player(1,"SinkOne",new LifeBar(100),new HashMap<>());
        Player sinkTwo = new Player(2,"SinkTwo",new LifeBar(100),new HashMap<>());

        Enemy lofi = new Enemy(24,"Lofi",new LifeBar(100));

        Chamber chamber1 = new Chamber(1,"Quarto de Lofi");
        Deque<Chamber> rooms = new ArrayDeque<>();
        chamber1.addEnemy(lofi);
        rooms.add(chamber1);

        Hanchinosu hachinosu = new Hanchinosu(1,"Hachinosu",rooms);

        System.out.println(hachinosu);
        System.out.println("Hachinosu active ? " + hachinosu.isActive());
        while (hachinosu.isActive()) {
            System.out.println("is active");
        }
    }
}
