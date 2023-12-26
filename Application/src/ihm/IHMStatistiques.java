package ihm;

import java.util.*;

import metier.Diagramme;

/**
 * Vue permettant l'affichage des différents diagrammes souhaités pour afficher les statistiques, Propose aussi les différents boutons utiles à l'utilisateur
 */
public class IHMStatistiques {


    public IHMStatistiques() {
    }

    private ArrayList<Diagramme> listeDiagrammes;
    private int nbIntervalles;
    private ArrayList<String> listeAffichagesVoulus;

    /**
     * Permet d'afficher les différents diagrammes de statistiques qui sont dans la liste listeDiagrammes
     */
    public void afficherDiagrammes() {
        // TODO implement here
    }

    /**
     * permet d'ajouter un diagramme dans la liste listeDiagrammes
     * @param diag Diagram à ajouter
     */
    public void ajouter(Diagramme diag) {
        // TODO implement here
    }

    /**
     * Permet d'afficher un formulaire demandant à l'utilisateur les diagrammes qu'il souhaite voir
     */
    public void afficherFormAffichages() {
        // TODO implement here
    }

    /**
     * Permet d'afficher un formulaire demandant à l'utilisateur le nombre d'intervalles qu'il souhaite voir dans les diagrammes
     */
    public void afficherFormNbIntervalles() {
        // TODO implement here
    }

    /**
     * Définit le nombre d'intervalles que comporteront les diagrammes
     * @return entier nombre souhaité
     */
    public int setNbIntervalles() {
        // TODO implement here
        return 0;
    }

    /**
     * Définit les différents diagrammes que l'on souhaitera afficher par la suite
     * @return liste des noms des diagrammes
     */
    public ArrayList<String> setAffichages() {
        // TODO implement here
        return null;
    }
    
    /**
     * Gère l'événement de clic sur le bouton d'export
     */
    public void boutonExport() {
    }

}