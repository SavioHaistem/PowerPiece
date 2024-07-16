package com.PowerPiece;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.services.CacheService;
import com.PowerPiece.services.CombatServie;
import com.PowerPiece.services.DungeonNavigator;
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
        DungeonNavigator.comeInDungeon(player,CacheService.getDungeons().get(scan.nextInt()));
        Enemy enemy = DungeonNavigator.getNextEnemy();

        while (enemy != null) {
            InterfaceService.loadText("carregando inimigo . . .");
            InterfaceService.timer(1);
            InterfaceService.cleanTerminal();
            while(enemy.isLive()) {
                System.out.println(enemy);
                System.out.println(player.toStringWithPowers());
                //choose turn:
                if (CombatServie.isPlayerTurn()) {
                    player.getPowers().values().forEach(InterfaceService::showOption);
                    InterfaceService.anyQuestion("escolha seu ataque");
                    CombatServie.hitEntity(enemy,player.getPowers().get(scan.nextInt()));
                    InterfaceService.cleanTerminal();
                    System.out.println(enemy);
                    InterfaceService.timer(2);
                    InterfaceService.cleanTerminal();
                } else {
                    InterfaceService.cleanTerminal();
                    InterfaceService.timer(2);
                    System.out.println("enemy jump your turn");
                    InterfaceService.timer(2);
                    InterfaceService.cleanTerminal();
                }
            }
            enemy = DungeonNavigator.getNextEnemy();
        }
        System.out.println(TextDecorations.BG_RED + "KAIDO has defeat, CONGRATULATIONS" + TextDecorations.RESET);
    }
}
