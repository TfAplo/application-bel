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
import java.util.ArrayList;

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
	        ArrayList<CheckBox> listCh = new ArrayList<>();
	        if(IHM.histoSPresent()) {
				CheckBox ch1 = new CheckBox();
				CheckBox ch2 = new CheckBox();
				ch1.setId("statistiques");
				ch1.setText("Statistiques");
				ch2.setId("histogrammeSurface");
				ch2.setText("Histogramme de Surface");
				vbox.getChildren().addAll(ch1, ch2);
				listCh.add(ch1);
				listCh.add(ch2);
			}
			if(IHM.histoDPresent()) {
				CheckBox ch3 = new CheckBox();
				CheckBox ch4 = new CheckBox();
				ch3.setId("histogrammeSurfaceCumulatif");
				ch3.setText("Histogramme de Surface Cumulatif");
				ch4.setId("histogrammeDiametreEquivalent");
				ch4.setText("Histogramme de Diametre Equivalent");
				vbox.getChildren().addAll(ch3, ch4);
				listCh.add(ch3);
				listCh.add(ch4);
			}
			if(IHM.tabPresent()) {
				CheckBox ch5 = new CheckBox();
				ch5.setId("histogrammeDiametreEquivalentCumulatif");
				ch5.setText("Histogramme de Diametre Equivalent Cumulatif");
				vbox.getChildren().add(ch5);
				listCh.add(ch5);
			}
			/**
			CheckBox ch1 = new CheckBox();
			ch1.setId("statistiques");
			ch1.setText("Statistiques");
			CheckBox ch2 = new CheckBox();
			ch2.setId("histogrammeSurface");
			ch2.setText("Histogramme de Surface");
			CheckBox ch3 = new CheckBox();
			ch3.setId("histogrammeSurfaceCumulatif");
			ch3.setText("Histogramme de Surface Cumulatif");
			CheckBox ch4 = new CheckBox();
			ch4.setId("histogrammeDiametreEquivalent");
			ch4.setText("Histogramme de Diametre Equivalent");
			CheckBox ch5 = new CheckBox();
			ch5.setId("histogrammeDiametreEquivalentCumulatif");
			ch5.setText("Histogramme de Diametre Equivalent Cumulatif");
			vbox.getChildren().add(ch1);
			vbox.getChildren().add(ch2);
			vbox.getChildren().add(ch3);
			vbox.getChildren().add(ch4);
			vbox.getChildren().add(ch5);
			**/
			CtrlExportCSV.getIHM().setVbox(vbox);
			CtrlExportCSV.getIHM().alimenterFenetre();
			/**
			listCh.add(ch1);
			listCh.add(ch2);
			listCh.add(ch3);
			listCh.add(ch4);
			listCh.add(ch5);
			**/
			CtrlExportCSV.getIHM().alimenterCheckBox(listCh);
			CtrlExportCSV.getIHM().setHistoDiamBarChart(CtrlAnalyse.getIhm().getHistoDiam().getBc());
			CtrlExportCSV.getIHM().setHistoDiamCumBarChar(CtrlAnalyse.getIhm().getHistoDiam().getBcc());
			CtrlExportCSV.getIHM().setHistoSurfaceBarChar(CtrlAnalyse.getIhm().getHistoSurf().getBc());
			CtrlExportCSV.getIHM().setHistoDiamCumBarChar(CtrlAnalyse.getIhm().getHistoSurf().getBcc());
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
