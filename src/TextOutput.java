public class TextOutput {

    private TextOutput() {

    }
    public static final String WELCOME_TEXT = "WELCOME TO MINESWEEPER MADNESS!";
    public static final String LETS_PLAY = "Let's Play ! 🎮 ";
    public static final String PLAYER_NAME = "Please enter your name";
    public static final String THANKS_FOR_PLAYING = "Thanks for playing!";
    public static final String HIGHSCORE_COLUMNS = Color.BOLD +
                                                    Color.BRIGHT_RED + "H" +
                                                    Color.BRIGHT_ORANGE + "I" +
                                                    Color.BRIGHT_YELLOW +"G" +
                                                    Color.BRIGHT_GREEN + "H" +
                                                    Color.BRIGHT_CYAN + "S" +
                                                    Color.BRIGHT_BLUE + "C" +
                                                    Color.DARK_PURPLE + "O" +
                                                    Color.BRIGHT_PURPLE + "R" +
                                                    Color.VIOLET + "E"+
                                                    Color.BRIGHT_WHITE + ":" + Color.RESET;
    public static final String EXIT_GAME = Color.CHARCOAL_GRAY + Color.ITALIC + "Quit game? Enter: " + Color.RESET +
                                                    Color.DARK_RED + "\"EXIT\"" + Color.RESET;


    public static final String EASY_GREEN = Color.BOLD + Color.GREEN + "EASY" + Color.RESET;
    public static final String MEDIUM_BLUE = Color.BOLD + Color.BLUE + "MEDIUM" + Color.RESET;
    public static final String HARD_RED = Color.BOLD + Color.BRIGHT_RED + "HARD" + Color.RESET;

    public static final String MENU = "MENU";
    public static final String PLAYER = "Player:";
    public static final String DIFFICULTY = "Difficulty:";

    public static final String RED_X = Color.BOLD + Color.BRIGHT_RED_BG + Color.BLACK + "  X  " + Color.RESET;
    public static final String ORANGE_X = Color.BOLD + Color.ORANGE_BG + Color.BLACK + "  X  " + Color.RESET;
    public static final String ORANGE_F = Color.BOLD + Color.ORANGE_BG + Color.BLACK + "  F  " + Color.RESET;


    //-------------------------------//

    public static final String ERROR_PLAYER_INPUT_NAME = Color.BRIGHT_ORANGE + "Your name must be between 2-15 letters and can only contain\n" +
                                                            "letters (A-Ö), numbers (0-9), hyphen (-) or single quote (')" + Color.RESET;
    public static final String ERROR_PLAYER_INVALID_INPUT = Color.BRIGHT_ORANGE + "Invalid input" + Color.RESET;
    public static final String ERROR_PLAYER_INT_INPUT = Color.BRIGHT_ORANGE + "Choose a number between :" + Color.RESET;
    public static final String ERROR_HIGHSCORE_NO_DATA = Color.BRIGHT_ORANGE + "No players in Highscore yet" + Color.RESET;
    public static final String ERROR_PLAYER_TRY_AGAIN = "Try again !";
    public static final String ERROR_PLAYER_INVALID_COORDINATE = "Invalid coordinate! ";
    public static final String ERROR_PLAYER_INPUT_FORMAT = "Try a coordinate e.g., 'A1' : ";
    public static final String ERROR_CELL_ALREADY_OPENED = "That cell is already open — choose another!";

    //-------------------------------//
    public static final String PLAYER_MAKE_MOVE_INFO = """
                                                        Enter the coordinate you want to open or
                                                        add 'F', at the end to place a flag
                                                        at that cell. (E.g., "A1" or "A1F")""";
    public static final String PLAYER_MAKE_MOVE_INFO_2 = "Enter coordinate: ";
    public static final String PLAYER_STEPS_ON_SAFE_CELL = "Phew... Safe for now!";
    public static final String PLAYER_WIN = "🥳 You win !! The minefield is cleared! ";
    public static final String PLAYER_RETURN = "Press ENTER) Return to MENU";
    public static final String PLAYER_RETRY = Color.BOLD + Color.BRIGHT_WHITE +
                                                "Would you like to try again?\n" + Color. RESET +
                                                "Press ENTER) YES\n" +
                                                "Press ANY KEY) Return to MENU";

    //-------------------------------//
    /// Prints home menu with the players selections

    public static void homeMenuOutput(Player player) {
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + " " + MENU + " ");
        System.out.println(" " + PLAYER + " " + Color.VIOLET + player.getName() + Color.RESET);
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
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE +   " Make your choice: " + Color.RESET);
    }

    /// Prints menu for difficulty choices

    public static void difficultyMenuOutput(Player player) {

        System.out.println();
        System.out.println(
                Color.BOLD + Color.BRIGHT_WHITE + " Press 1) for : " + Color.GREEN + "EASY  \n" + Color.RESET +
                Color.BOLD + Color.BRIGHT_WHITE + " Press 2) for : " + Color.BLUE + "MEDIUM  \n" + Color.RESET +
                Color.BOLD + Color.BRIGHT_WHITE + " Press 3) for : " + Color.BRIGHT_RED + "HARD  \n" + Color.RESET );
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE +
                " " + player.getName() + ", choose difficulty: " + Color.RESET);
    }

    /// Prints the start text on the first round

    public static void gameInfoOutput() {
        System.out.println(EXIT_GAME);
        System.out.println(Color.LIGHT_GRAY + PLAYER_MAKE_MOVE_INFO + Color.RESET);
        System.out.println();
        System.out.println(Color.BRIGHT_WHITE + PLAYER_MAKE_MOVE_INFO_2 + Color.RESET);
    }

    /// Prints the number of mines above the board in game

    public static void numberOfMinesLeftText(int numberOfMines) {
        System.out.println(Color.BOLD + Color.BRIGHT_RED + numberOfMines + Color.BRIGHT_WHITE + " mines left" + Color.RESET);
    }

    ///  Prints the Welcome-"sign"

    public static void welcomeText() {
        System.out.println();
        String coloredLine = Color.WHITE_BG + " " + (Color.BOLD + Color.BLUE + Color.BLINK + "*" + Color.BRIGHT_RED + "*").repeat(18) + Color.BLUE + "* " + Color.RESET;

        System.out.println(coloredLine);
        System.out.println(Color.WHITE_BG + " " + Color.BOLD + Color.BRIGHT_RED + Color.BLINK + "*  " +
                            Color.RESET + Color.WHITE_BG + Color.BLACK + Color.BOLD + WELCOME_TEXT +
                            Color.BRIGHT_RED +  Color.BLINK + "  * " + Color.RESET);
        System.out.println(coloredLine);
    }
    public static void enterNameText() {
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + " PLEASE ENTER YOUR NAME:");
    }
    ///  Prints the Game over-"sign"

    public static void gameOverOutput() {
        System.out.println();
        System.out.println((Color.BOLD + Color.BRIGHT_ORANGE + Color.BLINK + "*" + Color.RED + "*").repeat(12) + Color.BRIGHT_ORANGE + "*");
        System.out.println(Color.BOLD + Color.BRIGHT_RED + Color.BLINK + "*    " + Color.RESET + Color.BRIGHT_ORANGE + Color.BOLD + "YOU HIT A MINE!" + Color.RESET + Color.BRIGHT_RED + Color.BLINK + Color.BOLD + "    *");
        System.out.println(Color.BOLD + Color.BRIGHT_ORANGE + Color.BLINK + "*      " + Color.RESET + Color.BRIGHT_RED + Color.BOLD + "GAME OVER!!" + Color.RESET + Color.BRIGHT_ORANGE + Color.BLINK + Color.BOLD + "      *");
        System.out.println((Color.BOLD + Color.BRIGHT_RED + Color.BLINK + "*" + Color.BRIGHT_ORANGE + "*").repeat(12) + Color.BRIGHT_RED + "*" + Color.RESET);
        System.out.println();
    }

    ///  Prints the Game win-"sign"

    public static void gameWinOutput() {
        System.out.println();
        System.out.println((Color.BOLD + Color.BRIGHT_CYAN + Color.BLINK + "*" + Color.BRIGHT_GREEN + "*").repeat(12) + Color.BRIGHT_CYAN + "*");
        System.out.println(Color.BOLD + Color.BRIGHT_GREEN + Color.BLINK + "*  " + Color.RESET + Color.BRIGHT_CYAN + Color.BOLD + "ALL MINES CLEARED!!" + Color.BRIGHT_GREEN + Color.BLINK + Color.BOLD + "  *");
        System.out.println(Color.BOLD + Color.BRIGHT_CYAN + Color.BLINK + "*   " + Color.RESET + Color.BRIGHT_GREEN + Color.BOLD + "CONGRATULATIONS!!" + Color.BRIGHT_CYAN + Color.BLINK + Color.BOLD + "   *");
        System.out.println((Color.BOLD + Color.BRIGHT_GREEN + Color.BLINK + "*" + Color.BRIGHT_CYAN + "*").repeat(12) + Color.BRIGHT_GREEN + "*" + Color.RESET);
        System.out.println();
    }

    ///  Prints the Goodbye-"sign"

    public static void thanksForPlayingOutput() {
        System.out.println();
        System.out.println((Color.BOLD + Color.BRIGHT_YELLOW + Color.BLINK + "*" + Color.BRIGHT_CYAN + "*").repeat(12) + Color.BRIGHT_YELLOW + "*");
        System.out.println(Color.BOLD + Color.BRIGHT_CYAN + Color.BLINK + "*  " + Color.RESET + Color.BRIGHT_YELLOW + Color.BOLD + "THANKS FOR PLAYING!" + Color.RESET + Color.BRIGHT_CYAN + Color.BLINK + Color.BOLD + "  *");
        System.out.println(Color.BOLD + Color.BRIGHT_YELLOW + Color.BLINK + "*     " + Color.RESET + Color.BRIGHT_CYAN + Color.BOLD + "SEE YOU SOON!" + Color.RESET + Color.BRIGHT_YELLOW + Color.BLINK + Color.BOLD + "     *");
        System.out.println((Color.BOLD + Color.BRIGHT_CYAN + Color.BLINK + "*" + Color.BRIGHT_YELLOW + "*").repeat(12) + Color.BRIGHT_CYAN + "*" + Color.RESET);
        System.out.println();
    }

    //------------------------------------//
    /// Prints the help information

    public static void showHelpOutput() {
        Game.clearScreen();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + """
                
                📜 HOW TO PLAY MINESWEEPER 📜
                ----------------------------------
                
                🧩 GOAL:
                Find and clear all SAFE cells on the board.
                Avoid hidden mines 💣 or the game will end!
                
                🕹 CONTROLS:
                - Enter coordinates to open a cell.
                  Example: A1, B3,..
                
                ⛳️ FLAG:
                - Add 'F', at the end of the coordinate to place a ⛳️(blue background) at that cell.
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
                -------------------------
                Input:  "A1"
                Output: Shows number of nearby mines
                or 💣 if you hit one.
                
                Input:  "A1F"
                Output: Sets the cell as a ⛳️ (blue background)
                -------------------------
                """ + Color.RESET);
        System.out.println("Press ENTER) Return to MENU");

        InputHandler.getString();
        Game.clearScreen();
    }
}