package com.PowerPiece;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.dungeos.Dungeon;
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
        player.setAkumaNoMi(InterfaceService.chooseOneOption("Escolha sua AkumaNoMi: ",randomAkumaNoMis,scan));

        InterfaceService.cleanTerminal();
        InterfaceService.loadText("load player");
        InterfaceService.timer(1);
        InterfaceService.cleanTerminal();

        List<Dungeon> dungeons = CacheService.getDungeons().values().stream().toList();
        DungeonNavigator.comeInDungeon(player,InterfaceService.chooseOneOption("Escolha uma dungeon: ",dungeons,scan));
        Enemy enemy = DungeonNavigator.getNextEnemy();

        while (enemy != null && player.isLive()) {
            InterfaceService.loadText("carregando inimigo");
            InterfaceService.timer(1);
            InterfaceService.cleanTerminal();
            CombatServie.healEntity(player,40);
            while(enemy.isLive() && player.isLive()) {
                InterfaceService.cleanTerminal();
                System.out.println(enemy);
                System.out.println(player.toStringWithPowers());
                InterfaceService.timer(1);
                //choose turn:
                if (CombatServie.isPlayerTurn()) {
                    CombatServie.hitEntity(enemy,InterfaceService.chooseOneOption("Escolha seu ataque: ", player.getPowers(), scan));
                } else {
                    CombatServie.hitEntity(player,InterfaceService.chooseOneOption(enemy.getPowers()));
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
        scan.close();
        InterfaceService.tellerSays("closing PowerPiece... BYE!");
        InterfaceService.timer(1);
    }
}
