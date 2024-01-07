package metier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe GenerateurFichier est responsable de la génération des fichiers PNG à partir des données d'histogrammes
 */
public class GenerateurFichierHistoCSV {
	private final String[] nomColonnesStatistiques = {"nom de l'image", "grossissement", "nombre de particules trouvees",
			"ratio de surface couverte", "moyenne des aires", "moyenne diametres equivalents",
			"ecart-type des aires", "ecart-type des diametres equivalents"};
    private ArrayList<String> intervalles;
    private ArrayList<Integer> numberEnEntier;
	/**
     * Constructeur du générateur de fichiers
     */
    public GenerateurFichierHistoCSV(ArrayList<String> intervalles, ArrayList<Integer> numberEnEntier) {
    	this.intervalles = intervalles;
    	this.numberEnEntier = numberEnEntier;
    }

    /**
     * Crée le fichier CSV à partir des données d'histogrammes
     */
    public void creerFichierHistoCSV() 
    {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("fichierCSV.csv"))) {
            // En-têtes du fichier CSV
    		for (String string : intervalles) {
				writer.write(string + ";");
			}
    		
            writer.write("\n");
            String[] noms = {"Doe", "Smith", "Johnson"};
            String[] prenoms = {"John", "Jane", "Bob"};

            // Écrire les données dans le fichier CSV
            for (int i = 0; i < noms.length; i++) {
                writer.write(noms[i] + ";" + prenoms[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	System.out.println("Fichier CSV créé avec succès: fichierCSV.csv");
    }
    
}