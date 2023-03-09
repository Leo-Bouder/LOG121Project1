package Composants;

/**
 * The type Metal.
 */
public class Metal extends Composant{

    /**
     * Instantiates a new Metal.
     *
     * @param path  the path
     * @param x     the x
     * @param y     the y
     * @param angle the angle
     */
    public Metal(String path, int x, int y, double angle){
        super(path, angle);
        super.setPosX(x);
        super.setPosY(y);
    }
}
