package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetData;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureBetDataSubscribe;
import pe.com.intralot.loto.layer.model.domain.GanadiarioProcedureDrawData;
import pe.com.intralot.loto.layer.model.persistence.dao.GanadiarioSaleDao;
import pe.com.intralot.loto.lib.Dbms;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;


@Repository
public class GanadiarioSaleDaoImpl extends HibernateBaseDaoImpl implements GanadiarioSaleDao {
	

	public GanadiarioProcedureBetData findProcedureBetData(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("clientId= " + p_clientId);

		List<GanadiarioProcedureBetData> resultQuery = new ArrayList<GanadiarioProcedureBetData>();
		GanadiarioProcedureBetData objectDomain = new GanadiarioProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("GANADIARIOSALE_BETDATA", values);
			objectDomain = (GanadiarioProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

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
						" w_draws=" + objectDomain.getDraws() + 
						" w_cost=" + objectDomain.getCost() +
						" w_other_amount=" + objectDomain.getOtherAmount());
			}
		}
		return objectDomain;
	}
	
	@Override
	public GanadiarioProcedureBetDataSubscribe findProcedureBetDataSubscribe(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<GanadiarioProcedureBetDataSubscribe> resultQuery = new ArrayList<GanadiarioProcedureBetDataSubscribe>();
		GanadiarioProcedureBetDataSubscribe objectDomain = new GanadiarioProcedureBetDataSubscribe();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("GANADIARIOSALE_BETDATASUBSCRIBE", values);
			objectDomain = (GanadiarioProcedureBetDataSubscribe) DataAccessUtils.uniqueResult(resultQuery);

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
	public List<GanadiarioProcedureDrawData> findProcedureDrawData() throws Exception {
		
		List<GanadiarioProcedureDrawData> resultQueryList = new ArrayList<GanadiarioProcedureDrawData>();
		try {
			Object[] values = new Object[0];
			resultQueryList = super.findForNamed("GANADIARIOSALE_DRAWDATA", values);
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if(resultQueryList!=null){
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}		
		}
		return resultQueryList;
	}

	@Override
	public String[] findGanadiarioNextDraw() throws Exception {
		String[] resultQuery = new String[3];
		String sql = 
			" select to_char(dr_date,'fmDay dd \"de\" month \"del\" yyyy','NLS_DATE_LANGUAGE=Spanish')  fecha " + 
			"          , replace(replace(to_char( trunc(DR_JACKPOT) / 1000,'fm999,999.000'),',',chr(39)),'.',',') pozo " + 
			"          , draw_id " + 
			"          from lotocard.draw " + 
			"          where game_id = 164 " + 
			"          and draw_id = " + 
			"		          (select min(draw_id) from lotocard.draw where game_id = 164 and  draw_id > " + 
			"		             (select max(draw_id) from lotocard.draw where game_id = 164 and dr_draw_flag=1 ))";
		
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
