package dao;

import java.util.*;

import metier.EnsembleParticules;
import metier.Particule;

/**
 * Permet les échanges avec la table Particules de la base de donnée
 */
public class ParticuleDAO extends DAO<Particule>{

    /**
     * Default constructor
     */
    public ParticuleDAO() {
    }

    /**
     * Récupère les Particules d'une image à partir d'un  id
     * @param idImage entier permettant l'identification de l'image
     * @return retourne un EnsembleParticules
     */
    public EnsembleParticules lire(int idImage) {
        // TODO implement here
        return null;
    }

    /**
     * Ajoute des Particules dans la base de donnée à partir d'une chaine JSON
     * @param idImage identifiant de l'image à laquelle correspond les Particules
     * @param ParticulesJSON chaine contenant les Particules à ajoutées
     * @return retourne un Ensemble créé à partir des Particules
     */
    public EnsembleParticules creer(int idImage, String ParticulesJSON) {
        // TODO implement here
        return null;
    }

    /**
     * Met à jour une Particule
     * @param part instance de Particule qui contient les éléments à changer
     * @return 
     */
    public Particule mettreAJour(Particule part) {
		return part;
        // TODO implement here
    }

    /**
     * Supprime la Particule correspondant à l'objet fournie
     * @param idParticule à supprimer
     */
    public void supprimer(int idParticule) {
        // TODO implement here
    }
    
    /**
     * creer dans la base de données les Particules d'une image
     * @param ens
     * @return ensemble crééer
     */
    public EnsembleParticules creer(int idImage,EnsembleParticules ens) {
    	return null;
    }

	@Override
	public Particule creer(Particule obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(Particule obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Particule> lire() {
		// TODO Auto-generated method stub
		return null;
	}

}