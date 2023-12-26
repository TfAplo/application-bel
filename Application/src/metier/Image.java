package metier;

import java.util.*;

/**
 * Classe representant une image. Elle contient les informations lui etant liees.
 */
public class Image {

    /**
     * Default constructor
     */
    public Image() {
    }

    /**
     * ID de l'image dans la base de donnees.
     */
    public int idImage;

    /**
     * Nom du fichier de l'image.
     */
    public String nomFichier;

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
    public double largeurImage;

}