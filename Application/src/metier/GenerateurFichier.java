package metier;

import java.awt.image.BufferedImage;

/**
 * La classe GenerateurFichier est responsable de la génération des fichiers PNG à partir des données d'histogrammes
 */
public class GenerateurFichier 
{

    /**
     * Atttibut privé correspondant à l'image du fichier généré au format BuferedImage
     */
    private BufferedImage fichier;

    /**
     * Constructeur du générateur de fichiers
     */
    public GenerateurFichier() {
    }

    /**
     * Crée le fichier PNG à partir des données d'histogrammes
     *
     * @return l'image du fichier généré au format BufferedImage
     */
    public BufferedImage creerFichier() {
        return null;
    }

    /**
     * Getter de l'attribut fichier
     * @return fichier de type BufferedImage
     */
	public BufferedImage getFichier() {
		return fichier;
	}

    
    
}