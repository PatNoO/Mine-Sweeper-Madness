import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        while (true) {
            TextOutput.homeMenuOutput(player);

            int userInputMenu = InputHandler.getInt(1, 6, TextOutput.ERROR_PLAYER_INT_INPUT);

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
                    highScoreMenu();
                    break;
                case 5:
                    TextOutput.showHelpOutput();
                    break;
                case 6:
                    clearScreen();
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
                boardMinePercentage = 0.01; // 10 mines
                clearScreen();
                break;
            case 2:
                player.setDifficulty("MEDIUM");
                boardSizeWidth = 12;
                boardSizeHeight = 12;
                boardMinePercentage = 0.18; // 26 mines
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


        long startTime = System.currentTimeMillis();
        while (true) {
            clearScreen();
            board.printBoard();

            TextOutput.gameInfoOutput();

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

                        if (cell.hasMine() && cell.isVisible()) {
                            cell.setMineHit(true);
                            clearScreen();
                            board.openMines();
                            board.printBoard();
                            TextOutput.gameOverOutput();
                            playerRetry();
                            clearScreen();
                            break;

                        } else if (openedCells == totalCells - boardNumOfMines) {
                            int elapsedTime = (int)((System.currentTimeMillis() - startTime) / 1000);
                            player.setTime(elapsedTime);
                            try {
                                CSV.write(player, "highscore.csv");
                            } catch (IOException ignored) {}
                            clearScreen();
                            board.openMinesAsFlags();
                            board.printBoard();
                            TextOutput.gameWinOutput();
                            playerRetry();
                            clearScreen();
                            break;
                        }
                    }
                }
            }
        }
    }

    private void playerRetry() {
        System.out.println(TextOutput.PLAYER_RETRY);
        String userInput = InputHandler.getString();
        if (userInput.isEmpty()) {
            clearScreen();
            run();
        }
    }

    public void changePlayerName(Player player) {
        clearScreen();

        TextOutput.enterNameText();
        player.setName(InputHandler.getStringName(TextOutput.ERROR_PLAYER_INPUT_NAME));

        clearScreen();
    }

    public void highScoreMenu() {
        clearScreen();
        try {
            ArrayList<Player> players = CSV.readCsvFile("highscore.csv");

            List<Player> easyPlayers = players.stream().
                    filter(player -> player.getDifficulty().equals("EASY")).sorted(Comparator.comparing(Player::getTime)).toList();
            List<Player> mediumPlayers = players.stream().
                    filter(player -> player.getDifficulty().equals("MEDIUM")).sorted(Comparator.comparing(Player::getTime)).toList();
            List<Player> hardPlayers = players.stream().
                    filter(player -> player.getDifficulty().equals("HARD")).sorted(Comparator.comparing(Player::getTime)).toList();

            System.out.println();
            System.out.println(TextOutput.HIGHSCORE_COLUMNS);
            System.out.println();
            System.out.println(TextOutput.EASY_GREEN);
            for (int i = 0 ; i<Math.min(easyPlayers.size(), 5); i++) {
                Player p = easyPlayers.get(i);
                p.printScore();
            }
            System.out.println();
            System.out.println(TextOutput.MEDIUM_BLUE);
            for (int i = 0 ; i<Math.min(mediumPlayers.size(), 5); i++) {
                Player p = mediumPlayers.get(i);
                p.printScore();
            }
            System.out.println();
            System.out.println(TextOutput.HARD_RED);
            for (int i = 0 ; i<Math.min(hardPlayers.size(), 5); i++) {
                Player p = hardPlayers.get(i);
                p.printScore();
            }

        } catch (IOException ignored) {
            System.out.println();
            System.out.println(TextOutput.ERROR_HIGHSCORE_NO_DATA);
        }

        System.out.println();
        System.out.println(" " + TextOutput.PLAYER_RETURN);
        InputHandler.getString();
        clearScreen();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
