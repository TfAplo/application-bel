package metier;

import java.text.DecimalFormat;
import java.util.*;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

/**
 * Permet l'affichage d'un histogrammes de diamètre et d'un histogramme de diamètre cumulatif
 */
public class HistogrammeDiametre extends Diagramme {
	private BarChart<String,Number> bc;
	private CategoryAxis xAxis;
	private NumberAxis yAxis;
    
    public HistogrammeDiametre() {
    	xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Histogramme des diamètres équivalents");
        xAxis.setLabel("diamètres");       
        yAxis.setLabel("Pourcentage de particules");
    }

    /**
     * Permet l'alimentation d'un histogramme de diamètre
     * @param particules  EnsembleParticules à afficher
	 * @param nbIntervalles int representant le nombre d'intervalles voulues
     */
    public void alimenterHistoDiametre(EnsembleParticules particules, int nbIntervalles) {
    	double min = particules.getMinDiametre(); double max = particules.getMaxDiametre();
    	double ecart = max-min;
    	double intervalle = ecart/nbIntervalles;
    	double[] tabIntervalles = new double[nbIntervalles];
    	double ints = 0;
    	int i =0;
    	while(i < nbIntervalles-1) {
    		ints += intervalle;
			tabIntervalles[i] = ints;
			i++;
    	}
    	tabIntervalles[i] = max;
    	ArrayList<Pair<String, Double>> l = new ArrayList<Pair<String, Double>>();
    	//permet d'arrondir la valeure pour faciliter la lecture du diagramme
    	DecimalFormat decimalFormat = new DecimalFormat("#.##");
    	l.add(new Pair<String, Double>("0-"+Double.parseDouble(decimalFormat.format(tabIntervalles[0])), 0.0));
    	for (int j = 1; j < nbIntervalles; j++) {
    		l.add(new Pair<String, Double>(Double.parseDouble(decimalFormat.format(tabIntervalles[j-1]))+"-"+decimalFormat.format(tabIntervalles[j]), 0.0));
		}
    	ArrayList<Particule> parts = particules.getListeParticules();
    	for (Particule p : parts) {
			for (int j = 0; j < nbIntervalles; j++) {
				if(p.getDiametreEquivalent() <= tabIntervalles[j]) {
					l.set(j, new Pair<String, Double>(l.get(j).getKey(), l.get(j).getValue()+ 1));
					break;
				}
			}
		}
    	XYChart.Series series1 = new XYChart.Series();
    	series1.setName("pourcentage de particules dans l'intervalle de diamètres");
    	for (Pair<String, Double> p : l) {
    		series1.getData().add(new XYChart.Data(p.getKey(),p.getValue() *100/particules.getNombreParticules()));
		}
    	bc.getData().add(series1);
    }

    /**
     * Permet l'alimentation d'un histogramme de diamètre cumulatif
     * @param particules EnsembleParticules à afficher
     */
    public void alimenterHistoDiametreCumu(EnsembleParticules particules) {
        // TODO implement here
    }
    
    /**
     * permet l'affichage des histogrammes de diamètres
     */
	@Override
	public void afficher(AnchorPane mainContainer) {
		mainContainer.getChildren().add(bc);
	}

}