package pe.com.intralot.loto.layer.service.draw.boimpl;

/**
 * @author:   Victor Farro Veramendi
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.Draw;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.service.draw.bo.DrawBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class DrawBoImpl implements DrawBo{
	@Autowired
	private  DrawDao drawDao;

	@Override
	public Draw findByIdByGameId(Integer drawId, Integer gameID) throws Exception {
		LoggerApi.Log.info("drawId= " + drawId+ " gameID= "+gameID);    	
    	Draw objectDomain= new Draw();    	
		try {   
			objectDomain=drawDao.findByIdByGameId(drawId, gameID);	        
		} catch(Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {		
			if (objectDomain != null) {
				LoggerApi.Log.info("DR_ADDITIONAL= "+objectDomain.getDrAdditional()+
						   " DR_CAT_1= "+objectDomain.getDrCat1()+
						   " DR_CAT_10= "+objectDomain.getDrCat10()+
						   " DR_CAT_11= "+objectDomain.getDrCat11()+
						   " DR_CAT_2= "+objectDomain.getDrCat2()+
						   " DR_CAT_3= "+objectDomain.getDrCat3()+
						   " DR_CAT_4= "+objectDomain.getDrCat4()+
						   " DR_CAT_5= "+objectDomain.getDrCat5()+
						   " DR_CAT_6= "+objectDomain.getDrCat6()+
						   " DR_CAT_7= "+objectDomain.getDrCat7()+
						   " DR_CAT_8= "+objectDomain.getDrCat8()+
						   " DR_CAT_9= "+objectDomain.getDrCat9()+
						   " DR_CAT_TOTAL= "+objectDomain.getDrCatTotal()+
						   " DR_CLOSE_DATE= "+objectDomain.getDrCloseDate()+
						   " DR_CLOSE_HOUR= "+objectDomain.getDrCloseHour()+
						   " DR_CLOSE_MINUTE= "+objectDomain.getDrCloseMinute()+
						   " DR_DATE_UPDATE= "+objectDomain.getDrDateUpdate()+
						   " DR_DRAW_FLAG= "+objectDomain.getDrDrawFlag()+
						   " DR_EDITION_ID= "+objectDomain.getDrEditionId()+
						   " DR_EXPIRATION_2X1_DATE= "+objectDomain.getDrExpiration2x1Date()+
						   " DR_EXPIRATION_FREE_DATE= "+objectDomain.getDrExpirationFreeDate()+
						   " DR_EXPIRATION_PRIZE_DATE= "+objectDomain.getDrExpirationPrizeDate()+
						   " DR_EXTRA= "+objectDomain.getDrExtra()+
						   " DR_GROSS_1= "+objectDomain.getDrGross1()+
						   " DR_GROSS_10= "+objectDomain.getDrGross10()+
						   " DR_GROSS_11= "+objectDomain.getDrGross11()+
						   " DR_GROSS_2= "+objectDomain.getDrGross2()+
						   " DR_GROSS_3= "+objectDomain.getDrGross3()+
						   " DR_GROSS_4= "+objectDomain.getDrGross4()+
						   " DR_GROSS_5= "+objectDomain.getDrGross5()+
						   " DR_GROSS_6= "+objectDomain.getDrGross6()+
						   " DR_GROSS_7= "+objectDomain.getDrGross7()+
						   " DR_GROSS_8= "+objectDomain.getDrGross8()+
						   " DR_GROSS_9= "+objectDomain.getDrGross9()+
						   " DR_GROSS_TOTAL= "+objectDomain.getDrGrossTotal()+
						   " DR_JACKPOT="+objectDomain.getDrJackpot()+
						   " DR_MESSAGE= "+objectDomain.getDrMessage()+
						   " DR_NET_1= "+objectDomain.getDrNet1()+
						   " DR_NET_10= "+objectDomain.getDrNet10()+
						   " DR_NET_11= "+objectDomain.getDrNet11()+
						   " DR_NET_2= "+objectDomain.getDrNet2()+
						   " DR_NET_3= "+objectDomain.getDrNet3()+
						   " DR_NET_4= "+objectDomain.getDrNet4()+
						   " DR_NET_5= "+objectDomain.getDrNet5()+
						   " DR_NET_6= "+objectDomain.getDrNet6()+
						   " DR_NET_7= "+objectDomain.getDrNet7()+
						   " DR_NET_8= "+objectDomain.getDrNet8()+
						   " DR_NET_9= "+objectDomain.getDrNet9()+
						   " DR_NUMBERS= "+objectDomain.getDrNumbers()+
						   " DR_OFICIAL= "+objectDomain.getDrOficial()+
						   " DR_OPEN_DATE= "+objectDomain.getDrOpenDate()+
						   " DR_OPEN_HOUR= "+objectDomain.getDrOpenHour()+
						   " DR_OPEN_MINUTE= "+objectDomain.getDrOpenMinute()+
						   " DR_PERCENT= "+objectDomain.getDrPercent()+
						   " DR_PRINTED_1= "+objectDomain.getDrPrinted1()+
						   " DR_PRINTED_10= "+objectDomain.getDrPrinted10()+
						   " DR_PRINTED_11= "+objectDomain.getDrPrinted11()+
						   " DR_PRINTED_2= "+objectDomain.getDrPrinted2()+
						   " DR_PRINTED_3= "+objectDomain.getDrPrinted3()+
						   " DR_PRINTED_4= "+objectDomain.getDrPrinted4()+
						   " DR_PRINTED_5= "+objectDomain.getDrPrinted5()+
						   " DR_PRINTED_6= "+objectDomain.getDrPrinted6()+
						   " DR_PRINTED_7= "+objectDomain.getDrPrinted7()+
						   " DR_PRINTED_8= "+objectDomain.getDrPrinted8()+
						   " DR_PRINTED_9= "+objectDomain.getDrPrinted9()+
						   " DR_PROMOTION= "+objectDomain.getDrPromotion()+
						   " DR_RESULT= "+objectDomain.getDrResult()+
						   " DR_RESULT_DATE= "+objectDomain.getDrResultDate()+
						   " DR_SMS_MESSAGE_1= "+objectDomain.getDrSmsMessage1()+
						   " DR_SMS_MESSAGE_2= "+objectDomain.getDrSmsMessage2()+
						   " DR_TICKETS= "+objectDomain.getDrTickets()+
						   " DR_USER_UPDATE= "+objectDomain.getDrUserUpdate());
				}			
		} 		
        return objectDomain;
	}

	@Override
	public List<Draw> findByDrawListByGameId(Integer gameId, Integer days) throws Exception {
		List<Draw> resultQueryList = new ArrayList<Draw>();
		try {
			resultQueryList = drawDao.findByDrawListByGameId(gameId, days);
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
