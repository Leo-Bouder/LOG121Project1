package Composants;

/**
 * The type Moteur.
 */
public class Moteur extends Composant{


    /**
     * Instantiates a new Moteur.
     *
     * @param path  the path
     * @param x     the x
     * @param y     the y
     * @param angle the angle
     */
    public Moteur(String path, int x ,int y, double angle){
        super(path, angle);
        super.setPosX(x);
        super.setPosY(y);
    }
}
