package Usines;

import Composants.Composant;

import java.util.HashMap;
import java.util.List;

public class UsineMatiere extends Usine {


    protected int intervalProduction;
    protected boolean construire = true;
    public UsineMatiere(int posX, int posY, int id, HashMap<String, String> map, int intervalProduction, boolean con) {
        super(posX, posY, id, map, con);
        this.intervalProduction = intervalProduction;
        //this.sortieComposant = new Metal("src/ressources/metal.png", posX, posY);
    }

    public List<Composant> getSortieComposant() {
        return sortieComposant;
    }

    public int  getInterval(){
        return this.intervalProduction;
    }

    public void addHash(String type, String path){
        this.icones.put(type, path);
    }


}
