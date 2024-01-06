package controleurs;

import java.util.*;

import ihm.IHMStatistiques;

/**
 * Controleur permettant l'échange entre la vue IHMStatistiques et les différents models
 */
public class ControleAnalyse {


	private IHMStatistiques ihm;

    /**
     * Initialise un ensemble vide
     */
    public ControleAnalyse() {

    	ihm = new IHMStatistiques();
    }


    /**
     * Permet l'affichage des statistiques des images fournis en paramètres
     * @param images liste des images choisis pour afficher leurs statistiques
     */
    public void afficher(ArrayList<String> images) {
        // TODO implement here
    }

    /**
     * 
     */
    public void main() {
        // TODO implement here
    }
    
	public IHMStatistiques getIhm() {
		return ihm;
	}


}