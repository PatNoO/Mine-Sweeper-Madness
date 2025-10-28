public class Game {

    private int boardSizeWidth = 8;
    private int boardSizeHeight = 8;
    private double boardMinePercentage = 0.15; // 10 mines

    Player player = new Player("", "EASY");


    public Game() {
        clearScreen();
        TextOutput.welcomeText();

        TextOutput.enterNameText();
        player.setName(InputHandler.getStringName(TextOutput.ERROR_PLAYER_INPUT_NAME));
    }

    public void homeMenu() {
        clearScreen();
//        Player player = new Player("", "EASY");

//        TextOutput.enterNameText();
//        player.setName(InputHandler.getStringName(TextOutput.ERROR_PLAYER_INPUT_NAME));
//        clearScreen();

        while (true) {
            TextOutput.homeMenuOutput(player);

            int userInputMenu = InputHandler.getInt(1, 5, TextOutput.ERROR_PLAYER_INT_INPUT);

            switch (userInputMenu) {
                // Starts game
                case 1:
                    run();
                    break;
                case 2:
                    difficultyMenu(player);
                    break;
                case 3:
                    changePlayerName(player);
                    break;
                case 4:
                    TextOutput.showHelpOutput();
                    break;
                case 5:
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
        clearScreen();
        TextOutput.difficultyMenuOutput(player);

        int playerDifficulty = InputHandler.getInt(1, 3, TextOutput.ERROR_PLAYER_INT_INPUT);
        switch (playerDifficulty) {
            case 1:
                player.setDifficulty("EASY");
                boardSizeWidth = 8;
                boardSizeHeight = 8;
                boardMinePercentage = 0.18; // 10 mines
                clearScreen();
                break;
            case 2:
                player.setDifficulty("MEDIUM");
                boardSizeWidth = 12;
                boardSizeHeight = 12;
                boardMinePercentage = 0.15; // 22 mines
                clearScreen();
                break;
            case 3:
                player.setDifficulty("HARD");
                boardSizeWidth = 20;
                boardSizeHeight = 20;
                boardMinePercentage = 0.20; // 80 mines
                clearScreen();
                break;
            default:
                System.out.println(TextOutput.ERROR_PLAYER_INVALID_INPUT);
                clearScreen();
                homeMenu();
        }
    }

    public void run() {
        // Run Method
        int boardNumOfMines = (int) Math.round(boardSizeWidth * boardSizeHeight * boardMinePercentage);
        Board board = new Board(boardSizeWidth, boardSizeHeight, boardNumOfMines);


        while (true) {
            clearScreen();
            board.printBoard();

            System.out.println(Color.GRAY + TextOutput.PLAYER_EXIT_GAME + Color.RESET);
            System.out.println(Color.GRAY + TextOutput.PLAYER_MAKE_MOVE_INFO_2 + Color.RESET);
            System.out.println(Color.BRIGHT_WHITE + TextOutput.PLAYER_MAKE_MOVE_INFO + Color.RESET);

            String input = InputHandler.getString();
            Position pos = InputHandler.getPosition(input);

            if (input.equals("EXIT")) {
                homeMenu();
            }

            if (pos != null) {
                Cell cell = board.cellAtPosition(pos);
                if (cell != null) {
                    if ((input.length() == 3 && input.charAt(2) == 'F') || (input.length() == 4 && input.charAt(3) == 'F')) {

                        board.setCellAsFlag(pos.row(), pos.col());

                    } else {

                        board.openCellAtPosition(pos.row(), pos.col());

                        int openedCells = board.checkOpenedCells();
                        int totalCells = boardSizeWidth * boardSizeHeight;

                        if (openedCells == totalCells - boardNumOfMines) {
                            clearScreen();
                            board.openMinesAsFlags();
                            board.printBoard();
                            TextOutput.gameWinOutput();
                            System.out.println(TextOutput.PLAYER_RETRY);
                            String userInput = InputHandler.getString();
                            if (userInput.isEmpty()) {
                                clearScreen();
                                run();
                            }
                            break;
                        }
                        if (cell.hasMine() && cell.isVisible()) {
                            cell.setMineHit(true);
                            clearScreen();
                            board.openMines();
                            board.printBoard();
                            TextOutput.gameOverOutput();
                            System.out.println(TextOutput.PLAYER_RETRY);
                            String userInput = InputHandler.getString();
                            if (userInput.isEmpty()) {
                                clearScreen();
                                run();
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public void changePlayerName(Player player) {
        clearScreen();

        TextOutput.enterNameText();
        player.setName(InputHandler.getStringName(TextOutput.ERROR_PLAYER_INPUT_NAME));

        clearScreen();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
