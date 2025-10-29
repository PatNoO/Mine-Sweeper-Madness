public class Player {

    private String name;
    private String difficulty;
    private int time;

    public Player(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.time = 0;
    }

    public Player(String name, String difficulty, int time) {
        this.name = name;
        this.difficulty = difficulty;
        this.time = time;
    }

    public void printScore() {
        System.out.printf("%s%s%-17s%02d:%02d:%02d\n", " ", Color.BRIGHT_WHITE, this.name, this.time/3600, (this.time%3600)/60, this.time%60);
    }

    public void printDifficulty() {
        switch (this.difficulty) {
            case "EASY" -> System.out.println(" " + Color.BOLD + Color.BRIGHT_WHITE + TextOutput.DIFFICULTY + " " + Color.BRIGHT_GREEN + this.difficulty + Color.RESET);
            case "MEDIUM" -> System.out.println(" " + Color.BOLD + Color.BRIGHT_WHITE + TextOutput.DIFFICULTY + " " + Color.BRIGHT_BLUE + this.difficulty + Color.RESET);
            case "HARD" -> System.out.println(" " + Color.BOLD + Color.BRIGHT_WHITE + TextOutput.DIFFICULTY + " " + Color.BRIGHT_RED + this.difficulty + Color.RESET);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
