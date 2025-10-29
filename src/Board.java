import java.util.*;

/**
 * Represents the Minesweeper game board.
 * Handles creating cells, placing mines, counting nearby mines,
 * revealing cells, and printing the board to the console.
 */
public class Board {
    // * 2D array of Cell objects representing the game board
    private Cell[][] grid;

    /**
     * Constructor: initializes cells, mines, and nearby counts.
     *
     * @param width         board width
     * @param height        board height
     * @param numberOfMines number of mines to place
     */
    Board(int width, int height, int numberOfMines) {
        createCells(width, height);
        createMines(width, height, numberOfMines);
        createNearby(width, height);
    }

    /**
     * Returns the Cell at a given position object.
     * Returns null if the position is out of bounds.
     *
     * @param pos Position object containing row and column
     * @return the Cell at the position or null
     */
    public Cell cellAtPosition(Position pos) {
        if (pos.row() >= 0 && pos.row() < grid.length && pos.col() >= 0 && pos.col() < grid[0].length) {
            return grid[pos.row()][pos.col()];
        } else {
            return null;
        }
    }

    /**
     * Toggles a flag on a cell at a given row and column.
     * Flags only allowed on hidden cells.
     */
    public void setCellAsFlag(int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            Cell cell = grid[row][col];

            if (!cell.isVisible()) {
                cell.setMineAsFlag(!cell.showMineAsFlag());
            }
        }
    }

    /**
     * Initializes all cells as hidden and without mines.
     */
    private void createCells(int width, int height) {
        grid = new Cell[height][width];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Cell cell = new Cell(false, false, 0);
                grid[row][col] = cell;
            }
        }
    }

    /**
     * Randomly places mines on the board.
     * Ensures no duplicate placement.
     */
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

    /**
     * Calculates the number of mines near each cell.
     * Counts all neighbors carefully.
     */
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
                    count += ((grid[row - 1][col - 1].hasMine()) ? 1 : 0);
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

    /**
     * Opens/reveals the cell at the given row and column.
     * Recursively opens neighboring cells if no mines are nearby.
     *
     * @param row row index
     * @param col column index
     */
    public void openCellAtPosition(int row, int col) {

        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {

            Cell cell = grid[row][col];
            if (!cell.showMineAsFlag() && !cell.isVisible()) {
                cell.isVisible(true);
                // * If cell has no nearby mines and no mine itself, recursively reveal neighbors
                if (cell.getMinesNearby() == 0 && !cell.hasMine()) {

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

    /**
     * Reveals all mines on the board (used when the player loses).
     */
    public void openMines() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Cell cell = grid[row][col];
                if (cell.hasMine()) {
                    cell.isVisible(true);
                }
            }
        }
    }

    /**
     * Reveals all mines and marks them as flags (used for victory display).
     */
    public void openMinesAsFlags() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Cell cell = grid[row][col];
                if (cell.hasMine()) {
                    cell.isVisible(true);
                    cell.setMineAsFlag(true);
                }
            }
        }
    }

    /**
     * Reveals all mines and marks them as flags (used for victory display).
     */
    public int checkOpenedCells() {
        int numOfOpenedCells = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Cell cell = grid[row][col];
                if (cell.isVisible() && !cell.showMineAsFlag()) {
                    numOfOpenedCells++;
                }
            }
        }
        return numOfOpenedCells;
    }

    /**
     * Calculates the number of mines left (mines - flags).
     * Returns a negative number if there are extra flags.
     */
    private int numberOfMinesLeft() {
        int returnValue = 0;
        for (Cell[] rows : grid) {
            for (Cell cell : rows) {
                if (cell.showMineAsFlag()) {
                    returnValue--;
                }
                if (cell.hasMine()) {
                    returnValue++;
                }
            }
        }
        return returnValue;
    }

    /**
     * Prints the current board to the console with mines left.
     */
    public void printBoard() {
        System.out.println(Color.BOLD + Color.BRIGHT_RED + numberOfMinesLeft() + Color.BRIGHT_WHITE + " mines left" + Color.RESET);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                Cell cell = grid[row][col];
                System.out.print(cell.textAt(row, col));
            }
            System.out.println();
        }
    }
}
