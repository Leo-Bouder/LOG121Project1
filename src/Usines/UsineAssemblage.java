package Usines;

import Composants.Composant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsineAssemblage extends Usine {

    protected List<Composant> sortieComposant;
    protected int intervalProduction;
    protected boolean construire = false;
    protected int compteurMoteur = 0;
    protected int compteurAile = 0;

    public UsineAssemblage(int posX, int posY, int id, HashMap<String, String> map, int intervalProduction, boolean con) {
        super(posX, posY, id, map, con);
        this.intervalProduction = intervalProduction;
        this.sortieComposant = new ArrayList<>();
    }

    public int getCompteurMoteur() {
        return this.compteurMoteur;
    }

    public void setCompteurMoteur(int compteurMoteur) {
        this.compteurMoteur = compteurMoteur;
    }

    public int getCompteurAile() {
        return this.compteurAile;
    }

    public void setCompteurAile(int compteurMetal) {
        this.compteurAile = compteurMetal;
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
