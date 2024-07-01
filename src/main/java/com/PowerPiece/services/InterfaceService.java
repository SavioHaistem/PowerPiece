package com.PowerPiece.services;

import com.PowerPiece.entities.TextDecorations;

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
}
