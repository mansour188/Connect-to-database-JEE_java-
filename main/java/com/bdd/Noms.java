package com.bdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.bans.Utilisateur;

public class Noms {
	  private Connection connexion;

	public List<Utilisateur> recupererUtlisateurs(){
		
		List<Utilisateur> utilisateurs=new ArrayList<Utilisateur>();
		

		
		
		connexion=null ;
		Statement statement=null ;
		ResultSet resultat=null ;
		load_database();
		try {
			
			
			
			
			statement= connexion.createStatement();
			resultat=statement.executeQuery("SELECT nom,prenom FROM noms ;");
			

			
			while (resultat.next()) {
			 String nom=resultat.getString("nom");
			 String prenom=resultat.getString("prenom");
			 Utilisateur utilisateur=new Utilisateur();
			 utilisateur.setNom(nom);
			 utilisateur.setPrenom(prenom);
			 utilisateurs.add(utilisateur);
				
			}
			
		}catch(SQLException e) {System.out.println("drivr try no no no no no no");}finally {
			try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
		}
		
		
		
		return utilisateurs;
		
		
	}
	
	
	public void set_utlisateur(Utilisateur utilisateur) {
		load_database();
		try {
			PreparedStatement prep=connexion.prepareStatement("insert into noms(nom,prenom) VALUES (?,?) ;");
			prep.setString(1, utilisateur.getNom());
			prep.setString(2, utilisateur.getPrenom());
			prep.executeUpdate();
			
		}catch(SQLException e ) {
			
		}
		
	}
	public void load_database() {
         try {
			
			     Class.forName("com.mysql.cj.jdbc.Driver");

			
		  }catch(ClassNotFoundException e) {}
         try {
        	connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","");
         } catch(SQLException e){ e.printStackTrace();
}
         
		
	}

}
