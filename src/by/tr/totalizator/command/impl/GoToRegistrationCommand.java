package by.tr.totalizator.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.totalizator.command.Command;
import by.tr.totalizator.command.exception.CommandException;
import by.tr.totalizator.controller.PageName;

public class GoToRegistrationCommand implements Command {
	private final static String CURRENT_URL_ATTR = "currentUrl";
	private final static String CURRENT_URL = "Controller?command=go-to-registration";
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException{
		
		String currentURL = CURRENT_URL;
		request.getSession(false).setAttribute(CURRENT_URL_ATTR, currentURL);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PageName.REGISTRATION_PAGE);
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("Problems with forwarding page.", e);
		}
	}

}
