package Usines;

import Composants.Composant;

import java.util.HashMap;
import java.util.List;

/**
 * The type Usine matiere.
 */
public class UsineMatiere extends Usine {


    /**
     * The Interval production.
     */
    protected int intervalProduction;
    /**
     * The Construire.
     */
    protected boolean construire = true;

    /**
     * Instantiates a new Usine matiere.
     *
     * @param posX               the pos x
     * @param posY               the pos y
     * @param id                 the id
     * @param map                the map
     * @param intervalProduction the interval production
     * @param con                the con
     */
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
