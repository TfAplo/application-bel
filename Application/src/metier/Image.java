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
    public String nomImage;
    
    /*
     * emplacement de stockage de l'image
     */
    private String url;

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
    public double largeurReel;
    
    /*
     * id de l'operateur qui a stocker l'image
     */
    public int idOperateur;
    
    /*
     * id du produit auquel cette image est associée
     */
    public int idProduit;

	/**
     * Default constructor
     */
    public Image(int idImage, String nomImage, String url, int largeurPx, int hauteurPx, int grossissement, double largeurReel, int idOperateur, int idProduit) {
    	this.idImage = idImage;
    	this.nomImage = nomImage;
    	this.url = url;
    	this.largeurPx = largeurPx;
    	this.hauteurPx = hauteurPx;
    	this.grossissement = grossissement;
    	this.largeurReel = largeurReel;
    	this.idOperateur = idOperateur;
    	this.idProduit = idProduit;
    	
    }

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getLargeurPx() {
		return largeurPx;
	}

	public void setLargeurPx(int largeurPx) {
		this.largeurPx = largeurPx;
	}

	public int getHauteurPx() {
		return hauteurPx;
	}

	public void setHauteurPx(int hauteurPx) {
		this.hauteurPx = hauteurPx;
	}

	public int getGrossissement() {
		return grossissement;
	}

	public void setGrossissement(int grossissement) {
		this.grossissement = grossissement;
	}

	public double getLargeurReel() {
		return largeurReel;
	}

	public void setLargeurReel(double largeurReel) {
		this.largeurReel = largeurReel;
	}

	public int getIdOperateur() {
		return idOperateur;
	}

	public void setIdOperateur(int idOperateur) {
		this.idOperateur = idOperateur;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
    
   



}