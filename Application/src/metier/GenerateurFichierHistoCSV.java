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
    private ArrayList<String> intervalles;
    private ArrayList<Integer> numberEntier;
	/**
     * Constructeur du générateur de fichiers
     */
    public GenerateurFichierHistoCSV(ArrayList<String> intervalles, ArrayList<Integer> numberEntier) {
    	this.intervalles = intervalles;
    	this.numberEntier = numberEntier;
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
            String[] test2 = this.intervalles.toArray(new String[0]);
            int[] test1 = this.numberEntier.stream().mapToInt(Integer::intValue).toArray();
            
            // Écrire les données dans le fichier CSV
            for (int i = 0; i < test2.length; i++) {
                writer.write(test2[i] + ";" + test1[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	System.out.println("Fichier CSV créé avec succès: fichierCSV.csv");
    }
    
    public static void main(String[] args) {
    	ArrayList<String> intervalles = new ArrayList<>();
    	intervalles.add("ya");
    	intervalles.add("ya");
        String[] test2 = intervalles.toArray(new String[0]);
        ArrayList<Integer> numberEntier = new ArrayList<>();
        numberEntier.add(3);
        numberEntier.add(4);
        int[] test3 = numberEntier.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < test2.length; i++) {
			System.out.println(test2[i]);
			System.out.println(test3[i]);
		}
	}
    
}