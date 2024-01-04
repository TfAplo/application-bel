package ihm;

import java.util.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import metier.Diagramme;
import metier.EnsembleParticules;
import metier.HistogrammeDiametre;
import metier.HistogrammeSurface;
import metier.Image;
import metier.Statistique;
import metier.Tableau;

/**
 * Vue permettant l'affichage des différents diagrammes souhaités pour afficher les statistiques, Propose aussi les différents boutons utiles à l'utilisateur
 */
public class IHMStatistiques {
	private ArrayList<Diagramme> listeDiagrammes;
    private int nbIntervalles;
    private ArrayList<String> listeAffichagesVoulus;
    private Tableau tab;
    private HistogrammeDiametre histoDiam;
    private HistogrammeSurface histoSurf;
    private boolean slideDisHS;
    private boolean slideDisHD;
    private boolean tabCheck;
    private boolean afficher;
	 @FXML
	 private Button idAfficherButton;
	 @FXML
	 private CheckBox idHScheck;
	 @FXML
	 private Slider idSliderHS;
	 @FXML
	 private Label idLabelHS;
	 @FXML
	 private CheckBox idHDcheck;
	 @FXML
	 private Slider idSliderHD;
	 @FXML
	 private Label idLabelHD;
	 @FXML
	 private CheckBox idTABcheck;
    

    public IHMStatistiques() {
		this.listeDiagrammes = new ArrayList<Diagramme>();
		this.listeAffichagesVoulus = new ArrayList<String>();
		this.tab = new Tableau();
		this.histoDiam = new HistogrammeDiametre();
		this.histoSurf = new HistogrammeSurface();
		slideDisHS = true;
	    slideDisHD = true;
	    tabCheck = true;
	    afficher = false;
	}

	/**
     * Permet d'afficher les différents diagrammes de statistiques qui sont dans la liste listeDiagrammes
	 * @param mainContainer 
     */
    public void afficherDiagrammes(AnchorPane mainContainer) {
        // TODO implement here
    	for (Diagramme diag : listeDiagrammes) {
			diag.afficher(mainContainer);
		}
    }
    
    /**
     * ajoute les statistiques d'une image à mettre dans le tableau
     * @param stat
     * @param image 
     */
    public void alimenterTableau(Statistique stat, Image image) {
    	tab.alimenter(stat, image);
    }
    
    /**
     * permet l'alimentation des histogrammes de surface
     * @param ens
     */
    public void alimenterHistoS(EnsembleParticules ens) {
    	histoSurf.alimenterHistoSurface(ens, 20);
    	histoSurf.alimenterHistoSurfaceCumu(ens);
    }
    
    /**
     * permet l'alimentation des histogrammes de diamètres équivalents
     * @param ens
     */
    public void alimenterHistoD(EnsembleParticules ens) {
    	histoDiam.alimenterHistoDiametre(ens, 20);
    	histoDiam.alimenterHistoDiametreCumu(ens);
    }

    /**
     * permet d'ajouter un diagramme dans la liste listeDiagrammes
     * @param diag Diagram à ajouter
     */
    public void ajouter(Diagramme diag) {
        listeDiagrammes.add(diag);
    }

    /**
     * Définit le nombre d'intervalles que comporteront les diagrammes
     * @return entier nombre souhaité
     */
    public int setNbIntervalles() {
        // TODO implement here
        return 0;
    }

    /**
     * Définit les différents diagrammes que l'on souhaitera afficher par la suite
     * @return liste des noms des diagrammes
     */
    public ArrayList<String> setAffichages() {
        // TODO implement here
        return null;
    }
    
    /**
     * Gère l'événement de clic sur le bouton d'export
     */
    public void boutonExport() {
    }
    
    public boolean histoSPresent() {
    	for (Diagramme diag : listeDiagrammes) {
			if (diag instanceof HistogrammeSurface) {
				return true;
			}
		}return false;
    }
    
    public boolean histoDPresent() {
    	for (Diagramme diag : listeDiagrammes) {
			if (diag instanceof HistogrammeDiametre) {
				return true;
			}
		}return false;
    }

	public ArrayList<Diagramme> getListeDiagrammes() {
		return listeDiagrammes;
	}

	public void setListeDiagrammes(ArrayList<Diagramme> listeDiagrammes) {
		this.listeDiagrammes = listeDiagrammes;
	}

	public int getNbIntervalles() {
		return nbIntervalles;
	}

	public void setNbIntervalles(int nbIntervalles) {
		this.nbIntervalles = nbIntervalles;
	}

	public ArrayList<String> getListeAffichagesVoulus() {
		return listeAffichagesVoulus;
	}

	public void setListeAffichagesVoulus(ArrayList<String> listeAffichagesVoulus) {
		this.listeAffichagesVoulus = listeAffichagesVoulus;
	}
	
	public Tableau getTab() {
		return tab;
	}

	public void setTab(Tableau tab) {
		this.tab = tab;
	}

	public HistogrammeDiametre getHistoDiam() {
		return histoDiam;
	}

	public void setHistoDiam(HistogrammeDiametre histoDiam) {
		this.histoDiam = histoDiam;
	}

	public HistogrammeSurface getHistoSurf() {
		return histoSurf;
	}

	public void setHistoSurf(HistogrammeSurface histoSurf) {
		this.histoSurf = histoSurf;
	}
	
	public boolean isAfficher() {
		return afficher;
	}

	@FXML
	 public void initialize() {
		//permet de choisir le nombre d'intervalles
		idHScheck.setOnAction(e -> {
			if (slideDisHS) {idSliderHS.setDisable(false);slideDisHS=false;}
			else {idSliderHS.setDisable(true);slideDisHS=true;}
		});
		//permet d'actualiser le label avec la valeure du Slider
		idSliderHS.valueProperty().addListener(new ChangeListener<Number>() {
	         public void changed(ObservableValue <?extends Number>observable, Number oldValue, Number newValue){
	             idLabelHS.setText(String.valueOf(Math.round(newValue.floatValue())));
	         }
		});
		//permet de choisir le nombre d'intervalles
		idHDcheck.setOnAction(e -> {
			if (slideDisHD) {idSliderHD.setDisable(false);slideDisHD=false;}
			else {idSliderHD.setDisable(true);slideDisHD=true;}
		});
		//permet d'actualiser le label avec la valeure du Slider
		idSliderHD.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue <?extends Number>observable, Number oldValue, Number newValue){
				idLabelHD.setText(String.valueOf(Math.round(newValue.floatValue())));
			}
		});
		//permet de demander l'affichage du tableau
		idTABcheck.setOnAction(e -> {
			if (tabCheck) tabCheck=false;
			else tabCheck=true;
		});
		//lance l'analyse et l'affichage
		idAfficherButton.setOnAction(e -> System.out.println(tabCheck));
	}

}