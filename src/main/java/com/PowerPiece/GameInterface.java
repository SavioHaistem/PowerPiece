package com.PowerPiece;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.services.CacheService;
import com.PowerPiece.services.InterfaceService;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

        //Choose one random AKumaNoMi:
        List<AkumaNoMi> randomAkumaNoMis = Arrays.stream(randoms).mapToObj(CacheService.getAkumanomis()::get).toList();
        randomAkumaNoMis.forEach(InterfaceService::showOption);
        System.out.println(" ");
        InterfaceService.anyQuestion("Choose your AkumaNoMI: ");
        player.setPowers(CacheService.getAkumanomis().get(scan.nextInt()).getPowers());
        player.takeDamage(10);
        InterfaceService.cleanTerminal();
        System.out.println(player);


    }
}
