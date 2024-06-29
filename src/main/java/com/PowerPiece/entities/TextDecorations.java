package com.PowerPiece.entities;

import java.security.PublicKey;

public class TextDecorations {
    // Códigos ANSI para cores
    public static final String RESET = "\033[0m";  // Reset
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Códigos ANSI para estilo
    public static final String BOLD = "\033[1m";   // Bold
    public static final String UNDERLINE = "\033[4m"; // Underline

    public static final String BG_BLACK = "\033[40m";  // Black background
    public static final String BG_RED = "\033[41m";    // Red background
    public static final String BG_GREEN = "\033[42m";  // Green background
    public static final String BG_YELLOW = "\033[43m"; // Yellow background
    public static final String BG_BLUE = "\033[44m";   // Blue background
    public static final String BG_PURPLE = "\033[45m"; // Purple background
    public static final String BG_CYAN = "\033[46m";   // Cyan background
    public static final String BG_WHITE = "\033[47m";  // White background
}
