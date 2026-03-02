package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.TinkaProcedureDrawData;
import pe.com.intralot.loto.layer.model.persistence.dao.TinkaSaleDao;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class TinkaSaleDaoImpl extends HibernateBaseDaoImpl implements TinkaSaleDao{

	@Override
	public TinkaProcedureBetData findBetData(Integer p_clientId) throws Exception {
		
		LoggerApi.Log.info("clientId= " + p_clientId);
		List<TinkaProcedureBetData> resultQuery = new ArrayList<TinkaProcedureBetData>();
		TinkaProcedureBetData objectDomain = new TinkaProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("TINKASALE_BETDATA", values);
			objectDomain = (TinkaProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

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
						" w_numbers_more=" + objectDomain.getNumbersMore() +
						" w_numbers_less=" + objectDomain.getNumbersLess() +
						" w_price_type=" + objectDomain.getPriceType() + 
						" w_price_message="	+ objectDomain.getPriceMessage() + 
						" w_simple_bet_price=" + objectDomain.getSimpleBetPrice() + 
						" w_promotion_type=" + objectDomain.getPromotionType() +
						" w_balance_amount=" + objectDomain.getBalanceAmount() + 
						" w_balance_amount_game=" + objectDomain.getBalanceAmountGame() +
						" w_balance_quantity_game=" + objectDomain.getBalanceQuantityGame() +
						" w_algorithm=" + objectDomain.getAlgorithm() +
						" w_bets=" + objectDomain.getBets() + 
						" w_pay=" + objectDomain.getPay() + 
						" w_draws=" + objectDomain.getDraws() + 
						" w_cost=" + objectDomain.getCost() +
						" w_other_amount=" + objectDomain.getOtherAmount() +
						" w_other_quantity=" + objectDomain.getOtherQuantity());
			}
		}
		return objectDomain;
	}
	
	@Override
	public TinkaProcedureBetDataSubscribe findBetDataSubscribe(Integer p_clientId) throws Exception {
		
		LoggerApi.Log.info("clientId= " + p_clientId);
		List<TinkaProcedureBetDataSubscribe> resultQuery = new ArrayList<TinkaProcedureBetDataSubscribe>();
		TinkaProcedureBetDataSubscribe objectDomain = new TinkaProcedureBetDataSubscribe();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("TINKASALE_BETDATASUBSCRIBE", values);
			objectDomain = (TinkaProcedureBetDataSubscribe) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("w_status=" + objectDomain.getStatus() + " w_message=" + objectDomain.getMessage() + " w_prize=" + objectDomain.getPrize() + 
						" w_active_draw=" + objectDomain.getActiveDraw() + " w_close_date=" + objectDomain.getCloseDate() + " w_close_hour=" + objectDomain.getCloseHour() + 
						" w_next_draw="	+ objectDomain.getNextDraw() + " w_open_date=" + objectDomain.getOpenDate() + " w_open_hour=" + objectDomain.getOpenHour() + 
						" w_numbers_more=" + objectDomain.getNumbersMore() + " w_numbers_less=" + objectDomain.getNumbersLess() + " w_price_type=" + objectDomain.getPriceType() + 
						" w_price_message="	+ objectDomain.getPriceMessage() + " w_simple_bet_price=" + objectDomain.getSimpleBetPrice() + " w_promotion_type=" + objectDomain.getPromotionType() +
						" w_balance_amount=" + objectDomain.getBalanceAmount() + " w_balance_amount_game=" + objectDomain.getBalanceAmountGame() + " w_algorithm=" + objectDomain.getAlgorithm() +
						" w_bets=" + objectDomain.getBets() + " w_pay=" + objectDomain.getPay() + " w_draws=" + objectDomain.getDraws() + " w_cost=" + objectDomain.getCost() + 
						" w_1st_months=" + objectDomain.getFirstMonths() + " w_1st_draws=" + objectDomain.getFirstDraws() + " w_1st_discount=" + objectDomain.getFirstDiscount() +
						" w_2nd_months=" + objectDomain.getSecondMonths() + " w_2nd_draws=" + objectDomain.getSecondDraws() + " w_2nd_discount=" + objectDomain.getSecondDiscont() +
						" w_3rd_months=" + objectDomain.getTirdMonths() + " w_3rd_draws=" + objectDomain.getTirdDraws() + " w_3rd_discount=" + objectDomain.getTirdDiscount() + 
						" w_4th_months=" + objectDomain.getFourthMonths() + " w_4th_draws=" + objectDomain.getFourthDraws() + " w_4th_discount=" + objectDomain.getFourthDiscount() +" w_base_price=" + objectDomain.getBasePrice() + " w_other_amount=" + objectDomain.getOtherAmount());
			}
		}
		return objectDomain;
	}

	@Override
	public List<TinkaProcedureDrawData> findListDrawData() throws Exception {
		
		List<TinkaProcedureDrawData> resultQueryList = new ArrayList<TinkaProcedureDrawData>();
		try {
			Object[] values = new Object[0];
			resultQueryList = super.findForNamed("TINKASALE_DRAWDATA", values);
			
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
	public String[] findTinkaNextDraw() throws Exception {
		String[] resultQuery = new String[3];
		String sql = 
			" select to_char(dr_date,'fmDay dd \"de\" month \"del\" yyyy','NLS_DATE_LANGUAGE=Spanish')  fecha " + 
			"          , replace(replace(to_char( trunc(DR_JACKPOT) / 1000,'fm999,999.000'),',',chr(39)),'.',',') pozo " + 
			"          , draw_id " + 
			"          from lotocard.draw " + 
			"          where game_id = 41 " + 
			"          and draw_id = " + 
			"		          (select min(draw_id) from lotocard.draw where game_id = 41 and  draw_id > " + 
			"		             (select max(draw_id) from lotocard.draw where game_id = 41 and dr_draw_flag=1 ))";
		
		Dbms rs = new Dbms(sql);
		rs.executeQuery();
		if (rs.next()) {
			resultQuery[0] = rs.getString("fecha");
			resultQuery[1] = rs.getString("pozo");
			resultQuery[2] = rs.getString("draw_id");
		}
		rs.close();
		
		return resultQuery;
	}

}
