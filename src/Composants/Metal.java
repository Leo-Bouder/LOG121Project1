package Composants;

public class Metal extends Composant{

    public Metal(String path, int x, int y, double angle){
        super(path, angle);
        super.setPosX(x);
        super.setPosY(y);
    }
}
