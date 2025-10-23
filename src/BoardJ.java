import java.util.ArrayList;
import java.util.Collections;

public class BoardJ {

    static ArrayList<Cell> mines = new ArrayList<>();
    static ArrayList<Cell> safeSpots = new ArrayList<>();

    ///  Creates the mines in an Array
    public static void createMines() {
        Cell cell = null;

        for (int i = 0; i < 8; i++) {
            cell = new Cell(true, false, 0);

            mines.add(cell);
        }
    }

    ///  Creates the safe spots in an Array
    public static void createSafeSpots() {
        Cell cell = null;

        for (int i = 0; i < 28; i++) {
            cell = new Cell(false, false, 0);

            safeSpots.add(cell);
        }
    }
    ///  Creates grid from two Arrays - mines and safe spots
    public static Cell[][] getAllCells() {

        createMines();
        createSafeSpots();

        ArrayList<Cell> allCells = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            allCells.add(BoardJ.mines.get(i));
        }

        for (int i = 0; i < 28; i++) {
            allCells.add(BoardJ.safeSpots.get(i));
        }

        Collections.shuffle(allCells);

        Cell[][] grid = new Cell[6][6];

        int a = 0;

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {

                grid[i][j] = allCells.get(a);
                a++;
            }
        }
        return grid;
    }
}
