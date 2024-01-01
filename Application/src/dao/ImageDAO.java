package dao;

import java.util.*;

import metier.Image;

/**
 * Classe servant a effectuer des operations entre l'objet Image et son equivalent, la table Image, dans la base de donnees.
 */
public class ImageDAO extends DAO<Image>{

    /**
     * Default constructor
     */
    public ImageDAO() {
    }

    /**
     * Methode de creation d'une image dans la base de donnees a partir des attributs de l'objet Image.
     * @param image Instance de la classe Image devant etre inseree dans la base de donnees.
     * @return Instance de la classe Image ayant ete inseree dans la base de donnees.
     */
    @Override
    public Image creer(Image image) {
    	// si url deja dans la bdd
    	// alors on ne depose rien
    	// sinon on depose
    	return null;
    }

    /**
     * Methode de lecture d'une image dans la base de donnees a partir des attributs de l'objet Image.
     * @param idImage ID de l'image devant etre lue dans la base de donnees.
     * @return Instance de la classe Image contenant les donnees lu dans la base de donnees par rapport a l'ID.
     */

    public Image lire(int idImage) {
        // TODO implement here
        return null;
    }

    /**
     * Methode de mise a jour d'une image dans la base de donnees a partir des attributs de l'objet Image.
     * @param image Instance de la classe Image devant etre mise a jour dans la base de donnees.
     * @return Instance de la classe Image ayant ete mise a jour dans la base de donnees.
     */
    @Override
    public Image mettreAJour(Image image) {
        // TODO implement here
        return null;
    }

    /**
     * Methode de suppression d'une image dans la base de donnees a partir des attributs de l'objet Image.
     * @param image Instance de la classe Image devant etre supprimee dans la base de donnees.
     */
    @Override
    public void supprimer(Image image) {
        // TODO implement here
    }
    
    /**
     * @param nomFichier 
     * @return , une liste contenant les noms des images qui sont retournées d'apres la recherche. 
     */
    public ArrayList<String> lire(String nomFichier) {
        // TODO implement here
        return null;
    }

	@Override
	public ArrayList<Image> lire() {
		// TODO Auto-generated method stub
		return null;
	}

}