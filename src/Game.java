public class Game {

    static Board board;

    public Game() {
        // Init variables
    }

    public void homeMenu() {
        

    }


    public void run() {
        // Run Method
        int boardWidth = 10;
        int boardHeight = 10;
        int boardNumOfMines = 15;
        board = new Board(boardWidth, boardHeight, boardNumOfMines);

        System.out.println(Color.BOLD+"""
                            
                            SWEEP FOR MINES, BUT DO NOT HIT ONE!
                            """ + Color.RESET);

        while (true) {
            clearScreen();
            printBoard();


            Position pos = InputHandler.getPosition();

            if (pos != null) {
                Cell cell = board.cellAtPosition(pos);
                if (cell != null) {
                    board.openCellAtPosition(pos.row(), pos.col());
                    int openedCells = checkOpenedCells(board);
                    int totalCells = boardWidth * boardHeight;
                    if (openedCells == totalCells - boardNumOfMines) {
                        printBoard();
                        System.out.println(TextOutput.PLAYER_WIN);
                        break;
                    }
                    if (cell.hasMine()) {
                        openMines(board);
                        printBoard();
                        System.out.println();
                        System.out.println((Color.BOLD + Color.RED + "*" + Color.ORANGE + "*").repeat(15));
                        System.out.println(Color.BOLD + Color.ORANGE + "* " + Color.RED + "You hit a mine, GAME OVER! *");
                        System.out.println((Color.BOLD + Color.RED + "*" + Color.ORANGE + "*").repeat(15));
                        break;

                    }
                }
            }

        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int checkOpenedCells(Board board) {
        int numOfOpenedCells = 0;
        for (int row = 0; row < board.grid.length; row++) {
            for (int col = 0; col < board.grid[row].length; col++) {
                if (board.grid[row][col].isVisible()) {
                    numOfOpenedCells++;
                }
            }
        }
        return numOfOpenedCells;
    }

    public void openMines(Board board) {
        for (int row = 0; row < board.grid.length; row++) {
            for (int col = 0; col < board.grid[row].length; col++) {
                if (board.grid[row][col].hasMine()) {
                    board.grid[row][col].isVisible(true);
                }
            }
        }
    }

    public static void printBoard() {

        for (int row = 0; row < board.grid.length; row++) {
            for (int col = 0; col < board.grid[row].length; col++) {

                Cell cell = board.grid[row][col];
                System.out.print(cell.textAt(row, col));

            }
            System.out.println();
        }
    }
}
