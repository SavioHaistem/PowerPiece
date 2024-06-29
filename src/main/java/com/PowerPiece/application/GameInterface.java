package com.PowerPiece.application;
import com.PowerPiece.entities.Player;
import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.services.CacheService;

import java.util.Scanner;

public class GameInterface {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Player player = new Player();
        System.out.println(TextDecorations.BG_PURPLE + "|| POWER PIECE 1.0 ||" + TextDecorations.RESET);
        System.out.println(TextDecorations.RESET);
        System.out.print(TextDecorations.PURPLE + "Choose your player name: ");
        player.setName(scan.nextLine());
        System.out.println(TextDecorations.RESET);

        System.out.println(TextDecorations.GREEN + "Hi " + player.getName() + TextDecorations.RESET);
        System.out.println(TextDecorations.RESET);
    }
}
