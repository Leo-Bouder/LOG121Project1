package Patrons;

import Composants.Chemins;
import Usines.Usine;
import simulation.FenetrePrincipale;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {

    protected ArrayList<Usine> listeUsines;
    protected ArrayList<Chemins> listChemins;
    protected FenetrePrincipale fenetreP;

    public EventManager(FenetrePrincipale fenetre){
        this.listeUsines = new ArrayList<>();
        this.fenetreP = fenetre;
        this.listChemins = new ArrayList<>();
    }

    public void attach(Usine usine){
        this.listeUsines.add(usine);
    }

    public void attachChemins(Chemins chemin){
        this.listChemins.add(chemin);
    }

    public void dettach(Usine usine){
        this.listeUsines.remove(usine);
    }

    public void notifyUsines(){
        for (Usine usine: this.listeUsines) {
            usine.update();
        }
    }

    public ArrayList<Usine> getListeUsines(){
        fenetreP.propertyChange(new PropertyChangeEvent("eventManager", "ChargerFichier", null, null));
        return this.listeUsines;
    }

    public ArrayList<Chemins> getListChemins(){
        return this.listChemins;
    }

    @Override
    public String toString() {
        return "EventManager{" +
                "listeUsines=" + listeUsines +
                '}';
    }
}
