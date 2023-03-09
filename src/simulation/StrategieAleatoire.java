package simulation;

import Donnees.Donnees;
import Usines.Entrepot;

/**
 * The type Strategie aleatoire.
 */
public class StrategieAleatoire implements Strategie{

    /**
     * The Interval.
     */
    protected int interval;

    /**
     * Instantiates a new Strategie aleatoire.
     *
     * @param inter the inter
     */
    public StrategieAleatoire(int inter){
        this.interval = inter;
    }


    @Override
    public void vente() {
        Donnees d = Donnees.getInstance();
        Entrepot entrepot = (Entrepot) d.getEntreprot();
        if(entrepot != null)
            entrepot.setInterval(this.interval);
    }
}
