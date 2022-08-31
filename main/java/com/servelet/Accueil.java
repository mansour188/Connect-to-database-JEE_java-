package com.servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bans.User;
import com.bdd.Test;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		String name="mansour";
	    request.setAttribute("name", name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String last_name=request.getParameter("last_name");
		User user=new User();
		user.setName(name);
		user.setLast_name(last_name);
		Test test=new Test();
		test.set_user(user);
		List<User> users=test.Afficher();
		request.setAttribute("users", users);
	
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
	}

}
