package com.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bans.Utilisateur;
import com.bdd.Employes;
import com.bdd.Noms;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Noms noms=new Noms();
		request.setAttribute("utilisateurs", noms.recupererUtlisateurs());
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		System.out.println(nom);
		Utilisateur utilisateur=new Utilisateur();
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		System.out.println(prenom);
		
		Noms noms=new Noms();
        noms.set_utlisateur(utilisateur);
		
		
		
		// TODO Auto-generated method stub
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);

	}

}
