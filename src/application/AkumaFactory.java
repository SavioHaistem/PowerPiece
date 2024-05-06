package application;
import entities.Entity;
import entities.enemies.BlackBeard;

public class AkumaFactory {
    public static void main(String[] args) {
        Entity blackBeard = new BlackBeard();
        System.out.println(blackBeard);
        blackBeard.atack(blackBeard,10);
        System.out.println(blackBeard);
    }
}