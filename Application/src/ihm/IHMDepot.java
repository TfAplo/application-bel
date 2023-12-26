package ihm;

import java.util.*;

/**
 * Cette classe implémente l'interface servant a deposer une image.
 */
public class IHMDepot {

    /**
     * Default constructor
     */
    public IHMDepot() {
    }

    /**
     * Nom de la personne deposant l'image.
     */
    private String nomOperateur;

    /**
     * Nom du fichier de l'image.
     */
    private String nomFichier;

    /**
     * Largeur de l'image en pixel.
     */
    private int largeurPx;

    /**
     * Hauteur de l'image en pixel.
     */
    private int hauteurPx;

    /**
     * Grossissement du microscope lors de la prise de l'image.
     */
    private int grossissement;

    /**
     * Largeur réelle de l'image.
     */
    private double largeurImage;

    /**
     * Nom du produit sur l'image.
     */
    private String nomProduit;

    /**
     * Affichage du visuel. A gauche de l'ecran : image a deposer; a droite de l'ecran : 4 champs de saisie. En bas de l'ecran : un bouton pour valider sa selection.
     */
    public void afficher() {
        // TODO implement here
    }

    /**
     * Affichage du message de la reussite ou de l'echec du depot de l'image.
     */
    public void afficherMesageDepot() {
        // TODO implement here
    }

}