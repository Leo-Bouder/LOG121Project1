package Usines;

import Composants.Composant;
import Patrons.EventUsines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsineAssemblage extends Usine implements EventUsines {

    protected HashMap<Composant, Integer> sortie;
    protected List<Composant> sortieComposant;
    protected int intervalProduction;

    public UsineAssemblage(int posX, int posY, int id, HashMap<String, String> map, int intervalProduction) {
        super(posX, posY, id, map);
        this.intervalProduction = intervalProduction;
        this.sortie = new HashMap<>();
        this.sortieComposant = new ArrayList<>();
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

    public void addCompo(Composant composant){
        this.sortieComposant.add(composant);
    }

    public void removeCompo(Composant composant){
        this.sortieComposant.remove(composant);
    }
}
