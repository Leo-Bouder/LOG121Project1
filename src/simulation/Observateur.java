package simulation;

import Usines.Usine;

import java.util.ArrayList;
import java.util.List;

public class Observateur {

    private List<Usine> listUsine;

    public Observateur(){
        this.listUsine = new ArrayList<>();
    }

    public void attach(Usine usine){
        this.listUsine.add(usine);
    }

    public void dettach(Usine usine){
        this.listUsine.remove(usine);
    }

    public void notifyU(int cap){
        for(Usine usine : this.listUsine){
            usine.update(cap);
        }
    }
}
