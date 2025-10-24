public class TextOutput {

    private TextOutput() {

    }
    public static final String WELCOME_TEXT = "Welcome to Mine Sweeper Madness";
    public static final String LETS_PLAY = "Let's Play ! 🎮 ";
    public static final String PLAYER_NAME = "Please enter your name";
    public static final String THANKS_FOR_PLAYING = "Thanks for playing!";

    //-------------------------------//

    public static final String ERROR_PLAYER_INPUT_NAME = "Your name can only contain letters (A-Ö), hyphen (-) or single quote (')";
    public static final String ERROR_PLAYER_INVALID_INPUT = "Invalid input";
    public static final String ERROR_PLAYER_TRY_AGAIN = "Try again !";
    public static final String ERROR_PLAYER_INVALID_COORDINATE = "Invalid coordinate! ";;
    public static final String ERROR_PLAYER_INPUT_FORMAT = "Try a coordinate e.g., 'A1' : ";
    public static final String ERROR_PLAYER_INT_INPUT = "Choose a number between :";
    public static final String ERROR_CELL_ALREADY_OPENED = "That cell is already open — choose another!";
    //-------------------------------//

    public static final String PLAYER_MAKE_MOVE_INFO = "Enter a coordinate e.g., 'A1':";
    public static final String PLAYER_STEPPS_ON_MINE = "💣 Boom..! You hit a mine. " ;
    public static final String PLAYER_STEPPS_ON_SAFE_CELL = "Phew... Safe for now!";
    public static final String PLAYER_WIN = "🥳 You win !! The minefield is cleared! ";
    public static final String PLAYER_RETRY = "Would you like to try again? (Y/N)";
    public static final String BOARD_TITEL = Color.BOLD+"""
                            
                            SWEEP FOR MINES, BUT DO NOT HIT ONE!
                    
                           """ + Color.RESET;

    public static final String GAME_OVER = "\n" +
            Color.BOLD + Color.RED + "*" + Color.ORANGE + "*".repeat(15) + "\n" +
                    Color.BOLD + Color.ORANGE + "* " + Color.RED + "You hit a mine, GAME OVER! *" + "\n" +
                    Color.BOLD + Color.RED + "*" + Color.ORANGE + "*".repeat(15) + Color.RESET + "\n";


    //------------------------------------//

    public static void showHelp() {
        System.out.println(Color.BOLD+ """
                
                📜 HOW TO PLAY MINESWEEPER 📜
                ----------------------------------
                
                🧩 GOAL:
                Find and clear all SAFE cells on the board.
                Avoid hidden mines 💣 or the game will end!
                
                🕹 CONTROLS:
                - Type coordinates to open a cell.
                  Example: A1, B3,..
                
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
                Input:  A1
                Output: Shows number of nearby mines or 💣 if you hit one.
                
                -------------------------
                Press 1 to return to the game.
                """ + Color.RESET);
        int userHelpInput ;
        do {
            userHelpInput = InputHandler.getInt(TextOutput.ERROR_PLAYER_INVALID_INPUT);
            if (userHelpInput == 1) {
                return;
            } else {
                System.out.println(TextOutput.ERROR_PLAYER_INVALID_INPUT);
            }
        } while (true);

    }
}
// public static