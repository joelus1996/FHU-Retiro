package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureDrawData;
import pe.com.intralot.loto.layer.model.domain.GanagolProcedureProgramData;
import pe.com.intralot.loto.layer.model.persistence.dao.GanagolSaleDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class GanagolSaleDaoImpl extends HibernateBaseDaoImpl implements GanagolSaleDao {

	@Override
	public GanagolProcedureBetData findBetData(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("clientId= " + p_clientId);
		List<GanagolProcedureBetData> resultQuery = new ArrayList<GanagolProcedureBetData>();
		GanagolProcedureBetData objectDomain = new GanagolProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("GANAGOLSALE_BETDATA", values);
			objectDomain = (GanagolProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("w_status= " + objectDomain.getStatus() + 
						" w_message= " + objectDomain.getMessage() + 
						" w_prize= " + objectDomain.getPrize() + 
						" w_active_draw= " + objectDomain.getActiveDraw() + 
						" w_close_date= " + objectDomain.getCloseDate() + 
						" w_close_hour= " + objectDomain.getCloseHour() + 
						" w_next_draw= "	+ objectDomain.getNextDraw() + 
						" w_open_date= " + objectDomain.getOpenDate() + 
						" w_open_hour= " + objectDomain.getOpenHour() + 
						" w_notes= "	+ objectDomain.getNotes() + 
						" w_program= " + objectDomain.getProgram() + 
						" w_price_type= " + objectDomain.getPriceType() + 
						" w_price_message= "	+ objectDomain.getPriceMessage() + 
						" w_simple_bet_price= " + objectDomain.getSimpleBetPrice() + 
						" w_promotion_type= " + objectDomain.getPromotionType() +
						" w_balance_amount= " + objectDomain.getBalanceAmount() + 
						" w_balance_amount_game= " + objectDomain.getBalanceAmountGame() + 
						" w_balance_quantity_game= " + objectDomain.getBalanceQuantityGame() +
						" w_algorithm= " + objectDomain.getAlgorithm() +
						" w _bets= " + objectDomain.getBets() + 
						" w_pay= " + objectDomain.getPay() + 
						" w_draws= " + objectDomain.getDraws() + 
						" w_cost= " + objectDomain.getCost() +
						" w_last_draw= " + objectDomain.getLastDraw() +
						" w_last_prize= " + objectDomain.getLastPrize() +
						" w_last_close_hour= " + objectDomain.getLastCloseHour() +
						" w_last_close_date= " + objectDomain.getLastCloseDate() +
						" w_other_amount= " + objectDomain.getOtherAmount());
			}
		}
		return objectDomain;
	}

	@Override
	public List<GanagolProcedureDrawData> findListDrawData() throws Exception {

		List<GanagolProcedureDrawData> resultQueryList = new ArrayList<GanagolProcedureDrawData>();

		try {
			Object[] values = new Object[0];
			resultQueryList = super.findForNamed("GANAGOLSALE_DRAWDATA", values);
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

	@Override
	public List<GanagolProcedureProgramData> findListProgramData(Integer p_drawId) throws Exception {
		List<GanagolProcedureProgramData> resultQueryList = new ArrayList<GanagolProcedureProgramData>();

		try {
			Object[] values = new Object[1];
			values[0] = p_drawId;
			resultQueryList = super.findForNamed("GANAGOLSALE_PROGRAMDATA", values);
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
