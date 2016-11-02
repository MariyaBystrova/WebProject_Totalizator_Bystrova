package by.tr.totalizator.service;

import java.util.List;

import by.tr.totalizator.entity.Match;
import by.tr.totalizator.service.exception.ServiceException;

public interface TotalizatorService {
	List<Match> getCuponMatches(int cuponId) throws ServiceException;
}
