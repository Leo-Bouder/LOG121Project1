package simulation;

import Composants.Aile;
import Composants.Chemins;
import Composants.Composant;
import Composants.Moteur;
import Donnees.Donnees;
import Usines.*;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import static java.lang.Math.PI;
import static java.lang.Math.atan2;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Variables temporaires de la demonstration:
	private Point position = new Point(0,0);
	private int vitesse = 5;
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
			ArrayList<Composant> listeSuppression = new ArrayList<>();
			if((usine.getId() == 11) || (usine.getId() == 12) || (usine.getId() == 13) || (usine.getId() == 21) || (usine.getId() == 31) || (usine.getId() == 41) || (usine.getId()==51)){
				//System.out.println(usine.getSortieComposant());
				if(usine.getSortieComposant() != null){
					for(int j = 0; j < usine.getSortieComposant().size(); j++){
						Composant compo = usine.getSortieComposant().get(j);
						File metal = new File(compo.getPath());
						BufferedImage Icon = ImageIO.read(metal);
						int posX = compo.getPosX();
						int posY = compo.getPosY();
						g.drawImage(Icon,posX-(Icon.getWidth()/2),posY-(Icon.getHeight()/2),null);
						if(usine.getId() == 21){
							compo.setPosX((int) (posX + vitesse*Math.cos(Math.toDegrees(compo.getAngle())-0.0523599)));
							compo.setPosY((int) (posY + vitesse*Math.sin(Math.toDegrees(compo.getAngle())-0.0523599)));
						}
						else {
							compo.setPosX((int) (posX + vitesse*Math.cos(Math.toDegrees(compo.getAngle()))));
							compo.setPosY((int) (posY + vitesse*Math.sin(Math.toDegrees(compo.getAngle()))));
						}

						if((usine.getDirection() == 2 && compo.getPosX() < usine.getPosXComposant()) || (usine.getDirection() == 0 && compo.getPosX() > usine.getPosXComposant())){
							listeSuppression.add(compo);
							int idU = 0;
							for(int i = 0; i < list.size(); i++){
								if(usine.getPosXComposant() == list.get(i).getPosX() && usine.getPosYComposant() == list.get(i).getPosY()){
									idU = i;
								}
							}
							if(usine.getId() == 11){
								UsineAile aile = (UsineAile) listUsines.get(idU);
								aile.setCompteurMetal(aile.getCompteurMetal()+1);
								if(aile.getCompteurMetal() >= 2){
									aile.setConstruire(true);
									aile.setCompteurMetal(0);
								}
							}
							if(usine.getId() == 12 || usine.getId() == 13){
								UsineMoteur moteur = (UsineMoteur) listUsines.get(idU);
								moteur.setCompteurMetal(moteur.getCompteurMetal()+1);
								if(moteur.getCompteurMetal() >= 4){
									moteur.setConstruire(true);
									moteur.setCompteurMetal(0);
								}
							}
							if(usine.getId() == 21 || usine.getId() == 31){
								UsineAssemblage assemblage = (UsineAssemblage) listUsines.get(idU);
								if(compo.getPath().equals("src/ressources/aile.png")){
									assemblage.setCompteurAile(assemblage.getCompteurAile()+1);
								}
								else if(compo.getPath().equals("src/ressources/moteur.png")){
									assemblage.setCompteurMoteur(assemblage.getCompteurMoteur()+1);
								}
								if(assemblage.getCompteurAile() >=2 && assemblage.getCompteurMoteur() >= 4){
									assemblage.setConstruire(true);
									assemblage.setCompteurMoteur(0);
									assemblage.setCompteurAile(0);
								}
							}
							if(usine.getId()==41){
								Entrepot entrepot = (Entrepot) listUsines.get(idU);
								if((entrepot.getCapacite() < 5)){
									entrepot.setConstruire(true);
									entrepot.setCapacite(entrepot.getCapacite()+1);
								}
								entrepot.notifyU();
							}
						}
					}
					int i = 0;
					while(i < listeSuppression.size()){
						usine.getSortieComposant().remove(listeSuppression.get(i));
						i++;
					}
				}
			}
			Donnees.getInstance().setListeUsine(listUsines);
		}
	}

	public void paintUsines(Graphics g) throws IOException {
		for (Usine usine: list) {
			if(usine.getCurrentIcone() != null){
				File file = usine.createFile(usine.getCurrentIcone());
				BufferedImage IconUsine = ImageIO.read(file);
				//Déssiner l'image de l'usine
				g.drawImage(IconUsine, usine.getPosX() - IconUsine.getWidth()/2, usine.getPosY() - IconUsine.getHeight()/2, null);
			}
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