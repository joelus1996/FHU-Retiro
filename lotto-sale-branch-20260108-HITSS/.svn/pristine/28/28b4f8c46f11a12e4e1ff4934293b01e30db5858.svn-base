package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.domain.Super3ProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.Super3ProcedureDrawData;
import pe.com.intralot.loto.layer.model.persistence.dao.Super3SaleDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class Super3SaleDaoImpl extends HibernateBaseDaoImpl implements Super3SaleDao {

	@Override
	public Super3ProcedureBetData findBetData(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<Super3ProcedureBetData> resultQuery = new ArrayList<Super3ProcedureBetData>();
		Super3ProcedureBetData objectDomain = new Super3ProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("SUPER3SALE_BETDATA", values);
			objectDomain = (Super3ProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("w_status= " + objectDomain.getStatus() + 
						"w_message= " + objectDomain.getMessage() + 
						"w_prize= " + objectDomain.getPrize() + 
						"w_active_draw= " + objectDomain.getActiveDraw() + 
						"w_close_date= " + objectDomain.getCloseDate() + 
						"w_close_hour= " + objectDomain.getCloseHour() + 
						"w_next_draw= "	+ objectDomain.getNextDraw() + 
						"w_open_date= " + objectDomain.getOpenDate() + 
						"w_open_hour= " + objectDomain.getOpenHour() + 
						"w_numbers_more= "	+ objectDomain.getNumbersMore() + 
						"w_numbers_less= " + objectDomain.getNumbersLess() + 
						"w_price_type= " + objectDomain.getPriceType() + 
						"w_price_message= "	+ objectDomain.getPriceMessage() + 
						"w_simple_bet_price= " + objectDomain.getSimpleBetPrice() + 
						"w_promotion_type= " + objectDomain.getPromotionType() +
						"w_balance_amount= " + objectDomain.getBalanceAmount() + 
						"w_balance_amount_game= " + objectDomain.getBalanceAmountGame() + 
						"w_algorithm= " + objectDomain.getAlgorithm() +
						"w_bets= " + objectDomain.getBets() + 
						"w_pay= " + objectDomain.getPay() + 
						"w_draws= " + objectDomain.getDraws()+ 
						"w_cost= " + objectDomain.getCost());
			}
		}
		return objectDomain;
	}

	@Override
	public List<Super3ProcedureDrawData> findListDrawData() throws Exception {
		
		List<Super3ProcedureDrawData> resultQueryList = new ArrayList<Super3ProcedureDrawData>();
		try {
			Object[] values = new Object[0];
			resultQueryList = super.findForNamed("SUPER3SALE_DRAWDATA", values);
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}
	

}
