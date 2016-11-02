package by.tr.totalizator.command.impl;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.totalizator.command.Command;
import by.tr.totalizator.command.exception.CommandException;

public class LogoutCommand implements Command {
	
	private final static String ROLE = "role";
	private final static String USER_ID = "user_id";
	private final static String CURRENT_URL_ATTR = "currentUrl";
	private final static String CURRENT_URL = "Controller?command=logout";
	private final static String URL_INDEX = "http://localhost:8080/Totalizator/index.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		request.getSession(false).removeAttribute(ROLE);
		request.getSession(false).removeAttribute(USER_ID);
		
		request.getSession(false).setAttribute(CURRENT_URL_ATTR, CURRENT_URL);
		request.getSession(false).invalidate();
		
		try {
			response.sendRedirect(URL_INDEX);
		} catch (IOException e) {
			throw new CommandException("Problems with sendRedirecting page.", e);
		}
		
	}

}
