package application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import des controleurs
import controleurs.ControleRecherche;
import ihm.IHMStatistiques;

import java.io.IOException;

import controleurs.ControleAnalyse;
import controleurs.ControleDepot;
import controleurs.ControleExport;
import controleurs.ControleExportCSV;

public class Controleur {
	
	 private ControleAnalyse CtrlAnalyse;
	 private ControleDepot CtrlDepot;
	 private ControleExport CtrlExport;
	 private ControleRecherche CtrlRecherche;
	 private ControleExportCSV CtrlExportCSV;
	 
	 @FXML
	 private Button formulaireExportCSV;

	 @FXML
	 private Pane afficherResultatContainer;
	 
	 Controleur(ControleRecherche CtrlRecherche, ControleAnalyse CtrlAnalyse, ControleDepot CtrlDepot, ControleExport CtrlExport, ControleExportCSV CtrlExportCSV) {
		 this.CtrlRecherche = CtrlRecherche;
		 this.CtrlAnalyse = CtrlAnalyse;
		 this.CtrlDepot = CtrlDepot;
		 this.CtrlExport = CtrlExport;
		 this.CtrlExportCSV = CtrlExportCSV;
	 }
	 
	 @FXML
	 public void initialize() {
		 //Changer l'affichage du mainContainer quand on appuis sur les boutons
		 
		 //envoyer la recherche d'image au controleur
		 formulaireExportCSV.setOnAction(e -> afficherFormulaireCSV());
		  
	 }
	 
	 public void afficherFormulaireCSV() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PopUpExportCSV.fxml"));
         fxmlLoader.setController(CtrlExportCSV.getIHM());
		try {
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
	        stage.setTitle("Export au format CSV");
	        stage.setScene(new Scene(root1));
	        IHMStatistiques IHM = CtrlAnalyse.getIhm();
	        VBox vbox = new VBox();
	        if(IHM.histoSPresent()) {
				CheckBox ch1 = new CheckBox();
				CheckBox ch2 = new CheckBox();
				vbox.getChildren().addAll(ch1, ch2);
			}
			if(IHM.histoDPresent()) {
				CheckBox ch3 = new CheckBox();
				CheckBox ch4 = new CheckBox();
				vbox.getChildren().addAll(ch3, ch4);
			}
			if(IHM.tabPresent()) {
				CheckBox ch5 = new CheckBox();
				ch5.setId("statistiques");
				vbox.getChildren().add(ch5);
			}
			CheckBox ch1 = new CheckBox();
			ch1.setId("statistiques");
			ch1.setText("Statistiques");
			vbox.getChildren().add(ch1);
			CtrlExportCSV.getIHM().setVbox(vbox);
			CtrlExportCSV.getIHM().alimenterFenetre();
			CtrlExportCSV.getIHM().alimenterCheckBox();
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
