package application;
import entities.Player;
import entities.models.LifeBar;
import entities.models.Power;
import entities.models.Transformation;

import java.util.HashMap;
import java.util.Map;

public class GameInterface {
    public static void main(String[] args) {
        LifeBar zeroLifeBar = new LifeBar(100,100);
        zeroLifeBar.receiveDamage(20);
        String name = "SinkOne";
        Map<Integer, Power> powerMap = new HashMap<>();

        Player sinkOne = new Player(1,name,zeroLifeBar);
        Transformation sinkTwo = new Transformation(2,"SINK TWO",new LifeBar(2000),sinkOne,powerMap);
        Player reSink = sinkTwo.revertTransformation();
        System.out.println(sinkOne);
        System.out.println(sinkTwo);
        System.out.println(reSink);
    }
}
