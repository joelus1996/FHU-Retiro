package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.domain.DeportesvirtualesProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.DeportesvirtualesProcedureGetEventsTraduction;
import pe.com.intralot.loto.layer.model.persistence.dao.DeportesVirtualesSaleDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;
@Repository
public class DeportesVirtualesSaleDaoImpl extends HibernateBaseDaoImpl implements DeportesVirtualesSaleDao {

	@Override
	public DeportesvirtualesProcedureBetData findBetData(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<DeportesvirtualesProcedureBetData> resultQuery = new ArrayList<DeportesvirtualesProcedureBetData>();
		DeportesvirtualesProcedureBetData objectDomain = new DeportesvirtualesProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("DEPORTESVIRTUALESSALE_BETDATA", values);
			objectDomain = (DeportesvirtualesProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

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
	public DeportesvirtualesProcedureGetEventsTraduction getEventsTraduction(String playlistId) throws Exception {
		LoggerApi.Log.info("getEventsTraduction playlistId=" + playlistId);
		
		List<DeportesvirtualesProcedureGetEventsTraduction> resultQuery = new ArrayList<DeportesvirtualesProcedureGetEventsTraduction>();
		DeportesvirtualesProcedureGetEventsTraduction objectDomain = new DeportesvirtualesProcedureGetEventsTraduction();
		
		try {
			Object[] values = new Object[1];
	        values[0] = playlistId;
	        resultQuery = super.findForNamed("DEPORTESVIRTUALESSALE_GETEVENTSTRADUCTION", values);
			objectDomain = (DeportesvirtualesProcedureGetEventsTraduction) DataAccessUtils.uniqueResult(resultQuery);

	        if (resultQuery != null)
	            LoggerApi.Log.info("getEventsTraduction size=" + resultQuery.size()+ " traduction="+objectDomain.getPlaylistTraduction());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
        
        return objectDomain;
	}

}
