public class Game {

    static Board board;
    private int boardSizeWidth = 8;
    private int boardSizeHeight = 8;
    private double boardMinePercentage = 0.15; // 10 mines

    public Game() {
        // Init variables
    }

    public void homeMenu() {
        clearScreen();
        Player player = new Player("", "EASY");
        TextOutput.welcomeText();
        player.setName(InputHandler.getStringName(TextOutput.ERROR_PLAYER_INPUT_NAME));
        clearScreen();

        while (true) {
            TextOutput.homeMenuOutput(player);

            int userInputMenu = InputHandler.getInt(1, 4, TextOutput.ERROR_PLAYER_INT_INPUT);

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
                player.setDifficulty("EASY");
                boardSizeWidth = 8;
                boardSizeHeight = 8;
                boardMinePercentage = 0.15; // 10 mines
                break;
            case 2:
                player.setDifficulty("MEDIUM");
                boardSizeWidth = 12;
                boardSizeHeight = 12;
                boardMinePercentage = 0.15; // 22 mines
                break;
            case 3:
                player.setDifficulty("HARD");
                boardSizeWidth = 20;
                boardSizeHeight = 20;
                boardMinePercentage = 0.20; // 80 mines
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
        int boardNumOfMines = (int) Math.round(boardWidth * boardHeight * boardMinePercentage);
        board = new Board(boardWidth, boardHeight, boardNumOfMines);

        TextOutput.gameStartOutput();

        while (true) {
            clearScreen();
            printBoard();

            System.out.println(Color.GRAY + TextOutput.PLAYER_MAKE_MOVE_INFO_2 + Color.RESET);
            System.out.println(Color.BRIGHT_WHITE + TextOutput.PLAYER_MAKE_MOVE_INFO + Color.RESET);

            String input = InputHandler.getString();
            Position pos = InputHandler.getPosition(input);
            if (pos != null) {
                Cell cell = board.cellAtPosition(pos);
                if (cell != null) {
                    if ((input.length() == 3 && input.charAt(2) == 'F') || (input.length() == 4 && input.charAt(3) == 'F')) {

                        board.setCellAsFlag(pos.row(), pos.col());

                        int openedCells = checkOpenedCells();
                        int totalCells = boardWidth * boardHeight;
                        if (openedCells == totalCells - boardNumOfMines) {
                            openMinesAsFlags();
                            printBoard();
                            TextOutput.gameWinOutput();
                            break;
                        }

                    } else {

                        board.openCellAtPosition(pos.row(), pos.col());

                        int openedCells = checkOpenedCells();
                        int totalCells = boardWidth * boardHeight;
                        if (openedCells == totalCells - boardNumOfMines) {
                            openMinesAsFlags();
                            printBoard();
                            TextOutput.gameWinOutput();
                            System.out.println(TextOutput.PLAYER_RETRY);
                            String userInput = InputHandler.getString();
                            if (userInput.equals("YES")) {
                                run();
                            } else if (userInput.equals("NO")) {
                                homeMenu();
                            }
                            break;
                        }
                        if (cell.hasMine() && cell.isVisible()) {
                            cell.setMineHit(true);
                            clearScreen();
                            openMines();
                            printBoard();
                            TextOutput.gameOverOutput();
                            System.out.println(TextOutput.PLAYER_RETRY);
                            String userInput = InputHandler.getString();
                            if (userInput.equals("YES")) {
                                run();
                            } else if (userInput.equals("NO")) {
                                homeMenu();
                            }
                            break;
                        }
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
                if (cell.isVisible() && !cell.showMineAsFlag()) {
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
        System.out.println();

        for (int row = 0; row < board.grid.length; row++) {
            for (int col = 0; col < board.grid[row].length; col++) {

                Cell cell = board.grid[row][col];
                System.out.print(cell.textAt(row, col));

            }
            System.out.println();
        }
    }
}
