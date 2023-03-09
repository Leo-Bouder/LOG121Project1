package Composants;

/**
 * The type Chemins.
 */
public class Chemins {

    /**
     * The X 1.
     */
    public int x1;
    /**
     * The X 2.
     */
    public int x2;
    /**
     * The Y 1.
     */
    public int y1;
    /**
     * The Y 2.
     */
    public int y2;


    /**
     * Instantiates a new Chemins.
     *
     * @param x1 the x 1
     * @param x2 the x 2
     * @param y1 the y 1
     * @param y2 the y 2
     */
    public Chemins(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "Chemins{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                '}';
    }

    /**
     * Instantiates a new Chemins.
     */
    public Chemins(){

    }

    /**
     * Gets x 1.
     *
     * @return the x 1
     */
    public int getX1() {
        return x1;
    }

    /**
     * Sets x 1.
     *
     * @param x1 the x 1
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * Gets x 2.
     *
     * @return the x 2
     */
    public int getX2() {
        return x2;
    }

    /**
     * Sets x 2.
     *
     * @param x2 the x 2
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * Gets y 1.
     *
     * @return the y 1
     */
    public int getY1() {
        return y1;
    }

    /**
     * Sets y 1.
     *
     * @param y1 the y 1
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * Gets y 2.
     *
     * @return the y 2
     */
    public int getY2() {
        return y2;
    }

    /**
     * Sets y 2.
     *
     * @param y2 the y 2
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
}
