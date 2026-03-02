package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.com.intralot.loto.layer.model.persistence.dao.KineloSaleDao;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureDrawData;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.HibernateBaseDaoImpl;

@Repository
public class KineloSaleDaoImpl extends HibernateBaseDaoImpl implements KineloSaleDao{

	public KineloProcedureBetData findBetData(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);

		List<KineloProcedureBetData> resultQuery = new ArrayList<KineloProcedureBetData>();
		KineloProcedureBetData objectDomain = new KineloProcedureBetData();

		try {

			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = super.findForNamed("KINELOSALE_BETDATA", values);
			objectDomain = (KineloProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
    @Transactional(readOnly = false)
    public HashMap[] getHashMaps(ResultSet rs) throws java.sql.SQLException {
        HashMap[] result = null;
        Vector listado = new Vector();
        ResultSetMetaData rsm = rs.getMetaData();
        while (rs.next()) {
            HashMap ht = new HashMap();
            for (int i = 1; i <= rsm.getColumnCount(); i++)
                ht.put(rsm.getColumnName(i), rs.getObject(i));
            listado.add(ht);
        }
        result = new HashMap[listado.size()];
        result = (HashMap[]) listado.toArray(result);
        return result;
    }

	public List<KineloProcedureDrawData> findListDrawData() throws Exception {
		List<KineloProcedureDrawData> resultQueryList = new ArrayList<KineloProcedureDrawData>();
		try {
			Object[] values = new Object[0];
			resultQueryList = super.findForNamed("KINELOSALE_DRAWDATA", values);
			
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
