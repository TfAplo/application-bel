package ihm;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import metier.GenerateurFichierCSV;

public class IHMExportCSV {
	@FXML
	 private Button export;
	@FXML
	private AnchorPane anchorMain;
	
	private Node statistiques;

	private VBox vbox;
	
	private boolean cocheStatistiques;
	
	public IHMExportCSV() {
	}
	
	@FXML
	 public void initialize() {
		 //Changer l'affichage du mainContainer quand on appuis sur les boutons
		 
		 //envoyer la recherche d'image au controleur
		 export.setOnAction(e -> export());
		 statistiques.addEventHandler(null, null);
		 //statistiques.setOnAction(e -> coche());
	 }
	
	public void export() {
		//récupération des statistiques
		GenerateurFichierCSV generateur = new GenerateurFichierCSV();
		generateur.creerFichier();
	}
	
	public void coche() {
		this.cocheStatistiques = !this.cocheStatistiques;
	}
	
	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}
	
	public void alimenterFenetre() {
		anchorMain.getChildren().add(vbox);
	}
	
	public void alimenterCheckBox() {
		ObservableList<Node> list = vbox.getChildren();
		for (Node node : list) {
			if(node.getId() == "statistiques") {
				this.statistiques = node;
			}
		}
	}
}
