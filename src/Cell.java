public class Cell {

    private boolean hasMine;
    private boolean isVisible;
    private int minesNearby;


    public boolean hasMine() {
        return hasMine;
    }

    public void hasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void visible(boolean visible) {
        isVisible = visible;
    }

    public int minesNearby() {
        return minesNearby;
    }

    public void minesNearby(int minesNearby) {
        this.minesNearby = minesNearby;
    }

    public Cell(boolean hasMine, boolean isVisible, int minesNearby) {
        this.hasMine = hasMine;
        this.isVisible = isVisible;
        this.minesNearby = minesNearby;
    }

    public String textAt(int row, int col) {

        char rowChar = (char) ('A' + col);

        if (this.hasMine() && this.isVisible()) {
            return Color.BOLD + Color.RED_BG + Color.BLACK + "  X  " + Color.RESET;
        } else if (!this.hasMine() && this.isVisible()) {
            if (this.minesNearby() == 0) {
                return Color.BOLD + Color.GRAY + "  " + this.minesNearby() + "  " + Color.RESET;
            } else if (this.minesNearby() == 1) {
                return Color.BOLD + Color.GREEN + "  " + this.minesNearby() + "  " + Color.RESET;
            } else if (this.minesNearby() == 2) {
                return Color.BOLD + Color.BLUE + "  " + this.minesNearby() + "  " + Color.RESET;
            } else if (this.minesNearby() == 3) {
                return Color.BOLD + Color.RED + "  " + this.minesNearby() + "  " + Color.RESET;
            } else if (this.minesNearby() == 4) {
                return Color.BOLD + Color.PURPLE + "  " + this.minesNearby() + "  " + Color.RESET;
            } else if (this.minesNearby() >= 5) {
                return Color.BOLD + Color.CYAN + "  " + this.minesNearby() + "  " + Color.RESET;
            }
        } else {
            return Color.BOLD + Color.GRAY_BG + " " + rowChar + ((row>8) ? ("") : ("-")) + (row + 1) + " " + Color.RESET;
        }
        return "";
    }
}