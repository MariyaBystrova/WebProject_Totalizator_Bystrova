package by.tr.totalizator.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.tr.totalizator.connectionpool.ConnectionPool;
import by.tr.totalizator.connectionpool.exception.ConnectionPoolException;
import by.tr.totalizator.dao.TotalizatorOperationDAO;
import by.tr.totalizator.dao.exception.DAOException;
import by.tr.totalizator.entity.Match;

public class SQLTotalizatorOperationDAO implements TotalizatorOperationDAO {
	private final static String SELECT_MATCHES_WHERE_CUPONID = "SELECT m.`match_id`, m.`match_name`, m.`cupon_id`, m.`team_one`, m.`team_two`, m.`start_date`, m.`end_date` FROM `match` AS m WHERE m.`cupon_id`=?;";

	@Override
	public List<Match> getCuponMatches(int cuponId) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Match> list = new ArrayList<>();
		try {
			con = connectionPool.takeConnection();
			ps = con.prepareStatement(SELECT_MATCHES_WHERE_CUPONID);
			ps.setInt(1, cuponId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Match match = new Match(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6), rs.getTimestamp(7));
				list.add(match);
			}

		} catch (SQLException e) {
			throw new DAOException("Database access error.", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool error.", e);
		} finally {
			connectionPool.closeConnection(con, ps, rs);	 
		}
		return list;
	}

}
