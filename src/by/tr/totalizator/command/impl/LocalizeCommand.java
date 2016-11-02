package by.tr.totalizator.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tr.totalizator.command.Command;
import by.tr.totalizator.command.exception.CommandException;

public class LocalizeCommand implements Command {
	
	private final static String CURRENT_URL = "currentUrl";
	private final static String LOCAL = "local";
	private final static String COMMAND = "command";
	private final static String LOCALHOST = "http://localhost:8080/Totalizator/";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		request.getSession(false).setAttribute(LOCAL, request.getParameter(COMMAND));
		try {
			if (request.getSession(false).getAttribute(CURRENT_URL) != null) {

				response.sendRedirect(LOCALHOST + request.getSession(false).getAttribute(CURRENT_URL));

			} else {
				response.sendRedirect(LOCALHOST);
			}
		} catch (IOException e) {
			throw new CommandException("Problems with sendRedirecting page.", e);
		}
	}

}
