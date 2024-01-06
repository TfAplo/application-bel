package controleurs;

import java.util.*;

import metier.GenerateurFichier;
import ihm.IHMExport;

/**
 * La classe ControleExport gère le processus d'exportation des histogrammes au format PNG.
 */
public class ControleExport {

     /**
     * Attribut privé de type FenetreExport
     */
    private IHMExport fenetreExport;


	/**
     * Attribut privé de type GenerateurFichier
     */
    private GenerateurFichier generateurFichier;


  /**
     * Constructeur prenant en paramètre la fenêtre d'exportation et le générateur de fichiers.
     *
     * @param fenetreExport     la fenêtre d'exportation
     * @param generateurFichier le générateur de fichiers
     */
    public ControleExport() {
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

}