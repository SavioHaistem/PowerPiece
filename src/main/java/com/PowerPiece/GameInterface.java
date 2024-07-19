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
        int[] randoms = InterfaceService.random(3,10);
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
        InterfaceService.loadText("load player");
        InterfaceService.timer(2);
        InterfaceService.cleanTerminal();
        InterfaceService.title("Escolha uma Dungeon");
        CacheService.getDungeons().values().forEach(InterfaceService::showOption);
        InterfaceService.anyQuestion("Dungeon:");
        DungeonNavigator.comeInDungeon(player,CacheService.getDungeons().get(scan.nextInt()));
        Enemy enemy = DungeonNavigator.getNextEnemy();

        while (enemy != null && player.isLive()) {
            InterfaceService.loadText("carregando inimigo");
            InterfaceService.timer(1);
            InterfaceService.cleanTerminal();
            while(enemy.isLive() && player.isLive()) {
                InterfaceService.cleanTerminal();
                System.out.println(enemy);
                System.out.println(player.toStringWithPowers());
                InterfaceService.timer(1);
                //choose turn:
                if (CombatServie.isPlayerTurn()) {
                    player.getPowers().values().forEach(InterfaceService::showOption);
                    InterfaceService.anyQuestion("escolha seu ataque");
                    CombatServie.hitEntity(enemy,player.getPowers().get(scan.nextInt()));
                } else {
                    List<Integer> enemyPowers = enemy.getPowers().keySet().stream().toList();
                    int randomPowerIndex = InterfaceService.random(enemyPowers.size());
                    CombatServie.hitEntity(player,enemy.getPowerByIndex(randomPowerIndex));
                }
                InterfaceService.timer(1);
                InterfaceService.cleanTerminal();
                if (enemy.isLive()) {
                    System.out.println(enemy);
                    System.out.println(player.toStringWithPowers());
                    InterfaceService.timer(2);
                    InterfaceService.cleanTerminal();
                    InterfaceService.tellerSays("Next turn");
                    InterfaceService.timer(1);
                } else {
                    System.out.println(player);
                    InterfaceService.tellerSays("Enemy has dead");
                    InterfaceService.timer(2);
                    InterfaceService.cleanTerminal();
                }
                //TODO: fix player death
                //TODO: clear scan before read input user.
            }
            if (player.isLive()) {
                enemy = DungeonNavigator.getNextEnemy();
            } else {
                InterfaceService.tellerSays("|~~~~~~~~~ you has dead T-T ~~~~~~~~|");
            }
        }
        if (player.isLive()) {
            System.out.println(TextDecorations.BG_RED + "KAIDO has defeat, CONGRATULATIONS" + TextDecorations.RESET);
        } else {
            InterfaceService.cleanTerminal();
            InterfaceService.loadText("exiting dungeon");
            InterfaceService.timer(1);
        }
        InterfaceService.cleanTerminal();
        InterfaceService.tellerSays("closing PowerPiece... BYE!");
        InterfaceService.timer(1);
    }
}
