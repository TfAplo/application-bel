package metier;
import java.util.*;

/**
 * Cette classe est le résultat des images retournées en fonction de la recherche.
 */
public class ImageRecherche {

    /**
     * Default constructor
     */
    public ImageRecherche() {
    }

    /**
     *  Chaine de charactere qui contient le nom de l'image
     */
    public String nom;

    /**
     * Chaine de charactere qui contient l'emplacement de l'image
     */
    public String emplacement;

    /**
     * Booléen qui est à true si l'image est selectionner, sinon false
     */
    public boolean selection;

    /**
     * Change le status (booleen selection) de l'image
     * change à true si c'etait sur false, et inversement
     * @param image, nom de l'image 
     */
    public void ajoutImageSelectionner(String image) {
        // TODO implement here
    }

}