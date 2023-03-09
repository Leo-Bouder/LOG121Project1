package Composants;

/**
 * The type Composant.
 */
public class Composant {

    /**
     * The Path.
     */
    protected String path;
    /**
     * The Pos x.
     */
    public int posX;
    /**
     * The Pos y.
     */
    public int posY;

    private double angle;

    /**
     * Gets angle.
     *
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets angle.
     *
     * @param angle the angle
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Instantiates a new Composant.
     *
     * @param path  the path
     * @param angle the angle
     */
    public Composant(String path, double angle){
        this.path = path;
        this.angle = angle;
    }

    /**
     * Get path string.
     *
     * @return the string
     */
    public String getPath(){
        return path;
    }

    /**
     * Gets pos x.
     *
     * @return the pos x
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Sets pos x.
     *
     * @param x the x
     */
    public void setPosX(int x) {
        posX = x;
    }

    /**
     * Gets pos y.
     *
     * @return the pos y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Sets pos y.
     *
     * @param y the y
     */
    public void setPosY(int y) {
        posY = y;
    }
}
