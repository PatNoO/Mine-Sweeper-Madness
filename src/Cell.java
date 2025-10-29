/**
 * Represents a single cell (tile) on the Minesweeper game board.
 * <p>
 * Each cell can:
 * - contain a mine or not
 * - be visible or hidden
 * - display how many mines are nearby
 * - be flagged by the player
 * - know if it was the mine and was hit
 * <p>
 * The class also handles how the cell is displayed in the console
 * using colored output via the {@code Color} class.
 */
public class Cell {

    /**
     * Is True if this cell contains a mine.
     */
    private boolean hasMine;
    /**
     * Is True if this cell has been revealed to the player.
     */
    private boolean isVisible;
    /**
     * True if this cell’s mine was the one that exploded.
     */
    private boolean mineHit;
    /**
     * True if the player has marked this cell with a flag.
     */
    private boolean mineAsFlag;
    /**
     * Number of mines in the surrounding cells.
     */
    private int minesNearby;

    /**
     * Constructs a cell with the given properties
     *
     * @param hasMine     whether this cell contains a mine
     * @param isVisible   whether the cell is revealed
     * @param minesNearby number of surrounding mines
     */
    public Cell(boolean hasMine, boolean isVisible, int minesNearby) {
        this.hasMine = hasMine;
        this.isVisible = isVisible;
        this.minesNearby = minesNearby;
    }

    /**
     * Returns a string representing this cell for display in the console
     *
     * @param row row index of the cell
     * @param col column index of the cell
     * @return colored string showing mine, flag, or number of nearby mines
     */
    public String textAt(int row, int col) {
        // * Convert column index to letter (0 -> A, 1 -> B, etc.)
        char colChar = (char) ('A' + col);

        if (this.hasMine() && this.isVisible()) {

            if (this.isMineHit()) {
                return Color.BOLD + Color.BRIGHT_RED_BG + Color.BLACK + "  X  " + Color.RESET;
            } else if (this.showMineAsFlag()) {
                return Color.BOLD + Color.ORANGE_BG + Color.BLACK + "  F  " + Color.RESET;
            }
            return Color.BOLD + Color.ORANGE_BG + Color.BLACK + "  X  " + Color.RESET;

        } else if (this.showMineAsFlag()) {

            return Color.BOLD + Color.BLUE_BG + Color.BLACK + " " + colChar + ((row > 8) ? ("") : ("-")) + (row + 1) + " " + Color.RESET;

        } else if (!this.hasMine() && this.isVisible()) {

            return switch (this.getMinesNearby()) {
                case 0 -> Color.DARK_GRAY_BG + Color.CHARCOAL_GRAY + "     " + Color.RESET;
                case 1 -> Color.DARK_GRAY_BG + Color.GREEN + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 2 -> Color.DARK_GRAY_BG + Color.BRIGHT_BLUE + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 3 -> Color.DARK_GRAY_BG + Color.RED + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 4 -> Color.DARK_GRAY_BG + Color.PURPLE + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 5 -> Color.DARK_GRAY_BG + Color.CYAN + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 6 -> Color.DARK_GRAY_BG + Color.ORANGE + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 7 -> Color.DARK_GRAY_BG + Color.HOT_PINK + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 8 -> Color.DARK_GRAY_BG + Color.BRIGHT_YELLOW + "  " + this.getMinesNearby() + "  " + Color.RESET;
                default -> throw new IllegalStateException("Unexpected value: " + this.getMinesNearby());
            };

        } else {
            return Color.BOLD + Color.GRAY_BG + Color.BRIGHT_WHITE + " " + colChar + ((row > 8) ? ("") : ("-")) + (row + 1) + " " + Color.RESET;
        }
    }

    /**
     * @return true if this cell contains a mine.
     */
    public boolean hasMine() {
        return hasMine;
    }

    /**
     * Sets whether this cell contains a mine.
     *
     * @param hasMine true if the cell should contain a mine
     */
    public void hasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    /**
     * @return true if this cell has been revealed.
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Sets whether this cell is visible (revealed) on the board.
     *
     * @param visible true if the cell should be visible
     */
    public void isVisible(boolean visible) {
        this.isVisible = visible;
    }

    /**
     * @return how many mines are in the neighboring cells.
     */
    public int getMinesNearby() {
        return minesNearby;
    }

    /**
     * Sets how many mines are near this cell.
     *
     * @param minesNearby number of surrounding mines
     */
    public void setMinesNearby(int minesNearby) {
        this.minesNearby = minesNearby;
    }

    /**
     * @return true if this mine was hit (player lost on this cell).
     */
    public boolean isMineHit() {
        return mineHit;
    }

    /**
     * Sets whether this mine was the one that exploded.
     *
     * @param mineHit true if this cell's mine was triggered
     */
    public void setMineHit(boolean mineHit) {
        this.mineHit = mineHit;
    }

    /**
     * @return true if this cell is flagged by the player.
     */
    public boolean showMineAsFlag() {
        return mineAsFlag;
    }

    /**
     * Sets whether this cell is marked with a flag by the player.
     *
     * @param mineAsFlag true if flagged
     */
    public void setMineAsFlag(boolean mineAsFlag) {
        this.mineAsFlag = mineAsFlag;
    }
}