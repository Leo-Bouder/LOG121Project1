package Donnees;

import Composants.Chemins;
import Usines.Usine;

import java.util.ArrayList;
import java.util.List;

public final class Donnees {

    private ArrayList<Usine> listeUsine = new ArrayList<>();
    private List<Chemins> listeChemins;
    private static Donnees instance;
    private String[] listIcones = new String[7];

    public static boolean init = false;

    public List<Usine> getListeUsine() {
        return this.listeUsine;
    }

    public void setInit(){
        this.init = true;
    }

    public boolean getInit(){
        return this.init;
    }

    public void setListeUsine(ArrayList<Usine> listeUsine) {
        this.listeUsine = listeUsine;
    }

    public List<Chemins> getListeChemins() {
        return listeChemins;
    }

    public void setListeChemins(List<Chemins> listeChemins) {
        this.listeChemins = listeChemins;
    }

    private Donnees(){
        this.listeChemins = new ArrayList<>();
    }

    public static Donnees getInstance(){
        if(instance == null){
            return new Donnees();
        }
        return instance;
    }


}
