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

	

}