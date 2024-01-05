package controleurs;

import java.util.*;

import ihm.IHMExport;
import ihm.IHMExportCSV;
import metier.GenerateurFichier;
import metier.GenerateurFichierCSV;
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

	public void setIHM(IHMExportCSV iHM) {
		IHM = iHM;
	}
	
	public void export(HistogrammeDiametre histo) {
		
	}
}