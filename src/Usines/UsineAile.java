package Usines;

import Composants.Composant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsineAile extends Usine {

    protected List<Composant> sortieComposant;
    protected int intervalProduction;
    protected boolean construire = false;
    protected int compteurMetal;

    public UsineAile(int posX, int posY, int id, HashMap<String, String> map, int intervalProduction, boolean con) {
        super(posX, posY, id, map, con);
        this.intervalProduction = intervalProduction;
        this.sortieComposant = new ArrayList<>();
        //this.sortieComposant = new Aile("src/ressources/aile.png", posX, posY);
    }

    public int getCompteurMetal() {
        return compteurMetal;
    }

    public void setCompteurMetal(int compteurMetal) {
        this.compteurMetal = compteurMetal;
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
