package simulation;

import Composants.Chemins;
import Composants.Metal;
import Donnees.Donnees;
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
					if((usine.getIntervalEnCours() >= usine.getInterval())){
						if(usine.getId() == 13){
							usine.addCompo(new Metal("src/ressources/metal.png", usine.getPosX(), usine.getPosY()));
							usine.setIntervalEnCours(0);
						}
						if(usine.getId() == 12){
							usine.addCompo(new Metal("src/ressources/metal.png", usine.getPosX(), usine.getPosY()));
							usine.setIntervalEnCours(0);
						}
						if(usine.getId() == 11){
							//System.out.println("ici");
							usine.addCompo(new Metal("src/ressources/metal.png", usine.getPosX(), usine.getPosY()));
							usine.setIntervalEnCours(0);
						}
					}
					usine.setIntervalEnCours(usine.getIntervalEnCours()+1);
				}
				Donnees.getInstance().setListeUsine(listUsine);
				;
				/**
				 * C'est ici que vous aurez � faire la gestion de la notion de tour.
				 */
				//System.out.println("Attention List : " + list.toString());
				firePropertyChange("TEST", null, null);
			}
		}
		return null;
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("usines")){
			list = (ArrayList<Usine>) evt.getNewValue();
		}
	}
}