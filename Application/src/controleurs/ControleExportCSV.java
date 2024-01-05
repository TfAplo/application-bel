package controleurs;

import java.util.*;

import ihm.IHMExport;
import metier.GenerateurFichier;
import metier.GenerateurFichierCSV;
import metier.HistogrammeDiametre;

/**
 * La classe ControleExport gère le processus d'exportation des histogrammes au format CSV.
 */
public class ControleExportCSV {

     /**
     * Attribut privé de type FenetreExport
     */
    private IHMExport fenetreExport;


	/**
     * Attribut privé de type GenerateurFichier
     */
    private GenerateurFichier generateurFichier;


  /**
     * Constructeur prenant en paramètre la fenêtre d'exportation et le générateur de fichiers.
     *
     * @param fenetreExport     la fenêtre d'exportation
     * @param generateurFichier le générateur de fichiers
     */
    public ControleExportCSV(IHMExport fenetreExport, GenerateurFichier generateurFichier) {
        this.fenetreExport = fenetreExport;
        this.generateurFichier = generateurFichier;
    }
    
    public ControleExportCSV() 
    {
    }

    /**
     * Gère l'action d'exportation statistiques.
     */
    public void main() 
    {
        // TODO implement here
    }

    /**
     * Getter de l'attribut FenetreExport
     * @return fenetreExport
     */
    public IHMExport getFenetreExport() 
    {
		return fenetreExport;
	}
    
    /**
     * Getter de l'attribut generateurFichier
     * @return generateurFichier
     */
	public GenerateurFichier getGenerateurFichier() 
	{
		return generateurFichier;
	}
	
	public void export()
	{
		String[] listeNom = {"nom de l'image", "grossissement", "nombre de particules trouvees",
							"ratio de surface couverte", "moyenne des aires", "moyenne diametres equivalents",
							"ecart-type des aires", "ecart-type des diametres equivalents"};
		
		//récupération des statistiques
		GenerateurFichierCSV generateur = new GenerateurFichierCSV(listeNom);
		generateur.creerFichier();
		System.out.println("hello");
	}
	
	public void export(HistogrammeDiametre histo)
	{
		
	}
}