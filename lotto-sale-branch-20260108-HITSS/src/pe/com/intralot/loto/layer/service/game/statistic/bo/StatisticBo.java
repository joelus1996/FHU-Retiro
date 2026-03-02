package pe.com.intralot.loto.layer.service.game.statistic.bo;

import java.util.ArrayList;

import pe.com.intralot.loto.layer.model.bean.GameMonthStatistics;
import pe.com.intralot.loto.layer.model.domain.GameStats;

public interface StatisticBo {

	public ArrayList<String> consultarAnios(int gameId) throws Exception;
	
	public ArrayList<GameStats> consultarEstadisticas(int gameId, int year) throws Exception;

	public ArrayList<GameStats> consultarEstadisticasPorPosicion(int gameId, int year, int position) throws Exception;
	
	public ArrayList<String> consultarAniosGanadoresPorMes(int gameId) throws Exception;
	
	public ArrayList<GameMonthStatistics> consultarEstadisticasPorMes(int gameId, int year) throws Exception;
	
}