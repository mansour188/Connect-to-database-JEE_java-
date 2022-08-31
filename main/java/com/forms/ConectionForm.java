package com.forms;


import javax.servlet.http.HttpServletRequest;

public class ConectionForm {

	private String result ;
	public void virefication(HttpServletRequest request) {
		String login=request.getParameter("login");
		String pass=request.getParameter("pass");
		if (pass.equals(login+"123")) {
			result="welcome "+ login;
					
		}
		else {
			result="password or login incorrect";
		}
		
	}
	

	public String getResult() {
		return result;
	}

}
