package metier;

import java.util.*;

/**
 * Propose une liste de Statistiques
 */
public class EnsembleStatistiques {
    private ArrayList<Statistique> listeStatistiques;

    /**
     * Default constructor
     */
    public EnsembleStatistiques() {
    	listeStatistiques = new ArrayList<Statistique>();
    }

    /**
     * Ajoute une Statistiques (particule) dans la liste
     * @param stat Statistique à ajoutée
     */
    public void ajouterStatistique(Statistique stat) {
        listeStatistiques.add(stat);
    }

	@Override
	public String toString() {
		return "EnsembleStatistiques [listeStatistiques=" + listeStatistiques + "]";
	}

}