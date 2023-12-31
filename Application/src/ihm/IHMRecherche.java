package ihm;

import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;

import metier.ImageRecherche;
import metier.Image;

/**
 * Cette classe implémente l'interface servant a rechercher une image.
 */
public class IHMRecherche {

    /**
     * Default constructor
     */
    public IHMRecherche() {
    }
    
    /*
     * Container : contient toutes images que l'on souhaite afficher 
     */
    @FXML
    private Pane afficherResultatContainer;
    /**
     * affiche les images correspondent à la recherche qui sont presente dans la base de donnée.
     */
    public void afficherResultat(ArrayList<Image> listeImage) {
    	// On verifie que la liste ne soit pas vide 
    	if(!listeImage.isEmpty()) {
    		// liste non vide, on clear le container pour pouvoir mettre les nouveaux resultats correspondent 
    		afficherResultatContainer.getChildren().clear();
    		//parcourir la liste des images trouvé qui correspondent a la recherche.
        	for(Image image : listeImage) {
        		// creation de l'objet ImageRecherche qui contient l'objet image + un boolean sur la selection
        		ImageRecherche imageRechercher = new ImageRecherche(image,false);
        		
        		//pour chaque image on creer un Hyperlink fxml pour l'afficher et l'ajouter sur la fenetre
        		Hyperlink hyperlink = new Hyperlink(image.getNomImage());
        		//hyperlink.setOnAction(e -> ouvrirImage(image.getUrl()));
        		
        		// Creer une checkbox pour pouvoir effectuer une selection d'image
        		CheckBox hyperlinkCheckBox = new CheckBox();
        		hyperlinkCheckBox.setOnAction(e -> imageRechercher.ajoutImageSelectionner());
        		
        		//ajouter les elements au container
        		afficherResultatContainer.getChildren().add(hyperlink);
        		afficherResultatContainer.getChildren().add(hyperlinkCheckBox);
        	}
    	} else {
    		// ici la liste est donc vide on peux clear le container
    		afficherResultatContainer.getChildren().clear();
    	}
    }
   
}