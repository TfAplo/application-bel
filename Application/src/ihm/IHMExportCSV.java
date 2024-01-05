package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import metier.GenerateurFichierCSV;

public class IHMExportCSV {
	@FXML
	 private Button export;
	@FXML
	private CheckBox statistiques;
	
	private boolean cocheStatistiques;
	
	public IHMExportCSV() {
	}
	
	@FXML
	 public void initialize() {
		 //Changer l'affichage du mainContainer quand on appuis sur les boutons
		 
		 //envoyer la recherche d'image au controleur
		 export.setOnAction(e -> export());
		 
		 statistiques.setOnAction(e -> coche());
	 }
	
	public void export() {
		//récupération des statistiques
		GenerateurFichierCSV generateur = new GenerateurFichierCSV();
		generateur.creerFichier();
	}
	
	public void coche() {
		this.cocheStatistiques = !this.cocheStatistiques;
	}
}
