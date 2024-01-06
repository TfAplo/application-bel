package controleurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import dao.ParticuleDAO;
import metier.AnalyseImage;
import metier.EnsembleParticules;
import metier.Image;
import metier.Particule;

/**
 * Controleur permettant l'échange entre la vue IHMStatistiques et les différents models
 */
public class ControleAnalyse {
	private EnsembleParticules ensemble;
	private EnsembleParticules ensembleTemporaire;

    /**
     * Initialise un ensemble vide
     */
    public ControleAnalyse() {
    	ensemble = new EnsembleParticules();
    }

    /**
     * Permet l'affichage des particules des images fournis en paramètres
     * @param images liste des images choisis pour afficher leurs particules
     */
    public void afficher(ArrayList<Image> images) {
    	AnalyseImage analyseure = new AnalyseImage();
        for (Image image : images) {
        	//check si l'image à des particules
        	ParticuleDAO DBpart = new ParticuleDAO();
        	EnsembleParticules parts = DBpart.lire(image.getIdImage());
			if (!parts.estVide()) {
				//alimente ensemble avec les particules de la base
				ensemble.ajouterParticules(parts);
			}else {
				//analyse les images et les ajoutes à la base de donnée
				try {
					analyseure.executerScripts(image.getNomImage());
					lecteurCSV();
					DBpart.creer(image.getIdImage(), ensembleTemporaire);
				} catch (IOException e) {
					System.out.println("l'analyse de l'image: " + image + "a échoué");
					e.printStackTrace();
				}
			}
		}
        //affichage des diagrammes
    	
    }
    
    /**
     * permet de lire le fichier CSV donné par le script et de mettre ses données dans des objets Particule qui seront ensuite stockés dans EnsembleParticules
     * @throws IOException 
     */
    public void lecteurCSV() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\scriptsImages\\res\\out_data.csv"));
			String line;
			//premiere ligne n'est pas à stocker
			br.readLine();
			//lecture des lignes
			while((line = br.readLine()) != null) {
				Particule part = new Particule(line.split(","));
				this.ensembleTemporaire.ajouterParticule(part);
			}
    }
    
    public static void main(String[] args) {
    	
    }

}