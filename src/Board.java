import java.util.*;

public class Board {
    Cell[][] grid;


    public Cell cellAtPosition(Position pos) {
        if (pos.row()>=0 && pos.row()<grid.length && pos.col()>=0 && pos.col()<grid[0].length) {
            return grid[pos.row()][pos.col()];
        } else {
            return null;
        }
    }

    public void openCellAtPosition(int row, int col) {

        if (row>=0 && row<grid.length && col>=0 && col<grid[0].length) {

            Cell cell = grid[row][col];
            if (!cell.isVisible()) {
                cell.isVisible(true);
                if (cell.getMinesNearby() == 0) {

                    openCellAtPosition(row, col - 1);
                    openCellAtPosition(row, col + 1);

                    openCellAtPosition(row - 1, col - 1);
                    openCellAtPosition(row - 1, col);
                    openCellAtPosition(row - 1, col + 1);

                    openCellAtPosition(row + 1, col - 1);
                    openCellAtPosition(row + 1, col);
                    openCellAtPosition(row + 1, col + 1);

                }
            }
        }
    }


    Board(int width, int height, int numberOfMines) {
        createCells(width, height);
        createMines(width, height, numberOfMines);
        createNearby(width, height);
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
                if (col > 0) {
                    count += ((grid[row][col - 1].hasMine()) ? 1 : 0);
                }
                if (col < colWidth - 1) {
                    count += ((grid[row][col + 1].hasMine()) ? 1 : 0);
                }
                if (row < rowHeight - 1) {
                    count += ((grid[row + 1][col].hasMine()) ? 1 : 0);
                }
                if (row > 0) {
                    count += ((grid[row - 1][col].hasMine()) ? 1 : 0);
                }
                if (row < rowHeight - 1 && col < colWidth - 1) {
                    count += ((grid[row + 1][col + 1].hasMine()) ? 1 : 0);
                }
                if (row > 0 && col > 0) {
                    count += ((grid[row - 1][col - 1].hasMine()) ?  1 : 0);
                }
                if (row < rowHeight - 1 && col > 0) {
                    count += ((grid[row + 1][col - 1].hasMine()) ? 1 : 0);
                }
                if (row > 0 && col < colWidth - 1) {
                    count += ((grid[row - 1][col + 1].hasMine()) ? 1 : 0);
                }


                grid[row][col].setMinesNearby(count);
            }
        }
    }
}
