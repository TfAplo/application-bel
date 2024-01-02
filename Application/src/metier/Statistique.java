package metier;

public class Statistique {
	private int idStatistique;
	private int nbParticulesTrouvees;
	private double ratioSurfaceCouverte;
	private double moyenneAires;
	private double moyenneDiametresEquivalents;
	private double ecartTypeAires;
	private double ecartTypeDiametreEquivalent;
	private int idImage;
	
	/**
	 * Constructeur permettant de calculer directement à partir d'un ensemble de particules
	 * @param ens Ensemble dans lequel il y a les particules d'une seule image
	 */
	public Statistique(EnsembleParticules ens) {
		nbParticulesTrouvees = ens.getNombreParticules();
		ratioSurfaceCouverte = ens.getRatioSurfaceCouverte();
		moyenneAires = ens.getMoyenneAires();
		moyenneDiametresEquivalents = ens.getMoyenneDiametresEquivalents();
		ecartTypeAires = ens.getEcartTypeAires();
		ecartTypeDiametreEquivalent = ens.getEcartTypeDiametresEquivalents();
	}
	
}
