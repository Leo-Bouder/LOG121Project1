package simulation;

import Composants.Chemins;
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

	//private int cur = 0;

	@Override
	protected Object doInBackground() throws Exception {
		while(actif) {
			if(list != null){
				Thread.sleep(DELAI);
				/**
				 * C'est ici que vous aurez � faire la gestion de la notion de tour.
				 */
				System.out.println("Attention List : " + list.toString());
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