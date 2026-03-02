package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.bean.GameMonthStatistics;
import pe.com.intralot.loto.layer.model.domain.GameStats;
import pe.com.intralot.loto.layer.model.persistence.dao.StatisticDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class StatisticDaoImpl extends HibernateBaseDaoImpl implements StatisticDao {

	@Override
	public List<String> findYearsByGameId(Integer gameId) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId);		
		List<String> resultQueryList = new ArrayList<String>();
		try {
			Object[] values = new Object[1];
	        values[0] = gameId;
	        String queryString = "SELECT s.year FROM GameStats s " +
	        					 "WHERE s.gameId = ? and " +
	        					 	   "s.year <> 0 " +
	        					 	   "GROUP BY s.year " +
	        					  "ORDER BY s.year DESC"; 
	        
			resultQueryList = super.find(queryString, values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) 
				LoggerApi.Log.info("size=" + resultQueryList.size());			
		}
		return resultQueryList;
	}

	@Override
	public Integer findMaxAcountByGameIdByYear(Integer gameId, Integer year) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year);
		List<Integer> resultQueryList = new ArrayList<Integer>();
		Integer maxAcount = 0;
		try {
			Object[] values = new Object[2];
	        values[0] = gameId;
	        values[1] = year;
	        String queryString = "SELECT max(s.count) FROM "
	        		+ "GameStats s WHERE s.gameId = ? and s.year = ?"; 	        
			resultQueryList = super.find(queryString, values);
			maxAcount=Integer.parseInt(DataAccessUtils.uniqueResult(resultQueryList).toString());
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) 
				LoggerApi.Log.info("maxAcount=" + maxAcount);			
		}
		return maxAcount;
	}

	@Override
	public List<GameStats> findByGameByYear(Integer gameId, Integer year) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year);
		List<GameStats> resultQueryList = new ArrayList<GameStats>();
		try {
			Object[] values = new Object[2];
	        values[0] = gameId;
	        values[1] = year;
	        String queryString = "from GameStats s where s.gameId = ? and s.year = ? "
					+ "order by s.number";
	        resultQueryList = super.find(queryString, values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) 
				LoggerApi.Log.info("size=" + resultQueryList.size());			
		}
		return resultQueryList;
	}
	
	@Override
	public Integer findMaxAcountByGameIdByYearByPosition(Integer gameId, Integer year, Integer position) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year + " position="+position);
		List<Long> resultQueryList = new ArrayList<Long>();
		Integer maxAcount = 0;
		try {
			Object[] values = new Object[3];
	        values[0] = gameId;
	        values[1] = year;
	        values[2] = position;
	        String queryString = "select max(s.count) as maximo from "
	        		+ "GameStats s where s.gameId = ? and s.year = ? and s.position = ?"; 	        
			resultQueryList = super.find(queryString, values);
			maxAcount=Integer.parseInt(DataAccessUtils.uniqueResult(resultQueryList).toString());
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) 
				LoggerApi.Log.info("maxAcount=" + maxAcount);			
		}
		return maxAcount;
	}

	@Override
	public List<GameStats> findByGameByYearByPosition(Integer gameId, Integer year, Integer position) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year+" position="+position);
		List<GameStats> resultQueryList = new ArrayList<GameStats>();
		try {
			Object[] values = new Object[3];
	        values[0] = gameId;
	        values[1] = year;
	        values[2] = position;
	        String queryString = "from GameStats s where s.gameId = ? and s.year = ? "
					+ "and s.position = ? order by s.number";
	        resultQueryList = super.find(queryString, values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) 
				LoggerApi.Log.info("size=" + resultQueryList.size());			
		}
		return resultQueryList;
	}

	@Override
	public List<String> findWinningYearsByMonth(Integer gameId) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId);		
		List<String> resultQueryList = new ArrayList<String>();
		try {
			Object[] values = new Object[1];
	        values[0] = gameId;
	        String queryString = "select to_char(d.drDate,'YYYY') from Draw d "
	        		+ "where d.id.gameId = ? group by to_char(d.drDate,'YYYY') order by 1 desc"; 	        
			resultQueryList = super.find(queryString, values);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) 
				LoggerApi.Log.info("size=" + resultQueryList.size());			
		}
		return resultQueryList;
	}

	@Override
	public Integer findMaxSumDrCat1ByGameId(Integer gameId) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId);
		Integer maxSumDrCat1 = 0;
		pe.com.intralot.loto.lib.Dbms dt = null;
		try {
			dt = new pe.com.intralot.loto.lib.Dbms();
	        String queryString = "select max(s) as maximo from "
	        		+ "(select to_char(d.dr_date,'MM'),sum(d.dr_cat_1) as s "
	        		+ "from lotocard.Draw d where d.game_id = ? group by to_char(d.dr_date,'MM') order by 1 asc )";
	        dt.setSql(queryString);
	        dt.setInt(1, gameId);
			dt.executeQuery();
			dt.next();
			maxSumDrCat1=dt.getInt("maximo");
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (dt != null) {
				  try {
					  dt.close();
				  } catch (Exception e1) {}
			}
			if (maxSumDrCat1 != 0) 
				LoggerApi.Log.info("maxAcount=" + maxSumDrCat1);			
		}
		return maxSumDrCat1;
	}

	@Override
	public List<GameMonthStatistics> findStatisticMonthByGame(Integer gameId) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId);
		List<GameMonthStatistics> resultQueryList = new ArrayList<GameMonthStatistics>();
		pe.com.intralot.loto.lib.Dbms dt = null;
		try {
			dt = new pe.com.intralot.loto.lib.Dbms();
	        String queryString = "select to_char(d.dr_Date,'MM') as month,sum(d.dr_Cat_1) as count "
	        		+ "from lotocard.Draw d where d.game_Id = ? and dr_Date is not null group by to_char(d.dr_Date,'MM') order by 1 asc";
	        dt.setSql(queryString);
	        dt.setInt(1, gameId);
			dt.executeQuery();
			while (dt.next()) {
				GameMonthStatistics gms=new GameMonthStatistics();
				gms.setMes(Integer.parseInt(dt.getString("month")));
				gms.setCantidad(dt.getInt("count"));
				resultQueryList.add(gms);
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (dt != null) {
				  try {
					  dt.close();
				  } catch (Exception e1) {}
			}
			if (resultQueryList != null) 
				LoggerApi.Log.info("size=" + resultQueryList.size());			
		}
		return resultQueryList;
	}

	@Override
	public Integer findMaxSumDrCat1ByGameIdByYear(Integer gameId, Integer year) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year);
		Integer maxSumDrCat1 = 0;
		pe.com.intralot.loto.lib.Dbms dt = null;
		try {
			dt = new pe.com.intralot.loto.lib.Dbms();
	        String queryString = "select max(s) as maximo from "
	        		+ "(select to_char(d.dr_date,'MM'),sum(d.dr_cat_1) as s "
	        		+ "from lotocard.Draw d where d.game_id = ? and to_char(d.dr_Date,'YYYY') = ? "
	        		+ "group by to_char(d.dr_date,'MM') order by 1 asc )";
	        dt.setSql(queryString);
	        dt.setInt(1, gameId);
	        dt.setInt(2, year);
			dt.executeQuery();
			dt.next();
			maxSumDrCat1=dt.getInt("maximo");
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (dt != null) {
				  try {
					  dt.close();
				  } catch (Exception e1) {}
			}
			if (maxSumDrCat1 != 0) 
				LoggerApi.Log.info("maxAcount=" + maxSumDrCat1);			
		}
		return maxSumDrCat1;		
	}

	@Override
	public List<GameMonthStatistics> findStatisticMonthByGameByYear(Integer gameId, Integer year) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year);
		List<GameMonthStatistics> resultQueryList = new ArrayList<GameMonthStatistics>();
		pe.com.intralot.loto.lib.Dbms dt = null;
		try {
			dt = new pe.com.intralot.loto.lib.Dbms();
	        String queryString = "select to_char(d.dr_Date,'MM') as month,sum(d.dr_Cat_1) as count "
	        		+ "from lotocard.Draw d where d.game_Id = ? and to_char(d.dr_Date,'YYYY') = ? "
	        		+ "group by to_char(d.dr_Date,'MM') order by 1 asc";
	        dt.setSql(queryString);
	        dt.setInt(1, gameId);
	        dt.setInt(2, year);
			dt.executeQuery();
			while (dt.next()) {
				GameMonthStatistics gms=new GameMonthStatistics();
				gms.setMes(Integer.parseInt(dt.getString("month")));
				gms.setCantidad(dt.getInt("count"));
				resultQueryList.add(gms);
			}
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (dt != null) {
				  try {
					  dt.close();
				  } catch (Exception e1) {}
			}
			if (resultQueryList != null) 
				LoggerApi.Log.info("size=" + resultQueryList.size());			
		}
		return resultQueryList;
	}
}
