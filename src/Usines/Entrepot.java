package Usines;

import Composants.Avion;
import Patrons.EventManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Entrepot extends Usine{

    protected ArrayList<Avion> listeAvions;
    protected EventManager event;
    protected int capacite;


    public Entrepot(int posX, int posY, int id,HashMap<String, String> map ) {
        super(posX, posY, id, map);
        this.listeAvions = new ArrayList<>();
        this.capacite = 5;
    }

    public void notifyUsines(){
        this.event.notifyUsines();
    }

    public String icones(){
        String string = " ";
        for(int i = 0; i < icones.size(); i++) {
            string += icones.size();
        }
        return string;
    }
}
