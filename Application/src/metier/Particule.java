package metier;

import java.util.*;

/**
 * Permet l'instanciation de Particule trouvée en analysant une image
 */
public class Particule {
    private int idParticule;
    private double surfaceParticulePx;
    private double coCointHautGaucheX;
    private double coCointHautGaucheY;
    private double coCointHautDroitX;
    private double coCointHautDroitY;
    private double coCentreX;
    private double coCentreY;
    private double orientation;
    private double longueurAxeMajeur;
    private double longueurAxeMineur;
    private double diametreEquivalent;
    private int idImage;
    
    /**
     * Default constructor
     */
    public Particule(String[] attributs) {
    	surfaceParticulePx = Double.parseDouble(attributs[0]);
    	coCointHautGaucheX = Double.parseDouble(attributs[1]);
    	coCointHautGaucheY = Double.parseDouble(attributs[2]);
    	coCointHautDroitX = Double.parseDouble(attributs[3]);
    	coCointHautDroitY = Double.parseDouble(attributs[4]);
    	coCentreX = Double.parseDouble(attributs[5]);
    	coCentreY = Double.parseDouble(attributs[6]);
    	orientation = Double.parseDouble(attributs[7]);
    	longueurAxeMajeur = Double.parseDouble(attributs[8]);
    	longueurAxeMineur = Double.parseDouble(attributs[9]);
    	diametreEquivalent = Double.parseDouble(attributs[10]);
    }

	@Override
	public String toString() {
		return "Particule [idParticule=" + idParticule + ", surfaceParticulePx=" + surfaceParticulePx
				+ ", coCointHautGaucheX=" + coCointHautGaucheX + ", coCointHautGaucheY=" + coCointHautGaucheY
				+ ", coCointHautDroitX=" + coCointHautDroitX + ", coCointHautDroitY=" + coCointHautDroitY
				+ ", coCentreX=" + coCentreX + ", coCentreY=" + coCentreY + ", orientation=" + orientation
				+ ", longueurAxeMajeur=" + longueurAxeMajeur + ", longueurAxeMineur=" + longueurAxeMineur
				+ ", diametreEquivalent=" + diametreEquivalent + "]";
	}


    public int getIdParticule() {
		return idParticule;
	}

	public void setIdParticule(int idParticule) {
		this.idParticule = idParticule;
	}

	public double getSurfaceParticulePx() {
		return surfaceParticulePx;
	}

	public void setSurfaceParticulePx(double surfaceParticulePx) {
		this.surfaceParticulePx = surfaceParticulePx;
	}

	public double getCoCointHautGaucheX() {
		return coCointHautGaucheX;
	}

	public void setCoCointHautGaucheX(double coCointHautGaucheX) {
		this.coCointHautGaucheX = coCointHautGaucheX;
	}

	public double getCoCointHautGaucheY() {
		return coCointHautGaucheY;
	}

	public void setCoCointHautGaucheY(double coCointHautGaucheY) {
		this.coCointHautGaucheY = coCointHautGaucheY;
	}

	public double getCoCointHautDroitX() {
		return coCointHautDroitX;
	}

	public void setCoCointHautDroitX(double coCointHautDroitX) {
		this.coCointHautDroitX = coCointHautDroitX;
	}

	public double getCoCointHautDroitY() {
		return coCointHautDroitY;
	}

	public void setCoCointHautDroitY(double coCointHautDroitY) {
		this.coCointHautDroitY = coCointHautDroitY;
	}

	public double getCoCentreX() {
		return coCentreX;
	}

	public void setCoCentreX(double coCentreX) {
		this.coCentreX = coCentreX;
	}

	public double getCoCentreY() {
		return coCentreY;
	}

	public void setCoCentreY(double coCentreY) {
		this.coCentreY = coCentreY;
	}

	public double getOrientation() {
		return orientation;
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}

	public double getLongueurAxeMajeur() {
		return longueurAxeMajeur;
	}

	public void setLongueurAxeMajeur(double longueurAxeMajeur) {
		this.longueurAxeMajeur = longueurAxeMajeur;
	}

	public double getLongueurAxeMineur() {
		return longueurAxeMineur;
	}

	public void setLongueurAxeMineur(double longueurAxeMineur) {
		this.longueurAxeMineur = longueurAxeMineur;
	}

	public double getDiametreEquivalent() {
		return diametreEquivalent;
	}

	public void setDiametreEquivalent(double diametreEquivalent) {
		this.diametreEquivalent = diametreEquivalent;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

}