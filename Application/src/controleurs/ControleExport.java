package controleurs;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

import metier.GenerateurFichier;
import ihm.IHMExport;
import ihm.IHMStatistiques;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * La classe ControleExport gère le processus d'exportation des histogrammes au format PNG.
 */
public class ControleExport extends Application{
	


     /**
     * Attribut privé de type FenetreExport
     */
    private static IHMExport fenetreExport;
	@FXML 
	private Button boutonExport;
	private BarChart histo1;
	private BarChart histo2;
	private BarChart histo3;
	private BarChart histo4;
	@FXML 
	private Scene nouvelleScene;
	@FXML 
	private Button retour;
	@FXML 
	private static Stage popupStage;
  	@FXML
    private VBox checkBoxContainer;
  	

  	
  	
	@FXML 
	private Button okExport;

    @FXML
    private Button boutonValider;
    private static IHMStatistiques ihmStatistiques;// = new IHMStatistiques();
    private int compteurExport=0;
    private static List<BarChart<String, Number>> listeHistogrammes = new ArrayList<>();
	


	/**
     * Attribut privé de type GenerateurFichier
     */
    private static GenerateurFichier generateurFichier;


  /**
     * Constructeur prenant en paramètre la fenêtre d'exportation et le générateur de fichiers.
     *
     * @param fenetreExport     la fenêtre d'exportation
     * @param generateurFichier le générateur de fichiers
     */
   /* public ControleExport(IHMExport fenetreExport, GenerateurFichier generateurFichier) {
        this.fenetreExport = fenetreExport;
        this.generateurFichier = generateurFichier;
    }*/
    
    public ControleExport(IHMStatistiques ihmStat, List<BarChart<String, Number>> listeHistogrammes) {
    	this.ihmStatistiques = ihmStat;
    	this.listeHistogrammes = listeHistogrammes;
    	//System.out.println("constructeur"+this.listeHistogrammes);
    }
    
    public ControleExport() {
    	this.generateurFichier = new GenerateurFichier(this);

	}

    /**
     * Gère l'action d'exportation des images.
     */
    public void main() {
        // TODO implement here
    }

    /**
     * Getter de l'attribut FenetreExport
     * @return fenetreExport
     */
    public IHMExport getFenetreExport() {
		return fenetreExport;
	}
    
    /**
     * Getter de l'attribut generateurFichier
     * @return generateurFichier
     */
	public GenerateurFichier getGenerateurFichier() 
	{
		return generateurFichier;
	}
	
	public Scene getNouvelleScene() {
		return nouvelleScene;
	}
	   /**
     * Gère l'événement de clic sur le bouton d'export
     */
    
    public void boutonExport(){
        
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../controleurs/IHMExport.fxml"));
                Parent nouvelleSceneParent = loader.load();
                ControleExport controleur = loader.getController();

	   	         
	   	         popupStage = new Stage();
	   	         popupStage.initModality(Modality.APPLICATION_MODAL);
	   	         popupStage.setTitle("Export d'Histogrammes");
	   	
	   	         // Créer une scène pour la nouvelle fenêtre
	   	         nouvelleScene = new Scene(nouvelleSceneParent);
	   	
	   	         // Mettre la nouvelle scène dans la fenêtre modale
	   	         popupStage.setScene(nouvelleScene);
	   	         CategoryAxis xAxis = new CategoryAxis();
	   	         NumberAxis yAxis = new NumberAxis();
	 
	   	         controleur.initialiser(listeHistogrammes);
    
	   	         ControleExport controleurExport = ihmStatistiques.getControleurExport();  
	   		
	   		     fenetreExport.setControleurExport(controleurExport);
	   	
	   	         // Afficher la fenêtre modale
	   	         popupStage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
	public void clearCheckBoxes() {
	    checkBoxContainer.getChildren().clear();
	}
	
	private void verifierCheckBox() {
	    for (Node node : checkBoxContainer.getChildren()) {
	        if (node instanceof CheckBox) {
	            CheckBox checkBox = (CheckBox) node;
	            BarChart<String, Number> histogramme = (BarChart<String, Number>) checkBox.getUserData();

	            // Affichage des données associées à chaque checkbox
	            System.out.println("Texte de la checkbox : " + checkBox.getText());
	            System.out.println("Données de l'histogramme associé : " + histogramme);
	        }
	    }
	}
	
	
	
	
	public void resetController() {
	    checkBoxContainer.getChildren().clear();
	    listeHistogrammes.clear();
	 
	}
	


	public void initialiser(List<BarChart<String, Number>> histogrammes) {
	    fenetreExport= new IHMExport(this);
	    fenetreExport.creerCheckBox(listeHistogrammes,checkBoxContainer);
	    boutonValider.setOnAction(event -> fenetreExport.exporterHistogrammesEnPNG(event,checkBoxContainer,popupStage));
	        
	  }
		
	  private File choisirDossierDeDestination() {
	   // Utilisation d'un FileChooser pour choisir un dossier de destination
		  FileChooser fileChooser = new FileChooser();
	      fileChooser.setTitle("Choisir un dossier de destination");
	      fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
	      fileChooser.setInitialFileName("histogrammes_exportes");

	      return fileChooser.showSaveDialog(null);
	  }
	  
	  @FXML
	  public void boutonValide() {
		 // boutonValider.setOnAction(event -> fenetreExport.exporterHistogrammesEnPNG(event,checkBoxContainer,popupStage));
		  
	  }
		
	  @FXML
	  public void boutonExportOk() {
			 Stage stage = (Stage) okExport.getScene().getWindow();
			 stage.close();
		}
	  @FXML
	  public void boutonRetour() {
		  Stage stage = (Stage) retour.getScene().getWindow();
		  stage.close();
		  checkBoxContainer.getChildren().clear(); // Efface tous les éléments actuels
		  listeHistogrammes.clear();
	}
	  
	   public int exporterHistogramme(BarChart<?, ?> histogramme, String cheminFichier,IHMExport ihmExport) {
	    	boolean res =generateurFichier.enregistrerHistogrammeEnPNG(histogramme, cheminFichier);
	    	
	        if (res) {
	        	compteurExport++;
	            System.out.println("Histogramme exporté en tant que PNG avec succès !");
	           // FenetreValideExport();
	        } else {
	            ihmExport.FenetreErreurExport();
	            return 0;
	        }
	        return compteurExport;
	    }  
	    
    	
		@Override
		public void start(Stage arg0) throws Exception {
			// TODO Auto-generated method stub
			
		}
	
	
	
	
	
	
	

	

}