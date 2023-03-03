package simulation;

import Donnees.Donnees;
import Usines.Entrepot;

public class StrategieAleatoire implements Strategie{

    protected int interval;

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
