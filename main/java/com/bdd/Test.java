package com.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bans.User;

public class Test {
	 private Connection connexion ; 

	public List<User> Afficher(){
		List<User> users=new ArrayList<User>(); 
		
	connexion=null;
	Statement st=null;
	ResultSet result=null;
	load_database();
	
	
	try {
		st=connexion.createStatement();
		result=st.executeQuery("select nom,prenom from noms;");
		while(result.next()) {
			User user=new User();
			String name=result.getString("nom");
			String last_name=result.getString("prenom");
			user.setName(name);
			user.setLast_name(last_name);
			users.add(user);
		}
	}catch(SQLException e ) {}finally{
try {
	if(connexion !=null && st !=null && result !=null ) {
		connexion.close();
		st.close();
		result.close();
	}
}catch(SQLException ignore) {}
	}
	
		
		
		return users;
		
	}
	
	public void set_user(User user) {
		load_database();
		try {
			PreparedStatement prep=connexion.prepareStatement("insert into noms(nom,prenom) values(?,?);");
			prep.setString(1, user.getName());
			prep.setString(2, user.getLast_name());
			
			prep.executeUpdate();
		}catch(SQLException e) {}
		
	}
	public void load_database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {}
		
		try {
			connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","");
		}catch(SQLException e ){e.printStackTrace();}
	}

}
