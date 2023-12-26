package dao;

import java.util.*;

import metier.Image;
import metier.Operateur;

/**
 * Classe servant a effectuer des operations entre l'objet Operateur et son equivalent, la table Operateur, dans la base de donnees.
 */
public class OperateurDAO extends DAO<Image> {

    /**
     * Default constructor
     */
    public OperateurDAO() {
    }

    /**
     * Methode de creation d'un operateur dans la base de donnees a partir des attributs de l'objet Operateur.
     * @param operateur Instance de la classe Operateur devant etre inseree dans la base de donnees.
     * @return Instance de la classe Operateur ayant ete inseree dans la base de donnees.
     */
    public Operateur creer(Operateur operateur) {
        // TODO implement here
        return null;
    }

    /**
     * Methode de lecture d'un operateur dans la base de donnees a partir des attributs de l'objet Operateur.
     * @param idOperateur ID de l'operateur devant etre lu dans la base de donnees.
     * @return Instance de la classe Operateur contenant les donnees lues dans la base de donnees par rapport a l'ID.
     */
    public Operateur lire(int idOperateur) {
        // TODO implement here
        return null;
    }

    /**
     * Methode de mise a jour d'un operateur dans la base de donnees a partir des attributs de l'objet Operateur.
     * @param operateur Instance de la classe Operateur devant etre mise a jour dans la base de donnees.
     * @return Instance de la classe Operateur ayant ete mise a jour dans la base de donnees.
     */
    public Operateur mettreAJour(Operateur operateur) {
        // TODO implement here
        return null;
    }

    /**
     * Methode de suppression d'un operateur dans la base de donnees a partir des attributs de l'objet Operateur.
     * @param operateur Instance de la classe Operateur devant etre supprimee dans la base de donnees.
     */
    public void supprimer(Operateur operateur) {
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