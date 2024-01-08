package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import metier.Produit;

/**
 * Classe servant a effectuer des operations entre l'objet Produit et son equivalent, la table Produit, dans la base de donnees.
 */
public class ProduitDAO extends DAO<Produit>{

    /**
     * Methode de creation d'un produit dans la base de donnees a partir des attributs de l'objet Produit.
     * @param produit Instance de la classe Produit devant etre inseree dans la base de donnees.
     * @return Instance de la classe Produit ayant ete inseree dans la base de donnees.
     */
    public Produit creer(Produit produit) {
    	String rechercheProduit = "SELECT * FROM produit "
				+ "WHERE nomProduit = '"+ produit.getNomProduit()+ "'";
    	try {
    		ResultSet rs = stmt.executeQuery(rechercheProduit);
        	// si nomProduit n'est pas deja dans la bdd
			if (!rs.next()) {
				// on le cree
				String requete = "INSERT INTO produit (nomProduit) "
						+ "VALUES('" + produit.getNomProduit()+"')";
				
				try {
					stmt.executeUpdate(requete,Statement.RETURN_GENERATED_KEYS);
					ResultSet cles = stmt.getGeneratedKeys();
					if(cles.next()){
						int idProduit = cles.getInt(1);
						produit.setIdProduit(idProduit);
					}
				} catch (SQLException e) {
					System.err.println("Erreur requete SQL");
					e.printStackTrace();
				}
			} else {
				// on lui affecte son id situe dans la bdd
				produit.setIdProduit(rs.getInt("idProduit"));
			}
		} catch (SQLException e) {
			System.err.println("Erreur requete SQL");
			e.printStackTrace();
		}
        return produit;
    }

    /**
     * Methode de lecture d'un produit dans la base de donnees a partir des attributs de l'objet Produit.
     * @param idProduit ID du produit devant etre lu dans la base de donnees.
     * @return Instance de la classe Produit contenant les donnees lues dans la base de donnees par rapport a l'ID.
     */
    public Produit lire(int idProduit) {
        return null;
    }

    /**
     * Methode de mise a jour d'un produit dans la base de donnees a partir des attributs de l'objet Produit.
     * @param produit Instance de la classe Produit devant etre mise a jour dans la base de donnees.
     * @return Instance de la classe Produit ayant ete mise a jour dans la base de donnees.
     */
    public Produit mettreAJour(Produit produit) {
        return null;
    }

    /**
     * Methode de suppression d'un produit dans la base de donnees a partir des attributs de l'objet Produit.
     * @param produit Instance de la classe Produit devant etre supprimee dans la base de donnees.
     */
    public void supprimer(Produit produit) {
    }

	@Override
	public ArrayList<Produit> lire() {
		return null;
	}

}