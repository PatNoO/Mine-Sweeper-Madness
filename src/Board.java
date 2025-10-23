import java.util.*;

public class Board {
    Cell[][] grid;

    Board(int width, int height, int numberOfMines) {
        createCells(width, height);
        createMines(width, height, numberOfMines);
        createNearby(width, height);
    }

    private void createCells(int width, int height) {
        grid = new Cell[height][width];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Cell cell = new Cell(false, true, 0);
                grid[row][col] = cell;
            }
        }
    }

    private void createMines(int width, int height, int numberOfMines) {
        Random random = new Random();
        int i = 0;
        while (i < numberOfMines) {
            int col = random.nextInt(width);
            int row = random.nextInt(height);
            if (!grid[row][col].hasMine()) {
                grid[row][col].hasMine(true);
                i++;
            }
        }
    }

    private void createNearby(int colWidth, int rowHeight) {
        int count;

        for (int col = 0; col < colWidth; col++) {
            for (int row = 0; row < rowHeight; row++) {

                count = 0;

                try {
                    if (grid[row][col - 1].hasMine()) {
                        count++;
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (grid[row][col + 1].hasMine()) {
                        count++;
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (grid[row - 1][col].hasMine()) {
                        count++;
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (grid[row + 1][col].hasMine()) {
                        count++;
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (grid[row + 1][col - 1].hasMine()) {
                        count++;
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (grid[row + 1][col + 1].hasMine()) {
                        count++;
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (grid[row - 1][col + 1].hasMine()) {
                        count++;
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (grid[row - 1][col - 1].hasMine()) {
                        count++;
                    }
                } catch (Exception ignored) {
                }

                grid[row][col].setMinesNearby(count);
            }
        }
    }
}
