package by.tr.totalizator.service.impl;

import by.tr.totalizator.dao.UserOperationDAO;
import by.tr.totalizator.dao.exception.DAOException;
import by.tr.totalizator.dao.factory.DAOFactory;
import by.tr.totalizator.entity.User;
import by.tr.totalizator.service.UserService;
import by.tr.totalizator.service.exception.ServiceException;

public class EditUser implements UserService {

	@Override
	public boolean registerUser(String fName, String lName, String sex, String email, String country, String city,
			String address, String role, String login, String password, String passworgRep) throws ServiceException {

		if (!registrationValidator(fName, lName, sex, email, country, city, address, role, login, password,
				passworgRep)) {
			throw new ServiceException("Invalid date.");
		}
		
		city = city.isEmpty() ? null : city; //city and address are unnecessary for fulfilling
		address = address.isEmpty() ? null : address;
		User user = new User(fName, lName, sex, email, country, city, address, role);

		DAOFactory factory = DAOFactory.getInstance();
		UserOperationDAO userDAO = factory.getUserOperationDAO();
		try {
			userDAO.createUser(user, login, password);
		} catch (DAOException e) {
			throw new ServiceException("Create user failed.", e);
		}
		return true;
	}

	@Override
	public User authentication(String login, String password) throws ServiceException {
		User user = null;
		if (!authenticationValidator(login, password)) {
			throw new ServiceException("Invalid login or password.");
		}
		DAOFactory factory = DAOFactory.getInstance();
		UserOperationDAO userOpDao = factory.getUserOperationDAO();
		try {
			user = userOpDao.authentication(login, password);
		} catch (DAOException e) {
			throw new ServiceException("Autentication failed. ", e);
		}
		return user;
	}

	
	
	
	private boolean authenticationValidator(String login, String password) {
		if (login.isEmpty()) {
			return false;
		}
		if (password.isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean registrationValidator(String fName, String lName, String sex, String email, String country,
			String city, String address, String role, String login, String password, String passwordRep) {
		if (!password.equals(passwordRep)) {
			return false;
		}
		if (fName.isEmpty()) {
			return false;
		}
		if (lName.isEmpty()) {
			return false;
		}
		if (sex.isEmpty()) {
			return false;
		}
		if (email.isEmpty()) {
			return false;
		}
		if (country.isEmpty()) {
			return false;
		}
		if (role.isEmpty()) {
			return false;
		}
		if (login.isEmpty()) {
			return false;
		}
		return true;
	}

}
