package controleurs;

import java.util.*;

import ihm.IHMExport;
import ihm.IHMExportCSV;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import metier.GenerateurFichier;
import metier.GenerateurFichierHistoCSV;
import metier.HistogrammeDiametre;

/**
 * La classe ControleExport gère le processus d'exportation des histogrammes au format CSV.
 */
public class ControleExportCSV {
    private IHMExportCSV IHM;
	
    public ControleExportCSV() 
    {
    	this.IHM = new IHMExportCSV();
    }
	
	public IHMExportCSV getIHM() {
		return IHM;
	}

	public void setIHM(IHMExportCSV IHM) {
		this.IHM = IHM;
	}
	
	
	
}