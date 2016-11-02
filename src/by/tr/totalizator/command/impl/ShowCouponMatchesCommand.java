package by.tr.totalizator.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tr.totalizator.command.Command;
import by.tr.totalizator.command.exception.CommandException;
import by.tr.totalizator.controller.PageName;
import by.tr.totalizator.entity.Match;
import by.tr.totalizator.service.TotalizatorService;
import by.tr.totalizator.service.exception.ServiceException;
import by.tr.totalizator.service.factory.ServiceFactory;
import by.tr.totalizator.tag.JSPListBean;

public class ShowCouponMatchesCommand implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();
	
	private final static String CURRENT_URL = "currentUrl";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String url = "Controller?command=show_coupon_matches";

		request.getSession(false).setAttribute(CURRENT_URL, url);

		String page = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		TotalizatorService totoService = factory.getTotaliztorService();

		try {	
				List<Match> list = totoService.getCuponMatches(1);
				
				JSPListBean jsp = new JSPListBean(list);
				request.setAttribute("list", jsp);

				page = PageName.USER_PAGE_TOTO;
			
		} catch (ServiceException e) {
			rootLogger.error(e.getMessage());
			page = PageName.ERROR_PAGE;
		}

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("Problems with forwarding page.", e);
		}
	}

}
