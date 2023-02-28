package Composants;

public class Composant {

    protected String path;
    public static int posX;
    public static int posY;

    public Composant(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int x) {
        posX = x;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int y) {
        posY = y;
    }
}
