package Composants;

/**
 * The type Avion.
 */
public class Avion extends Composant{


    /**
     * Instantiates a new Avion.
     *
     * @param path  the path
     * @param x     the x
     * @param y     the y
     * @param angle the angle
     */
    public Avion(String path, int x, int y, double angle){
        super(path, angle);
        super.setPosX(x);
        super.setPosY(y);
    }
}
