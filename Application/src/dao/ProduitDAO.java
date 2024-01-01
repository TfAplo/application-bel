package dao;

import java.util.*;

import metier.Image;
import metier.Produit;

/**
 * Classe servant a effectuer des operations entre l'objet Produit et son equivalent, la table Produit, dans la base de donnees.
 */
public class ProduitDAO extends DAO<Image>{

    /**
     * Default constructor
     */
    public ProduitDAO() {
    }

    /**
     * Methode de creation d'un produit dans la base de donnees a partir des attributs de l'objet Produit.
     * @param produit Instance de la classe Produit devant etre inseree dans la base de donnees.
     * @return Instance de la classe Produit ayant ete inseree dans la base de donnees.
     */
    public Produit creer(Produit produit) {
    	// si nomProduit deja dans la bdd
		// alors on ne le cree pas
		// sinon on cree
        return null;
    }

    /**
     * Methode de lecture d'un produit dans la base de donnees a partir des attributs de l'objet Produit.
     * @param idProduit ID du produit devant etre lu dans la base de donnees.
     * @return Instance de la classe Produit contenant les donnees lues dans la base de donnees par rapport a l'ID.
     */
    public Produit lire(int idProduit) {
        // TODO implement here
        return null;
    }

    /**
     * Methode de mise a jour d'un produit dans la base de donnees a partir des attributs de l'objet Produit.
     * @param produit Instance de la classe Produit devant etre mise a jour dans la base de donnees.
     * @return Instance de la classe Produit ayant ete mise a jour dans la base de donnees.
     */
    public Produit mettreAJour(Produit produit) {
        // TODO implement here
        return null;
    }

    /**
     * Methode de suppression d'un produit dans la base de donnees a partir des attributs de l'objet Produit.
     * @param produit Instance de la classe Produit devant etre supprimee dans la base de donnees.
     */
    public void supprimer(Produit produit) {
        // TODO implement here
    }

	@Override
	public ArrayList<Image> lire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image creer(Image obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image mettreAJour(Image obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(Image obj) {
		// TODO Auto-generated method stub
		
	}

}