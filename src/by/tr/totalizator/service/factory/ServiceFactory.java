package by.tr.totalizator.service.factory;

import by.tr.totalizator.service.TotalizatorService;
import by.tr.totalizator.service.UserService;
import by.tr.totalizator.service.impl.EditTotalizator;
import by.tr.totalizator.service.impl.EditUser;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private UserService userService = new EditUser();
	private TotalizatorService totaliztorService = new EditTotalizator();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public TotalizatorService getTotaliztorService() {
		return totaliztorService;
	}

	
}
