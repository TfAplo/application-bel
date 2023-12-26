package dao;

import java.util.*;

import metier.EnsembleStatistiques;
import metier.Image;
import metier.Statistique;

/**
 * Permet les échanges avec la table Statistiques de la base de donnée
 */
public class StatistiquesDAO extends DAO<Image>{

    /**
     * Default constructor
     */
    public StatistiquesDAO() {
    }

    /**
     * Récupère les statistiques d'une image à partir d'un  id
     * @param idImage entier permettant l'identification de l'image
     * @return retourne un EnsembleStatistiques
     */
    public EnsembleStatistiques lire(int idImage) {
        // TODO implement here
        return null;
    }

    /**
     * Ajoute des Statistiques dans la base de donnée à partir d'une chaine JSON
     * @param idImage identifiant de l'image à laquelle correspond les statistiques
     * @param statistiquesJSON chaine contenant les statistiques à ajoutées
     * @return retourne un Ensemble créé à partir des statistiques
     */
    public EnsembleStatistiques creer(int idImage, String statistiquesJSON) {
        // TODO implement here
        return null;
    }

    /**
     * Met à jour une Statistique
     * @param stat instance de Statistique qui contient les éléments à changer
     */
    public void mettreAJour(Statistique stat) {
        // TODO implement here
    }

    /**
     * Supprime la Statistique correspondant à l'objet fournie
     * @param idStatistique à supprimer
     */
    public void supprimer(int idStatistique) {
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