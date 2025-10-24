public class Game {

    static Board board;

    public Game() {
        // Init variables
    }

    public void run() {
        // Run Method
        board = new Board(10, 10, 15);

        System.out.println(Color.BOLD+"""
                            
                            SWEEP FOR MINES, BUT DO NOT HIT ONE!
                            """ + Color.RESET);

        while (true) {
            clearScreen();
            printBoard();


            Position pos = InputHandler.getPosition();

            if (pos != null) {
                Cell cell = board.cellAtPosition(pos);
                board.openCellAtPosition(pos.row(), pos.col());
                if (cell != null) {
                    if (cell.hasMine()) {
                        openBoard(board);
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

    public void openBoard(Board board) {
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
