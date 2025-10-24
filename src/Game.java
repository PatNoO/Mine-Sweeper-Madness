import org.w3c.dom.Text;

public class Game {

    static Board board;

    public Game() {
        // Init variables
    }

    public void homeMenu() {
        Player player = new Player("");
        System.out.println(TextOutput.WELCOME_TEXT);
        System.out.println(TextOutput.PLAYER_NAME);
        player.setName(InputHandler.getStringName(TextOutput.ERROR_PLAYER_INPUT_NAME));

        while (true) {
            System.out.println("Welcome to the home menu!");

            System.out.println("Press 1 to play game ");
            System.out.println("Press 2 change difficulty ");
            System.out.println("Press 3 to for help ");
            System.out.println("Press 4 to quit ");

            int userInputMenu = InputHandler.getInt(1, 4, TextOutput.ERROR_PLAYER_INT_INPUT);
            System.out.println(userInputMenu);

            switch (userInputMenu) {
                // Startar spelet
                case 1:
                    run();
                    break;
                case 2:
                    difficultyMenu(player);
                    break;
                case 3:
                    TextOutput.showHelp();
                    break;
                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println(TextOutput.ERROR_PLAYER_INVALID_INPUT);
                    break;
            }

        }

    }

    public void difficultyMenu(Player player) {

        System.out.println(player.getName() + " Choose difficulty :");
        System.out.println("Press 1 for : " + Color.GREEN + "EASY" + Color.RESET);
        System.out.println("Press 2 for : " + Color.BLUE + "MEDIUM" + Color.RESET);
        System.out.println("Press 3 for : " + Color.RED + "HARD" + Color.RESET);

        int playerDifficulty = InputHandler.getInt(1, 4, TextOutput.ERROR_PLAYER_INT_INPUT);
        switch (playerDifficulty) {
            case 1:
                System.out.println(Color.GREEN + "EASY" + Color.RESET);
                break;
            case 2:
                System.out.println(Color.BLUE + "MEDIUM" + Color.RESET);
                break;
            case 3:
                System.out.println(Color.RED + "HARD" + Color.RESET);
                break;
            default:
                System.out.println(TextOutput.ERROR_PLAYER_INVALID_INPUT);
                homeMenu();

        }


    }


    public void run() {
        // Run Method
        int boardWidth = 10;
        int boardHeight = 10;
        int boardNumOfMines = 15;
        board = new Board(boardWidth, boardHeight, boardNumOfMines);
        /// todo kanske starta på homeMenu istället för run ?
        //homeMenu();

        System.out.println(Color.BOLD + """
                
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
                        TextOutput.GameOverOutput();

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
