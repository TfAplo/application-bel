package controleurs;

import java.util.*;
import dao.ImageDAO;
import ihm.IHMRecherche;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import metier.Image;
import metier.ImageRecherche;
/**
 * Cette classe controle les autres.
 */
public class ControleRecherche {
	
	ImageDAO imageDao = new ImageDAO();
	IHMRecherche IHMR = new IHMRecherche();
	

    /**
     * Default constructor
     */
    public ControleRecherche() {
    }

    /**
     * @param nom, valeur de l'input de la recherche , censé contenir un potentiel nom d'image.
     */
    public void recherche(String recherche, Pane afficherResultatContainer) {
    	
        System.out.println(recherche);
        
        //recuperer une liste d'image qui correspondent
        ArrayList<Image> listeImage = imageDao.lire(recherche);
        // les afficher sur la fenetre
        //IHMR.afficherResultat(listeImage);
        
     // On verifie que la liste ne soit pas vide 
    	if(!listeImage.isEmpty()) {
    		// liste non vide, on clear le container pour pouvoir mettre les nouveaux resultats correspondent 
    		afficherResultatContainer.getChildren().clear();
    		//parcourir la liste des images trouvé qui correspondent a la recherche.
    		int i = 0;
        	for(Image image : listeImage) {
        		// creation de l'objet ImageRecherche qui contient l'objet image + un boolean sur la selection
        		ImageRecherche imageRechercher = new ImageRecherche(image,false);
        		
        		//pour chaque image on creer un Hyperlink fxml pour l'afficher et l'ajouter sur la fenetre
        		Hyperlink hyperlink = new Hyperlink(image.getNomImage());
        		hyperlink.setLayoutY(50 * i);
        		hyperlink.setLayoutX(5);
        		//hyperlink.setOnAction(e -> ouvrirImage(image.getUrl()));
        		
        		// Creer une checkbox pour pouvoir effectuer une selection d'image
        		CheckBox hyperlinkCheckBox = new CheckBox();
        		hyperlinkCheckBox.setLayoutY(50 * i);
        		hyperlinkCheckBox.setLayoutX(80);
        		hyperlinkCheckBox.setOnAction(e -> imageRechercher.ajoutImageSelectionner());
        		
        		//ajouter les elements au container
        		afficherResultatContainer.getChildren().add(hyperlink);
        		afficherResultatContainer.getChildren().add(hyperlinkCheckBox);
        		
        		i += 1;
        	}
    	} else {
    		// ici la liste est donc vide on peux clear le container
    		afficherResultatContainer.getChildren().clear();
    	}
    }
            
}
