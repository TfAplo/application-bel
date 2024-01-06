package controleurs;

import java.util.ArrayList;
import java.util.Iterator;

import dao.ImageDAO;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import metier.Image;

public class ControleRecherche {

	ImageDAO imageDao = new ImageDAO();
	
	/*
	 * liste d'image qui contiendra les images qui correspondent a la recherche
	 */
	private ArrayList<Image> listeImage = new ArrayList<>();
	
	/*
	 * Liste d'image Selectionner
	 */
	private ArrayList<Image> listeImageSelectionner = new ArrayList<>();
	
	/*
	 * Fonction de recherche 
	 * @param recherche, String : valeur de la barre de recherche
	 * @param2 afficherResultatContainer, VBox ,section d'affichage des resultats de la recherche
	 * @param3 imageSelectionner, VBox ,section d'affichage des resultats de la selection
	 */
	public void recherche(String recherche, VBox afficherResultatContainer, VBox imageSelectionner) {
		// recuperer une liste d'image qui correspondent dans la bdd
		listeImage= imageDao.lire(recherche);
		
		//Si la liste n'est pas vide alors on affiche les resultats, sinon la liste est vide donc on vide le container
		if(!listeImage.isEmpty()){
			affichageRecherche(listeImage, afficherResultatContainer,imageSelectionner);
		} else {
			afficherResultatContainer.getChildren().clear();
		}
	}
	/*
	 * Gere l'affichage de la section de Recherche des images
	 * @param image, Objet image
	 * @param2 container, afficherResultatRecherche
	 * @param3 container2, imageSelected
	 */
	public void affichageRecherche(ArrayList<Image> listeImage, VBox container, VBox container2){
		container.getChildren().clear();
		//parcourir les elements
		for (Image image: listeImage){
			// creer l'element hbox contenant le nom et une checkbox pour le selection
			HBox elementImage = creerElement(image, container,container2);
			//ajouter l'element au container 
			container.getChildren().add(elementImage);
		}
		
	}
	/*
	 * Gere l'affichage de la section de Selection des images
	 *@param image, Objet image
	 *@param2 container, afficherResultatRecherche
	 *@param3 container2, imageSelected
	 */
	public void affichageSelection(ArrayList<Image> listeImage, VBox container, VBox container2){
		container2.getChildren().clear();
		//parcourir les elements
		for (Image image: listeImage){
			// creer l'element hbox contenant le nom et une checkbox pour le selection
			HBox elementImage = creerElement(image, container,container2);
			//ajouter l'element au container 
			container2.getChildren().add(elementImage);
		}
		
	}
	/* creer l'element hbox contenant le nom et une checkbox pour une image
	 * @param image, objet Image
	 * @return HBox
	 */
	public HBox creerElement(Image image, VBox container,VBox container2){
		HBox elementImage = new HBox();
		//creer un Label fxml pour l'afficher le nom de l'image
		Label nomImage = new Label(image.getNomImage());
		// Creer une checkbox pour pouvoir effectuer une selection d'image
		CheckBox CheckBox = new CheckBox();
		
		CheckBox.setOnAction(e -> actualiserSelection(image, container, container2));
		
		//check si l'image est deja dans la liste (et si on doit "check" la box)
		for (Image imageSelectionner: listeImageSelectionner){
			if(isEqual(imageSelectionner, image)) {
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
	/*
	 * Actualise l'affichage des section de recherche et de selection des images
	 * @param image, Objet image
	 * @param2 container, afficherResultatRecherche
	 * @param3 container2, imageSelected
	 */
	public void actualiserSelection(Image image, VBox container, VBox container2){
		boolean isRemoved = false;
    	Iterator<Image> iterator = listeImageSelectionner.iterator();
    	
    	//si l'image est deja dans la liste alors on la retire sinon on l'ajoute
    	while(iterator.hasNext()) {
    		Image imageSelect = iterator.next();
    		if(isEqual(imageSelect, image)) {
    			isRemoved = true;
    			iterator.remove();
    			break;
    		}
    	}
    	if(!isRemoved) {
    		listeImageSelectionner.add(image);
    	}
   		// Mettre à jour les deux containers après la suppression ou l'ajout
        affichageSelection(listeImageSelectionner, container, container2);
        affichageRecherche(listeImage, container, container2);
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
