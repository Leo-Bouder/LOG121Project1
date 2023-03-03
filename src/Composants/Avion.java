package Composants;

public class Avion extends Composant{


    public Avion(String path, int x, int y, double angle){
        super(path, angle);
        super.setPosX(x);
        super.setPosY(y);
    }
}
