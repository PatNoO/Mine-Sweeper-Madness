import java.util.*;

public class Board {
    Cell[][] grid;

    Board(int width, int height, int numberOfMines) {
        createCells(width, height);
        createMines(width, height, numberOfMines);
        createNearby(width, height);
    }

    private void createNearby(int width, int height) {
        int count;

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                count = 0;
                Cell cell = grid[row][col];
                cell.setMinesNearby(0);

///         Check center cells
                for (int r = 1; r < height - 1; r++) {
                    for (int c = 1; c < width - 1; c++) {
                        if (row == r && col == c) {
                            if (grid[row][col - 1].hasMine()) {
                                count++;
                            }
                            if (grid[row][col + 1].hasMine()) {
                                count++;
                            }
                            if (grid[row - 1][col].hasMine()) {
                                count++;
                            }
                            if (grid[row + 1][col].hasMine()) {
                                count++;
                            }
                            if (grid[row + 1][col - 1].hasMine()) {
                                count++;
                            }
                            if (grid[row + 1][col + 1].hasMine()) {
                                count++;
                            }
                            if (grid[row - 1][col + 1].hasMine()) {
                                count++;
                            }
                            if (grid[row - 1][col - 1].hasMine()) {
                                count++;
                            }
                        }
                    }
                }

///         Check corner cells

                if (row == 0 && col == 0) {
                    if (grid[row + 1][col].hasMine()) {
                        count++;
                    }
                    if (grid[row + 1][col + 1].hasMine()) {
                        count++;
                    }
                    if (grid[row][col + 1].hasMine()) {
                        count++;
                    }
                }
                if (row == height-1 && col == 0) {
                    if (grid[row - 1][col].hasMine()) {
                        count++;
                    }
                    if (grid[row - 1][col + 1].hasMine()) {
                        count++;
                    }
                    if (grid[row][col + 1].hasMine()) {
                        count++;
                    }
                }
                if (row == 0 && col == width-1) {
                    if (grid[row][col - 1].hasMine()) {
                        count++;
                    }
                    if (grid[row + 1][col - 1].hasMine()) {
                        count++;
                    }
                    if (grid[row + 1][col].hasMine()) {
                        count++;
                    }
                }
                if (row == height-1 && col == width-1) {
                    if (grid[row - 1][col - 1].hasMine()) {
                        count++;
                    }
                    if (grid[row][col - 1].hasMine()) {
                        count++;
                    }
                    if (grid[row - 1][col].hasMine()) {
                        count++;
                    }
                }

///         Check top side cells
                for (int c = 1; c < width - 1; c++) {
                    if (row == 0 && col == c) {
                        if (grid[row][col - 1].hasMine()) {
                            count++;
                        }
                        if (grid[row][col + 1].hasMine()) {
                            count++;
                        }
                        if (grid[row + 1][col - 1].hasMine()) {
                            count++;
                        }
                        if (grid[row + 1][col].hasMine()) {
                            count++;
                        }
                        if (grid[row + 1][col + 1].hasMine()) {
                            count++;
                        }
                    }
                }

///         Check bottom side cells
                for (int c = 1; c < width - 1; c++) {
                    if (row == 5 && col == c) {
                        if (grid[row][col - 1].hasMine()) {
                            count++;
                        }
                        if (grid[row][col + 1].hasMine()) {
                            count++;
                        }
                        if (grid[row - 1][col - 1].hasMine()) {
                            count++;
                        }
                        if (grid[row - 1][col].hasMine()) {
                            count++;
                        }
                        if (grid[row - 1][col + 1].hasMine()) {
                            count++;
                        }
                    }
                }

///         Check left side cells
                for (int r = 1; r < height - 1; r++) {
                    if (row == r && col == 0) {
                        if (grid[row - 1][col].hasMine()) {
                            count++;
                        }
                        if (grid[row - 1][col + 1].hasMine()) {
                            count++;
                        }
                        if (grid[row + 1][col].hasMine()) {
                            count++;
                        }
                        if (grid[row][col + 1].hasMine()) {
                            count++;
                        }
                        if (grid[row + 1][col + 1].hasMine()) {
                            count++;
                        }
                    }
                }

///         Check right side cells
                for (int r = 1; r < height - 1; r++) {
                    if (row == r && col == width-1) {
                        if (grid[row - 1][col].hasMine()) {
                            count++;
                        }
                        if (grid[row - 1][col - 1].hasMine()) {
                            count++;
                        }
                        if (grid[row][col - 1].hasMine()) {
                            count++;
                        }
                        if (grid[row + 1][col - 1].hasMine()) {
                            count++;
                        }
                        if (grid[row + 1][col].hasMine()) {
                            count++;
                        }
                    }
                }

                cell.setMinesNearby(count);
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

    private void createCells(int width, int height) {
        grid = new Cell[height][width];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Cell cell = new Cell(false, false, 0);
                grid[row][col] = cell;
            }
        }
    }
}
