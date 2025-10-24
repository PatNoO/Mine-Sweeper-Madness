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
                if (cell != null) {
                    if (board.openCellAtPosition(pos.row(), pos.col())) {
                        System.out.println("You hit a Mine!!!!");

                    }
                }
            }

        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
