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

    public void print() {
        switch (difficulty) {
            case "EASY" -> System.out.println(" " + this.name + " | " + Color.GREEN + this.difficulty + Color.RESET + " | " + this.time + " sec" );
            case "MEDIUM" -> System.out.println(" " + this.name + " | " + Color.BLUE + this.difficulty + Color.RESET + " | " + this.time + " sec" + Color.RESET);
            case "HARD" -> System.out.println(" " + this.name + " | " + Color.BRIGHT_RED + this.difficulty + Color.RESET + " | " + this.time + " sec" + Color.RESET);
        }
    }
    public void printScore() {
        System.out.println(" " + this.name  + " | " + this.time + " sec");
    }
    public void printDifficulty() {
        switch (difficulty) {
            case "EASY" -> System.out.println(" Difficulty: " + Color.GREEN + this.difficulty + Color.RESET);
            case "MEDIUM" -> System.out.println(" Difficulty: " + Color.BLUE + this.difficulty);
            case "HARD" -> System.out.println(" Difficulty: " + Color.BRIGHT_RED + this.difficulty);
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
