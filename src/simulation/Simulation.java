package simulation;

import java.beans.PropertyChangeListener;

public class Simulation {

	/**
	 * Cette classe repr�sente l'application dans son ensemble.
	 */
	public static void main(String[] args) {
		Environnement environnement = new Environnement();
		FenetrePrincipale fenetre = new FenetrePrincipale();
		fenetre.addPropertyChangeListener(environnement);
		environnement.addPropertyChangeListener(fenetre);
		environnement.execute();
	}
}
