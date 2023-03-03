package simulation;

import Donnees.Donnees;
import Usines.Entrepot;
import Usines.Usine;

public class StrategieFixe implements Strategie{

    protected int interval;

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
