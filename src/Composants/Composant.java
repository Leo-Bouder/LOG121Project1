package Composants;

public class Composant {

    protected String path;
    public int posX;
    public int posY;

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
