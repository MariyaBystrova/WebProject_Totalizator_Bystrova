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
import by.tr.totalizator.service.UserService;
import by.tr.totalizator.service.exception.ServiceException;
import by.tr.totalizator.service.factory.ServiceFactory;

public class RegisterUserCommand implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();

	private final static String FIRST_NAME = "firstName";
	private final static String LAST_NAME = "lastName";
	private final static String SEX = "sex";
	private final static String EMAIL = "email";
	private final static String COUNTRY = "country";
	private final static String CITY = "city";
	private final static String ADDRESS = "address";
	private final static String USER = "user";
	private final static String LOGIN = "login";
	private final static String PASSWORD = "password";
	private final static String PASSWORD_AGAIN = "passwordAgain";
	private final static String CURRENT_URL_ATTR = "currentUrl";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		String url = "Controller?command=registration&firstName=" + request.getParameter(FIRST_NAME) + "&lastName="
				+ request.getParameter(LAST_NAME) + "&sex=" + request.getParameter(SEX) + "&email="
				+ request.getParameter(EMAIL) + "&country=" + request.getParameter(COUNTRY) + "&city="
				+ request.getParameter(CITY) + "&address=" + request.getParameter(ADDRESS) + "&login="
				+ request.getParameter(LOGIN) + "&password=" + request.getParameter(PASSWORD) + "&passwordAgain="
				+ request.getParameter(PASSWORD_AGAIN);

		request.getSession(false).setAttribute(CURRENT_URL_ATTR, url);

		ServiceFactory sf = ServiceFactory.getInstance();
		UserService userService = sf.getUserService();

		// role

		String page = null;

		try {
			boolean result = userService.registerUser(request.getParameter(FIRST_NAME), request.getParameter(LAST_NAME),
					request.getParameter(SEX), request.getParameter(EMAIL), request.getParameter(COUNTRY),
					request.getParameter(CITY), request.getParameter(ADDRESS), USER, request.getParameter(LOGIN),
					request.getParameter(PASSWORD), request.getParameter(PASSWORD_AGAIN));
			if (result) {
				page = PageName.REGISTRATION_COMPLETED_PAGE;

			} else {
				page = PageName.REGISTRATION_PAGE;
			}
		} catch (ServiceException e) {
			rootLogger.error(e.getMessage());
			page = PageName.REGISTRATION_PAGE;
		}

		try {
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(page);
			reqDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("Problems with forwarding page.", e);
		}

	}

}
