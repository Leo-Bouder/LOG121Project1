package simulation;

import Composants.Chemins;
import Usines.Usine;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Variables temporaires de la demonstration:
	private Point position = new Point(0,0);
	private Point vitesse = new Point(1,1);
	private int taille = 32;

	private ArrayList<Usine> list;
	private ArrayList<Chemins> listChemins;

	@Override
	public void paint(Graphics g) {
		try {
			if((this.list != null) & (this.listChemins != null)){

				//Créer l'image des usines
				super.paint(g);
				for (Chemins chemin : listChemins) {
					g.drawLine(chemin.getX1(), chemin.getY1(), chemin.getX2(), chemin.getY2());
				}
				for (Usine usine: list) {
					/*for (String key: usine.getIcones().keySet()) {
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
		} catch (IOException e) {
			throw new RuntimeException(e);
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