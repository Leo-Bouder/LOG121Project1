package Usines;

import simulation.Observateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Entrepot extends Usine{

    protected int intervalProduction = 0;
    protected List<Usine> list;
    protected int capacite = 0;
    protected boolean construire = false;
    protected Observateur obs;


    public Entrepot(int posX, int posY, int id,HashMap<String, String> map, boolean con) {
        super(posX, posY, id, map, con);
        this.list = new ArrayList<>();
    }

    public List<Usine> getList() {
        return list;
    }

    public void setObs(Observateur obs) {
        this.obs = obs;
    }

    public int getIntervalProduction() {
        return intervalProduction;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setIntervalProduction(int intervalProduction) {
        this.intervalProduction = intervalProduction;
    }

    public String icones(){
        String string = " ";
        for(int i = 0; i < icones.size(); i++) {
            string += icones.size();
        }
        return string;
    }

    public void notifyU(){
        obs.notifyU(this.capacite);
    }
}
