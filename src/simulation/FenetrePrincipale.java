package simulation;

import Composants.Chemins;
import Usines.Usine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * The type Fenetre principale.
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 1 : LOG121 - Simulation";
	private static final Dimension DIMENSION = new Dimension(700, 700);


	/**
	 * The Panneau principal.
	 */
	PanneauPrincipal panneauPrincipal;

	/**
	 * Instantiates a new Fenetre principale.
	 */
	public FenetrePrincipale() {
		panneauPrincipal = new PanneauPrincipal();
		MenuFenetre menuFenetre = new MenuFenetre(this);
		add(panneauPrincipal);
		add(menuFenetre, BorderLayout.NORTH);
		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		// Rendre la fen�tre visible
		setVisible(true);
		// Mettre la fen�tre au centre de l'�cran
		setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		setResizable(false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("TEST")) {

			repaint();
			//System.out.println(evt.getNewValue());
		}
		if (evt.getPropertyName().equals("ParserUsines")){
			panneauPrincipal.create((ArrayList<Usine>) evt.getNewValue());
			firePropertyChange("usines", null, evt.getNewValue());
		}
		if(evt.getPropertyName().equals("ParserChemins")){
			panneauPrincipal.createChemins((ArrayList<Chemins>) evt.getNewValue());
		}
	}
}
