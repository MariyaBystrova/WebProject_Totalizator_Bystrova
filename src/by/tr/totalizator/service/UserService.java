package by.tr.totalizator.service;

import by.tr.totalizator.entity.User;
import by.tr.totalizator.service.exception.ServiceException;

public interface UserService {
	boolean registerUser(String fName, String lName, String sex, String email, String country, String city,
			String address, String role, String login, String password, String passworgRep) throws ServiceException;

	User authentication(String login, String password) throws ServiceException;
}
