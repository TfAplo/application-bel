package metier;

import java.util.*;

/**
 * Classe representant une image. Elle contient les informations lui etant liees.
 */
public class Image {
    /**
     * ID de l'image dans la base de donnees.
     */
    public int idImage;

    /**
     * Nom du fichier de l'image.
     */
    public String nomFichier;

    /**
     * Largeur de l'image en pixel.
     */
    public int largeurPx;

    /**
     * Hauteur de l'image en pixel.
     */
    public int hauteurPx;

    /**
     * Grossissement du microscope lors de la prise de l'image.
     */
    public int grossissement;

    /**
     * Largeur réelle de l'image.
     */
    public double largeurImage;
    
    /*
     * emplacement de stockage de l'image
     */
    private String url;
    


	/**
     * Default constructor
     */
    public Image(int idImage, String nomFichier, int largeurPx, int hauteurPx, int grossissement, double largeurImage, String url) {
    	this.idImage = idImage;
    	this.nomFichier = nomFichier;
    	this.largeurPx = largeurPx;
    	this.hauteurPx = hauteurPx;
    	this.grossissement = grossissement;
    	this.largeurImage = largeurImage;
    	this.url = url;
    }
    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}




}