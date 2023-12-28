package metier;
import java.util.*;

/**
 * Cette classe est le résultat des images retournées en fonction de la recherche.
 */
public class ImageRecherche{

    private boolean selection;
    
    private Image image;
    
    public ImageRecherche(Image image, boolean selection) {
		this.selection = selection;
		this.image = image;
	}

	/**
     * Change le status (booleen selection) de l'image
     * change à true si c'etait sur false, et inversement
     * @param image, nom de l'image 
     */
    public void ajoutImageSelectionner() {
        //verifier le status du boolean
    	if(this.selection == true) {
    		//changement de status
    		this.selection = false;
    		
    	}else if(this.selection == false){
    		this.selection = true;
    	}
    }

}