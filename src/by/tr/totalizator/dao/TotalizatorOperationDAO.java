package by.tr.totalizator.dao;

import java.util.List;

import by.tr.totalizator.dao.exception.DAOException;
import by.tr.totalizator.entity.Match;

public interface TotalizatorOperationDAO {
	List<Match> getCuponMatches(int cuponId) throws DAOException;
	
}
