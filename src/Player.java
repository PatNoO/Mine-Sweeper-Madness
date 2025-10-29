import java.util.Calendar;
import java.util.Date;

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
        System.out.printf("%-20s%02d:%02d:%02d\n", this.name, this.time/3600, this.time/60%60, this.time%60);
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
