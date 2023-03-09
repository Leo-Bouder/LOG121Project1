package simulation;

import java.beans.PropertyChangeListener;

/**
 * The type Simulation.
 */
public class Simulation {

	/**
	 * Cette classe repr�sente l'application dans son ensemble.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		Environnement environnement = new Environnement();
		FenetrePrincipale fenetre = new FenetrePrincipale();
		fenetre.addPropertyChangeListener(environnement);
		environnement.addPropertyChangeListener(fenetre);
		environnement.execute();
	}
}
