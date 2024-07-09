package com.PowerPiece;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.services.CacheService;
import com.PowerPiece.services.CombatServie;
import com.PowerPiece.services.InterfaceService;

import java.util.*;

public class GameInterface {
    public static void main(String[] args) {
        int[] randoms = InterfaceService.randomizeManyTimes(3,10);
        Scanner scan = new Scanner(System.in);
        Player player = new Player();
        InterfaceService.cleanTerminal();

        //Create player:
        InterfaceService.title("Power Piece 1.0");
        InterfaceService.anyQuestion("Choose your nick name: ");
        player.setEntityId(1);
        player.setLifeBar(new LifeBar(100));
        player.setName(scan.nextLine());
        InterfaceService.cleanTerminal();

        //carregando akuma no mis:
        InterfaceService.loadText("Aleatorizando akumanomis");
        InterfaceService.timer(2);
        InterfaceService.cleanTerminal();

        //Choose one random AKumaNoMi:
        List<AkumaNoMi> randomAkumaNoMis = Arrays.stream(randoms).mapToObj(CacheService.getAkumanomis()::get).toList();
        randomAkumaNoMis.forEach(InterfaceService::showOption);
        InterfaceService.anyQuestion("Choose your AkumaNoMI: ");
        player.setAkumaNoMi(CacheService.getAkumanomis().get(scan.nextInt()));
        player.takeDamage(10);
        InterfaceService.cleanTerminal();
        InterfaceService.loadText("Criando personagem");
        InterfaceService.timer(2);
        InterfaceService.cleanTerminal();
        InterfaceService.title("Seu personagem");
        System.out.println(player.toStringWithPowersName());
        InterfaceService.timer(2);
        InterfaceService.cleanTerminal();
        InterfaceService.title("Escolha uma Dungeon");
        CacheService.getDungeons().values().forEach(InterfaceService::showOption);
        InterfaceService.anyQuestion("Dungeon:");
        CombatServie.setDungeon(scan.nextInt());
        while(CombatServie.haveEnemy()) {
            System.out.println("Cleared");
            CombatServie.currentDungeon.getEnemies().clear();
        }
        System.out.println("Enemies appear");
    }
}
