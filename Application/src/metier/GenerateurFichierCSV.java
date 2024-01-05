package metier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe GenerateurFichier est responsable de la génération des fichiers PNG à partir des données d'histogrammes
 */
public class GenerateurFichierCSV 
{
	//private ArrayList<Objet> listeOblet;
	private final String[] nomColonnes = {"nom de l'image", "grossissement", "nombre de particules trouvees",
			"ratio de surface couverte", "moyenne des aires", "moyenne diametres equivalents",
			"ecart-type des aires", "ecart-type des diametres equivalents"};
	
    /**
     * Constructeur du générateur de fichiers
     */
    public GenerateurFichierCSV() {
    }

    /**
     * Crée le fichier CSV à partir des données d'histogrammes
     *
     * @return un boolean qui est true si le fichier est bien créer ou false si il ne s'est pas créer
     */
    public void creerFichier() 
    {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("fichierCSV.csv"))) {
            // En-têtes du fichier CSV
    		for(int i = 0; i < this.nomColonnes.length; i++) {
    			writer.write(nomColonnes[i] + ";");
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