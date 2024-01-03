package controleurs;

import java.util.*;

import dao.ImageDAO;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import metier.Image;
import metier.ImageRecherche;
/**
 * Cette classe controle les autres.
 */
public class ControleRecherche{
	
	ImageDAO imageDao = new ImageDAO();

	/*
	 * Liste d'image Selectionner
	 */
	private ArrayList<Image> listeImageSelectionner = new ArrayList<>();


    /**
     * Default constructor
     */
    public ControleRecherche(){
    }

	/**
     * @param nom, valeur de l'input de la recherche , censé contenir un potentiel nom d'image.
     */
    public void recherche(String recherche, VBox afficherResultatContainer) {
    	
        //recuperer une liste d'image qui correspondent
        ArrayList<Image> listeImage = imageDao.lire(recherche);
        
        // les afficher sur la fenetre , On verifie que la liste ne soit pas vide 
    	if(!listeImage.isEmpty()) {
    		// liste non vide, on clear le container pour pouvoir mettre les nouveaux resultats correspondent 
    		afficherResultatContainer.getChildren().clear();
    		//parcourir la liste des images trouvé qui correspondent a la recherche.
        	for(Image image : listeImage) {
        		// creation de l'objet ImageRecherche qui contient l'objet image + un boolean sur la selection
        		ImageRecherche imageRechercher = new ImageRecherche(image,false);
        		
        		//pour chaque image on creer un Hyperlink fxml pour l'afficher et l'ajouter sur la fenetre
        		Hyperlink hyperlink = new Hyperlink(image.getNomImage());
        		
        		// Creer une checkbox pour pouvoir effectuer une selection d'image
        		CheckBox hyperlinkCheckBox = new CheckBox();
        
        		hyperlinkCheckBox.setOnAction(e -> ajoutImageSelectionner(image));
        		//verifier que l'image est dans la liste ou non (pb lorsqu'on recherche des images deja dans la liste la checkbox est reinitialiser
        		// et donc cela ne correspond plus a son etat dans la liste
        		ArrayList<Image> liste = getListeImageSelectionner();
        		
        		for(Image imageSelect: liste) {
        			if(isEqual(imageSelect, image)) {
        				hyperlinkCheckBox.setSelected(true);
        			}
        		}    		
        		
        		//Creer un element qui contient le nom de l'image et la checkbox
        		HBox hContainer = new HBox();
        		hContainer.setId("hContainer");
        		hContainer.getChildren().add(hyperlink);
        		hContainer.getChildren().add(hyperlinkCheckBox);
        		
        		//ajouter les elements au container
        		afficherResultatContainer.getChildren().add(hContainer);
        		
        	}
    	} else {
    		// ici la liste est donc vide on peux clear le container
    		afficherResultatContainer.getChildren().clear();
    	}
    }
    
    /* ajoute l'image ou l'enleve en fonction de sa presence ou non dans la liste
     * @param image, instance de Image
     */
    public void ajoutImageSelectionner(Image image) 
    {
    	boolean isRemoved = false;
    	Iterator<Image> iterator = getListeImageSelectionner().iterator();
    	
    	while(iterator.hasNext()) 
    	{
    		Image imageSelect = iterator.next();
    		if(isEqual(imageSelect, image)) 
    		{
    			isRemoved = true;
    			iterator.remove();
    		}
    	}
    	if(!isRemoved) 
    	{
    		listeImageSelectionner.add(image);
    	}
    	System.out.println(listeImageSelectionner);
    }
    
    /*
     * retourne la liste d'image selectionner
     */
    public ArrayList<Image> getListeImageSelectionner() {
		return listeImageSelectionner;
	}
    
    /*
     * Compare si deux image sont eguale (avec leurs id qui est unique)
     */
    public static boolean isEqual(Image image1, Image image2) {
        if (image1 == image2) {
            return true;
        }
        if (image1.getIdImage() == image2.getIdImage()) {
            return true;
        }
        return false;
    }
              
}
