package Usines;

import Composants.Composant;
import simulation.Observer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Usine.
 */
public class Usine implements Observer {

    /**
     * The Pos x.
     */
    protected int posX;
    /**
     * The Pos y.
     */
    protected int posY;
    /**
     * The Id.
     */
    protected int id;
    /**
     * The Entree.
     */
    protected HashMap<Composant, Integer> entree;

    /**
     * The Icones.
     */
    public HashMap<String, String> icones;

    /**
     * The Sortie composant.
     */
    protected ArrayList<Composant> sortieComposant;
    /**
     * The Current icone.
     */
    protected String currentIcone;

    /**
     * The Interval.
     */
    protected int interval;
    /**
     * The Interval en cours.
     */
    protected int intervalEnCours;

    /**
     * The Pos x composant.
     */
    protected int posXComposant;
    /**
     * The Pos y composant.
     */
    protected int posYComposant;
    /**
     * The Direction.
     */
    protected int direction;
    /**
     * The Construire.
     */
    protected boolean construire;
    /**
     * The Update.
     */
    protected boolean update = true;
    /**
     * The Path courant.
     */
    protected String pathCourant;

    /**
     * Instantiates a new Usine.
     *
     * @param posX       the pos x
     * @param posY       the pos y
     * @param id         the id
     * @param map        the map
     * @param construire the construire
     */
    public Usine(int posX, int posY, int id, HashMap<String, String> map, boolean construire){
        this.posX = posX;
        this.posY = posY;
        this.id = id;
        this.entree = new HashMap<>();
        this.icones = map;
        this.sortieComposant = new ArrayList<>();
        this.construire = construire;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Sets direction.
     *
     * @param direction the direction
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * Gets pos x composant.
     *
     * @return the pos x composant
     */
    public int getPosXComposant() {
        return posXComposant;
    }

    /**
     * Is construire boolean.
     *
     * @return the boolean
     */
    public boolean isConstruire() {
        return construire;
    }

    /**
     * Sets construire.
     *
     * @param construire the construire
     */
    public void setConstruire(boolean construire) {
        this.construire = construire;
    }

    /**
     * Gets current icone.
     *
     * @return the current icone
     */
    public String getCurrentIcone() {
        return currentIcone;
    }

    /**
     * Sets current icone.
     *
     * @param currentIcone the current icone
     */
    public void setCurrentIcone(String currentIcone) {
        this.currentIcone = currentIcone;
    }

    /**
     * Sets pos x composant.
     *
     * @param posXComposant the pos x composant
     */
    public void setPosXComposant(int posXComposant) {
        this.posXComposant = posXComposant;
    }

    /**
     * Gets pos y composant.
     *
     * @return the pos y composant
     */
    public int getPosYComposant() {
        return posYComposant;
    }

    /**
     * Sets pos y composant.
     *
     * @param posYComposant the pos y composant
     */
    public void setPosYComposant(int posYComposant) {
        this.posYComposant = posYComposant;
    }

    /**
     * Get sortie composant list.
     *
     * @return the list
     */
    public List<Composant> getSortieComposant(){
        return this.sortieComposant;
    }

    /**
     * Gets pos x.
     *
     * @return the pos x
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Set path.
     *
     * @param paht the paht
     */
    public void setPath(String paht){
        this.pathCourant = paht;
    }

    /**
     * Get path string.
     *
     * @return the string
     */
    public String getPath(){
        return this.pathCourant;
    }

    /**
     * Get interval int.
     *
     * @return the int
     */
    public int  getInterval(){
        return this.interval;
    }

    /**
     * Sets pos x.
     *
     * @param posX the pos x
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Gets pos y.
     *
     * @return the pos y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Sets pos y.
     *
     * @param posY the pos y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets entree.
     *
     * @return the entree
     */
    public HashMap<Composant, Integer> getEntree() {
        return entree;
    }

    /**
     * Add entree.
     *
     * @param composant the composant
     * @param i         the
     */
    public void addEntree(Composant composant, Integer i) {
        this.entree.put(composant, i);
    }

    /**
     * Get icones hash map.
     *
     * @return the hash map
     */
    public HashMap<String, String> getIcones(){
        return this.icones;
    }

    /**
     * Get update boolean.
     *
     * @return the boolean
     */
    public boolean getUpdate(){
        return this.update;
    }

    /**
     * Gets interval en cours.
     *
     * @return the interval en cours
     */
    public int getIntervalEnCours() {
        return intervalEnCours;
    }

    /**
     * Sets interval en cours.
     *
     * @param intervalEnCours the interval en cours
     */
    public void setIntervalEnCours(int intervalEnCours) {
        this.intervalEnCours = intervalEnCours;
    }

    /**
     * Add compo.
     *
     * @param composant the composant
     */
    public void addCompo(Composant composant){
        this.sortieComposant.add(composant);
    }

    /**
     * Remove compo.
     *
     * @param composant the composant
     */
    public void removeCompo(Composant composant){
        this.sortieComposant.remove(composant);
    }

    /**
     * Sets interval.
     *
     * @param interval the interval
     */
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

    /**
     * Add hash.
     *
     * @param type the type
     * @param path the path
     */
    public void addHash(String type, String path) {
        this.icones.put(type, path);
    }

    /**
     * Create file file.
     *
     * @param path the path
     * @return the file
     */
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
