package Usines;

import Composants.Composant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Usine aile.
 */
public class UsineAile extends Usine {

    /**
     * The Sortie composant.
     */
    protected List<Composant> sortieComposant;
    /**
     * The Interval production.
     */
    protected int intervalProduction;
    /**
     * The Construire.
     */
    protected boolean construire = false;
    /**
     * The Compteur metal.
     */
    protected int compteurMetal;

    /**
     * Instantiates a new Usine aile.
     *
     * @param posX               the pos x
     * @param posY               the pos y
     * @param id                 the id
     * @param map                the map
     * @param intervalProduction the interval production
     * @param con                the con
     */
    public UsineAile(int posX, int posY, int id, HashMap<String, String> map, int intervalProduction, boolean con) {
        super(posX, posY, id, map, con);
        this.intervalProduction = intervalProduction;
        this.sortieComposant = new ArrayList<>();
        //this.sortieComposant = new Aile("src/ressources/aile.png", posX, posY);
    }

    /**
     * Gets compteur metal.
     *
     * @return the compteur metal
     */
    public int getCompteurMetal() {
        return compteurMetal;
    }

    /**
     * Sets compteur metal.
     *
     * @param compteurMetal the compteur metal
     */
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
