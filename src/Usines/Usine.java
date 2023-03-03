package Usines;

import Composants.Composant;
import simulation.Observer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usine implements Observer {

    protected int posX;
    protected int posY;
    protected int id;
    protected HashMap<Composant, Integer> entree;

    public HashMap<String, String> icones;

    protected ArrayList<Composant> sortieComposant;
    protected String currentIcone;

    protected int interval;
    protected int intervalEnCours;

    protected int posXComposant;
    protected int posYComposant;
    protected int direction;
    protected boolean construire;
    protected boolean update = true;
    protected String pathCourant;

    public Usine(int posX, int posY, int id, HashMap<String, String> map, boolean construire){
        this.posX = posX;
        this.posY = posY;
        this.id = id;
        this.entree = new HashMap<>();
        this.icones = map;
        this.sortieComposant = new ArrayList<>();
        this.construire = construire;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getPosXComposant() {
        return posXComposant;
    }

    public boolean isConstruire() {
        return construire;
    }

    public void setConstruire(boolean construire) {
        this.construire = construire;
    }

    public String getCurrentIcone() {
        return currentIcone;
    }

    public void setCurrentIcone(String currentIcone) {
        this.currentIcone = currentIcone;
    }

    public void setPosXComposant(int posXComposant) {
        this.posXComposant = posXComposant;
    }

    public int getPosYComposant() {
        return posYComposant;
    }

    public void setPosYComposant(int posYComposant) {
        this.posYComposant = posYComposant;
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

    public boolean getUpdate(){
        return this.update;
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

    @Override
    public void update(int capacite) {
        if(capacite < 3){
            this.setConstruire(true);
        }
        else if(capacite >= 5){
            this.setConstruire(false);
            this.sortieComposant = new ArrayList<>();
        }
    }
}
