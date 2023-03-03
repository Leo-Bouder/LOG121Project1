package Composants;

public class Composant {

    protected String path;
    public int posX;
    public int posY;

    private double angle;

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Composant(String path, double angle){
        this.path = path;
        this.angle = angle;
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
