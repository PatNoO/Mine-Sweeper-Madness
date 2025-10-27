public class Game {

    static Board board;
    private int boardSizeWidth = 10;
    private int boardSizeHeight = 10;
    private double boardMinePercentage = 0.15;

    public Game() {
        // Init variables
    }

    public void homeMenu() {
        Player player = new Player("");
        TextOutput.welcomeText();
        player.setName(InputHandler.getStringName(TextOutput.ERROR_PLAYER_INPUT_NAME));

        while (true) {
            TextOutput.homeMenuOutput(player);

            int userInputMenu = InputHandler.getInt(1, 4, TextOutput.ERROR_PLAYER_INT_INPUT);
//            System.out.println(userInputMenu);

            switch (userInputMenu) {
                // Startar spelet
                case 1:
                    run();
                    break;
                case 2:
                    difficultyMenu(player);
                    break;
                case 3:
                    TextOutput.showHelpOutput();
                    break;
                case 4:
                    TextOutput.thanksForPlayingOutput();
                    System.exit(0);
                    break;

                default:
                    System.out.println(TextOutput.ERROR_PLAYER_INVALID_INPUT);
                    break;
            }

        }

    }

    public void difficultyMenu(Player player) {

        TextOutput.difficultyMenuOutput(player);

        int playerDifficulty = InputHandler.getInt(1, 4, TextOutput.ERROR_PLAYER_INT_INPUT);
        switch (playerDifficulty) {
            case 1:
                System.out.println(Color.GREEN + "EASY" + Color.RESET);
                boardSizeWidth = 10;
                boardSizeHeight = 10;
                boardMinePercentage = 0.15;
                break;
            case 2:
                System.out.println(Color.BLUE + "MEDIUM" + Color.RESET);
                boardSizeWidth = 18;
                boardSizeHeight = 18;
                boardMinePercentage = 0.15;
                break;
            case 3:
                System.out.println(Color.RED + "HARD" + Color.RESET);
                boardSizeWidth = 26;
                boardSizeHeight = 26;
                boardMinePercentage = 0.15;
                break;
            default:
                System.out.println(TextOutput.ERROR_PLAYER_INVALID_INPUT);
                homeMenu();

        }


    }


    public void run() {
        // Run Method
        int boardWidth = boardSizeWidth;
        int boardHeight = boardSizeHeight;
        int boardNumOfMines = (int)Math.round(boardWidth * boardHeight * boardMinePercentage);
        board = new Board(boardWidth, boardHeight, boardNumOfMines);

        TextOutput.gameStartOutput();

        while (true) {
            clearScreen();
            printBoard();


            System.out.println(TextOutput.PLAYER_MAKE_MOVE_INFO + Color.GRAY + TextOutput.PLAYER_MAKE_MOVE_INFO_2 + Color.RESET);

            // Om man kör placera flagga
//            System.out.println(TextOutput.PLAYER_SET_FLAG_INFO + Color.GRAY + TextOutput.PLAYER_SET_FLAG_INFO_2 + Color.RESET);

            Position pos = InputHandler.getPosition();

            if (pos != null) {
                Cell cell = board.cellAtPosition(pos);
                if (cell != null) {

                    /* TODO:
                        Finns en fungerande funktion att placera flaggor
                        Men inte löst bytet mellan den och att öppna celler
                    */

                    // "Placera flagga"
//                    board.setCellAsFlag(pos.row(), pos.col());

                    // Kommentera ut rad 130-147, för att testa ovan metod

                                board.openCellAtPosition(pos.row(), pos.col());

                                int openedCells = checkOpenedCells();
                                int totalCells = boardWidth * boardHeight;
                                if (openedCells == totalCells - boardNumOfMines) {
                                    openMinesAsFlags();
                                    printBoard();
                                    TextOutput.gameWinOutput();
                                    break;
                                }
                                if (cell.hasMine()) {
                                    cell.setMineHit(true);
                                    openMines();
                                    printBoard();
                                    TextOutput. gameOverOutput();

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

    public int checkOpenedCells() {
        int numOfOpenedCells = 0;
        for (int row = 0; row < board.grid.length; row++) {
            for (int col = 0; col < board.grid[row].length; col++) {
                Cell cell = board.grid[row][col];
                if (cell.isVisible()) {
                    numOfOpenedCells++;
                }
            }
        }
        return numOfOpenedCells;
    }

    public void openMinesAsFlags() {
        for (int row = 0; row < board.grid.length; row++) {
            for (int col = 0; col < board.grid[row].length; col++) {
                Cell cell = board.grid[row][col];
                if (cell.hasMine()) {
                    cell.isVisible(true);
                    cell.setMineAsFlag(true);
                }
            }
        }
    }

    public void openMines() {
        for (int row = 0; row < board.grid.length; row++) {
            for (int col = 0; col < board.grid[row].length; col++) {
                Cell cell = board.grid[row][col];
                if (cell.hasMine()) {
                    cell.isVisible(true);
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
