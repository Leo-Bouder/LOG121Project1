package Usines;

import simulation.Observateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Entrepot.
 */
public class Entrepot extends Usine{

    /**
     * The Interval production.
     */
    protected int intervalProduction = 0;
    /**
     * The List.
     */
    protected List<Usine> list;
    /**
     * The Capacite.
     */
    protected int capacite = 0;
    /**
     * The Construire.
     */
    protected boolean construire = false;
    /**
     * The Obs.
     */
    protected Observateur obs;


    /**
     * Instantiates a new Entrepot.
     *
     * @param posX the pos x
     * @param posY the pos y
     * @param id   the id
     * @param map  the map
     * @param con  the con
     */
    public Entrepot(int posX, int posY, int id,HashMap<String, String> map, boolean con) {
        super(posX, posY, id, map, con);
        this.list = new ArrayList<>();
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<Usine> getList() {
        return list;
    }

    /**
     * Sets obs.
     *
     * @param obs the obs
     */
    public void setObs(Observateur obs) {
        this.obs = obs;
    }

    /**
     * Gets interval production.
     *
     * @return the interval production
     */
    public int getIntervalProduction() {
        return intervalProduction;
    }

    /**
     * Gets capacite.
     *
     * @return the capacite
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * Sets capacite.
     *
     * @param capacite the capacite
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    /**
     * Sets interval production.
     *
     * @param intervalProduction the interval production
     */
    public void setIntervalProduction(int intervalProduction) {
        this.intervalProduction = intervalProduction;
    }

    /**
     * Icones string.
     *
     * @return the string
     */
    public String icones(){
        String string = " ";
        for(int i = 0; i < icones.size(); i++) {
            string += icones.size();
        }
        return string;
    }

    /**
     * Notify u.
     */
    public void notifyU(){
        obs.notifyU(this.capacite);
    }
}
