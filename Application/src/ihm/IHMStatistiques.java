package ihm;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import controleurs.ControleExport;
import metier.Diagramme;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import  javafx.event.ActionEvent;

/**
 * Vue permettant l'affichage des différents diagrammes souhaités pour afficher les statistiques, Propose aussi les différents boutons utiles à l'utilisateur
 */
public class IHMStatistiques extends Application {
	
 



    private ArrayList<Diagramme> listeDiagrammes;
    private int nbIntervalles;
    private ArrayList<String> listeAffichagesVoulus;
    private static ControleExport controleurExport;
    private IHMExport ihmExport;
	@FXML
	private BarChart histo1;
	@FXML
	private BarChart histo2;
	@FXML
	private BarChart histo3;
	@FXML
	private BarChart histo4;
	private static List<BarChart<String, Number>> listeHistogrammes = new ArrayList<>();
	 
	 
	public IHMStatistiques() {
	}
	 
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("IHMStats.fxml"));

        Scene scene = new Scene(root,600,400);  	     
        controleurExport = new ControleExport(this,listeHistogrammes);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(args);
 
		
    }
    
    /**
     * Gère l'événement de clic sur le bouton d'export
     */
    @FXML
    public void  boutonExport() {
    	controleurExport.boutonExport();
    }
    
    public void initialize() {

    	listeHistogrammes.clear();
	    listeHistogrammes.add(histo1);
	         
	    listeHistogrammes.add(histo2);
	    listeHistogrammes.add(histo3);
	    listeHistogrammes.add(histo4);

    }
    


    public ControleExport getControleurExport() {
        return controleurExport;
    }
    public IHMExport getIhmExport() {
        return ihmExport;
    }
    /**
     * Permet d'afficher les différents diagrammes de statistiques qui sont dans la liste listeDiagrammes
     */
    public void afficherDiagrammes() {
        // TODO implement here
    }

    /**
     * permet d'ajouter un diagramme dans la liste listeDiagrammes
     * @param diag Diagram à ajouter
     */
    public void ajouter(Diagramme diag) {
        // TODO implement here
    }

    /**
     * Permet d'afficher un formulaire demandant à l'utilisateur les diagrammes qu'il souhaite voir
     */
    public void afficherFormAffichages() {
        // TODO implement here
    }

    /**
     * Permet d'afficher un formulaire demandant à l'utilisateur le nombre d'intervalles qu'il souhaite voir dans les diagrammes
     */
    public void afficherFormNbIntervalles() {
        // TODO implement here
    }

    /**
     * Définit le nombre d'intervalles que comporteront les diagrammes
     * @return entier nombre souhaité
     */
    public int setNbIntervalles() {
        // TODO implement here
        return 0;
    }

    /**
     * Définit les différents diagrammes que l'on souhaitera afficher par la suite
     * @return liste des noms des diagrammes
     */
    public ArrayList<String> setAffichages() {
        // TODO implement here
        return null;
    }
    




}