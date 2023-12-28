package ihm;

import java.util.*;

import javafx.scene.control.Hyperlink;

/**
 * Cette classe implémente l'interface servant a rechercher une image.
 */
public class IHMRecherche {

    /**
     * Default constructor
     */
    public IHMRecherche() {
    }

    @FXML
    private Pane afficherResultatContainer;
    /**
     * affiche les images correspondent à la recherche qui sont presente dans la base de donnée.
     */
    public void afficherResultat(ArrayList<Image> listeImages) {
    	// On verifie que la liste ne soit pas vide 
    	if(!listeImages.isEmpty()) {
    		// liste non vide, on clear le container pour pouvoir mettre les nouveaux resultats correspondent 
    		afficherResultatContainer.getChildren().clear();
    		//parcourir la liste des images trouvé qui correspondent a la recherche.
        	for (Image image : listeImages) {
        		//pour chaque image on creer un Hyperlink fxml pour l'afficher et l'ajouter sur la fenetre
        		Hyperlink hyperlink = new Hyperlink(image.getNom());
        		hyperlink.setOnAction(e -> ouvrirImage(image.getUrl()));
        		
        		//ajouter le lien au container
        		afficherResultatContainer.getChildren().add(hyperlink);
        	}
    	} else {
    		// ici la liste est donc vide on peux clear le container
    		afficherResultatContainer.getChildren().clear();
    	}
    }
}