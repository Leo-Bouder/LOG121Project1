package Donnees;

import Composants.Chemins;
import Usines.Usine;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Donnees.
 */
public final class Donnees {

    private ArrayList<Usine> listeUsine = new ArrayList<>();
    private List<Chemins> listeChemins;
    private static Donnees instance = null;

    /**
     * Get instance donnees.
     *
     * @return the donnees
     */
    public static Donnees getInstance(){
        if(instance == null){
            instance = new Donnees();
        }
        return instance;
    }

    /**
     * Get list icones string [ ].
     *
     * @return the string [ ]
     */
    public String[] getListIcones() {
        return listIcones;
    }

    /**
     * Sets list icones.
     *
     * @param listIcones the list icones
     */
    public void setListIcones(String[] listIcones) {
        this.listIcones = listIcones;
    }

    /**
     * Get entreprot usine.
     *
     * @return the usine
     */
    public Usine getEntreprot(){
        for(Usine usine : listeUsine){
            if(usine.getId() == 51){
                return usine;
            }
        }
        return null;
    }

    private String[] listIcones = new String[7];

    /**
     * The constant init.
     */
    public static boolean init = false;

    /**
     * Gets liste usine.
     *
     * @return the liste usine
     */
    public ArrayList<Usine> getListeUsine() {
        return this.listeUsine;
    }

    /**
     * Set init.
     */
    public void setInit(){
        this.init = true;
    }

    /**
     * Get init boolean.
     *
     * @return the boolean
     */
    public boolean getInit(){
        return this.init;
    }

    /**
     * Sets liste usine.
     *
     * @param listeUsine the liste usine
     */
    public void setListeUsine(ArrayList<Usine> listeUsine) {
        this.listeUsine = listeUsine;
    }

    /**
     * Gets liste chemins.
     *
     * @return the liste chemins
     */
    public List<Chemins> getListeChemins() {
        return listeChemins;
    }

    /**
     * Sets liste chemins.
     *
     * @param listeChemins the liste chemins
     */
    public void setListeChemins(List<Chemins> listeChemins) {
        this.listeChemins = listeChemins;
    }

    private Donnees(){
        this.listeChemins = new ArrayList<>();
    }




}
