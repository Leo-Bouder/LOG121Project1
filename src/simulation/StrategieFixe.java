package simulation;

import Donnees.Donnees;
import Usines.Entrepot;
import Usines.Usine;

/**
 * The type Strategie fixe.
 */
public class StrategieFixe implements Strategie{

    /**
     * The Interval.
     */
    protected int interval;

    /**
     * Instantiates a new Strategie fixe.
     *
     * @param inter the inter
     */
    public StrategieFixe(int inter) {
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
