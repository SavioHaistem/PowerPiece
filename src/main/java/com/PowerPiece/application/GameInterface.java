package com.PowerPiece.application;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.entities.models.LifeBar;
import com.PowerPiece.services.CacheService;
import com.PowerPiece.services.InterfaceService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameInterface {
    public static void main(String[] args) {
        int[] randoms = InterfaceService.randomizeManyTimes(3,10);
        Scanner scan = new Scanner(System.in);
        Player player = new Player();

        InterfaceService.title("Power Piece 1.0");
        InterfaceService.anyQuestion("Choose your nick name: ");
        player.setEntityId(1);
        player.setLifeBar(new LifeBar(100));
        player.setName(scan.nextLine());

        System.out.println(" ");
        List<AkumaNoMi> randomAkumaNoMis = Arrays.stream(randoms).mapToObj(CacheService.getAkumanomis()::get).toList();
        randomAkumaNoMis.forEach(InterfaceService::showOption);
        System.out.println(" ");
        InterfaceService.anyQuestion("Choose your AkumaNoMI: ");
        scan.nextLine();
        player.setPowers(CacheService.getAkumanomis().get(scan.nextInt()).getPowers());

        System.out.println(player);
    }
}
