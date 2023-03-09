package simulation;

import Composants.Chemins;
import Donnees.Donnees;
import Usines.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * The type Menu fenetre.
 */
public class MenuFenetre extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private static final String MENU_FICHIER_TITRE = "Fichier";
	private static final String MENU_FICHIER_CHARGER = "Charger";
	private static final String MENU_FICHIER_QUITTER = "Quitter";
	private static final String MENU_SIMULATION_TITRE = "Simulation";
	private static final String MENU_SIMULATION_CHOISIR = "Choisir";
	private static final String MENU_AIDE_TITRE = "Aide";
	private static final String MENU_AIDE_PROPOS = "� propos de...";
	private FenetrePrincipale fenetre;

	/**
	 * Instantiates a new Menu fenetre.
	 *
	 * @param fenetre the fenetre
	 */
	public MenuFenetre(FenetrePrincipale fenetre) {
		ajouterMenuFichier();
		ajouterMenuSimulation();
		ajouterMenuAide();
		this.fenetre = fenetre;
	}

	/**
	 * Cr�er le menu de Fichier
	 */
	private void ajouterMenuFichier() {
		JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
		JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER);
		JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);

		menuCharger.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("S�lectionnez un fichier de configuration");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Cr�er un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".xml", "xml");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// TODO - Parser le fichier XML s�lectionn�

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				try {

					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = db.parse(new File(path));
					doc.getDocumentElement().normalize();
					doc.getDocumentElement();

					ArrayList<Usine> listU = new ArrayList<>();
					//Pour rentrer dans la balise simulation
					NodeList nList = doc.getElementsByTagName("simulation");

					//Pour rentrer dans les balises usine dans la simulation
					Node nListU = nList.item(0);
					Element simulation = (Element) nListU;
					NodeList listUsine = simulation.getElementsByTagName("usine");

					//Pour rentrer dans les balises chemins
					Node nListChemins = nList.item(0);
					Element simulation2 = (Element) nListChemins;
					NodeList listChemins = simulation2.getElementsByTagName("chemin");

					//Pour selectionner la balise métadonnées
					NodeList meta = doc.getElementsByTagName("metadonnees");
					Node nListMat = meta.item(0);
					Element metaElem = (Element) nListMat;
					NodeList listUsineMeta =  metaElem.getElementsByTagName("usine");

					//Interval
					for(int i = 0; i < listUsine.getLength(); i++){

						Node nodeUsine = listUsine.item(i);
						Element usine = (Element) nodeUsine;
						//On récupère tous les attributs des usines dans la balise simulation
						String type = usine.getAttribute("type");
						String id = usine.getAttribute("id");
						String x = usine.getAttribute("x");
						String y = usine.getAttribute("y");
						int interval = 0;
						HashMap<String, String> map = new HashMap<>();
						if(type.equals("entrepot")){
							HashMap<String, String> hashMap = new HashMap<>();
							//Boucle pour récupérer les usines et leurs données
							for(int j = 0; j < listUsineMeta.getLength(); j++){
								Node nodeUsineMeta = listUsineMeta.item(j);
								Element usineMeta = (Element) nodeUsineMeta;
								String typeU = usineMeta.getAttribute("type");
								if(typeU.equals("entrepot")){
									NodeList iconeS = nodeUsineMeta.getChildNodes();
									Node listIcones = iconeS.item(1);
									Element iconesEl = (Element) listIcones;
									NodeList listIcone = iconesEl.getElementsByTagName("icone");

									//Boucle pour remplir la Hashmap avec les noms d'icônes et les path associés
									for(int h = 0; h < listIcone.getLength(); h++){
										Node nodeIcon = listIcone.item(h);
										Element iconEl = (Element) nodeIcon;
										hashMap.put(iconEl.getAttribute("type"), iconEl.getAttribute("path"));
									}
								}
							}
							//Création de l'objet Entrepôt
							Entrepot entrepot = new Entrepot(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(id), hashMap, false);
							listU.add(entrepot);
						}
						else if(type.equals("usine-matiere")){
							HashMap<String, String> hashMap = new HashMap<>();
							for(int j = 0; j < listUsineMeta.getLength(); j++){
								Node nodeUsineMeta = listUsineMeta.item(j);
								Element usineMeta = (Element) nodeUsineMeta;
								String typeU = usineMeta.getAttribute("type");
								if(typeU.equals("usine-matiere")){
									interval = Integer.parseInt(usineMeta.getElementsByTagName("interval-production").item(0).getTextContent());
									NodeList iconeS = nodeUsineMeta.getChildNodes();
									Node listIcones = iconeS.item(1);
									Element iconesEl = (Element) listIcones;
									NodeList listIcone = iconesEl.getElementsByTagName("icone");

									for(int h = 0; h < listIcone.getLength(); h++){
										Node nodeIcon = listIcone.item(h);
										Element iconEl = (Element) nodeIcon;
										hashMap.put(iconEl.getAttribute("type"), iconEl.getAttribute("path"));
									}
								}
							}
							UsineMatiere usineMatiere = new UsineMatiere(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(id), hashMap, interval, true);
							listU.add(usineMatiere);
						}
						else if(type.equals("usine-aile")){
							HashMap<String, String> hashMap = new HashMap<>();
							for(int j = 0; j < listUsineMeta.getLength(); j++){
								Node nodeUsineMeta = listUsineMeta.item(j);
								Element usineMeta = (Element) nodeUsineMeta;
								String typeU = usineMeta.getAttribute("type");
								if(typeU.equals("usine-aile")){
									NodeList icones = nodeUsineMeta.getChildNodes();
									interval = Integer.parseInt(usineMeta.getElementsByTagName("interval-production").item(0).getTextContent());
									Node listIcones = icones.item(1);
									Element iconesEl = (Element) listIcones;
									NodeList listIcone = iconesEl.getElementsByTagName("icone");
									for(int h = 0; h < listIcone.getLength(); h++){
										Node nodeIcon = listIcone.item(h);
										Element iconEl = (Element) nodeIcon;
										hashMap.put(iconEl.getAttribute("type"), iconEl.getAttribute("path"));
									}
								}
							}
							UsineAile usineAile = new UsineAile(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(id), hashMap, interval, false);
							listU.add(usineAile);
						}
						else if(type.equals("usine-assemblage")){
							HashMap<String, String> hashMap = new HashMap<>();
							for(int j = 0; j < listUsineMeta.getLength(); j++){
								Node nodeUsineMeta = listUsineMeta.item(j);
								Element usineMeta = (Element) nodeUsineMeta;
								String typeU = usineMeta.getAttribute("type");
								if(typeU.equals("usine-assemblage")){
									NodeList iconeS = nodeUsineMeta.getChildNodes();
									interval = Integer.parseInt(usineMeta.getElementsByTagName("interval-production").item(0).getTextContent());
									Node listIcones = iconeS.item(1);
									Element iconesEl = (Element) listIcones;
									NodeList listIcone = iconesEl.getElementsByTagName("icone");
									for(int h = 0; h < listIcone.getLength(); h++){
										Node nodeIcon = listIcone.item(h);
										Element iconEl = (Element) nodeIcon;
										hashMap.put(iconEl.getAttribute("type"), iconEl.getAttribute("path"));
									}
								}
							}
							Usine usineAssemblage = new UsineAssemblage(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(id), hashMap,interval, false);
							listU.add(usineAssemblage);
						}
						else if(type.equals("usine-moteur")){
							HashMap<String, String> hashMap = new HashMap<>();
							for(int j = 0; j < listUsineMeta.getLength(); j++){
								Node nodeUsineMeta = listUsineMeta.item(j);
								Element usineMeta = (Element) nodeUsineMeta;
								String typeU = usineMeta.getAttribute("type");
								if(typeU.equals("usine-moteur")){
									NodeList iconeS = nodeUsineMeta.getChildNodes();
									interval = Integer.parseInt(usineMeta.getElementsByTagName("interval-production").item(0).getTextContent());
									Node listIcones = iconeS.item(1);
									Element iconesEl = (Element) listIcones;
									NodeList listIcone = iconesEl.getElementsByTagName("icone");
									for(int h = 0; h < listIcone.getLength(); h++){
										Node nodeIcon = listIcone.item(h);
										Element iconEl = (Element) nodeIcon;
										hashMap.put(iconEl.getAttribute("type"), iconEl.getAttribute("path"));
									}
								}
							}
							Usine usineMoteur = new UsineMoteur(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(id), hashMap, interval, false);
							listU.add(usineMoteur);
						}
					}

					//Partie pour les chemins
					int x1 = 0;
					int x2 = 0;
					int y1 = 0;
					int y2 = 0;
					ArrayList<Chemins> listC = new ArrayList<>();

					//Boucle pour récupérer les chemins
					for(int i = 0; i < listChemins.getLength(); i++){
						Node nodeChemins = listChemins.item(i);
						Element cheminEl = (Element) nodeChemins;
						int de = Integer.parseInt(cheminEl.getAttribute("de"));
						int vers = Integer.parseInt(cheminEl.getAttribute("vers"));
						Chemins chemin = new Chemins();
						Donnees d = Donnees.getInstance();
						System.out.println(d.getListeUsine());
						for (Usine usine: listU) {
							//Récupérer la position de l'usine de départ
							if(de == usine.getId()){
								x1 = usine.getPosX();
								y1 = usine.getPosY();
								chemin.setX1(x1);
								chemin.setY1(y1);
							}
							//Récupérer la position de l'usine d'arrivée
							if(vers == usine.getId()){
								x2 = usine.getPosX();
								y2 = usine.getPosY();
								chemin.setX2(x2);
								chemin.setY2(y2);
							}
							//Vérification de la non nullité (vide ou pas) du chemin
							if((chemin.getX1() != 0) & (chemin.getX2() != 0) & (chemin.getY1() != 0) & (chemin.getY2() != 0)){
								listC.add(chemin);
							}
						}
					}
					//Création d'évenements pour passer les données à la fenêtre principale
					//System.out.println("Liste Usine : " +donnees.getListeUsine().toString());
					Donnees d = Donnees.getInstance();
					Observateur observateur = new Observateur();
					int idEntrepot = 0;
					for(int i = 0; i < listU.size(); i++){
						if(listU.get(i).getId() == 51){
							idEntrepot = i;
						}
					}
					for(Usine usine : listU){
						if(usine.getId() != 51){
							observateur.attach(usine);
						}
					}
					((Entrepot) listU.get(idEntrepot)).setObs(observateur);
					d.setListeUsine(listU);
					fenetre.propertyChange(new PropertyChangeEvent("PARSER", "ParserUsines", null, listU));
					fenetre.propertyChange(new PropertyChangeEvent("PARSER", "ParserChemins", null, listC));
				} catch (ParserConfigurationException ex) {
					throw new RuntimeException(ex);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				} catch (SAXException ex) {
					throw new RuntimeException(ex);
				}
				File selectedFile = fileChooser.getSelectedFile();
			}
		});
		
		menuQuitter.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});

		menuFichier.add(menuCharger);
		menuFichier.add(menuQuitter);

		add(menuFichier);

	}

	/**
	 * Cr�er le menu de Simulation
	 */
	private void ajouterMenuSimulation() {
		JMenu menuSimulation = new JMenu(MENU_SIMULATION_TITRE);
		JMenuItem menuChoisir = new JMenuItem(MENU_SIMULATION_CHOISIR);
		menuSimulation.add(menuChoisir);

		menuChoisir.addActionListener((ActionEvent e) -> {
			// Ouvrir la fen�tre de s�lection
			// TODO - R�cup�rer la bonne strat�gie de vente
			new FenetreStrategie();
		});
		add(menuSimulation);

	}

	/**
	 * Cr�er le menu Aide
	 */
	private void ajouterMenuAide() {
		JMenu menuAide = new JMenu(MENU_AIDE_TITRE);
		JMenuItem menuPropos = new JMenuItem(MENU_AIDE_PROPOS);
		menuAide.add(menuPropos);

		menuPropos.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(null,
					"<html><p>Application simulant une chaine de production d'avions.</p>" + "<br>"
							+ "<p>&copy; &nbsp; 2017 &nbsp; Ghizlane El Boussaidi</p>"
							+ "<p>&copy; &nbsp; 2017 &nbsp; Dany Boisvert</p>"
							+ "<p>&copy; &nbsp; 2017 &nbsp; Vincent Mattard</p>" + "<br>"
							+ "<p>&Eacute;cole de technologie sup&eacute;rieure</p></html>");
		});
		add(menuAide);
	}

}
