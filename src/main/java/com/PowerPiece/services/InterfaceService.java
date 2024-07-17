package com.PowerPiece.services;

import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.interfaces.Optionable;

import java.io.IOException;
import java.util.*;

public final class InterfaceService {
    public static void timer(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void title(String title) {
        System.out.println(" ");
        System.out.println(TextDecorations.BG_PURPLE + title);
        System.out.println(TextDecorations.RESET);
    }
    public static void anyQuestion(String question) {
        System.out.println(TextDecorations.PURPLE + "| " + question);
        System.out.print("> " + TextDecorations.RESET);
    }
    public static <T extends Optionable> void showOption(T optionObject) {
        String option = TextDecorations.YELLOW +
                optionObject.getOption() +
                TextDecorations.RESET;
        System.out.println(option);
    }
    public static int[] randomizeManyTimes(int manyRandoms, int range) {
        Set<Integer> randoms = new HashSet<>(range);
        Random randomGenerator = new Random();
        while (randoms.size() < manyRandoms) {
            int randomInt = randomGenerator.nextInt(range);
            randoms.add(randomInt > 0 ? randomInt : 10);
        }
        return randoms.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void cleanTerminal() {
        System.out.print("\033\143");
    }
    public static void loadText(String text) {
        System.out.println(TextDecorations.GREEN + text + " ..." + TextDecorations.RESET);
    }
    public static void tellerSays(String text) {
        System.out.println(TextDecorations.BOLD + text.toUpperCase() + TextDecorations.RESET);
    }
}
