public class TextOutput {

    private TextOutput() {

    }

    public static final String ERROR_PLAYER_INPUT_NAME = "Your name can only contain letters (A-Ö), hyphen (-) or single quote (')";
    public static final String ERROR_PLAYER_INVALID_INPUT = "Invalid input";
    public static final String ERROR_PLAYER_TRY_AGAIN = "Try again !";
    public static final String ERROR_PLAYER_INPUT_FORMAT = "Try a coordinate e.g., 'A1' : ";
    public static final String ERROR_PLAYER_INT_INPUT = "Choose a number between : ";

    //-------------------------------//

    public static final String PLAYER_MAKE_MOVE_INFO = "Enter a coordinate e.g., 'A1':";
    public static final String PLAYER_STEPPS_ON_MINE = "💣 Boom..! You hit a mine. " ;
    public static final String PLAYER_GAME_OVER = "☠️ Game Over ! ";
    public static final String PLAYER_STEPPS_ON_SAFE_CELL = "Phew... Safe for now!";
    public static final String PLAYER_WIN = "🥳 You win !! The minefield is cleared! ";

    public static final String BOARD_TITEL = Color.BOLD+"""
                            
                            SWEEP FOR MINES, BUT DO NOT HIT ONE!
                            """ + Color.RESET;
}
// public static