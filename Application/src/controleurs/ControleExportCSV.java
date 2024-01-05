package controleurs;

import java.util.*;

import ihm.IHMExport;
import metier.GenerateurFichier;
import metier.GenerateurFichierCSV;
import metier.HistogrammeDiametre;

/**
 * La classe ControleExport gère le processus d'exportation des histogrammes au format CSV.
 */
public class ControleExportCSV {
    
    public ControleExportCSV() 
    {
    }

    /**
     * Gère l'action d'exportation statistiques.
     */
    public void main() {
        // TODO implement here
    }

	
	public void export() {
		//récupération des statistiques
		GenerateurFichierCSV generateur = new GenerateurFichierCSV();
		generateur.creerFichier();
	}
	
	public void export(HistogrammeDiametre histo) {
		
	}
}