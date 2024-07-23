package com.PowerPiece;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.enemies.Enemy;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.entities.models.Power;
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
                CombatServie.healEntity(player,40);
                InterfaceService.cleanTerminal();
                System.out.println(enemy);
                System.out.println(player.toStringWithPowers());
                InterfaceService.timer(1);
                //choose turn:
                if (CombatServie.isPlayerTurn()) {
                    //TODO: Choose option method;
                    InterfaceService.anyQuestion("Escolha seu ataque");
                    CombatServie.hitEntity(enemy,player.getPowers().get(scan.nextInt()));
                } else {
                    List<Integer> enemyPowers = enemy.getPowers().stream().map(Power::getId).toList();
                    int randomPowerIndex = InterfaceService.random(enemyPowers.size());
                    CombatServie.hitEntity(player,enemy.getPowerByIndex(randomPowerIndex));
                }
                InterfaceService.timer(1);
                InterfaceService.cleanTerminal();
                if (enemy.isLive() && player.isLive()) {
                    System.out.println(enemy);
                    System.out.println(player.toStringWithPowers());
                    InterfaceService.timer(2);
                    InterfaceService.cleanTerminal();
                    InterfaceService.tellerSays("Próximo turno");
                    InterfaceService.timer(1);
                } else if (player.isLive()) {
                    System.out.println(player);
                    InterfaceService.tellerSays("O inimigo foi derrotado");
                    InterfaceService.timer(2);
                    InterfaceService.cleanTerminal();
                    enemy = DungeonNavigator.getNextEnemy();
                } else {
                    InterfaceService.cleanTerminal();
                    InterfaceService.tellerSays("|~~~~~~~~~ você morreu T-T ~~~~~~~~|");
                    InterfaceService.timer(2);
                }
            }
            //TODO: fix player death
            //TODO: clear scan before read input user.
        }
        if (player.isLive()) {
            System.out.println(TextDecorations.BG_RED +  " PARABÉNS, VOCÊ SOBREVIVEU ATÉ O FINAL DA DG" + TextDecorations.RESET);
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
