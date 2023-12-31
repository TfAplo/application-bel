package application;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import controleurs.ControleAnalyse;
import controleurs.ControleDepot;
import controleurs.ControleExport;
//import des controleurs
import controleurs.ControleRecherche;


public class Controleur {
	
	 private ControleAnalyse CtrlAnalyse;
	 private ControleDepot CtrlDepot;
	 private ControleExport CtrlExport;
	 private ControleRecherche CtrlRecherche;
	 
	 @FXML
	 private TextField rechercher;
	 @FXML
	 private VBox afficherResultatContainer;
	 
	 Controleur(ControleRecherche CtrlRecherche, ControleAnalyse CtrlAnalyse, ControleDepot CtrlDepot, ControleExport CtrlExport) {
		 this.CtrlRecherche = CtrlRecherche;
		 this.CtrlAnalyse = CtrlAnalyse;
		 this.CtrlDepot = CtrlDepot;
		 this.CtrlExport = CtrlExport;
	 }
	 
	 @FXML
	 public void initialize() {
		 //envoyer la recherche d'image au controleur
		 rechercher.setOnAction(e -> CtrlRecherche.recherche(rechercher.getText(),afficherResultatContainer));
		  
	 }
	
}
