package com.bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


import com.bans.Articl;

public class Articls {
	
  private Connection conexion ;
  public List<Articl> Affichage(){
	  List<Articl> articls=new ArrayList<Articl>(); 
	  conexion=null ;
		Statement statement=null ;
		ResultSet result=null;
		load_database();
		try{
			statement= conexion.createStatement();  //statement for excute request SQL 
			result=statement.executeQuery("select n,lang,Ow from articl;");
			
		  
		  while(result.next()) {
			  Articl article=new Articl();
			  int n=result.getInt("n");
			  String lang=result.getString("lang");
			  String owner=result.getString("Ow");
			  article.setN(n);
			  article.setOwner(owner);
			  article.setLang(lang);
			  articls.add(article);
			  
			  
			  
		  }
		  
	  }catch (SQLException e ) {}
	  
	  
	return articls;
	  
  }
   
   

	
	
	public void load_database() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
		}catch (ClassNotFoundException e) {}
		
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "");
		}catch(SQLException e) {}
		
		
	}

}
