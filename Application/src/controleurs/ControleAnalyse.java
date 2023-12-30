package controleurs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import metier.EnsembleStatistiques;
import metier.Statistique;

/**
 * Controleur permettant l'échange entre la vue IHMStatistiques et les différents models
 */
public class ControleAnalyse {
	private EnsembleStatistiques ensemble;

    /**
     * Initialise un ensemble vide
     */
    public ControleAnalyse() {
    	ensemble = new EnsembleStatistiques();
    }

    /**
     * Permet l'affichage des statistiques des images fournis en paramètres
     * @param images liste des images choisis pour afficher leurs statistiques
     */
    public void afficher(ArrayList<String> images) {
        // TODO implement here
    }
    
    /**
     * permet de lire le fichier CSV donné par le script et de mettre ses données dans des objets Statistique qui seront ensuite stockés dans EnsembleStatistiques
     * @throws IOException 
     */
    public void lecteurCSV() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\scriptsImages\\res\\out_data.csv"));
			String line;
			//premiere ligne n'est pas à stocker
			br.readLine();
			//lecture des lignes
			while((line = br.readLine()) != null) {
				Statistique stat = new Statistique(line.split(","));
				this.ensemble.ajouterStatistique(stat);
			}
    }
    
    public static void main(String[] args) {
    	
    }

}