package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataChCh;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.KabalaProcedureDrawData;
import pe.com.intralot.loto.layer.model.persistence.dao.KabalaSaleDao;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class KabalaSaleDaoImpl extends HibernateBaseDaoImpl  implements KabalaSaleDao {
	
	@Override
	public KabalaProcedureBetData findProcedureBetData(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<KabalaProcedureBetData> resultQuery = new ArrayList<KabalaProcedureBetData>();
		KabalaProcedureBetData objectDomain = new KabalaProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("KABALASALE_BETDATA", values);
			objectDomain = (KabalaProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info(" w_status=" + objectDomain.getStatus() + 
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
						" w_draws=" + objectDomain.getDraws() + 
						" w_cost=" + objectDomain.getCost() +
						" w_other_amount=" + objectDomain.getOtherAmount());
			}
		}
		return objectDomain;
	}
	
	@Override
	public KabalaProcedureBetDataSubscribe findProcedureBetDataSubscribe(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<KabalaProcedureBetDataSubscribe> resultQuery = new ArrayList<KabalaProcedureBetDataSubscribe>();
		KabalaProcedureBetDataSubscribe objectDomain = new KabalaProcedureBetDataSubscribe();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("KABALASALE_BETDATASUBSCRIBE", values);
			objectDomain = (KabalaProcedureBetDataSubscribe) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info(" w_status=" + objectDomain.getStatus() + 
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
						" w_1st_months=" + objectDomain.getFirstMonths() + 
						" w_1st_draws=" + objectDomain.getFirstDraws() + 
						" w_1st_discount=" + objectDomain.getFirstDiscount() +
						" w_2nd_months=" + objectDomain.getSecondMonths() + 
						" w_2nd_draws=" + objectDomain.getSecondDraws() + 
						" w_2nd_discount=" + objectDomain.getSecondDiscont() +
						" w_3rd_months=" + objectDomain.getTirdMonths() + 
						" w_3rd_draws=" + objectDomain.getTirdDraws() + 
						" w_3rd_discount=" + objectDomain.getTirdDiscount() + 
						" w_4th_months=" + objectDomain.getFourthMonths() + 
						" w_4th_draws=" + objectDomain.getFourthDraws() + 
						" w_4th_discount=" + objectDomain.getFourthDiscount() + " w_other_amount=" + objectDomain.getOtherAmount());
			}
		}
		return objectDomain;
	}
	
	@Override
	public KabalaProcedureBetDataChCh findProcedureBetDataChCh(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<KabalaProcedureBetDataChCh> resultQuery = new ArrayList<KabalaProcedureBetDataChCh>();
		KabalaProcedureBetDataChCh objectDomain = new KabalaProcedureBetDataChCh();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("KABALASALE_BETDATACHCH", values);
			objectDomain = (KabalaProcedureBetDataChCh) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info(" w_status=" + objectDomain.getStatus() + 
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
						" w_prev_bet_price=" + objectDomain.getPrevBetPrice() + 
						" w_promotion_type=" + objectDomain.getPromotionType() +
						" w_balance_amount=" + objectDomain.getBalanceAmount() + 
						" w_balance_amount_game=" + objectDomain.getBalanceAmountGame() + 
						" w_algorithm=" + objectDomain.getAlgorithm() +
						" w_bets=" + objectDomain.getBets() + 
						" w_pay=" + objectDomain.getPay() + 
						" w_draws=" + objectDomain.getDraws()+ 
						" w_cost=" + objectDomain.getCost()+ 
						" w_channel1_order=" + objectDomain.getChannel1Order()+ 
						" w_channel2_order=" + objectDomain.getChannel2Order());
			}
		}
		return objectDomain;
	}

	@Override
	public List<KabalaProcedureDrawData> findProcedureDrawData() throws Exception {
		
		List<KabalaProcedureDrawData> resultQueryList = new ArrayList<KabalaProcedureDrawData>();
		try {
			Object[] values = new Object[0];
			resultQueryList = super.findForNamed("KABALASALE_DRAWDATA", values);
			
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
	public String[] findKabalaNextDraw() throws Exception {
		String[] resultQuery = new String[3];
		String sql = 
			" select to_char(dr_date,'fmDay dd \"de\" month \"del\" yyyy','NLS_DATE_LANGUAGE=Spanish')  fecha " + 
			"          , replace(replace(to_char( trunc(DR_JACKPOT) / 1000,'fm999,999.000'),',',chr(39)),'.',',') pozo " + 
			"          , draw_id " + 
			"          from lotocard.draw " + 
			"          where game_id = 42 " + 
			"          and draw_id = " + 
			"		          (select min(draw_id) from lotocard.draw where game_id = 42 and  draw_id > " + 
			"		             (select max(draw_id) from lotocard.draw where game_id = 42 and dr_draw_flag=1 ))";
		
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
