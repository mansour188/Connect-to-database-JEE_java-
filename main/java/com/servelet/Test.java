package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bans.Personne;
import com.forms.ConectionForm;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        
	        
	        Personne personne=new Personne() ;
	        personne.setAge("11");
	        request.setAttribute("personne", personne);
	        
	        String  age=personne.getAge();
	        String var ="hi iam heer";
	        request.setAttribute("variable", var);
	        String [] alphas= { "A" ,"B","C","D","E"};
	        request.setAttribute("alphas", alphas);
	        
	        	

	        
	        
	        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated  method stub
		HttpSession  session= request.getSession();
		String login=request.getParameter("login");
		String pass=request.getParameter("pass");
		session.setAttribute("login", login);
		session.setAttribute("pass",pass);
		
		ConectionForm form=new ConectionForm();
		form.virefication(request);
		String  result=form.getResult();
		request.setAttribute("form", form);
		request.setAttribute("result", result);
	     
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
		
	}

}
