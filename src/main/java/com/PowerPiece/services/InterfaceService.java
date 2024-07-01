package com.PowerPiece.services;

import com.PowerPiece.entities.TextDecorations;
import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.interfaces.Optionable;

import java.util.*;

public final class InterfaceService {
    public static void timer(Integer seconds) {

    }
    public static void title(String title) {
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
        Random random = new Random();
        while (randoms.size() < manyRandoms) {
            randoms.add(random.nextInt(range));
        }
        return randoms.stream().mapToInt(Integer::intValue).toArray();
    }
}
