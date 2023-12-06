package application;

import entities.AkumaNoMi;
import enums.akumanomis.AkumaRarity;
import enums.akumanomis.AkumaType;

import java.util.Scanner;

public class AkumaFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("\n\nCreate your Akuma no mi! game\n\n");
        System.out.print("Type Akuma name: ");
        String name = scan.nextLine();
        System.out.print("Choose Akuma no mi type (ZOAN,PARAMECIA,LOGIA): ");
        AkumaType akumaType = AkumaType.valueOf(scan.nextLine().toUpperCase());
        System.out.print("Choose your Akuma no mi Rarity (MYSTIC,RARE,COMMON): ");
        AkumaRarity akumaRarity = AkumaRarity.valueOf(scan.nextLine().toUpperCase());

        System.out.print("Set your Akuma no mi description: ");
        String description = scan.nextLine();

        AkumaNoMi yourAkuma = new AkumaNoMi(akumaType,akumaRarity,description,name);
        System.out.println("Your Akuma no mi: ");
        System.out.println(yourAkuma);
    }
}