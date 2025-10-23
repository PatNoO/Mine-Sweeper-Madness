public class Game {

    static Board board;

    public Game() {
        // Init variables
    }

    public void run() {
        // Run Method
        board = new Board(10, 10, 20);

        System.out.println(Color.BOLD+"""
                            
                            SWEEP FOR MINES, BUT DO NOT HIT ONE!
                            """ + Color.RESET);

        while (true) {
            printBoard();
            openCell(board.grid);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void openCell(Cell[][] grid) {
        while (true) {
            int a = -1;
            int b = -1;

            System.out.println();
            System.out.println("Enter a coordinate e.g., 'A1':");
            String choice = InputHandler.getMove();
            

            for (int i = 0; i < grid.length; i++) {
                char charInGrid = (char) ('A' + i);
                if (charInGrid == choice.charAt(0)) {
                    a = i;
                    break;
                }
            }

            for (int i = 0; i < grid.length; i++) {
                String nrInGrid = String.valueOf(i + 1);
                if (choice.substring(2).equals(nrInGrid)) {
                    b = i;
                    break;
                }
            }

            if (a != -1 && b != -1) {
                Cell cell = grid[b][a];

                cell.visible(true);
                break;
            } else {
                System.out.println("Wrong input");
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
