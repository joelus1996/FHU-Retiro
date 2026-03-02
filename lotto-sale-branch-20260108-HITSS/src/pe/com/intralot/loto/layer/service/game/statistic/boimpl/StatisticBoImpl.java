package pe.com.intralot.loto.layer.service.game.statistic.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.model.bean.GameMonthStatistics;
import pe.com.intralot.loto.layer.model.domain.GameStats;
import pe.com.intralot.loto.layer.model.domain.TicketProcedureGetPrizesList;
import pe.com.intralot.loto.layer.model.persistence.dao.StatisticDao;
import pe.com.intralot.loto.layer.service.game.statistic.bo.StatisticBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;


@Service
public class StatisticBoImpl implements StatisticBo {

	@Autowired
	private StatisticDao statisticDao;
	
	@Override
	public ArrayList<String> consultarAnios(int gameId) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId);
		
		List<String> resultQueryList = new ArrayList<String>();
		try {
			resultQueryList = statisticDao.findYearsByGameId(gameId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("size=" + resultQueryList.size());
		}
		return new ArrayList<String>(resultQueryList);
	}

	@Override
	public ArrayList<GameStats> consultarEstadisticas(int gameId, int year) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year);
		
		List<GameStats> resultQueryList = new ArrayList<GameStats>();
		Integer maxAcount=0;
		try {
			maxAcount = statisticDao.findMaxAcountByGameIdByYear(gameId, year);
			resultQueryList = statisticDao.findByGameByYear(gameId, year);
			for (GameStats gameStats : resultQueryList) {
				gameStats.setAncho((maxAcount <= 0) ? 0 : (int)(gameStats.getCount()*100/maxAcount));
			}

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("size=" + resultQueryList.size());
		}
		return new ArrayList<GameStats>(resultQueryList);
	}

	@Override
	public ArrayList<GameStats> consultarEstadisticasPorPosicion(int gameId, int year, int position) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year + " position="+position);
		
		List<GameStats> resultQueryList = new ArrayList<GameStats>();
		Integer maxAcount=0;
		try {
			maxAcount = statisticDao.findMaxAcountByGameIdByYearByPosition(gameId, year, position);
			resultQueryList = statisticDao.findByGameByYearByPosition(gameId, year, position);
			for (GameStats gameStats : resultQueryList) {
				gameStats.setAncho((maxAcount <= 0) ? 0 : (int)(gameStats.getCount()*100/maxAcount));
			}

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("size=" + resultQueryList.size());
		}
		return new ArrayList<GameStats>(resultQueryList);
	}

	@Override
	public ArrayList<String> consultarAniosGanadoresPorMes(int gameId) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId);
		
		List<String> resultQueryList = new ArrayList<String>();
		try {
			resultQueryList = statisticDao.findWinningYearsByMonth(gameId);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("size=" + resultQueryList.size());
		}
		return new ArrayList<String>(resultQueryList);
	}

	@Override
	public ArrayList<GameMonthStatistics> consultarEstadisticasPorMes(int gameId, int year) throws Exception {
		LoggerApi.Log.info("gameId=" + gameId+" year="+year);
		
		ArrayList<GameMonthStatistics> resultQueryList = new ArrayList<GameMonthStatistics>();
		Integer maxAcount=0;
		try {
			if(year==0) {
				maxAcount = statisticDao.findMaxSumDrCat1ByGameId(gameId);
				resultQueryList = new ArrayList<GameMonthStatistics>(statisticDao.findStatisticMonthByGame(gameId));
			}else {
				maxAcount = statisticDao.findMaxSumDrCat1ByGameIdByYear(gameId, year);
				resultQueryList = new ArrayList<GameMonthStatistics>(statisticDao.findStatisticMonthByGameByYear(gameId, year));
			}
			
			for (GameMonthStatistics gameMonthStatistics : resultQueryList) {
				gameMonthStatistics.setAncho((maxAcount <= 0) ? 0 : (int)(gameMonthStatistics.getCantidad()*75/maxAcount));
			}
			
			int numElementos=resultQueryList.size();
			if(numElementos>0) {
				int mes_min = resultQueryList.get(0).getMes();
				int mes_max = resultQueryList.get(numElementos-1).getMes();
				if(mes_min>1){
					for(int i=1; i<mes_min; i++){
						GameMonthStatistics e = new GameMonthStatistics();
						e.setMes(i);
						resultQueryList.add(i-1, e);						
					}
				}
				if(mes_max<12){
					for(int i=0; i<12-mes_max; i++){
						GameMonthStatistics e = new GameMonthStatistics();
						e.setMes(mes_max+i+1);
						resultQueryList.add(e);						
					}
				}
			}

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			LoggerApi.Log.info("size=" + resultQueryList.size());
		}
		return resultQueryList;
	}

    
}
