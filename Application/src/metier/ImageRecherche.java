package metier;
import java.util.*;

/**
 * Cette classe est le résultat des images retournées en fonction de la recherche.
 */
public class ImageRecherche {
	
     // Chaine de charactere qui contient le nom de l'image
    public String nom;

     //Chaine de charactere qui contient l'emplacement de l'image
    public String emplacement;

     //Booléen qui est à true si l'image est selectionner, sinon false
    public boolean selection;

     //Default constructor
    public ImageRecherche(Image image, boolean selection){
    	this.image = image;
    	//this.nom = nom;
    	//this.emplacement = emplacement;
    	this.selection = selection;
    }
    /**
     * Change le status (booleen selection) de l'image
     * change à true si c'etait sur false, et inversement
     * @param image, nom de l'image 
     */
    public void ajoutImageSelectionner(Image image) {
        //verifier le status du boolean
    	if(image.selection == true) {
    		//changement de status
    		image.selection = false
    	}else if(image.selection == false){
    		image.selection = true;
    	}
    }

}