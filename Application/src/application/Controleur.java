package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
	 @FXML
	 private AnchorPane mainContainer;
	 @FXML
	 private Button DeposerImage;
	 @FXML
	 private Button afficherStats;
	 
	 Controleur(ControleRecherche CtrlRecherche, ControleAnalyse CtrlAnalyse, ControleDepot CtrlDepot, ControleExport CtrlExport) {
		 this.CtrlRecherche = CtrlRecherche;
		 this.CtrlAnalyse = CtrlAnalyse;
		 this.CtrlDepot = CtrlDepot;
		 this.CtrlExport = CtrlExport;
	 }
	 
	 @FXML
	 public void initialize() {
		 //Changer l'affichage du mainContainer quand on appuis sur les boutons
		 DeposerImage.setOnAction(e -> mainContainerDeposer());
		 afficherStats.setOnAction(e -> mainContainerAfficher());
		 
		 //envoyer la recherche d'image au controleur
		 rechercher.setOnAction(e -> CtrlRecherche.recherche(rechercher.getText(),afficherResultatContainer));
		  
	 }
	
	 public void mainContainerDeposer() {
		 // clear le container
		 mainContainer.getChildren().clear();
		 //hbox princiale
		 HBox main = new HBox();
		 main.setId("MainHox");
		 //partie deposer image
		 AnchorPane glisserDeposerImage = new AnchorPane();
		 glisserDeposerImage.setId("glisserDeposer");
		 AnchorPane.setTopAnchor(glisserDeposerImage, 0.0);
		 AnchorPane.setRightAnchor(glisserDeposerImage, 650.0);
		 AnchorPane.setLeftAnchor(glisserDeposerImage, 0.0);
		 Label GlisserText = new Label("Glisser votre image ici");
		 glisserDeposerImage.getChildren().add(GlisserText);
		 //ajout au container
		 mainContainer.getChildren().add(glisserDeposerImage);
		 
		 //partie de gauche
		 VBox vbox = new VBox();
		 AnchorPane.setLeftAnchor(vbox, 500.0);
		 AnchorPane.setRightAnchor(vbox, 0.0);
		 AnchorPane.setTopAnchor(vbox, 0.0);
		 
		 HBox hbox1 = new HBox();
		 Label op = new Label("Opérateur :");
		 TextField opT = new TextField();
		 opT.setPromptText("Opérateur");
		 hbox1.getChildren().add(op);
		 hbox1.getChildren().add(opT);
		 vbox.getChildren().add(hbox1);
		 
		 HBox hbox2 = new HBox();
		 Label op2 = new Label("Grossissement :");
		 TextField opT2 = new TextField();
		 opT2.setPromptText("Grossissement");
		 hbox2.getChildren().add(op2);
		 hbox2.getChildren().add(opT2);
		 vbox.getChildren().add(hbox2);
		 
		 HBox hbox3 = new HBox();
		 Label op3 = new Label("Largeur réelle :");
		 TextField opT3 = new TextField();
		 opT3.setPromptText("Largeur réelle");
		 hbox3.getChildren().add(op3);
		 hbox3.getChildren().add(opT3);
		 vbox.getChildren().add(hbox3);
		 
		 HBox hbox4 = new HBox();
		 Label op4 = new Label("Nom du Produit :");
		 TextField opT4 = new TextField();
		 opT4.setPromptText("Nom du Produit");
		 hbox4.getChildren().add(op4);
		 hbox4.getChildren().add(opT4);
		 vbox.getChildren().add(hbox4);
		 
		 Button Select = new Button();
		 Select.setText("Selectionner une image");
		 vbox.getChildren().add(Select);
		 
		 main.getChildren().add(vbox);
		 mainContainer.getChildren().add(vbox);
		 
		 
		 // partie du bas
		 Button valid = new Button();
		 valid.setText("Valider le dépôt");
		 valid.setLayoutY(580);
		 valid.setLayoutX(460);
		 
		 mainContainer.getChildren().add(valid);
	 }
	 
	 public void mainContainerAfficher() {
		// clear le container
		mainContainer.getChildren().clear();
	 }
}


