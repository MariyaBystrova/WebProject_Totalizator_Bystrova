package by.tr.totalizator.service.impl;

import java.util.List;

import by.tr.totalizator.dao.TotalizatorOperationDAO;
import by.tr.totalizator.dao.exception.DAOException;
import by.tr.totalizator.dao.factory.DAOFactory;
import by.tr.totalizator.entity.Match;
import by.tr.totalizator.service.TotalizatorService;
import by.tr.totalizator.service.exception.ServiceException;

public class EditTotalizator implements TotalizatorService {

	@Override
	public List<Match> getCuponMatches(int cuponId) throws ServiceException {
		if (cuponId < 0) {
			throw new ServiceException("Invalid data: cupon_id must be greater then 0.");
		}

		DAOFactory factory = DAOFactory.getInstance();
		TotalizatorOperationDAO userDAO = factory.getTotalizatorOperationDAO();
		
		List<Match> list = null;
		try {
			list = userDAO.getCuponMatches(cuponId);
		} catch (DAOException e) {
			throw new ServiceException("Get cupon matches failed.", e);
		}
		return list;
	}

}
