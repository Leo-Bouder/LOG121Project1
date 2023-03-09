package Usines;

import Composants.Composant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Usine assemblage.
 */
public class UsineAssemblage extends Usine {

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
     * The Compteur moteur.
     */
    protected int compteurMoteur = 0;
    /**
     * The Compteur aile.
     */
    protected int compteurAile = 0;

    /**
     * Instantiates a new Usine assemblage.
     *
     * @param posX               the pos x
     * @param posY               the pos y
     * @param id                 the id
     * @param map                the map
     * @param intervalProduction the interval production
     * @param con                the con
     */
    public UsineAssemblage(int posX, int posY, int id, HashMap<String, String> map, int intervalProduction, boolean con) {
        super(posX, posY, id, map, con);
        this.intervalProduction = intervalProduction;
        this.sortieComposant = new ArrayList<>();
    }

    /**
     * Gets compteur moteur.
     *
     * @return the compteur moteur
     */
    public int getCompteurMoteur() {
        return this.compteurMoteur;
    }

    /**
     * Sets compteur moteur.
     *
     * @param compteurMoteur the compteur moteur
     */
    public void setCompteurMoteur(int compteurMoteur) {
        this.compteurMoteur = compteurMoteur;
    }

    /**
     * Gets compteur aile.
     *
     * @return the compteur aile
     */
    public int getCompteurAile() {
        return this.compteurAile;
    }

    /**
     * Sets compteur aile.
     *
     * @param compteurMetal the compteur metal
     */
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
