public class TextOutput {

    private TextOutput() {

    }
    public static final String WELCOME_TEXT = "WELCOME TO MINESWEEPER MADNESS!";
    public static final String LETS_PLAY = "Let's Play ! 🎮 ";
    public static final String PLAYER_NAME = "Please enter your name";
    public static final String THANKS_FOR_PLAYING = "Thanks for playing!";

    //-------------------------------//

    public static final String ERROR_PLAYER_INPUT_NAME = "Your name can only contain letters (A-Ö), hyphen (-) or single quote (')";
    public static final String ERROR_PLAYER_INVALID_INPUT = "Invalid input";
    public static final String ERROR_PLAYER_TRY_AGAIN = "Try again !";
    public static final String ERROR_PLAYER_INVALID_COORDINATE = "Invalid coordinate! ";
    public static final String ERROR_PLAYER_INPUT_FORMAT = "Try a coordinate e.g., 'A1' : ";
    public static final String ERROR_PLAYER_INT_INPUT = "Choose a number between :";
    public static final String ERROR_CELL_ALREADY_OPENED = "That cell is already open — choose another!";

    //-------------------------------//

    public static final String PLAYER_MAKE_MOVE_INFO = "Enter coordinate: ";
    public static final String PLAYER_MAKE_MOVE_INFO_2 = "Type the coordinate you want to open or\nadd 'F', at the end to place a flag\nat that cell. (E.g., \"A1\" or \"A1F\")";
    public static final String PLAYER_SET_FLAG_INFO = "Place a flag at coordinate: ";
    public static final String PLAYER_SET_FLAG_INFO_2 = " (Type \"open\" to switch back to open cells)";
    public static final String PLAYER_STEPS_ON_SAFE_CELL = "Phew... Safe for now!";
    public static final String PLAYER_WIN = "🥳 You win !! The minefield is cleared! ";
    public static final String PLAYER_RETRY = """
                                              Would you like to try again?
                                              Press ENTER) Yes
                                              Press ANY KEY) Menu""";

    //-------------------------------//
    /// Prints home menu with the players selections

    public static void homeMenuOutput(Player player) {
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + Color.BOX + " MENU ");
        System.out.println(" Player: " + player.getName());
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + Color.BOX +
                " Press 1) Play: " + player.getDifficulty() + "   \n" +
                " Press 2) Change difficulty \n" +
                " Press 3) Change player name \n" +
                " Press 4) Help \n" +
                " Press 5) Quit game          " + Color.RESET);
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + Color.BOX + " Make your choice: " + Color.RESET);
    }

    /// Prints menu for difficulty choices

    public static void difficultyMenuOutput(Player player) {

        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + Color.BOX +
                " Press 1) for : EASY  \n" +
                " Press 2) for : MEDIUM \n" +
                " Press 3) for : HARD     " + Color.RESET);
        System.out.println();
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + Color.BOX +
                " " + player.getName() + ", choose difficulty: " + Color.RESET);
    }

    /// Prints the start text on the first round

    public static void gameStartOutput() {
        System.out.println();
        System.out.println(Color.BOLD + Color.BOX + Color.BRIGHT_WHITE +
                " SWEEP FOR MINES, BUT DO NOT HIT ONE! " + Color.RESET);
        System.out.println();
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
        System.out.println(Color.BOLD + Color.BRIGHT_WHITE + "PLEASE ENTER YOUR NAME:");
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
        System.out.println(Color.BOLD + """
                
                📜 HOW TO PLAY MINESWEEPER 📜
                ----------------------------------
                
                🧩 GOAL:
                Find and clear all SAFE cells on the board.
                Avoid hidden mines 💣 or the game will end!
                
                🕹 CONTROLS:
                - Type coordinates to open a cell.
                  Example: A1, B3,..
                
                ⛳️ FLAG:
                - Add 'F', at the end of the coordinate to place a flag at that cell.
                (E.g., "A1" or "A1F")
                
                💡 TIP:
                - The number on a revealed cell shows how many mines
                  are hidden around it (in 8 directions).
                
                - Use logic to avoid mines and find safe paths.
                - You can play carefully or take risks — up to you!
                
                🏁 WIN CONDITION:
                - You win when all safe cells have been revealed!
                
                ☠️ LOSE CONDITION:
                - You lose if you open a cell that has a mine.
                
                Example round:
                -------------------------
                Input:  "A1"
                Output: Shows number of nearby mines
                or 💣 if you hit one.
                
                Input:  "A1F"
                Output: Sets the cell as a ⛳️ (green background)
                -------------------------
                Press 1) Return to HOME MENU""" + Color.RESET);

        int userHelpInput;
        do {
            userHelpInput = InputHandler.getInt(TextOutput.ERROR_PLAYER_INVALID_INPUT);
            if (userHelpInput == 1) {
                Game.clearScreen();
                return;
            } else {
                System.out.println(TextOutput.ERROR_PLAYER_INVALID_INPUT);
            }
        } while (true);
    }
}