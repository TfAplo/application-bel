package ihm;

import java.util.*;

/**
 * La classe IHMExport représente une fenêtre d'exportation
 */
public class IHMExport 
{

    /**
     * Attribut privé correspondant à l'ensemble des histogrammes sélectionnés 
     */
    private int[] tabHisto;

    /**
     * Constructeur de la fenêtre d'exportation
     */
    public IHMExport() {
    }

    /**
     * Sélectionne les histogrammes à exporter
     *
     * @param tabHisto tableau des identifiants des histogrammes sélectionnés
     */
    public void selectHisto(int[] tabHisto) {
    }

    /**
     * Affiche une erreur en cas de problème, lorsque aucun histogramme n'est sélectionné ou lorsqu'il y'a une erreur lors de la création du fichier PNG
     */
    public void afficheErreur() {
    }

    /**
     * Valide le processus d'exportation
     */
    public void valideExport() {
    }
    
    /**
     * Getter de l'attribut tabHisto
     * @return tabHisto de type int[]
     */
	public int[] getTabHisto() {
		return tabHisto;
	}



    

}