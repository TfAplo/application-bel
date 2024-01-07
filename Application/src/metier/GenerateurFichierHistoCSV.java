package metier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * La classe GenerateurFichier est responsable de la génération des fichiers PNG à partir des données d'histogrammes
 */
public class GenerateurFichierHistoCSV {
	private final String[] nomColonnesStatistiques = {"nom de l'image", "grossissement", "nombre de particules trouvees",
			"ratio de surface couverte", "moyenne des aires", "moyenne diametres equivalents",
			"ecart-type des aires", "ecart-type des diametres equivalents"};
	private int compteur;
	/**
     * Constructeur du générateur de fichiers
     */
    public GenerateurFichierHistoCSV() {
    	this.compteur = 0;
    }

    /**
     * Crée le fichier CSV à partir des données d'histogrammes
     */
    public void creerFichierHistoCSV(ArrayList<String> intervalles, ArrayList<Integer> numberEntier)
    {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("fichierCSV.csv"))) {
            // En-têtes du fichier CSV
    		for (String string : intervalles) {
				writer.write(string + ";");
			}
            writer.write("\n");
            String[] test2 = intervalles.toArray(new String[0]);
            int[] test1 = numberEntier.stream().mapToInt(Integer::intValue).toArray();
            
            // Écrire les données dans le fichier CSV
            for (int i = 0; i < test2.length; i++) {
                writer.write(test2[i] + ";" + test1[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	System.out.println("Fichier CSV créé avec succès: fichierCSV" + this.compteur + ".csv");
    	this.compteur++;
    }
}