package pe.com.intralot.loto.layer.controller.game.kinelo.boimpl;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.controller.game.kinelo.bo.KineloResultBo;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.persistence.dao.KineloSaleDao;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.KineloProcedureDrawData;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanKineloResultBo")
public class KineloResultBoImpl implements KineloResultBo {
	
    @Autowired
    private KineloSaleDao kineloSaleDao;
 
	@Autowired
	private DrawDao beanDrawDao;
	
	public List<Draw> getResult() throws Exception {
		List<Draw> objectList=new ArrayList<Draw>();
     try {
    	 	LoggerApi.Log.info("");
			objectList= beanDrawDao.findWithCondition08();
			
			return objectList;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectList!=null){
				LoggerApi.Log.info("objectList: "+objectList.size());
			}else{
				LoggerApi.Log.info("objectList: "+"null");
			}
			}
	}


	
	public List<Draw> getResultForItem(Object[] params) throws Exception {
		List<Draw> objectList=new ArrayList<Draw>();
	     try {
	    	    LoggerApi.Log.info("params:"+params.length);
				objectList= beanDrawDao.findWithCondition09(params);
				
				return objectList;
				
			} catch (Exception e) {
				LoggerApi.severe(e);			
				throw new Exception(e);	
				
			} finally{
				if(objectList!=null){
					LoggerApi.Log.info("objectList: "+objectList.size());	
				}else{
					LoggerApi.Log.info("objectList: "+"null");	
				}
				}
	     
	}

	public Draw getKineloLastResult() throws Exception {
		return beanDrawDao.getKineloLastResult();
	}



	public List<Draw> getKineloLastResultByFecha(String fechaMinima, String fechaMaxima) throws Exception {
		return beanDrawDao.getKineloLastResultByFecha(fechaMinima, fechaMaxima);
	}



	public KineloProcedureBetData findByClientId(Integer p_clientId) throws Exception {
		LoggerApi.Log.info("clientId= " + p_clientId);
        KineloProcedureBetData objectDomain = new KineloProcedureBetData();
        try {
            objectDomain = kineloSaleDao.findBetData(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (objectDomain != null)
                LoggerApi.Log.info("Status=" + objectDomain.getStatus() + " Message=" + objectDomain.getMessage() + " Prize=" + objectDomain.getPrize()
                        + " ActiveDraw=" + objectDomain.getActiveDraw() + " CloseDate=" + objectDomain.getCloseDate() + " CloseHour=" + objectDomain.getCloseHour()
                        + " NextDraw=" + objectDomain.getNextDraw() + " OpenDate=" + objectDomain.getOpenDate() + " OpenHour=" + objectDomain.getOpenHour()
                        + " NumbersMore=" + objectDomain.getNumbersMore() + " NumbersLess=" + objectDomain.getNumbersLess() + " PriceType=" + objectDomain.getPriceType() 
                        + " PriceMessage=" + objectDomain.getPriceMessage() + " SimpleBetPrice=" + objectDomain.getSimpleBetPrice() + " PromotionType=" + objectDomain.getPromotionType() 
                        + " BalanceAmount=" + objectDomain.getBalanceAmount() + " BalanceAmountGame="+ objectDomain.getBalanceAmountGame() + " Algorithm=" + objectDomain.getAlgorithm() 
                        + " Bets=" + objectDomain.getBets() + " Pay=" + objectDomain.getPay() + " Draws=" + objectDomain.getDraws() + " Cost=" + objectDomain.getCost() + " OtherAmount=" + objectDomain.getOtherAmount());
        }
        return objectDomain;
	}



	public List<KineloProcedureDrawData> findListDrawData() throws Exception {
		return kineloSaleDao.findListDrawData();
	}
	
}