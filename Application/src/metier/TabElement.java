package metier;

public class TabElement {
	public String nomImage;
	public int grossissement;
	private int nbParticulesTrouvees;
	private double ratioSurfaceCouverte;
	private double moyenneAires;
	private double moyenneDiametresEquivalents;
	private double ecartTypeAires;
	private double ecartTypeDiametreEquivalent;
	
	public TabElement(String nomImage, int grossissement, int nbParticulesTrouvees, double ratioSurfaceCouverte,
			double moyenneAires, double moyenneDiametresEquivalents, double ecartTypeAires,
			double ecartTypeDiametreEquivalent) {
		this.nomImage = nomImage;
		this.grossissement = grossissement;
		this.nbParticulesTrouvees = nbParticulesTrouvees;
		this.ratioSurfaceCouverte = ratioSurfaceCouverte;
		this.moyenneAires = moyenneAires;
		this.moyenneDiametresEquivalents = moyenneDiametresEquivalents;
		this.ecartTypeAires = ecartTypeAires;
		this.ecartTypeDiametreEquivalent = ecartTypeDiametreEquivalent;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public int getGrossissement() {
		return grossissement;
	}

	public void setGrossissement(int grossissement) {
		this.grossissement = grossissement;
	}

	public int getNbParticulesTrouvees() {
		return nbParticulesTrouvees;
	}

	public void setNbParticulesTrouvees(int nbParticulesTrouvees) {
		this.nbParticulesTrouvees = nbParticulesTrouvees;
	}

	public double getRatioSurfaceCouverte() {
		return ratioSurfaceCouverte;
	}

	public void setRatioSurfaceCouverte(double ratioSurfaceCouverte) {
		this.ratioSurfaceCouverte = ratioSurfaceCouverte;
	}

	public double getMoyenneAires() {
		return moyenneAires;
	}

	public void setMoyenneAires(double moyenneAires) {
		this.moyenneAires = moyenneAires;
	}

	public double getMoyenneDiametresEquivalents() {
		return moyenneDiametresEquivalents;
	}

	public void setMoyenneDiametresEquivalents(double moyenneDiametresEquivalents) {
		this.moyenneDiametresEquivalents = moyenneDiametresEquivalents;
	}

	public double getEcartTypeAires() {
		return ecartTypeAires;
	}

	public void setEcartTypeAires(double ecartTypeAires) {
		this.ecartTypeAires = ecartTypeAires;
	}

	public double getEcartTypeDiametreEquivalent() {
		return ecartTypeDiametreEquivalent;
	}

	public void setEcartTypeDiametreEquivalent(double ecartTypeDiametreEquivalent) {
		this.ecartTypeDiametreEquivalent = ecartTypeDiametreEquivalent;
	}
	
	
	
	
}
