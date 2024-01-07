package ihm;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import metier.GenerateurFichierHistoCSV;

public class IHMExportCSV {
	@FXML
	 private Button export;
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
	
	private GenerateurFichierHistoCSV gen;

	public IHMExportCSV() {
	}
	
	@FXML
	 public void initialize() {
		 //Changer l'affichage du mainContainer quand on appuis sur les boutons
		 
		 //envoyer la recherche d'image au controleur
		 export.setOnAction(e -> export());
		 //statistiques.setOnAction(e -> coche());
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
		for (CheckBox checkBox2 : checkbox) {
			checkBox2.setPadding(insets);
			if(checkBox2.getId() == "statistiques") {
				checkBox2.setOnAction(e -> cocheStatistiques());
			}
			if(checkBox2.getId() == "histogrammeSurface") {
				checkBox2.setOnAction(e -> cocheHistogrammeSurface());
			}
			if(checkBox2.getId() == "histogrammeSurfaceCumulatif") {
				checkBox2.setOnAction(e -> cocheHistogrammeSurfaceCumulatif());
			}
			if(checkBox2.getId() == "histogrammeDiametreEquivalent") {
				checkBox2.setOnAction(e -> cocheHistogrammeDiametreEquivalent());
			}
			if(checkBox2.getId() == "histogrammeDiametreEquivalentCumulatif") {
				checkBox2.setOnAction(e -> cocheHistogrammeDiametreEquivalentCumulatif());
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
	
	
	
	public void export() {
		if (isValideHistogrammeDiametreEquivalentCumulatif()){
			exportHistogrammeDiametreEquivalentCumulatif(this.histoDiamCumBarChar);
		}
		//GenerateurFichierCSV generateur = new GenerateurFichierCSV();
		//generateur.creerFichier();
	}
	
	public void exportHistogrammeDiametreEquivalent(BarChart<String,Number> histo) {
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
		gen.creerFichierHistoCSV(intervalles, numberEntier);
	}
	
	public void exportHistogrammeDiametreEquivalentCumulatif(BarChart<String,Number> histo) {
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
		gen.creerFichierHistoCSV(intervalles, numberEntier);
	}
	
	public void exportHistogrammeSurface(BarChart<String,Number> histo) {
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
		gen.creerFichierHistoCSV(intervalles, numberEntier);
	}
	
	public void exportHistogrammeSurfaceCumulatif(BarChart<String,Number> histo) {
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
		gen.creerFichierHistoCSV(intervalles, numberEntier);
	}
}
