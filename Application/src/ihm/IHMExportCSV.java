package ihm;

import java.io.File;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import metier.GenerateurFichierCSV;
import metier.TabElement;

public class IHMExportCSV {
	@FXML
	private Button export;
	@FXML
	private Button retour;
	@FXML
	private AnchorPane anchorMain;

	private VBox vbox;
	
	private boolean valideStatistiques;
	private boolean valideHistogrammeSurface;
	private boolean valideHistogrammeSurfaceCumulatif;
	private boolean valideHistogrammeDiametreEquivalent;
	private boolean valideHistogrammeDiametreEquivalentCumulatif;
	
	private BarChart histoDiamBarChart;
	private BarChart histoDiamCumBarChar;
	private BarChart histoSurfaceBarChar;
	private BarChart histoSurfaceCumBarChar;
	
	private TableView<TabElement> statistiques;
	
	private GenerateurFichierCSV gen;

	public IHMExportCSV() {
		gen = new GenerateurFichierCSV();
	}
	
	@FXML
	 public void initialize() {
		 export.setOnAction(e -> export());
		 retour.setOnAction(e -> boutonRetour());
	 }
	
	
	
	@FXML
	  public void boutonRetour() {
		  Stage stage = (Stage) retour.getScene().getWindow();
		  stage.close();
	  }
	
	
	
	public void cocheStatistiques() {
		this.valideStatistiques = !this.valideStatistiques;
	}
	public void cocheHistogrammeSurface() {
		this.valideHistogrammeSurface = !this.valideHistogrammeSurface;
	}
	public void cocheHistogrammeSurfaceCumulatif() {
		this.valideHistogrammeSurfaceCumulatif = !this.valideHistogrammeSurfaceCumulatif;
	}
	public void cocheHistogrammeDiametreEquivalent() {
		this.valideHistogrammeDiametreEquivalent = !this.valideHistogrammeDiametreEquivalent;
	}
	public void cocheHistogrammeDiametreEquivalentCumulatif() {
		this.valideHistogrammeDiametreEquivalentCumulatif = !this.valideHistogrammeDiametreEquivalentCumulatif;
	}
	
	
	
	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}
	
	public void alimenterFenetre() {
		anchorMain.getChildren().add(vbox);
	}
	
	public void alimenterCheckBox(ArrayList<CheckBox> checkbox) {
		Insets insets = new Insets(10, 10, 10, 10);
		for (CheckBox CheckBox : checkbox) {
			CheckBox.setPadding(insets);
			if(CheckBox.getId() == "statistiques") {
				CheckBox.setOnAction(e -> cocheStatistiques());
			}
			if(CheckBox.getId() == "histogrammeSurface") {
				CheckBox.setOnAction(e -> cocheHistogrammeSurface());
			}
			if(CheckBox.getId() == "histogrammeSurfaceCumulatif") {
				CheckBox.setOnAction(e -> cocheHistogrammeSurfaceCumulatif());
			}
			if(CheckBox.getId() == "histogrammeDiametreEquivalent") {
				CheckBox.setOnAction(e -> cocheHistogrammeDiametreEquivalent());
			}
			if(CheckBox.getId() == "histogrammeDiametreEquivalentCumulatif") {
				CheckBox.setOnAction(e -> cocheHistogrammeDiametreEquivalentCumulatif());
			}
		}
	}
	
	

	public boolean isValideStatistiques() {
		return valideStatistiques;
	}

	public boolean isValideHistogrammeSurface() {
		return valideHistogrammeSurface;
	}

	public boolean isValideHistogrammeSurfaceCumulatif() {
		return valideHistogrammeSurfaceCumulatif;
	}

	public boolean isValideHistogrammeDiametreEquivalent() {
		return valideHistogrammeDiametreEquivalent;
	}

	public boolean isValideHistogrammeDiametreEquivalentCumulatif() {
		return valideHistogrammeDiametreEquivalentCumulatif;
	}
	
	
	
	public void setHistoDiamBarChart(BarChart barChart) {
		this.histoDiamBarChart = barChart;
	}
	
	public void setHistoDiamCumBarChar(BarChart barChart) {
		this.histoDiamCumBarChar = barChart;
	}
	
	public void setHistoSurfaceBarChar(BarChart barChart) {
		this.histoSurfaceBarChar = barChart;
	}
	
	public void setHistoSurfaceCumBarChar(BarChart barChart) {
		this.histoSurfaceCumBarChar = barChart;
	}
	
	public void setStatistiques(TableView<TabElement> statistiques) {
		this.statistiques = statistiques;
	}
	
	
	
	/**
     * methode ouvrant une nouvelle fenetre validant l'exportation
     */
    @FXML
    public void FenetreValideExport() {
    	openFXMLWindow("../application/IHMValideExport.fxml");  
    }
    
    /**
     * methode permettant d'ouvrir une nouvelle fenetre en fonction du chemin passé en paramètre
     * @param fxmlFilePath : chemin du fichier fxml
     */
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
	
    
    
    public File choisirDossierDeDestination() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir un dossier de destination");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        return fileChooser.showSaveDialog(null); 
    }
    
    
    
	public void export() {
		if(isValideHistogrammeDiametreEquivalent()) {
			exportHistogramme(this.histoDiamBarChart, "donneesHistoDiamEq.csv", "pourcentage de particule");
		}
		if (isValideHistogrammeDiametreEquivalentCumulatif()){
			exportHistogramme(this.histoDiamCumBarChar, "donneesHistoDiamEqCumulatif.csv", "pourcentage cumulatif de particule");
		}
		if(isValideHistogrammeSurface()) {
			exportHistogramme(this.histoSurfaceBarChar, "donneesHistoDiamSur.csv", "pourcentage de particule");
		}
		if(isValideHistogrammeSurfaceCumulatif()) {
			exportHistogramme(this.histoSurfaceCumBarChar, "donneesHistoDiamSurCumulatif.csv", "pourcentage cumulatif de particule");
		}
		if(isValideStatistiques()) {
			exportStatistiques(this.statistiques);
		}
		FenetreValideExport();
	}
	
	public void exportHistogramme(BarChart<String,Number> histo, String nom, String colonne) {
		ArrayList<String> intervalles = new ArrayList<>();
		ArrayList<Number> number = new ArrayList<>();
		ObservableList<Series<String, Number>> list = histo.getData();
		for (XYChart.Series<String, Number> chartSeries : histo.getData()) {
            for (XYChart.Data<String, Number> data : chartSeries.getData()) {
                String intervalle = data.getXValue();
                Number pourcentage = data.getYValue();
                intervalles.add(intervalle);
                number.add(pourcentage);
            }
        }
		ArrayList<Integer> numberEntier = new ArrayList<>();
		for (Number numberInInt : number) {
			int valeurEntiere = numberInInt.intValue();
			numberEntier.add(valeurEntiere);
		}
		gen.creerFichierHistoCSV(intervalles, numberEntier, nom, colonne);
	}
	
	public void exportStatistiques(TableView<TabElement> statistiques) {
		ArrayList<String> nomImage = new ArrayList<>();
		ArrayList<Double> grossissement = new ArrayList<>();
		ArrayList<Integer> nbParticuleTrouve = new ArrayList<>();
		ArrayList<Double> ratioSurfaceCouverte = new ArrayList<>();
		ArrayList<Double> moyenneAiresPx = new ArrayList<>();
		ArrayList<Double> moyenneDiametresEquivalentsPx = new ArrayList<>();
		ArrayList<Double> ecartTypeAiresPx = new ArrayList<>();
		ArrayList<Double> ecartTypeDiametreEquivalentPx = new ArrayList<>();
		ArrayList<Double> moyenneAires = new ArrayList<>();
		ArrayList<Double> moyenneDiametresEquivalents = new ArrayList<>();
		ArrayList<Double> ecartTypeAires = new ArrayList<>();
		ArrayList<Double> ecartTypeDiametreEquivalent = new ArrayList<>();
		for (TabElement element : statistiques.getItems()) {
			nomImage.add(element.getNomImage());
			grossissement.add(element.getGrossissement());
			nbParticuleTrouve.add(element.getNbParticulesTrouvees());
			ratioSurfaceCouverte.add(element.getRatioSurfaceCouverte());
			moyenneAiresPx.add(element.getMoyenneAiresPx());
			moyenneDiametresEquivalentsPx.add(element.getMoyenneDiametresEquivalentsPx());
			ecartTypeAiresPx.add(element.getEcartTypeAiresPx());
			ecartTypeDiametreEquivalentPx.add(element.getEcartTypeDiametreEquivalentPx());
			moyenneAires.add(element.getMoyenneAires());
			moyenneDiametresEquivalents.add(element.getMoyenneDiametresEquivalents());
			ecartTypeAires.add(element.getEcartTypeAires());
			ecartTypeDiametreEquivalent.add(element.getEcartTypeDiametreEquivalent());
        }
		gen.creerFichierStatistiquesCSV(nomImage, grossissement, nbParticuleTrouve, ratioSurfaceCouverte, moyenneAiresPx, moyenneDiametresEquivalentsPx, ecartTypeAiresPx, ecartTypeDiametreEquivalentPx, moyenneAires, moyenneDiametresEquivalents, ecartTypeAires, ecartTypeDiametreEquivalent);
	}
}