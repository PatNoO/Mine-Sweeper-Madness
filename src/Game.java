public class Game {

    static Board board;
    public Game() {
        // Init variables
    }

    public void run() {
        // Run Method
        board = new Board(10, 5, 10);
        printBoard();
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
