package simulation;

import Composants.Chemins;
import Composants.Composant;
import Donnees.Donnees;
import Usines.Usine;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Variables temporaires de la demonstration:
	private Point position = new Point(0,0);
	private Point vitesse = new Point(5,5);
	private int taille = 32;

	private ArrayList<Usine> list;
	private ArrayList<Chemins> listChemins;

	@Override
	public void paint(Graphics g) {
			if((this.list != null) & (this.listChemins != null)){
				//Créer l'image des usines
				super.paint(g);
				paintChemins(g);
				try {
					paintComposants(g);
					paintUsines(g);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
	}

	public void paintChemins(Graphics g){
		for (Chemins chemin : this.listChemins) {
			g.drawLine(chemin.getX1(), chemin.getY1(), chemin.getX2(), chemin.getY2());
		}
	}

	public void paintComposants(Graphics g) throws IOException {
		ArrayList<Usine> listUsines = Donnees.getInstance().getListeUsine();
		for(Usine usine : listUsines){
			if((usine.getId() == 11) || (usine.getId() == 12) || (usine.getId() == 13)){
				//System.out.println(usine.getSortieComposant());
				System.out.println(usine.getId());
				if(usine.getSortieComposant() != null){
					for(Composant compo : usine.getSortieComposant()){
						System.out.println(compo.getPosX());
						String pathMetal = "src/ressources/metal.png";
						File metal = new File(pathMetal);
						BufferedImage IconMetal = ImageIO.read(metal);
						int posX = compo.getPosX();
						int posY = compo.getPosY();
						g.drawImage(IconMetal,posX,posY,null);
						compo.setPosX(posX+1);
						compo.setPosY(posY+1);
					}
				}

			}
			Donnees.getInstance().setListeUsine(listUsines);
		}
	}

	public void paintUsines(Graphics g) throws IOException {
		for (Usine usine: list) {
						/*for
							(String key: usine.getIcones().keySet()) {
							System.out.println("key : " + key);
							System.out.println("value : " + usine.getIcones().get(key));
						}
					 	*/
			//System.out.println("Intervalle usine : "+ usine.getClass() + " " + usine.getInterval());
			String path = usine.getIcones().get("vide");
			File file = usine.createFile(path);
			BufferedImage IconUsine = ImageIO.read(file);
			//Déssiner l'image de l'usine
			g.drawImage(IconUsine, usine.getPosX() - IconUsine.getWidth()/2, usine.getPosY() - IconUsine.getHeight()/2, null);
		}
	}

	public ArrayList<Chemins> getListChemins() {
		return listChemins;
	}

	public void setListChemins(ArrayList<Chemins> listChemins) {
		this.listChemins = listChemins;
	}

	public void create(ArrayList<Usine> listUsine){
		this.list = listUsine;
	}

	public void createChemins(ArrayList<Chemins> listChemins){
		this.listChemins = listChemins;
	}



}