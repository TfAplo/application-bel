package metier;

import java.util.*;

/**
 * Propose une liste de Particules
 */
public class EnsembleParticules {
    private ArrayList<Particule> listeParticules;

    /**
     * Default constructor
     */
    public EnsembleParticules() {
    	listeParticules = new ArrayList<Particule>();
    }

    /**
     * Ajoute une Particule dans la liste
     * @param particule Particule à ajoutée
     */
    public void ajouterParticule(Particule particule) {
        listeParticules.add(particule);
    }
    
    /**
     * ajoute des Particules contenues dans un ensemble
     * @param ens ensemble contenant les particules à ajouter
     */
    public void ajouterParticules(EnsembleParticules ens) {
    	this.listeParticules.addAll(ens.getListeParticules());
    }
    
    /**
     * Teste si l'ensemble est vide
     * @return
     */
    public boolean estVide() {
    	return listeParticules.isEmpty();
    }

	@Override
	public String toString() {
		return "EnsembleParticules [listeParticules=" + listeParticules + "]";
	}

	public ArrayList<Particule> getListeParticules() {
		return listeParticules;
	}

	public void setListeParticules(ArrayList<Particule> listeParticules) {
		this.listeParticules = listeParticules;
	}

	
	

}