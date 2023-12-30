package metier;

import java.util.*;

/**
 * Permet l'instanciation de statistique d'une particule trouvée en analysant une image
 */
public class Statistique {
    private int idStatistique;
    private double surfaceParticulePx;
    private double coCointHautGaucheX;
    private double coCointHautGaucheY;
    private double coCointHautDroitX;
    private double coCointHautDroitY;
    private double coCentreX;
    private double coCentreY;
    private double orientation;
    private double longueurAxeMajeurPx;
    private double longueurAxeMineurPx;
    private double diametreEquivalentPx;
    
    /**
     * Default constructor
     */
    public Statistique(String[] stats) {
    	surfaceParticulePx = Double.parseDouble(stats[0]);
    	coCointHautGaucheX = Double.parseDouble(stats[1]);
    	coCointHautGaucheY = Double.parseDouble(stats[2]);
    	coCointHautDroitX = Double.parseDouble(stats[3]);
    	coCointHautDroitY = Double.parseDouble(stats[4]);
    	coCentreX = Double.parseDouble(stats[5]);
    	coCentreY = Double.parseDouble(stats[6]);
    	orientation = Double.parseDouble(stats[7]);
    	longueurAxeMajeurPx = Double.parseDouble(stats[8]);
    	longueurAxeMineurPx = Double.parseDouble(stats[9]);
    	diametreEquivalentPx = Double.parseDouble(stats[10]);
    }

	@Override
	public String toString() {
		return "Statistique [idStatistique=" + idStatistique + ", surfaceParticulePx=" + surfaceParticulePx
				+ ", coCointHautGaucheX=" + coCointHautGaucheX + ", coCointHautGaucheY=" + coCointHautGaucheY
				+ ", coCointHautDroitX=" + coCointHautDroitX + ", coCointHautDroitY=" + coCointHautDroitY
				+ ", coCentreX=" + coCentreX + ", coCentreY=" + coCentreY + ", orientation=" + orientation
				+ ", longueurAxeMajeurPx=" + longueurAxeMajeurPx + ", longueurAxeMineurPx=" + longueurAxeMineurPx
				+ ", diametreEquivalentPx=" + diametreEquivalentPx + "]";
	}

}