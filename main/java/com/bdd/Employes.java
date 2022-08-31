package com.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bans.Employe;

public class Employes {
	private Connection connexion;

	public List<Employe> affiche(){
		List<Employe> employes =new ArrayList<Employe>(); 
		
		
		
		connexion=null ;
		Statement statement=null ;
		ResultSet result=null;
		load_database();
		try{
			statement= connexion.createStatement();  //statement for excute request SQL 
			result=statement.executeQuery("select mat,nom from employe ;");
			

			
			
			while(result.next()) {
				Employe ep=new Employe();
				int mat=result.getInt("mat");
				String nom=result.getString("nom");
				ep.setMat(mat);
				ep.setNom(nom);
				employes.add(ep);
				
			}
			
		}catch (SQLException e) {}finally{
			try {
				if (connexion !=null) {
					connexion.close();
				}
				if (statement !=null) {
					statement.close();
				}
				if (result !=null) {
					result.close();
				}
			}catch(SQLException e) {}
			
		}
		
		
		
		return employes ;
		
	}
	

	
	
	
	
	
	public void load_database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");   //charger deriver jdbc (/webapp/lib/mysqlconecteur)
		}catch (ClassNotFoundException e) {}
		try {
			connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root",""); //connection with database 
			
		}catch(SQLException e ) {}
	}
}
