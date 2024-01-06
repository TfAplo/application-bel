package metier;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import ihm.IHMExport;
import controleurs.ControleExport;

/**
 * La classe GenerateurFichier est responsable de la génération des fichiers PNG à partir des données d'histogrammes
 */
public class GenerateurFichier 
{
	@FXML 
	private Button boutonExport;
	@FXML
	private BarChart histo1;
	//private static IHMExport ihmExport;
	private static ControleExport controleExport;

    /**
     * Atttibut privé correspondant à l'image du fichier généré au format BuferedImage
     */
    private BufferedImage fichier;

    /**
     * Constructeur du générateur de fichiers
     */
    public GenerateurFichier(/*IHMExport ihmExport*/ControleExport controle) {
    	//this.ihmExport=ihmExport;
    	this.controleExport=controle;
    	
    }
    
    

    /**
     * Crée le fichier PNG à partir des données d'histogrammes
     *
     * @return l'image du fichier généré au format BufferedImage
     */

    public boolean enregistrerHistogrammeEnPNG(BarChart<?, ?> histogramme, String cheminFichier) {

	        try {
	            WritableImage image = histogramme.snapshot(new SnapshotParameters(), null);
	            File file = new File(cheminFichier);
	            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
	            return true;
   
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    
    }

    /*  public void creerFichier() {
    
	  WritableImage image = histo1.snapshot(new SnapshotParameters(), null);

    // Créer un objet FileChooser si vous voulez que l'utilisateur choisisse l'emplacement
    // Pour cet exemple, je vais sauvegarder directement dans un dossier nommé "export"
    File dossierExport = new File("export");
    if (!dossierExport.exists()) {
        dossierExport.mkdir();
    }

    // Créer un fichier pour sauvegarder l'image
    File file = new File("export/histogramme.png");

    // Utiliser ImageIO pour écrire l'image dans le fichier PNG
    try {
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        System.out.println("Histogramme exporté en tant que PNG avec succès ! hehe");
    } catch (IOException e) {
        e.printStackTrace();
    }
}*/


    /**
     * Getter de l'attribut fichier
     * @return fichier de type BufferedImage
     */
	public BufferedImage getFichier() {
		return fichier;
	}

    
    
}