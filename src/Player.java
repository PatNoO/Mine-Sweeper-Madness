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
        System.out.println(this.name + " | " + this.difficulty + " | " + this.time + " sec");
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
