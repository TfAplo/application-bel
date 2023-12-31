package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import dao.SingleConnection;
import metier.Image;

/**
 * Classe servant a effectuer des operations entre l'objet Image et son equivalent, la table Image, dans la base de donnees.
 */
public class ImageDAO extends DAO<Image>{

	Connection cn=null;
    /**
     * Default constructor
     */
    public ImageDAO() {
    }

    /**
     * Methode de creation d'une image dans la base de donnees a partir des attributs de l'objet Image.
     * @param image Instance de la classe Image devant etre inseree dans la base de donnees.
     * @return Instance de la classe Image ayant ete inseree dans la base de donnees.
     */
    @Override
    public Image creer(Image image) {
    	
    	//recuperation des attributs
        int idImage;
        String nomFichier = image.getNomFichier();
        int largeurPx = image.getLargeurPx();
        int hauteurPx = image.getHauteurPx();
        int grossissement = image.getGrossissement();
        double largeurImage = image.getLargeurImage();
        String url = image.getUrl();
        
        //creation de la requete SQL
        String sql = "INSERT INTO image (nomFichier, largeurPx, hauteurPx, grossissement, largeurImage, url) "
        		+ "VALUES ('"+ nomFichier +"'," + largeurPx+"," + hauteurPx +"," +largeurImage +",'"+url + "')";
        
        // Execution de la requete
 		try {
 			stmt = cn.createStatement();
 			idImage = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
 			
 			//Creation de l'objet image
 			Image newImage = new Image(idImage, nomFichier, grossissement, grossissement, grossissement, largeurImage, url);
 			return newImage;
 		}
 		catch(SQLException e) {
 			System.err.println("Erreur requete SQL");
 			e.printStackTrace();
 		}
        return null;
    }

    /**
     * Methode de lecture d'une image dans la base de donnees a partir des attributs de l'objet Image.
     * @param idImage ID de l'image devant etre lue dans la base de donnees.
     * @return Instance de la classe Image contenant les donnees lu dans la base de donnees par rapport a l'ID.
     */

    public Image lire(int idImage) {
    	
    	 //creation de la requete SQL
    	String sql = "SELECT * FROM image WHERE idImage = " + idImage;
    	

 		ResultSet rs = null;
 		try {
 			stmt = cn.createStatement();
 			rs = stmt.executeQuery(sql);

 			while(rs.next()) {
 		        String nomImage = rs.getString("nomFichier");
 		        int largeurPx = rs.getInt("largeurPx");
 		        int hauteurPx = rs.getInt("hauteurPx");
 		        int grossissement = rs.getInt("grossissement");
 		        double largeurImage = rs.getDouble("largeurImage");
 		        String url = rs.getString("url");
 		        
 		     //Creation de l'objet image
			Image newImage = new Image(idImage, nomImage, grossissement, grossissement, grossissement, largeurImage, url);
			return newImage;
 			}
 		}
 		catch(SQLException e) {
 			System.err.println("Erreur requete SQL");
 			e.printStackTrace();
 		}
        return null;
    }

    /**
     * Methode de mise a jour d'une image dans la base de donnees a partir des attributs de l'objet Image.
     * @param image Instance de la classe Image devant etre mise a jour dans la base de donnees.
     * @return Instance de la classe Image ayant ete mise a jour dans la base de donnees.
     */
    @Override
    public Image mettreAJour(Image image) {
    	
    	//recuperation des attributs
    	int idImage = image.getIdImage();
        String nomImage = image.getNomFichier();
        int largeurPx = image.getLargeurPx();
        int hauteurPx = image.getHauteurPx();
        int grossissement = image.getGrossissement();
        double largeurImage = image.getLargeurImage();
        String url = image.getUrl();
         
        //creation de la requete SQL
        String sql = "UPDATE image SET nomFichier = '" + nomImage+ "',";
        sql += "largeurPx = '" + largeurPx  + "',";
        sql += "hauteurPx = '" +hauteurPx +"',";
        sql += "grossissement = '"+ grossissement + "',";
        sql += "largeurImage = '"+ largeurImage + "',";
        sql += "url= '" + url + "' WHERE idImage = " + idImage;
         
        //Execution de la requete
        try {
        	stmt.executeUpdate(sql);
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
        return image;
    }

    /**
     * Methode de suppression d'une image dans la base de donnees a partir des attributs de l'objet Image.
     * @param image Instance de la classe Image devant etre supprimee dans la base de donnees.
     */
    @Override
    public void supprimer(Image image) {
        // TODO implement here
    }
    
    /**
     * @param nomFichier 
     * @return , une liste contenant les noms des images qui sont retournées d'apres la recherche. 
     */
    public ArrayList<String> lire(String nomFichier) {
        // TODO implement here
        return null;
    }

	@Override
	public ArrayList<Image> lire() {
		// TODO Auto-generated method stub
		return null;
	}

}