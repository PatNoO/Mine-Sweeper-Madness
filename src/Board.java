import java.util.*;

public class Board {
    Cell[][] grid;

    Board(int width, int height, int numberOfMines) {

        grid = new Cell[height][width];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Cell cell = new Cell(false, true, 0);
                grid[row][col] = cell;
            }
        }

        Random random = new Random();
        int i = 0;
        while (i < numberOfMines) {
            int col = random.nextInt(width); // Generate a random number between 0 and 99
            int row = random.nextInt(height);
            if (!grid[row][col].hasMine()) {
                grid[row][col].hasMine(true);
                i++;
            }
        }
    }
}
