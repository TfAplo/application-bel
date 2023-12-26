package controleurs;

import java.util.*;

/**
 * Cette classe controle les autres. Elle instancie IHMDepot et DBImage.
 */
public class ControleDepot {

    /**
     * Default constructor
     */
    public ControleDepot() {
    }

    /**
     * Methode de lancement principale. Cette methode initialise tout, et sert a gerer les communications entre toutes les classes.
     */
    public void main() {
        // TODO implement here
    }

    /**
     * Methode pour deposer une image dans la base de donnees a partir des informations rentrees par l'operateur. Pour chaque image que l'operateur souhaite deposer, elle sera appeler.
     * @param nomOperateur Nom de la personne deposant l'image.
     * @param nomFichier Nom du fichier de l'image.
     * @param largeurPx Largeur de l'image en pixel.
     * @param hauteurPx Hauteur de l'image en pixel.
     * @param grossissement Grossissement du microscope lors de la prise de l'image.
     * @param largeurImage Largeur réelle de l'image.
     * @param nomProduit Nom du produit sur l'image.
     * @return Booleen qui indique si l'image a ete deposee dans la base de donnees ou non.
     */
    public Boolean deposerImage(String nomOperateur, String nomFichier, int largeurPx, int hauteurPx, int grossissement, double largeurImage, String nomProduit) {
        // TODO implement here
        return null;
    }

}