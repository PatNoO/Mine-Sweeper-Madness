/// Utility class containing all game-related text outputs and messages
public class TextOutput {

    // Private constructor to prevent instantiation of this utility class
    private TextOutput() {

    }

    // ----------------- Static Text Constants ----------------- //

    public static final String WELCOME_TEXT = "WELCOME TO MINESWEEPER MADNESS!";
    public static final String PLAYER_NAME = "\n" +
                                                " " + Color.BOLD + Color.WHITE_BG + Color.BLACK + " PLEASE ENTER YOUR NAME: " + Color.RESET;

    public static final String EASY_GREEN = Color.BOLD + Color.BRIGHT_GREEN + "EASY" + Color.RESET;
    public static final String MEDIUM_BLUE = Color.BOLD + Color.BRIGHT_BLUE + "MEDIUM" + Color.RESET;
    public static final String HARD_RED = Color.BOLD + Color.BRIGHT_RED + "HARD" + Color.RESET;

    public static final String PLAYER = "Player:";
    public static final String DIFFICULTY = "Difficulty:";

    public static final String RED_X = Color.BOLD + Color.BRIGHT_RED_BG + Color.BLACK + "  X  " + Color.RESET;
    public static final String ORANGE_X = Color.BOLD + Color.ORANGE_BG + Color.BLACK + "  X  " + Color.RESET;
    public static final String ORANGE_F = Color.BOLD + Color.ORANGE_BG + Color.BLACK + "  F  " + Color.RESET;

    public static final String HIGHSCORE = Color.BOLD + "         " +
                                            Color.BRIGHT_RED + "H" +
                                            Color.BRIGHT_ORANGE + "I" +
                                            Color.BRIGHT_YELLOW +"G" +
                                            Color.BRIGHT_GREEN + "H" +
                                            Color.BRIGHT_CYAN + "S" +
                                            Color.BRIGHT_BLUE + "C" +
                                            Color.DARK_PURPLE + "O" +
                                            Color.BRIGHT_PURPLE + "R" +
                                            Color.BRIGHT_PINK + "E" + Color.RESET;

    // ----------------- Error Messages ----------------- //

    public static final String ERROR_PLAYER_INPUT_NAME = Color.BRIGHT_ORANGE + "Your name must be between 2-15 letters and can only contain\n" +
                                                            "letters (A-Ö), numbers (0-9), hyphen (-) or single quote (')" + Color.RESET;
    public static final String ERROR_PLAYER_INVALID_INPUT = Color.BRIGHT_ORANGE + "Invalid input" + Color.RESET;
    public static final String ERROR_PLAYER_INT_INPUT = Color.BRIGHT_ORANGE + "Choose a number between :" + Color.RESET;
    public static final String ERROR_HIGHSCORE_NO_DATA = Color.BRIGHT_ORANGE + "No players in Highscore yet" + Color.RESET;


    // ----------------- Player Instructions ----------------- //
    public static final String PLAYER_EXIT_GAME = Color.CHARCOAL_GRAY + Color.ITALIC + " Quit game? Enter: " + Color.RESET +
                                                    Color.DARK_RED + "\"EXIT\"" + Color.RESET;
    public static final String PLAYER_MAKE_MOVE_INFO = """
             Enter the coordinate you want to open or
             add 'F', at the end to place a flag
             at that cell. (E.g., "A1" or "A1F")\
            """;
    public static final String PLAYER_MAKE_MOVE_INPUT = " Enter coordinate: ";
    public static final String PLAYER_RETURN = "Press ENTER) ⏎ MENU";
    public static final String PLAYER_RETRY = " " + Color.BOLD + Color.WHITE_BG + Color.BLACK +
                                                " Would you like to play again? " + Color.RESET + "\n" +
                                                "  Press ENTER) YES\n" +
                                                "  Press ANY KEY) ⏎ MENU";


    // ----------------- Menu Outputs ----------------- //

    /// Prints home menu with the players selections
    public static void homeMenuOutput(Player player) {
        System.out.println();
        System.out.println(" " + Color.BOLD + Color.WHITE_BG + Color.BLACK + " MENU " + Color.RESET);
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + " " + PLAYER + " " + Color.HOT_PINK + player.getName() + Color.RESET);
        player.printDifficulty();
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE +
                " Press 1) Play game   \n" +
                " Press 2) Change difficulty \n" +
                " Press 3) Change player name \n" +
                " Press 4) Highscore \n" +
                " Press 5) Help \n" +
                " Press 6) Quit game          " + Color.RESET);
        System.out.println();
        System.out.println(" " + Color.BOLD + Color.WHITE_BG + Color.BLACK + " Enter your choice: " + Color.RESET);
    }

    /// Prints menu for difficulty choices

    public static void difficultyMenuOutput() {
        System.out.println();
        System.out.println(" " + Color.BOLD + Color.WHITE_BG + Color.BLACK + " DIFFICULTY " + Color.RESET);
        System.out.println();
        System.out.println(
                Color.BOLD + Color.BRIGHT_WHITE + " Press 1) " + Color.BRIGHT_GREEN + "EASY  \n" + Color.RESET +
                Color.BOLD + Color.BRIGHT_WHITE + " Press 2) " + Color.BRIGHT_BLUE + "MEDIUM  \n" + Color.RESET +
                Color.BOLD + Color.BRIGHT_WHITE + " Press 3) " + Color.BRIGHT_RED + "HARD  \n" + Color.RESET );
        System.out.println(" " + Color.BOLD + Color.WHITE_BG + Color.BLACK + " Enter your choice: " + Color.RESET);
    }

    /// Prints the start text on the first round
    public static void gameInfoOutput() {
        System.out.println(PLAYER_EXIT_GAME);
        System.out.println(Color.LIGHT_GRAY + PLAYER_MAKE_MOVE_INFO + Color.RESET);
        System.out.println();
        System.out.println(" " + Color.BOLD + Color.WHITE_BG + Color.BLACK + PLAYER_MAKE_MOVE_INPUT + Color.RESET);
    }

    /// Prints the number of mines above the board in game
    public static void numberOfMinesLeftText(int numberOfMines) {
        System.out.println(" " + Color.BOLD + Color.BRIGHT_RED + numberOfMines + Color.BRIGHT_WHITE + " mines left" + Color.RESET);
    }

    ///  Prints the Welcome-"sign"
    public static void welcomeText() {
        System.out.println();
        String coloredLine = " " + Color.WHITE_BG + " " + (Color.BOLD + Color.BLUE + Color.BLINK + "*" + Color.BRIGHT_RED + "*").repeat(18) + Color.BLUE + "* " + Color.RESET;

        System.out.println(coloredLine);
        System.out.println(" " + Color.WHITE_BG + " " + Color.BOLD + Color.BRIGHT_RED + Color.BLINK + "*  " +
                            Color.RESET + Color.WHITE_BG + Color.BLACK + Color.BOLD + WELCOME_TEXT +
                            Color.BRIGHT_RED +  Color.BLINK + "  * " + Color.RESET);
        System.out.println(coloredLine);
    }

    ///  Prints the Game over-"sign"
    public static void gameOverOutput() {
        System.out.println();
        System.out.println(" " + (Color.BOLD + Color.BRIGHT_ORANGE + Color.BLINK + "*" + Color.RED + "*").repeat(12) + Color.BRIGHT_ORANGE + "*");
        System.out.println(" " + Color.BOLD + Color.BRIGHT_RED + Color.BLINK + "*    " + Color.RESET + Color.BRIGHT_ORANGE + Color.BOLD + "YOU HIT A MINE!" + Color.RESET + Color.BRIGHT_RED + Color.BLINK + Color.BOLD + "    *");
        System.out.println(" " + Color.BOLD + Color.BRIGHT_ORANGE + Color.BLINK + "*      " + Color.RESET + Color.BRIGHT_RED + Color.BOLD + "GAME OVER!!" + Color.RESET + Color.BRIGHT_ORANGE + Color.BLINK + Color.BOLD + "      *");
        System.out.println(" " + (Color.BOLD + Color.BRIGHT_RED + Color.BLINK + "*" + Color.BRIGHT_ORANGE + "*").repeat(12) + Color.BRIGHT_RED + "*" + Color.RESET);
        System.out.println();
    }

    ///  Prints the Game win-"sign"
    public static void gameWinOutput() {
        System.out.println();
        System.out.println(" " + (Color.BOLD + Color.BRIGHT_CYAN + Color.BLINK + "*" + Color.BRIGHT_GREEN + "*").repeat(12) + Color.BRIGHT_CYAN + "*");
        System.out.println(" " + Color.BOLD + Color.BRIGHT_GREEN + Color.BLINK + "*  " + Color.RESET + Color.BRIGHT_CYAN + Color.BOLD + "ALL MINES CLEARED!!" + Color.BRIGHT_GREEN + Color.BLINK + Color.BOLD + "  *");
        System.out.println(" " + Color.BOLD + Color.BRIGHT_CYAN + Color.BLINK + "*   " + Color.RESET + Color.BRIGHT_GREEN + Color.BOLD + "CONGRATULATIONS!!" + Color.BRIGHT_CYAN + Color.BLINK + Color.BOLD + "   *");
        System.out.println(" " + (Color.BOLD + Color.BRIGHT_GREEN + Color.BLINK + "*" + Color.BRIGHT_CYAN + "*").repeat(12) + Color.BRIGHT_GREEN + "*" + Color.RESET);
        System.out.println();
    }

    /// Prints the time after winning game
    public static void gameWinPrintTime(int elapsedTime) {
        System.out.printf("%s%s%s%s%s%s\n"," " + Color.BLINK, Color.BOLD, Color.GREEN_BG, Color.BRIGHT_WHITE, " YOUR TIME: ", Color.RESET);
        System.out.printf("%s%s%s%s%s%02d:%02d:%02d%s%s\n\n"," " + Color.BLINK, Color.BOLD, Color.GREEN_BG, Color.BRIGHT_WHITE, "  ", elapsedTime / 3600, (elapsedTime % 3600) / 60, elapsedTime % 60, "  ", Color.RESET);
    }

    /// Prints the time after winning game
    public static void gameOverPrintTime(int elapsedTime) {
        System.out.printf("%s%s%s%s%s%s\n"," ", Color.BOLD, Color.BRIGHT_RED_BG, Color.BLACK, " YOUR TIME: ", Color.RESET);
        System.out.printf("%s%s%s%s%s%02d:%02d:%02d%s%s\n\n"," ", Color.BOLD, Color.BRIGHT_RED_BG, Color.BLACK, "  ", elapsedTime / 3600, (elapsedTime % 3600) / 60, elapsedTime % 60, "  ", Color.RESET);
    }

    ///  Prints the Goodbye-"sign"
    public static void thanksForPlayingOutput() {
        System.out.println();
        System.out.println(" " + (Color.BOLD + Color.BRIGHT_YELLOW + Color.BLINK + "*" + Color.BRIGHT_CYAN + "*").repeat(12) + Color.BRIGHT_YELLOW + "*");
        System.out.println(" " + Color.BOLD + Color.BRIGHT_CYAN + Color.BLINK + "*  " + Color.RESET + Color.BRIGHT_YELLOW + Color.BOLD + "THANKS FOR PLAYING!" + Color.RESET + Color.BRIGHT_CYAN + Color.BLINK + Color.BOLD + "  *");
        System.out.println(" " + Color.BOLD + Color.BRIGHT_YELLOW + Color.BLINK + "*     " + Color.RESET + Color.BRIGHT_CYAN + Color.BOLD + "SEE YOU SOON!" + Color.RESET + Color.BRIGHT_YELLOW + Color.BLINK + Color.BOLD + "     *");
        System.out.println(" " + (Color.BOLD + Color.BRIGHT_CYAN + Color.BLINK + "*" + Color.BRIGHT_YELLOW + "*").repeat(12) + Color.BRIGHT_CYAN + "*" + Color.RESET);
        System.out.println();
    }


    // ----------------- Help Instructions ----------------- //

    /// Prints the help information
    public static void showHelpOutput() {
        Game.clearScreen();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + """
                
                 📜 HOW TO PLAY MINESWEEPER 📜
                ------------------------------
                
                🧩 GOAL:
                - Find and clear all SAFE cells on the board.
                  Avoid hidden mines 💣 or the game will end!
                
                🕹 CONTROLS:
                - Enter coordinates to open a cell.
                  Example: A1, B3,..
                
                ⛳️ FLAG:
                - Add 'F', at the end of the coordinate to place a ⛳️ (blue background) at that cell.
                (E.g., "A1" or "A1F")
                
                💡 TIP:
                - The number on an opened cell shows how many mines
                  are hidden around it (in 8 directions).
                
                - Use logic to avoid mines and find safe paths.
                
                - You can play carefully or take risks — up to you!
                
                🏁 WIN CONDITION:
                - You win when all safe cells have been opened!
                
                ☠️ LOSE CONDITION:
                - You lose if you open a cell that has a mine.
                
                 Example round:
                ------------------------------
                Input:
                 "A1"
                Output:
                 Number of nearby mines
                 or 💣 if you hit one.
                
                Input:
                 "A1F"
                Output:
                 Marks the cell as a ⛳️ (blue background)
                ------------------------------
                """ + Color.RESET);
        System.out.println("Press ENTER) ⏎ MENU");

        InputHandler.getString();
        Game.clearScreen();
    }
}