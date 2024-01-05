package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import metier.GenerateurFichierCSV;

public class IHMExportCSV {
	@FXML
	 private Button export;
	
	public IHMExportCSV() {
	}
	
	@FXML
	 public void initialize() {
		 //Changer l'affichage du mainContainer quand on appuis sur les boutons
		 
		 //envoyer la recherche d'image au controleur
		 export.setOnAction(e -> export());
		  
	 }
	
	public void export() {
		//récupération des statistiques
		GenerateurFichierCSV generateur = new GenerateurFichierCSV();
		generateur.creerFichier();
	}
}
