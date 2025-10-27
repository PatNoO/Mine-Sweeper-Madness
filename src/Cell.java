public class Cell {

    private boolean hasMine;
    private boolean isVisible;
    private boolean mineHit;
    private boolean mineAsFlag;
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

    public void isVisible(boolean visible) {
        this.isVisible = visible;
    }

    public int getMinesNearby() {
        return minesNearby;
    }

    public void setMinesNearby(int minesNearby) {
        this.minesNearby = minesNearby;
    }

    public boolean isMineHit() {
        return mineHit;
    }

    public void setMineHit(boolean mineHit) {
        this.mineHit = mineHit;
    }

    public boolean showMineAsFlag() {
        return mineAsFlag;
    }

    public void setMineAsFlag(boolean mineAsFlag) {
        this.mineAsFlag = mineAsFlag;
    }

    public Cell(boolean hasMine, boolean isVisible, int minesNearby) {
        this.hasMine = hasMine;
        this.isVisible = isVisible;
        this.minesNearby = minesNearby;
    }

    public String textAt(int row, int col) {

        char rowChar = (char) ('A' + col);

        if (this.hasMine() && this.isVisible()) {

            if (this.isMineHit()) {
                return Color.BOLD + Color.BRIGHT_RED_BG + Color.BLACK + "  X  " + Color.RESET;
            } else if (this.showMineAsFlag()) {
                return Color.BOLD + Color.GREEN_BG + Color.BLACK + "  F  " + Color.RESET;
            }
            return Color.BOLD + Color.ORANGE_BG + Color.BLACK + "  X  " + Color.RESET;

        } else if (this.showMineAsFlag()) {
            return Color.BOLD + Color.GREEN_BG + Color.BLACK +  " " + rowChar + ((row > 8) ? ("") : ("-")) + (row + 1) + " "  + Color.RESET;

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
            return Color.BOLD + Color.GRAY_BG + " " + rowChar + ((row > 8) ? ("") : ("-")) + (row + 1) + " " + Color.RESET;
        }
    }
}