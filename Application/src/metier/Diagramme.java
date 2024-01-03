package metier;

import java.util.*;

import javafx.scene.layout.AnchorPane;

/**
 * Permet la généralisation des différents diagrammes (Histogrammes et tableau)
 */
public abstract class Diagramme {

    /**
     * Default constructor
     */
    public Diagramme() {
    }
    
    public abstract void afficher(AnchorPane mainContainer);

}