package by.tr.totalizator.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tr.totalizator.command.Command;
import by.tr.totalizator.command.CommandProvider;
import by.tr.totalizator.command.exception.CommandException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String COMMAND_NAME = "command";
	private final CommandProvider commandHelper = new CommandProvider();
	private final static Logger rootLogger = LogManager.getRootLogger();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
		String commandName = null;
		Command command = null;

		commandName = request.getParameter(COMMAND_NAME);
		command = commandHelper.getCommand(commandName);
		try {
			command.execute(request, response);
		} catch (CommandException e1) {
			rootLogger.error(e1.getMessage());
			page = PageName.ERROR_PAGE;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			try {														
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				rootLogger.error(e.getMessage());
			} 
		}
	}

}
