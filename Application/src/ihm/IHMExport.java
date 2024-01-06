package ihm;

import java.io.File;

import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

import controleurs.ControleExport;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import metier.GenerateurFichier;

/**
 * La classe IHMExport représente une fenêtre d'exportation
 */
public class IHMExport 
{
    private static GenerateurFichier generateurFichier;
	private static ControleExport controleurExport;
	@FXML
    private VBox checkBoxContainer;
	//test 
  	@FXML
  	private VBox checkBoxContainer2;
	@FXML 
	private Button retour;
	@FXML 
	private Button okExport;
	@FXML
	private Button boutonValider;
	private int compteurCheckBox;
	private int compteurExport;
	private List<BarChart<String, Number>> listeHistogrammes; 

    private List<CheckBox> listeCheckBox = new ArrayList<>();

    
    
    public IHMExport(ControleExport controleur) {
    	this.controleurExport=controleur;
    }

    public void creerCheckBox(List<BarChart<String, Number>> listeHistogrammes,VBox checkBoxContainer) {
    	checkBoxContainer.getChildren().clear();
        int countCheckBoxes = 0; 

        for (int i = 0; i < listeHistogrammes.size(); i++) {
            BarChart<String, Number> histogramme = listeHistogrammes.get(i);
            CheckBox checkBox = new CheckBox(histogramme.getTitle());
            checkBox.setUserData(histogramme);
            checkBoxContainer.getChildren().add(checkBox); 
            countCheckBoxes++;
            checkBox.setMinWidth(150); 
        }
    	


    }
    
    public void exporterHistogrammesEnPNG(ActionEvent event,VBox checkBoxContainer,Stage popup) {
    	compteurCheckBox=0;
    	boolean isSelected = checkBoxContainer.getChildren().stream()
    	        .filter(node -> node instanceof CheckBox)
    	        .map(node -> (CheckBox) node)
    	        .anyMatch(CheckBox::isSelected);

    	if (!isSelected) {
    	    	
    	    afficherMessageAucuneSelection();
    	} else {
    	  
	    File selectedDirectory = choisirDossierDeDestination();
	
	    if (selectedDirectory != null) {
	        for (Node node : checkBoxContainer.getChildren()) {
	            if (node instanceof CheckBox) {
	                CheckBox checkBox = (CheckBox) node;
	                if (checkBox.isSelected()) {
	                	compteurCheckBox++;
	                    BarChart<?, ?> histogramme = (BarChart<?, ?>) checkBox.getUserData();
	                    String cheminFichier = selectedDirectory.getAbsolutePath()  + checkBox.getText() + ".png";
	                    compteurExport=controleurExport.exporterHistogramme(histogramme,cheminFichier,this);
	                    popup.close();
	                    
	               
	                }
	             }
	         }
	      }
       }
    	afficheFenetreValide();
    }	
    
    
    public void afficheFenetreValide() {
    	if (compteurExport==compteurCheckBox && compteurCheckBox != 0) {
    		FenetreValideExport(); 		
    	}
    }
    
    private File choisirDossierDeDestination() {
    	
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir un dossier de destination");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setInitialFileName("histogrammes_");
        return fileChooser.showSaveDialog(null); 
    }


    
    public void afficherMessageAucuneSelection() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aucune sélection");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner au moins un histogramme à exporter.");
        alert.showAndWait();
    }
    
    @FXML
    public void FenetreValideExport() {
    	openFXMLWindow("../application/IHMValideExport.fxml");  
    }
    
    @FXML
    public void FenetreErreurExport() {
    	openFXMLWindow("../application/IHMErreurExport.fxml");

    }
    
    public void openFXMLWindow(String fxmlFilePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	public Button getBoutonValider() {
		return boutonValider;
	}


	
   public void setControleurExport(ControleExport controleurExport) {
        this.controleurExport = controleurExport;
    }
	


}