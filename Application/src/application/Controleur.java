package application;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import des controleurs
import controleurs.ControleRecherche;


public class Controleur {
	

	 private ControleRecherche CtrlRecherche;
	 
	 @FXML
	 private TextField rechercher;
	 
	 
	 Controleur(ControleRecherche CtrlRecherche) {
		 this.CtrlRecherche = CtrlRecherche;
	 }
	 
	 @FXML
	 public void initialize() {
		 //envoyer la recherche d'image au controleur
		 rechercher.setOnAction(e -> CtrlRecherche.recherche(rechercher.getText()));
		 
		 
	 }
	
}
