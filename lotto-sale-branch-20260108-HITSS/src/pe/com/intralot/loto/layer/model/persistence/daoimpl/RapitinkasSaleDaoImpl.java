package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
 * @author: Victor Farro Veramendi
 * @rol: Analista Programador
 * @proyecto:
 * 
 */

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.domain.RapitinkasProcedureBetData;
import pe.com.intralot.loto.layer.model.persistence.dao.RapitinkasSaleDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class RapitinkasSaleDaoImpl extends HibernateBaseDaoImpl implements RapitinkasSaleDao{

	@Override
	public RapitinkasProcedureBetData findBetData(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<RapitinkasProcedureBetData> resultQuery = new ArrayList<RapitinkasProcedureBetData>();
		RapitinkasProcedureBetData objectDomain = new RapitinkasProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("RAPITINKASSALE_BETDATA", values);
			objectDomain = (RapitinkasProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

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

}
