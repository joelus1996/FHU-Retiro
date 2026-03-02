package pe.com.intralot.loto.layer.service.game.rapitinkas.boimpl;

/**
 * @author: Victor Farro Veramendi
 * @rol: Analista Programador
 * @proyecto:
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.RapitinkasProcedureBetData;
import pe.com.intralot.loto.layer.model.persistence.dao.RapitinkasSaleDao;
import pe.com.intralot.loto.layer.service.game.rapitinkas.bo.RapitinkasBo;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.Constants;

@Service
public class RapitinkasBoImpl implements RapitinkasBo {

    @Autowired
    RapitinkasSaleDao rapitinkasSaleDao;

    @Override
    public RapitinkasProcedureBetData findByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId= " + p_clientId);
        RapitinkasProcedureBetData objectDomain = new RapitinkasProcedureBetData();
        try {
            objectDomain = rapitinkasSaleDao.findBetData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("w_status=" + objectDomain.getStatus() + " w_message=" + objectDomain.getMessage() + " w_prize=" + objectDomain.getPrize()
                        + " w_active_draw=" + objectDomain.getActiveDraw() + " w_close_date=" + objectDomain.getCloseDate() + " w_close_hour=" + objectDomain.getCloseHour()
                        + " w_next_draw=" + objectDomain.getNextDraw() + " w_open_date=" + objectDomain.getOpenDate() + " w_open_hour=" + objectDomain.getOpenHour()
                        + " w_numbers_more=" + objectDomain.getNumbersMore() + " w_numbers_less=" + objectDomain.getNumbersLess() + " w_price_type="
                        + objectDomain.getPriceType() + " w_price_message=" + objectDomain.getPriceMessage() + " w_simple_bet_price=" + objectDomain.getSimpleBetPrice()
                        + " w_promotion_type=" + objectDomain.getPromotionType() + " w_balance_amount=" + objectDomain.getBalanceAmount() + " w_balance_amount_game="
                        + objectDomain.getBalanceAmountGame() + " w_algorithm=" + objectDomain.getAlgorithm() + " w_bets=" + objectDomain.getBets() + " w_pay="
                        + objectDomain.getPay() + " w_draws=" + objectDomain.getDraws() + " w_cost=" + objectDomain.getCost() + " w_nickname=" + objectDomain.getNickName()
                        + " w_user=" + objectDomain.getUser());
        }
        return objectDomain;
    }

    @Override
    public boolean isAllowedGoIn(String user) {
        boolean isRapitinkasSale = Boolean.valueOf(ConnectionFactory.operationProperty("rapitinkasSaleEnabled", Constants.contextSale).trim()).booleanValue();
        boolean isAllowed = false;
        String rapitinkasSaleUsers = String.valueOf(ConnectionFactory.operationProperty("rapitinkasSaleUsers", Constants.contextSale)).toString().trim();
        if (isRapitinkasSale == false) {
            if (rapitinkasSaleUsers != null && !rapitinkasSaleUsers.equals("")) {
                String[] saleUsers = rapitinkasSaleUsers.split(",");
                for (String saleUser : saleUsers)
                    if (saleUser.equals(user)) {
                        isAllowed = true;
                        break;
                    } else
                        isAllowed = false;
            }
        } else
            isAllowed = true;
        return isAllowed;
    }
}
