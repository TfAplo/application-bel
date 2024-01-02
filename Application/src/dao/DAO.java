package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public abstract class DAO<T> {
	protected Connection connect;
	protected Statement stmt;
	
	public DAO() {
	}
	
	public void open() {
		try {
			connect=  SingleConnection.getInstance();
			stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" === ERREUR OPEN DAO === ");
			e.printStackTrace();
		}
		
	}
	
	public void close(){
		//on ferme l'acces a la BDD
		try {
			SingleConnection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" === ERREUR CLOSE DAO === ");
			e.printStackTrace();
		}
	}
	
	/**
	 * Permet de récupérer les objets
	 * @return
	 */
	public abstract ArrayList<T> lire();
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T creer(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract T mettreAJour(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void supprimer(T obj);

}
