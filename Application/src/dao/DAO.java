package dao;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {
	protected Connection connect;
	
	public DAO() {
	}
	
	public static void open() {
		
	}
	
	public static void close() {
		
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
