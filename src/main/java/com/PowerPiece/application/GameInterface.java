package com.PowerPiece.application;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.services.CacheService;
import com.PowerPiece.services.InterfaceService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameInterface {
    public static void main(String[] args) {
        int[] randoms = InterfaceService.randomizeManyTimes(3,10);
        Scanner scan = new Scanner(System.in);
        Player player = new Player();

        InterfaceService.title("Power Piece 1.0");
        InterfaceService.anyQuestion("Choose your nick name: ");
        player.setName(scan.nextLine());
        InterfaceService.anyQuestion("Choose one AkumaNoMI: ");
        List<AkumaNoMi> randomAkumaNoMis = Arrays.stream(randoms).mapToObj(
                operand -> CacheService.getAkumanomis().get(operand)).toList();
        randomAkumaNoMis.forEach(InterfaceService::showOption);
    }
}
