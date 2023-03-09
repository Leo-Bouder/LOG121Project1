package Composants;

/**
 * The type Aile.
 */
public class Aile extends Composant{

    /**
     * Instantiates a new Aile.
     *
     * @param path  the path
     * @param x     the x
     * @param y     the y
     * @param angle the angle
     */
    public Aile(String path, int x, int y, double angle){
        super(path, angle);
        super.setPosX(x);
        super.setPosY(y);
    }
}
