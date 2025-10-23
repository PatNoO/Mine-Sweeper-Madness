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

            return switch (this.getMinesNearby()) {
                case 0 -> Color.CHARCOAL_GRAY   + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 1 -> Color.GREEN           + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 2 -> Color.BLUE            + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 3 -> Color.RED             + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 4 -> Color.PURPLE          + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 5 -> Color.CYAN            + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 6 -> Color.ORANGE          + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 7 -> Color.HOT_PINK        + "  " + this.getMinesNearby() + "  " + Color.RESET;
                case 8 -> Color.BRIGHT_YELLOW   + "  " + this.getMinesNearby() + "  " + Color.RESET;
                default -> throw new IllegalStateException("Unexpected value: " + this.getMinesNearby());
            };

        } else {
            return Color.BOLD + Color.GRAY_BG + " " + rowChar + ((row>8) ? ("") : ("-")) + (row + 1) + " " + Color.RESET;
        }
    }
}