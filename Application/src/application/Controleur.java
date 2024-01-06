package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import metier.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
//import des controleurs
import controleurs.ControleRecherche;
import ihm.IHMStatistiques;
import controleurs.ControleAnalyse;
import controleurs.ControleDepot;
import controleurs.ControleExport;


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
	 @FXML
	 public VBox imageSelected;
	 @FXML
	 private Button btnValiderDepot;
	 @FXML
	 private Button btnSelectionImage;
	 @FXML
	 private TextField champOperateur;
	 @FXML
	 private TextField champGrossissement;
	 @FXML
	 private TextField champLargeurReel;
	 @FXML
	 private TextField champNomProduit;
	 @FXML
	 private Label LabelGlisserImage;
	 @FXML
	 private Label LabelNomImage;
	 @FXML
	 private Label LabelStatutDepot;
	 @FXML
	 private Rectangle RectangleStatutDepot;
	 @FXML
	 private AnchorPane glisserDeposer;
	 @FXML
	 private Button idAnalyser;
	 
	// Variable servant a plusieurs methodes
	private String nomImage;
	private String url;
	private double largeurPx;
	private double hauteurPx;
	private java.io.File selectedFile;
	 
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
		 idAnalyser.setOnAction(e -> afficherFormulaireAnalyse());
		 
		 //envoyer la recherche d'image au controleur
		 CtrlRecherche.recherche("",afficherResultatContainer,imageSelected);
		 rechercher.setOnAction(e -> CtrlRecherche.recherche(rechercher.getText(),afficherResultatContainer,imageSelected));
		  
		 glisserDeposer.setOnDragOver(e -> gestionnaireDragOver(e));
		 glisserDeposer.setOnDragDropped(e -> selectionImageParDrag(e));
		 btnSelectionImage.setOnAction(e -> selectionImageParBouton());
		 btnValiderDepot.setOnAction(e -> validerDepot());
		 
		 LabelNomImage.setVisible(false);
		 LabelStatutDepot.setVisible(false);
		 RectangleStatutDepot.setVisible(false);
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
			ScrollPane sp = new ScrollPane();
			VBox main = new VBox();
			sp.setContent(main);
			sp.setMaxSize(mainContainer.getWidth(), mainContainer.getHeight());
			sp.setPannable(true);
			sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
			ObservableList<Node> container = main.getChildren();
			CtrlAnalyse.getIhm().afficherDiagrammes(container);
			mainContainer.getChildren().add(sp);
		 }
	 
	 public void afficherEtDisparaitreStatutDepot() {
		 LabelStatutDepot.setVisible(true);
         RectangleStatutDepot.setVisible(true);
         
         // Créer une timeline pour déclencher l'action de suppression après 3 secondes
         Duration delay = Duration.seconds(5);
         KeyFrame keyFrame = new KeyFrame(delay, event -> {
             // Code à exécuter après le délai
        	 LabelStatutDepot.setVisible(false);
             RectangleStatutDepot.setVisible(false);
         });

         Timeline timeline = new Timeline(keyFrame);
         timeline.setCycleCount(1);
         timeline.play();
	 }
	 
	 private void validerDepot() {
		 String nomOperateur = champOperateur.getText();
		 String grossissement = champGrossissement.getText();
		 String largeurReel = champLargeurReel.getText();
		 String nomProduit = champNomProduit.getText();

		// si tous les champs sont bien remplis
		 if ((nomOperateur != null) && (nomImage != null) && (url != null) && (largeurPx != 0) && (hauteurPx != 0) && (grossissement != null) && (largeurReel != null) && (nomProduit != null) ) {
			 try {
				 Double grossissementDouble = Double.parseDouble(grossissement);
				 Double largeurReelDouble = Double.parseDouble(largeurReel);
				 
				 CtrlDepot.deposerImage(nomOperateur, nomImage, url,
						 largeurPx, hauteurPx, grossissementDouble, 
						 largeurReelDouble, nomProduit);
				 
				 // on remet tout de l'image selectionnee a zero
				 nomImage = null;
				 url = null;
	             largeurPx = 0;
	             hauteurPx = 0;
	             selectedFile = null;
	             
	             // faire disparaitre Label LabelNomImage
	             LabelNomImage.setVisible(false);
	             // vider le Label LabelNomImage
	             LabelNomImage.setText(null);
	             // faire apparaitre Label LabelGlisserImage
	             LabelGlisserImage.setVisible(true);
	             
	             // vider tous les champs
	             champOperateur.setText(null);
	             champGrossissement.setText(null);
	             champLargeurReel.setText(null);
	             champNomProduit.setText(null);
	             LabelStatutDepot.setText("L'image a bien été déposée dans la base de donnée.");
			 } catch (NumberFormatException e) {
				 LabelStatutDepot.setText("1Erreur - L'image n'a pas été déposée dans la base de donnée. Veillez à bien renseigner des informations correctes.");
			 }
		 } else {
			 LabelStatutDepot.setText("2Erreur - L'image n'a pas été déposée dans la base de donnée. Veillez à bien remplir tous les champs et à sélectionner une image.");
		 }
		 afficherEtDisparaitreStatutDepot();
	 }
	 
	 private void selectionImageParBouton() {
		 FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Sélectionner un fichier");

         // Affichage de la boîte de dialogue et recuperation de l'image selectionnee
         selectedFile = fileChooser.showOpenDialog(null);

         if (selectedFile != null && selectedFile.getName().toLowerCase().endsWith(".tif")) {
         	 nomImage = selectedFile.getName();
         	 url = selectedFile.getAbsolutePath();

         	 // modifie les variables largeurPx et hauteurPx avec la largeur et la hauteur de l'image
         	 calculerDimensionImage(url);
             
             // faire disparaitre Label LabelGlisserImage
             LabelGlisserImage.setVisible(false);
             // associer a Label LabelNomImage le nom de l'image selectionne
             LabelNomImage.setText(nomImage);
             // faire apparaitre Label LabelNomImage
             LabelNomImage.setVisible(true);
         }
	 }
	 
 	 private void gestionnaireDragOver(DragEvent event) {
        if (event.getGestureSource() != glisserDeposer && event.getDragboard().hasFiles()) {
        	List<File> files = event.getDragboard().getFiles();
            boolean contientFichierTif = files.stream().anyMatch(file -> file.getName().toLowerCase().endsWith(".tif"));
            if (contientFichierTif && files.size() == 1) {
                event.acceptTransferModes(TransferMode.COPY);
            }
        }
        event.consume();
    }
	 
	 private void selectionImageParDrag(DragEvent event) {
		 Dragboard db = event.getDragboard();
         boolean success = false;

         if (db.hasFiles()) {
             selectedFile = db.getFiles().get(0);

   	         if (selectedFile != null && selectedFile.getName().toLowerCase().endsWith(".tif")) {
   	        	 nomImage = selectedFile.getName();
   	         	 url = selectedFile.getAbsolutePath();
   	        	 
   	         	 // modifie les variables largeurPx et hauteurPx avec la largeur et la hauteur de l'image
   	         	calculerDimensionImage(url);
   	             
   	             // faire disparaitre Label LabelGlisserImage
   	             LabelGlisserImage.setVisible(false);
   	             // associer a Label LabelNomImage le nom de l'image selectionne
   	             LabelNomImage.setText(nomImage);
   	             // faire apparaitre Label LabelNomImage
   	             LabelNomImage.setVisible(true);
   	             success = true;
   	         }
         }
         event.setDropCompleted(success);
         event.consume();
	 }

	 private void calculerDimensionImage(String url) {
		 File fichierImage = new File(url);
		 try {
             BufferedImage image = ImageIO.read(fichierImage);

             largeurPx = image.getWidth();
             hauteurPx = image.getHeight();
         } catch (IOException e) {
             e.printStackTrace();
         }
	 }
	 
	 private void afficherFormulaireAnalyse() {
		 //affiche la popup
		try {
			CtrlAnalyse.setIhm(new IHMStatistiques());
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popUpAfficherStats.fxml"));
			fxmlLoader.setController(CtrlAnalyse.getIhm());
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Sélection des affichages souhaités");
			stage.setScene(new Scene(root1));
			stage.show();
			stage.setOnCloseRequest(e-> {
				if (CtrlAnalyse.getIhm().isAfficher()) {
					ArrayList<Image> l = new ArrayList<Image>();
					Image i1 = new Image("113.tif ","url", 50 ,50,50,50,10,20);
					i1.setIdImage(2);
					l.add(i1);
					i1.setIdImage(2);
					Image i2 =new Image("751.tif","url", 50,50,50,50,10,20);
					i2.setIdImage(3);
					l.add(i2);
					CtrlAnalyse.afficher(l);//CtrlRecherche.getListeImageSelectionner()
					mainContainer.getChildren().clear();
					ScrollPane sp = new ScrollPane();
					VBox main = new VBox();
					sp.setContent(main);
					sp.setMaxSize(mainContainer.getWidth(), mainContainer.getHeight());
					sp.setPannable(true);
					sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
					ObservableList<Node> container = main.getChildren();
					CtrlAnalyse.getIhm().afficherDiagrammes(container);
					mainContainer.getChildren().add(sp);
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



