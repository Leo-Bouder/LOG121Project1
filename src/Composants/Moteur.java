package Composants;

public class Moteur extends Composant{


    public Moteur(String path, int x ,int y, double angle){
        super(path, angle);
        super.setPosX(x);
        super.setPosY(y);
    }
}
