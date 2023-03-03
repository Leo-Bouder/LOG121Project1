package simulation;

import Composants.*;
import Donnees.Donnees;
import Usines.Entrepot;
import Usines.Usine;

import javax.swing.SwingWorker;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Environnement extends SwingWorker<Object, String> implements PropertyChangeListener {
	private boolean actif = true;
	private static final int DELAI = 5;
	private ArrayList<Usine> list = new ArrayList<>();
	private static int delai = 0;

	//private int cur = 0;

	@Override
	protected Object doInBackground() throws Exception {
		while(actif) {
			if(list != null){
				//Toutes les 5 millisecondes le programme reprend
				Thread.sleep(DELAI);
				//parcours de toutes les usines
				ArrayList<Usine> listUsine = Donnees.getInstance().getListeUsine();
				for(Usine usine : listUsine){
					//Toutes les x secondes, on crée un composant qu'on ajoute dans la liste de l'usine
					setIcones(usine, usine.getIntervalEnCours(), usine.getInterval());
						if(usine.getId() == 13 && usine.getUpdate()){
							usine.setPosXComposant(320);
							usine.setPosYComposant(352);
							usine.setDirection(2);
							double angle = Math.toRadians(Math.atan2(usine.getPosYComposant() - usine.getPosY(), usine.getPosXComposant() - usine.getPosX()));
							if((usine.getIntervalEnCours() >= usine.getInterval())){
								usine.addCompo(new Metal("src/ressources/metal.png", usine.getPosX(), usine.getPosY(), angle));
								usine.setIntervalEnCours(0);
							}
						}
						if(usine.getId() == 12 && usine.getUpdate()){
							usine.setPosXComposant(320);
							usine.setPosYComposant(352);
							usine.setDirection(0);
							double angle = Math.toRadians(Math.atan2(usine.getPosYComposant() - usine.getPosY(), usine.getPosXComposant() - usine.getPosX()));
							if((usine.getIntervalEnCours() >= usine.getInterval())){
								usine.addCompo(new Metal("src/ressources/metal.png", usine.getPosX(), usine.getPosY(), angle));
								usine.setIntervalEnCours(0);
							}
						}
						if(usine.getId() == 11 && usine.getUpdate()){
							usine.setPosXComposant(320);
							usine.setPosYComposant(32);
							usine.setDirection(0);
							double angle = Math.toRadians(Math.atan2(usine.getPosYComposant() - usine.getPosY(), usine.getPosXComposant() - usine.getPosX()));
							if((usine.getIntervalEnCours() >= usine.getInterval())){
								usine.addCompo(new Metal("src/ressources/metal.png", usine.getPosX(), usine.getPosY(), angle));
								usine.setIntervalEnCours(0);
							}
						}
						if(usine.getId() == 21 && usine.getUpdate()){
							usine.setPosXComposant(160);
							usine.setPosYComposant(192);
							usine.setDirection(2);
							double angle = Math.toRadians(Math.atan2(usine.getPosYComposant() - usine.getPosY(), usine.getPosXComposant() - usine.getPosX()));
							if((usine.getIntervalEnCours() >= usine.getInterval())){
								usine.addCompo(new Aile("src/ressources/aile.png", usine.getPosX(), usine.getPosY(), angle));
								usine.setIntervalEnCours(0);
								usine.setConstruire(false);
							}
						}
						if(usine.getId() == 31 && usine.getUpdate()){
							usine.setPosXComposant(160);
							usine.setPosYComposant(192);
							usine.setDirection(2);
							double angle = Math.toRadians(Math.atan2(usine.getPosYComposant() - usine.getPosY(), usine.getPosXComposant() - usine.getPosX()));
							if((usine.getIntervalEnCours() >= usine.getInterval())){
								usine.addCompo(new Moteur("src/ressources/moteur.png", usine.getPosX(), usine.getPosY(), angle));
								usine.setIntervalEnCours(0);
								usine.setConstruire(false);
							}
						}
						if(usine.getId() == 41 && usine.getUpdate()){
							usine.setPosXComposant(640);
							usine.setPosYComposant(192);
							usine.setDirection(0);
							double angle = Math.toRadians(Math.atan2(usine.getPosYComposant() - usine.getPosY(), usine.getPosXComposant() - usine.getPosX()));
							if((usine.getIntervalEnCours() >= usine.getInterval())){
								usine.addCompo(new Avion("src/ressources/avion.png", usine.getPosX(), usine.getPosY(), angle));
								usine.setIntervalEnCours(0);
								usine.setConstruire(false);
							}
						}
						if(usine.getId() == 51){
							usine.setDirection(0);
							Entrepot entrepot = (Entrepot) usine;
							if((entrepot.getCapacite() > 0) && (entrepot.getIntervalEnCours() >= entrepot.getInterval())){
								entrepot.setIntervalEnCours(0);
								entrepot.setCapacite(entrepot.getCapacite()-1);
								entrepot.notifyU();
							}
						}
						if(usine.isConstruire()){
							usine.setIntervalEnCours(usine.getIntervalEnCours()+1);
						}
				}
				Donnees.getInstance().setListeUsine(listUsine);
				;
				/**
				 * C'est ici que vous aurez � faire la gestion de la notion de tour.
				 */
				firePropertyChange("TEST", null, null);
			}
		}
		return null;
	}

	public void setIcones(Usine usine, int intervalEnCours, int intervalproduction){
		if(usine.getId() != 51){
			if(intervalEnCours >= intervalproduction){
				usine.setCurrentIcone(usine.getIcones().get("plein"));
			}
			else if(intervalEnCours >= intervalproduction*2/3){
				usine.setCurrentIcone(usine.getIcones().get("deux-tiers"));
			}
			else if(intervalEnCours >= intervalproduction/3){
				usine.setCurrentIcone(usine.getIcones().get("un-tiers"));
			}
			else {
				usine.setCurrentIcone(usine.getIcones().get("vide"));
			}
		}
		else if(usine.getId() == 51){
			Entrepot entrepot = (Entrepot) usine;
			if(entrepot.getCapacite() >= 5){
				usine.setCurrentIcone(usine.getIcones().get("plein"));
			}
			else if(entrepot.getCapacite() >= 5*2/3){
				usine.setCurrentIcone(usine.getIcones().get("deux-tiers"));
			}
			else if(entrepot.getCapacite() >= 5*1/3){
				usine.setCurrentIcone(usine.getIcones().get("un-tiers"));
			}
			else{
				usine.setCurrentIcone(usine.getIcones().get("vide"));
			}
		}

	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("usines")){
			list = (ArrayList<Usine>) evt.getNewValue();
		}
	}
}