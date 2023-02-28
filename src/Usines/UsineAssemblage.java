package Usines;

import Composants.Avion;
import Composants.Composant;
import Patrons.EventUsines;

import java.util.HashMap;

public class UsineAssemblage extends Usine implements EventUsines {

    protected HashMap<Composant, Integer> sortie;
    protected Composant sortieComposant;
    protected int intervalProduction;

    public UsineAssemblage(int posX, int posY, int id, HashMap<String, String> map, int intervalProduction) {
        super(posX, posY, id, map);
        this.intervalProduction = intervalProduction;
        this.sortie = new HashMap<>();
        this.sortieComposant = new Avion("src/ressources/avion.png", posX, posY);
    }

    public Composant getSortieComposant() {
        return sortieComposant;
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
