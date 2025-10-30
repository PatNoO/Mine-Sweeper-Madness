/// Represents a player in the game, including their name, difficulty level, and total time.

public class Player {

    /// The player's name.
    private String name;
    /// The difficulty level chosen by the player (e.g., EASY, MEDIUM, HARD).
    private String difficulty;
    /// The player's total time.
    private int time;

    /**
     * Constructs a new Player with a given name and difficulty.
     * The time is initialized to 0.
     *
     * @param name       the name of the player
     * @param difficulty the difficulty level of the player
     */
    public Player(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.time = 0;
    }

    /**
     * Constructs a new Player with a given name, difficulty, and time.
     *
     * @param name       the name of the player
     * @param difficulty the difficulty level of the player
     * @param time       the total time
     */
    public Player(String name, String difficulty, int time) {
        this.name = name;
        this.difficulty = difficulty;
        this.time = time;
    }

    /**
     * Prints the player's name and time formatted as HH:MM:SS.
     * The name is left-aligned to 17 characters.
     */
    public void printScore() {

        System.out.printf("%s%s%-17s%02d:%02d:%02d\n", " ", Color.BRIGHT_WHITE, this.name, this.time/3600, (this.time%3600)/60, this.time%60);
    }

    /**
     * Prints the player's difficulty with color formatting depending on the difficulty level.
     * (Uses the Color class for colored text output in the console.)
     */
    public void printDifficulty() {
        switch (this.difficulty) {
            case "EASY" -> System.out.println(" " + Color.BOLD + Color.BRIGHT_WHITE + TextOutput.DIFFICULTY + " " + Color.BRIGHT_GREEN + this.difficulty + Color.RESET);
            case "MEDIUM" -> System.out.println(" " + Color.BOLD + Color.BRIGHT_WHITE + TextOutput.DIFFICULTY + " " + Color.BRIGHT_BLUE + this.difficulty + Color.RESET);
            case "HARD" -> System.out.println(" " + Color.BOLD + Color.BRIGHT_WHITE + TextOutput.DIFFICULTY + " " + Color.BRIGHT_RED + this.difficulty + Color.RESET);
        }
    }

    /// @return the player's name
    public String getName() {
        return name;
    }

    /// @param name sets the player's name
    public void setName(String name) {
        this.name = name;
    }

    /// @return the difficulty level
    public String getDifficulty() {
        return difficulty;
    }

    /// @param difficulty sets the difficulty level
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /// @return the player's total time in seconds
    public int getTime() {
        return time;
    }

    /// @param time sets the player's total time
    public void setTime(int time) {
        this.time = time;
    }
}
