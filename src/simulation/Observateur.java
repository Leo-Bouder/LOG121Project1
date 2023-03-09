package simulation;

import Usines.Usine;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Observateur.
 */
public class Observateur {

    private List<Usine> listUsine;

    /**
     * Instantiates a new Observateur.
     */
    public Observateur(){
        this.listUsine = new ArrayList<>();
    }

    /**
     * Attach.
     *
     * @param usine the usine
     */
    public void attach(Usine usine){
        this.listUsine.add(usine);
    }

    /**
     * Dettach.
     *
     * @param usine the usine
     */
    public void dettach(Usine usine){
        this.listUsine.remove(usine);
    }

    /**
     * Notify u.
     *
     * @param cap the cap
     */
    public void notifyU(int cap){
        for(Usine usine : this.listUsine){
            usine.update(cap);
        }
    }
}
