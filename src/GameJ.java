public class GameJ {

    public GameJ() {
        // Init variables
    }

    public void run() {
        // Run Method

     System.out.println(Color.BOLD+"""
                            
                            SWEEP FOR MINES, BUT DO NOT HIT ONE!
                            """);
    Cell[][] grid = BoardJ.createGrid();

        while (true) {

        printBoard(grid);
        openCell(grid);
        checkAround(grid);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

public static void checkAround(Cell[][] grid) {

    int count;
    Cell cell = null;

    for (int i = 0; i <= 5; i++) {
        for (int j = 0; j <= 5; j++) {

            count = 0;
            cell = grid[i][j];
            cell.setMinesNearby(0);

///         Check center cells
            for (int k = 1; k <= 4; k++) {
                for (int l = 1; l <= 4; l++) {
                    if (i == k && j == l) {
                        if (grid[i][j - 1].hasMine()) {
                            count++;
                        }
                        if (grid[i][j + 1].hasMine()) {
                            count++;
                        }
                        if (grid[i - 1][j].hasMine()) {
                            count++;
                        }
                        if (grid[i + 1][j].hasMine()) {
                            count++;
                        }
                        if (grid[i + 1][j - 1].hasMine()) {
                            count++;
                        }
                        if (grid[i + 1][j + 1].hasMine()) {
                            count++;
                        }
                        if (grid[i - 1][j + 1].hasMine()) {
                            count++;
                        }
                        if (grid[i - 1][j - 1].hasMine()) {
                            count++;
                        }
                    }
                }
            }

///         Check corner cells

            if (i == 0 && j == 0) {
                if (grid[i + 1][j].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j + 1].hasMine()) {
                    count++;
                }
                if (grid[i][j + 1].hasMine()) {
                    count++;
                }
            }
            if (i == 5 && j == 0) {
                if (grid[i - 1][j].hasMine()) {
                    count++;
                }
                if (grid[i - 1][j + 1].hasMine()) {
                    count++;
                }
                if (grid[i][j + 1].hasMine()) {
                    count++;
                }
            }
            if (i == 0 && j == 5) {
                if (grid[i][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j].hasMine()) {
                    count++;
                }
            }
            if (i == 5 && j == 5) {
                if (grid[i - 1][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i - 1][j].hasMine()) {
                    count++;
                }
            }

///         Check top side cells
            if (i == 0 && j == 1 || i == 0 && j == 2 || i == 0 && j == 3 || i == 0 && j == 4) {
                if (grid[i][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i][j + 1].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j + 1].hasMine()) {
                    count++;
                }
            }

///         Check bottom side cells
            if (i == 5 && j == 1 || i == 5 && j == 2 || i == 5 && j == 3 || i == 5 && j == 4) {
                if (grid[i][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i][j + 1].hasMine()) {
                    count++;
                }
                if (grid[i - 1][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i - 1][j].hasMine()) {
                    count++;
                }
                if (grid[i - 1][j + 1].hasMine()) {
                    count++;
                }

            }

///         Check left side cells
            if (i == 1 && j == 0 || i == 2 && j == 0 || i == 3 && j == 0 || i == 4 && j == 0) {
                if (grid[i - 1][j].hasMine()) {
                    count++;
                }
                if (grid[i - 1][j + 1].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j].hasMine()) {
                    count++;
                }
                if (grid[i][j + 1].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j + 1].hasMine()) {
                    count++;
                }
            }

///         Check left side cells
            if (i == 1 && j == 5 || i == 2 && j == 5 || i == 3 && j == 5 || i == 4 && j == 5) {
                if (grid[i - 1][j].hasMine()) {
                    count++;
                }
                if (grid[i - 1][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j - 1].hasMine()) {
                    count++;
                }
                if (grid[i + 1][j].hasMine()) {
                    count++;
                }
            }

            cell.setMinesNearby(count);
        }
    }
}


public static void openCell(Cell[][] grid) {

    int a = 0;
    int b = 0;

    System.out.println();
    System.out.println("Enter a coordinate e.g., 'A1':");
    String choice = InputHandler.getMove();

    // Print A-1 if A1

    for (int i = 0; i < grid.length; i++) {
        char charInGrid = (char)('A' + i );
        if (charInGrid == choice.charAt(0)) {
            a = i;
            break;
        }
    }

//    if (choice.charAt(0) == 'A') {
//        a = 0;
//    } else if (choice.charAt(0) == 'B') {
//        a = 1;
//    } else if (choice.charAt(0) == 'C') {
//        a = 2;
//    } else if (choice.charAt(0) == 'D') {
//        a = 3;
//    } else if (choice.charAt(0) == 'E') {
//        a = 4;
//    } else if (choice.charAt(0) == 'F') {
//        a = 5;
//    }

    if (choice.charAt(2) == '1') {
        b = 0;
    } else if (choice.charAt(2) == '2') {
        b = 1;
    } else if (choice.charAt(2) == '3') {
        b = 2;
    } else if (choice.charAt(2) == '4') {
        b = 3;
    } else if (choice.charAt(2) == '5') {
        b = 4;
    } else if (choice.charAt(2) == '6') {
        b = 5;
    }

    Cell cell = grid[b][a];

    cell.visible(true);

}

public static void printBoard(Cell[][] grid) {

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {

            Cell cell = grid[i][j];

            char rowChar = (char) ('A' + j);

            if (cell.hasMine() && cell.isVisible()) {
                System.out.print(Color.BOLD + Color.RED_BG + Color.BLACK + "  X  " + Color.RESET);
            } else if (!cell.hasMine() && cell.isVisible()) {
                if (cell.getMinesNearby() == 0) {
                    System.out.print(Color.BOLD + Color.GRAY + "  " + cell.getMinesNearby() + "  " + Color.RESET);
                } else if (cell.getMinesNearby() == 1) {
                    System.out.print(Color.BOLD + Color.GREEN + "  " + cell.getMinesNearby() + "  " + Color.RESET);
                } else if (cell.getMinesNearby() == 2) {
                    System.out.print(Color.BOLD + Color.BLUE + "  " + cell.getMinesNearby() + "  " + Color.RESET);
                } else if (cell.getMinesNearby() == 3) {
                    System.out.print(Color.BOLD + Color.RED + "  " + cell.getMinesNearby() + "  " + Color.RESET);
                } else if (cell.getMinesNearby() == 4) {
                    System.out.print(Color.BOLD + Color.PURPLE + "  " + cell.getMinesNearby() + "  " + Color.RESET);
                } else if (cell.getMinesNearby() >= 5) {
                    System.out.print(Color.BOLD + Color.CYAN + "  " + cell.getMinesNearby() + "  " + Color.RESET);
                }
            } else {
                System.out.print(Color.BOLD + Color.GRAY_BG + " " + rowChar + "-" + (i + 1) + " " + Color.RESET);
            }
        }
        System.out.println();
    }
}
}
