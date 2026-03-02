package pe.com.intralot.loto.layer.model.persistence.dao;

import java.util.List;

import pe.com.intralot.loto.layer.model.bean.GameMonthStatistics;
import pe.com.intralot.loto.layer.model.domain.GameStats;

/**
 * @author:   Zolanch Tavara Sandon
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

public interface StatisticDao {
		
	public List<String> findYearsByGameId(Integer gameId) throws Exception;
	public Integer findMaxAcountByGameIdByYear(Integer gameId, Integer year) throws Exception;
	public List<GameStats> findByGameByYear(Integer gameId, Integer year) throws Exception;
	public Integer findMaxAcountByGameIdByYearByPosition(Integer gameId, Integer year, Integer position) throws Exception;
	public List<GameStats> findByGameByYearByPosition(Integer gameId, Integer year, Integer position) throws Exception;
	public List<String> findWinningYearsByMonth(Integer gameId) throws Exception;
	public Integer findMaxSumDrCat1ByGameId(Integer gameId) throws Exception;
	public List<GameMonthStatistics> findStatisticMonthByGame(Integer gameId) throws Exception;
	public Integer findMaxSumDrCat1ByGameIdByYear(Integer gameId, Integer year) throws Exception;
	public List<GameMonthStatistics> findStatisticMonthByGameByYear(Integer gameId, Integer year) throws Exception;

}