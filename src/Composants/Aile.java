package Composants;

public class Aile extends Composant{

    public Aile(String path, int x, int y, double angle){
        super(path, angle);
        super.setPosX(x);
        super.setPosY(y);
    }
}
