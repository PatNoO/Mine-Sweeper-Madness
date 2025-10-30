import java.util.*;

/**
 * Represents the Minesweeper game board.
 * Handles creating cells, placing mines, counting nearby mines,
 * revealing cells, and printing the board to the console.
 */
public class Board {
    // * 2D array of Cell objects representing the game board
    private Cell[][] grid;
    private final int width;
    private final int height;

    /**
     * Constructor: initializes cells, mines, and nearby counts.
     *
     * @param width         board width
     * @param height        board height
     * @param numberOfMines number of mines to place
     */
    Board(int width, int height, int numberOfMines) {
        this.width = width;
        this.height = height;
        createCells();
        createMines(numberOfMines);
        createNearby();
    }

    /**
     * Returns the Cell at a given position object.
     * Returns null if the position is out of bounds.
     *
     * @param pos Position object containing row and column
     * @return the Cell at the position or null
     */
    public Cell cellAtPosition(Position pos) {
        if (pos.row() >= 0 && pos.row() < height && pos.col() >= 0 && pos.col() < width) {
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
        if (row >= 0 && row < width && col >= 0 && col < height) {
            Cell cell = grid[row][col];

            if (!cell.isVisible()) {
                cell.setMineAsFlag(!cell.showMineAsFlag());
            }
        }
    }

    /// Initializes all cells as hidden and without mines.
    private void createCells() {
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
    private void createMines(int numberOfMines) {
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
    private void createNearby() {
        int count;

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                count = 0;
                if (col > 0) {
                    count += ((grid[row][col - 1].hasMine()) ? 1 : 0);
                }
                if (col < width - 1) {
                    count += ((grid[row][col + 1].hasMine()) ? 1 : 0);
                }
                if (row < height - 1) {
                    count += ((grid[row + 1][col].hasMine()) ? 1 : 0);
                }
                if (row > 0) {
                    count += ((grid[row - 1][col].hasMine()) ? 1 : 0);
                }
                if (row < height - 1 && col < width - 1) {
                    count += ((grid[row + 1][col + 1].hasMine()) ? 1 : 0);
                }
                if (row > 0 && col > 0) {
                    count += ((grid[row - 1][col - 1].hasMine()) ? 1 : 0);
                }
                if (row < height - 1 && col > 0) {
                    count += ((grid[row + 1][col - 1].hasMine()) ? 1 : 0);
                }
                if (row > 0 && col < width - 1) {
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

        if (row >= 0 && row < height && col >= 0 && col < width) {

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

    /// Reveals all mines on the board (used when the player loses).
    public void openMines() {
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                if (cell.hasMine()) {
                    cell.isVisible(true);
                }
            }
        }
    }

    /// Reveals all mines and marks them as flags (used for victory display).
    public void openMinesAsFlags() {
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                if (cell.hasMine()) {
                    cell.isVisible(true);
                    cell.setMineAsFlag(true);
                }
            }
        }
    }

    /// Reveals all mines and marks them as flags (used for victory display).
    public int checkOpenedCells() {
        int numOfOpenedCells = 0;
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                if (cell.isVisible() && !cell.showMineAsFlag()) {
                    numOfOpenedCells++;
                }
            }
        }
        return numOfOpenedCells;
    }

    /// Calculates the number of mines left (mines - flags).
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

    /// Prints the current board to the console with mines left.
    public void printBoard() {
        TextOutput.numberOfMinesLeftText(numberOfMinesLeft());

        for (int row = 0; row < height; row++) {
            System.out.print(" ");
            for (int col = 0; col < width; col++) {
                Cell cell = grid[row][col];
                System.out.print(cell.textAt(row, col));
            }
            System.out.println();
        }
    }
}
