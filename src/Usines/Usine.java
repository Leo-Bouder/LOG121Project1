package Usines;

import Composants.Composant;
import Patrons.EventUsines;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usine implements EventUsines {

    protected int posX;
    protected int posY;
    protected int id;
    protected HashMap<Composant, Integer> entree;

    public HashMap<String, String> icones;

    protected ArrayList<Composant> sortieComposant;

    protected int interval;
    protected int intervalEnCours;



    protected String pathCourant;

    public Usine(int posX, int posY, int id, HashMap<String, String> map) {
        this.posX = posX;
        this.posY = posY;
        this.id = id;
        this.entree = new HashMap<>();
        this.icones = map;
        this.sortieComposant = new ArrayList<>();
    }

    public List<Composant> getSortieComposant(){
        return this.sortieComposant;
    }

    public int getPosX() {
        return posX;
    }

    public void setPath(String paht){
        this.pathCourant = paht;
    }

    public String getPath(){
        return this.pathCourant;
    }

    public int  getInterval(){
        return this.interval;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Composant, Integer> getEntree() {
        return entree;
    }

    public void addEntree(Composant composant, Integer i) {
        this.entree.put(composant, i);
    }

    public HashMap<String, String> getIcones(){
        return this.icones;
    }

    public void update() {

    }

    public int getIntervalEnCours() {
        return intervalEnCours;
    }

    public void setIntervalEnCours(int intervalEnCours) {
        this.intervalEnCours = intervalEnCours;
    }

    public void addCompo(Composant composant){
        this.sortieComposant.add(composant);
    }

    public void removeCompo(Composant composant){
        this.sortieComposant.remove(composant);
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "Usine{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", id=" + id +
                ", icones=" + icones +
                ", sortieComposant=" + sortieComposant +
                '}';
    }

    public void addHash(String type, String path) {
        this.icones.put(type, path);
    }

    public File createFile(String path){
        File file = new File(path);
        return file;
    }
}
