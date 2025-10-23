public class Cell {

    private boolean mine;

    private boolean visible;

    private int minesNearby;

    public Cell (boolean mine, boolean visible, int minesNearby) {
        this.mine = mine;
        this.visible = visible;
        this.minesNearby = minesNearby;

    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setMinesNearby(int minesNearby) {
        this.minesNearby = minesNearby;
    }

    public boolean hasMine() {
        return mine;
    }

    public boolean isVisible() {
        return visible;
    }

    public int getMinesNearby() {
        return minesNearby;
    }

}