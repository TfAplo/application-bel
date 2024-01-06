package controleurs;

import java.util.ArrayList;
import java.util.Iterator;

import dao.ImageDAO;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import metier.Image;

public class ControleRecherche2 {

	ImageDAO imageDao = new ImageDAO();
	
	/*
	 * Liste d'image Selectionner
	 */
	private ArrayList<Image> listeImageSelectionner = new ArrayList<>();
	
	
	public void recherche(String recherche, VBox afficherResultatContainer, VBox imageSelected) 
	{
		// recuperer une liste d'image qui correspondent dans la bdd
		ArrayList<Image> listeImage= imageDao.lire(recherche);
		
		//Si la liste n'est pas vide alors on affiche les resultats, sinon la liste est vide donc on vide le container
		if(!listeImage.isEmpty())
		{
			affichage(listeImage, afficherResultatContainer, imageSelected);
		} else 
		{
			afficherResultatContainer.getChildren().clear();
		}
	}
	
	public void affichage(ArrayList<Image> listeImage, VBox container, VBox imageSelected)
	{
		container.getChildren().clear();
		//parcourir les elements
		for (Image image: listeImage)
		{
			// creer l'element hbox contenant le nom et une checkbox pour le selection
			HBox elementImage = creerElement(image, imageSelected);
			//ajouter l'element au container 
			container.getChildren().add(elementImage);
		}
		if(!(imageSelected == null))
		{
			affichage(listeImageSelectionner, imageSelected, null);
		}
		
	}
	/* creer l'element hbox contenant le nom et une checkbox pour une image
	 * @param image, objet Image
	 * @return HBox
	 */
	public HBox creerElement(Image image, VBox imageSelected)
	{
		HBox elementImage = new HBox();
		//creer un Label fxml pour l'afficher le nom de l'image
		Label nomImage = new Label(image.getNomImage());
		// Creer une checkbox pour pouvoir effectuer une selection d'image
		CheckBox CheckBox = new CheckBox();
		CheckBox.setOnAction(e -> ajoutSuppImageSelection(image, imageSelected));
		//CheckBox.setOnAction(e -> ajoutImageSelection(image, imageSelected));
		//check si l'image est deja dans la liste (et si on doit "check" la box)
		for (Image imageSelectionner: listeImageSelectionner)
		{
			if(isEqual(imageSelectionner, image)) 
			{
				CheckBox.setSelected(true);
			}
		}
		// ajouter les elements au container
		elementImage.getChildren().add(nomImage);
		elementImage.getChildren().add(CheckBox);
		
		// ajouter un id pour le css
		elementImage.setId("hContainer");
		
		return elementImage;
	}
	
	public void ajoutSuppImageSelection(Image image, VBox imageSelected)
	{
		boolean isRemoved = false;
    	Iterator<Image> iterator = listeImageSelectionner.iterator();
    	
    	//si l'image est deja dans la liste alors on la retire sinon on l'ajoute
    	while(iterator.hasNext()) 
    	{
    		Image imageSelect = iterator.next();
    		if(isEqual(imageSelect, image)) 
    		{
    			isRemoved = true;
    			iterator.remove();
    			// actualiser les images selectionner dans l'affichage
    			affichage(listeImageSelectionner, imageSelected, null);
    		}
    	}
    	if(!isRemoved) 
    	{
    		listeImageSelectionner.add(image);
    		//afficher les images selectionner dans la zone
    		affichage(listeImageSelectionner, imageSelected, null);
    	}
    	System.out.println(listeImageSelectionner);
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
	
	/*
     * retourne la liste d'image selectionner
     */
    public ArrayList<Image> getListeImageSelectionner() {
		return listeImageSelectionner;
	}
    

}
