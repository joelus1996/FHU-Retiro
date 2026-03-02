package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureCommandCashier;
import pe.com.intralot.loto.layer.model.domain.ClicyganaProcedureCommandClose;
import pe.com.intralot.loto.layer.model.persistence.dao.ClicyganaSaleDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class ClicyganaSaleDaoImpl extends HibernateBaseDaoImpl implements ClicyganaSaleDao{

	@Override
	public ClicyganaProcedureBetData findBetData(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<ClicyganaProcedureBetData> resultQuery = new ArrayList<ClicyganaProcedureBetData>();
		ClicyganaProcedureBetData objectDomain = new ClicyganaProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("CLICYGANASALE_BETDATA", values);
			objectDomain = (ClicyganaProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("w_status=" + objectDomain.getStatus() + 
						" w_message=" + objectDomain.getMessage() + 
						" w_prize=" + objectDomain.getPrize() + 
						" w_active_draw=" + objectDomain.getActiveDraw() + 
						" w_close_date=" + objectDomain.getCloseDate() + 
						" w_close_hour=" + objectDomain.getCloseHour() + 
						" w_next_draw="	+ objectDomain.getNextDraw() + 
						" w_open_date=" + objectDomain.getOpenDate() + 
						" w_open_hour=" + objectDomain.getOpenHour() + 
						" w_numbers_more="	+ objectDomain.getNumbersMore() + 
						" w_numbers_less=" + objectDomain.getNumbersLess() + 
						" w_price_type=" + objectDomain.getPriceType() + 
						" w_price_message="	+ objectDomain.getPriceMessage() + 
						" w_simple_bet_price=" + objectDomain.getSimpleBetPrice() + 
						" w_promotion_type=" + objectDomain.getPromotionType() +
						" w_balance_amount=" + objectDomain.getBalanceAmount() + 
						" w_balance_amount_game=" + objectDomain.getBalanceAmountGame() + 
						" w_algorithm=" + objectDomain.getAlgorithm() +
						" w_bets=" + objectDomain.getBets() + 
						" w_pay=" + objectDomain.getPay() + 
						" w_draws=" + objectDomain.getDraws()+ 
						" w_cost=" + objectDomain.getCost()+
						" w_nickname=" + objectDomain.getNickName()+ 
						" w_user=" + objectDomain.getUser());
			}
		}
		return objectDomain;
	}

	@Override
	public ClicyganaProcedureCommandClose findCommandClose(String p_sessionCode) throws Exception {
		LoggerApi.Log.info("sessionCode= " + p_sessionCode);

		List<ClicyganaProcedureCommandClose> resultQuery = new ArrayList<ClicyganaProcedureCommandClose>();
		ClicyganaProcedureCommandClose objectDomain = new ClicyganaProcedureCommandClose();

		try {
			Object[] values = new Object[1];
			values[0] = p_sessionCode;
			resultQuery = super.findForNamed("CLICYGANASALE_COMMANDCLOSE", values);
			objectDomain = (ClicyganaProcedureCommandClose) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("s_message=" + objectDomain.getMessage());
			}
		}
		return objectDomain;
	}

	@Override
	public ClicyganaProcedureCommandCashier findCommandCashier(String p_sessionCode) throws Exception {
		LoggerApi.Log.info("sessionCode= " + p_sessionCode);

		List<ClicyganaProcedureCommandCashier> resultQuery = new ArrayList<ClicyganaProcedureCommandCashier>();
		ClicyganaProcedureCommandCashier objectDomain = new ClicyganaProcedureCommandCashier();

		try {
			Object[] values = new Object[1];
			values[0] = p_sessionCode;
			resultQuery = super.findForNamed("CLICYGANASALE_COMMANDCASHIER", values);
											  
			objectDomain = (ClicyganaProcedureCommandCashier) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("s_message=" + objectDomain.getMessage());
			}
		}
		return objectDomain;
	}

	

	

	
}
