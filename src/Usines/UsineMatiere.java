package Usines;

import Composants.Composant;
import Patrons.EventUsines;

import java.util.HashMap;

public class UsineMatiere extends Usine implements EventUsines {

    protected HashMap<Composant, Integer> sortie;
    protected int intervalProduction;
    public UsineMatiere(int posX, int posY, int id, HashMap<String, String> map, int intervalProduction) {
        super(posX, posY, id, map);
        this.intervalProduction = intervalProduction;
        this.sortie = new HashMap<>();
    }

    public int  getInterval(){
        return this.intervalProduction;
    }

    public void addHash(String type, String path){
        this.icones.put(type, path);
    }

    public void addComposant(Composant composant, int quantite){
        this.sortie.put(composant, quantite);
    }

}
