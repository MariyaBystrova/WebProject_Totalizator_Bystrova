package by.tr.totalizator.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tr.totalizator.command.Command;
import by.tr.totalizator.command.exception.CommandException;
import by.tr.totalizator.controller.PageName;
import by.tr.totalizator.entity.User;
import by.tr.totalizator.service.UserService;
import by.tr.totalizator.service.exception.ServiceException;
import by.tr.totalizator.service.factory.ServiceFactory;

public class LoginCommand implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();

	private final static String LOGIN = "login";
	private final static String PASSWORD = "password";
	private final static String ADMIN = "admin";
	private final static String USER = "user";
	private final static String ROLE = "role";
	private final static String USER_ID = "user_id";
	private final static String CURRENT_URL = "currentUrl";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		String url = "Controller?command=Logination&login=" + request.getParameter(LOGIN) + "&password="
				+ request.getParameter(PASSWORD);

		request.getSession(false).setAttribute(CURRENT_URL, url);

		String page = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();

		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);

		try {
			User user = userService.authentication(login, password);
			if (user != null) {

				request.getSession(true).setAttribute(ROLE, user.getRole());
				request.getSession(true).setAttribute(USER_ID, user.getId());

				if (user.getRole().equals(ADMIN)) {
					page = PageName.ADMIN_PAGE;
				}
				if (user.getRole().equals(USER)) {
					page = PageName.USER_PAGE_GENERAL;
				}
			} else {
				page = PageName.INDEX_PAGE;
			}
		} catch (ServiceException e) {
			rootLogger.error(e.getMessage());
			page = PageName.INDEX_PAGE;
		}

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("Problems with forwarding page.", e);
		}

	}

}