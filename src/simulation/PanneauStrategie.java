package simulation;

import Donnees.Donnees;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/**
 * The type Panneau strategie.
 */
public class PanneauStrategie extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Panneau strategie.
	 */
	public PanneauStrategie() {

		ButtonGroup groupeBoutons = new ButtonGroup();
		JRadioButton strategie1 = new JRadioButton("Stratégie 1");
		JRadioButton strategie2 = new JRadioButton("Stratégie 2");
		
		JButton boutonConfirmer = new JButton("Confirmer");

		boutonConfirmer.addActionListener((ActionEvent e) -> {
			// TODO - Appeler la bonne strat�gie
			System.out.println(getSelectedButtonText(groupeBoutons));
			// Fermer la fen�tre du composant
			SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
		});

		JButton boutonAnnuler = new JButton("Annuler");

		boutonAnnuler.addActionListener((ActionEvent e) -> {
			// Fermer la fen�tre du composant
			SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
		});

		groupeBoutons.add(strategie1);
		groupeBoutons.add(strategie2);		
		add(strategie1);
		add(strategie2);		
		add(boutonConfirmer);
		add(boutonAnnuler);

	}

	/**
	 * Retourne le bouton s�lectionn� dans un groupe de boutons.
	 *
	 * @param groupeBoutons the groupe boutons
	 * @return selected button text
	 */
	public String getSelectedButtonText(ButtonGroup groupeBoutons) {
		Donnees d = Donnees.getInstance();
		for (Enumeration<AbstractButton> boutons = groupeBoutons.getElements(); boutons.hasMoreElements();) {
			AbstractButton bouton = boutons.nextElement();
			if(!bouton.isSelected()){
				StrategieFixe strat = new StrategieFixe(1500);
				strat.vente();
			}
			if (bouton.isSelected()) {
				if(bouton.getText().equals("Stratégie 1")){
					StrategieFixe strat = new StrategieFixe(1500);
					strat.vente();
				}
				else if(bouton.getText().equals("Stratégie 2")){
					StrategieAleatoire strat = new StrategieAleatoire((int) (Math.random() * (120 - 70)) + 70);
					strat.vente();
				}
				return bouton.getText();
			}
		}
		return null;
	}

}
