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

    public int getMinesNearby() {
        return minesNearby;
    }

    public void setMinesNearby(int minesNearby) {
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
            if (this.getMinesNearby() == 0) {
                return Color.BOLD + Color.GRAY + "  " + this.getMinesNearby() + "  " + Color.RESET;
            } else if (this.getMinesNearby() == 1) {
                return Color.BOLD + Color.GREEN + "  " + this.getMinesNearby() + "  " + Color.RESET;
            } else if (this.getMinesNearby() == 2) {
                return Color.BOLD + Color.BLUE + "  " + this.getMinesNearby() + "  " + Color.RESET;
            } else if (this.getMinesNearby() == 3) {
                return Color.BOLD + Color.RED + "  " + this.getMinesNearby() + "  " + Color.RESET;
            } else if (this.getMinesNearby() == 4) {
                return Color.BOLD + Color.PURPLE + "  " + this.getMinesNearby() + "  " + Color.RESET;
            } else if (this.getMinesNearby() >= 5) {
                return Color.BOLD + Color.CYAN + "  " + this.getMinesNearby() + "  " + Color.RESET;
            }
        } else {
            return Color.BOLD + Color.GRAY_BG + " " + rowChar + ((row>8) ? ("") : ("-")) + (row + 1) + " " + Color.RESET;
        }
        return "";
    }
}