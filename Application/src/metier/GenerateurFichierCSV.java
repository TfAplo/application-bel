package metier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * La classe GenerateurFichier est responsable de la génération des fichiers PNG à partir des données d'histogrammes
 */
public class GenerateurFichierCSV {
	private final String[] nomColonnesStatistiques = {"nom de l'image", "grossissement", "nombre de particules trouvees",
			"ratio de surface couverte", "moyenne des aires px",  "moyenne diametres equivalents px",
			"ecart-type des aires px", "ecart-type des diametres equivalents px", "moyenne des aires", 
			"moyenne diametres equivalents", "ecart-type des aires", "ecart-type des diametres equivalents"};
	private int compteur;
	/**
     * Constructeur du générateur de fichiers
     */
    public GenerateurFichierCSV() {
    	this.compteur = 0;
    }

    /**
     * Crée le fichier CSV à partir des données d'histogrammes
     */
    public void creerFichierHistoCSV(ArrayList<String> intervalles, ArrayList<Integer> numberEntier, String nom, String colonne) {
    	String[] Intervalles = intervalles.toArray(new String[0]);
        int[] NumberEntier = numberEntier.stream().mapToInt(Integer::intValue).toArray();
    	
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nom))) {
            // En-têtes du fichier CSV
    		writer.write("intervalles;" + colonne + "\n");
        
            // Écrire les données dans le fichier CSV
            for (int i = 0; i < Intervalles.length; i++) {
                writer.write(Intervalles[i] + ";" + NumberEntier[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	System.out.println("Fichier CSV créé avec succès: " + nom + "");
    	this.compteur++;
    }
    
    public void creerFichierStatistiquesCSV(ArrayList<String> nomImage,
    								ArrayList<Double> grossissement,
    								ArrayList<Integer> nbParticuleTrouve,
    								ArrayList<Double> ratioSurfaceCouverte,
    								ArrayList<Double> moyenneAiresPx,
    								ArrayList<Double> moyenneDiametresEquivalentsPx,
    								ArrayList<Double> ecartTypeAiresPx,
    								ArrayList<Double> ecartTypeDiametreEquivalentPx,
    								ArrayList<Double> moyenneAires,
    								ArrayList<Double> moyenneDiametresEquivalents,
    								ArrayList<Double> ecartTypeAires,
    								ArrayList<Double> ecartTypeDiametreEquivalent) {
    	String[] NomImage = nomImage.toArray(new String[0]);
    	double[] Grossissement = grossissement.stream().mapToDouble(Double::doubleValue).toArray();
    	int[] NbParticuleTrouve = nbParticuleTrouve.stream().mapToInt(Integer::intValue).toArray();
    	double[] RatioSurfaceCouverte = ratioSurfaceCouverte.stream().mapToDouble(Double::doubleValue).toArray();
    	double[] MoyenneAiresPx = moyenneAiresPx.stream().mapToDouble(Double::doubleValue).toArray();
    	double[] MoyenneDiametresEquivalentsPx = moyenneDiametresEquivalentsPx.stream().mapToDouble(Double::doubleValue).toArray();
    	double[] EcartTypeAiresPx = ecartTypeAiresPx.stream().mapToDouble(Double::doubleValue).toArray();
    	double[] EcartTypeDiametreEquivalentPx = ecartTypeDiametreEquivalentPx.stream().mapToDouble(Double::doubleValue).toArray();
    	double[] MoyenneAires = moyenneAires.stream().mapToDouble(Double::doubleValue).toArray();
    	double[] MoyenneDiametresEquivalents = moyenneDiametresEquivalents.stream().mapToDouble(Double::doubleValue).toArray();
    	double[] EcartTypeAires = ecartTypeAires.stream().mapToDouble(Double::doubleValue).toArray();
    	double[] EcartTypeDiametreEquivalent = ecartTypeDiametreEquivalent.stream().mapToDouble(Double::doubleValue).toArray();
    	
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("statistiquesImages.csv"))) {
            for(int i = 0; i < this.nomColonnesStatistiques.length; i++) {
            	writer.write(this.nomColonnesStatistiques[i] + ";");
            }
            writer.write("\n");
    		for (int i = 0; i < NomImage.length; i++) {
                writer.write(NomImage[i] + ";" + Grossissement[i] + ";" + NbParticuleTrouve[i] 
                			+ ";" + RatioSurfaceCouverte[i] + ";" + MoyenneAiresPx[i] + ";" +
                			MoyenneDiametresEquivalentsPx[i] + ";" + EcartTypeAiresPx[i] + ";" +
                			EcartTypeDiametreEquivalentPx[i] + ";" + MoyenneAires[i] + ";" +
                			MoyenneDiametresEquivalents[i] + ";" + EcartTypeAires[i] +  
                			";" + EcartTypeDiametreEquivalent[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	System.out.println("Fichier CSV créé avec succès: statistiquesImages.csv");
    }
}