package pe.com.intralot.loto.layer.controller.game.ganagol.boimpl;

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

import pe.com.intralot.loto.layer.controller.game.ganagol.bo.GanagolBetBo;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawItemDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.DrawItem;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetDataMobile;
import pe.com.intralot.loto.layer.model.pojo.GanagolSale;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service("beanGanagolBetBo")
public class GanagolBetBoImpl implements GanagolBetBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
    private ProcedureDao beanProcedureDao;
	@Autowired
	private DrawItemDao beanDrawItemDao;
	@Autowired
	private DrawDao beanDrawDao;  
	
	public List<DrawItem> findInformationForDrawItem() throws Exception {
		List<DrawItem> objectList=new ArrayList<DrawItem>();
        try {
			LoggerApi.Log.info("");
			objectList= beanDrawItemDao.findAllWithCondition02();
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

	
	public Draw getDrawsGanagol01() throws Exception {
		Draw objectPojo= new Draw();
		 try {
				LoggerApi.Log.info("getDrawsGanagol01");
				objectPojo= beanDrawDao.findAllWithCondition04();
				if(objectPojo.getDrawPk().getDrawId()>5000) objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId()-5000);
	            else objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId());
				
				if(objectPojo.getDrawId2()>5000) objectPojo.setDrawId2(objectPojo.getDrawId2()-5000);

	            //else objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId());
				return objectPojo;
				
			} catch (Exception e) {
				LoggerApi.severe(e);			
				throw new Exception(e);	
				
			} finally{
				if(objectPojo!=null){
					LoggerApi.Log.info("getDrawsGanagol01 objectPojo: "+objectPojo.toString());	
				}else{
					LoggerApi.Log.info("getDrawsGanagol01 objectPojo: "+"null");
				}
				
			}
		 
	}
	
	
	public Draw getDrawsGanagol02() throws Exception {
		Draw objectPojo=new Draw();
		 try {
			    LoggerApi.Log.info("");
				
				objectPojo= beanDrawDao.findAllWithCondition05();
				if(objectPojo.getDrawPk().getDrawId()>5000) objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId()-5000);
	            else objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId());
				return objectPojo;
				
			} catch (Exception e) {
				LoggerApi.severe(e);			
				throw new Exception(e);	
				
			} finally{
				if(objectPojo!=null){
					LoggerApi.Log.info("objectPojo: "+objectPojo.toString());	
				}else{
					LoggerApi.Log.info("objectPojo: "+"null");
				}
				
				}
		 
	}
	
    public GanagolProcedureBetData findGanagolByClientId(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId);
        GanagolProcedureBetData objectDomain = new GanagolProcedureBetData();
        try {
            objectDomain = beanDrawDao.findGanagolBetData(p_clientId);        	
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	if (objectDomain != null)
            LoggerApi.Log.info("w_status=" + objectDomain.getStatus() + " w_message=" + objectDomain.getMessage() + " w_prize=" + objectDomain.getPrize()
            + " w_active_draw=" + objectDomain.getActiveDraw() + " w_close_date=" + objectDomain.getCloseDate() + " w_close_hour=" + objectDomain.getCloseHour()
            + " w_next_draw=" + objectDomain.getNextDraw() + " w_open_date=" + objectDomain.getOpenDate() + " w_open_hour=" + objectDomain.getOpenHour()
            + " w_notes= " + objectDomain.getNotes() + " w_program=" + objectDomain.getProgram() + " w_price_type=" + objectDomain.getPriceType()
            + " w_price_message=" + objectDomain.getPriceMessage() + " w_simple_bet_price=" + objectDomain.getSimpleBetPrice() + " w_promotion_type="
            + objectDomain.getPromotionType() + " w_balance_amount=" + objectDomain.getBalanceAmount() + " w_balance_amount_game="
            + objectDomain.getBalanceAmountGame() + " w_balance_quantity_game=" + objectDomain.getBalanceQuantityGame()  + " w_algorithm=" + objectDomain.getAlgorithm() 
            + " w_bets=" + objectDomain.getBets() + " w_pay=" + objectDomain.getPay() + " w_draws=" + objectDomain.getDraws() + " w_cost=" + objectDomain.getCost());
}

        return objectDomain;
    }
    
    public GanagolProcedureBetDataMobile findGanagolByClientIdMobile(Integer p_clientId) throws Exception {
        LoggerApi.Log.info("clientId=" + p_clientId);
        GanagolProcedureBetDataMobile objectDomain = new GanagolProcedureBetDataMobile();
        try {           
        	objectDomain = beanDrawDao.findGanagolBetDataMobile(p_clientId);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	if (objectDomain != null)
            LoggerApi.Log.info("w_status=" + objectDomain.getStatus() + " w_message=" + objectDomain.getMessage() + " w_prize=" + objectDomain.getPrize()
            + " w_active_draw=" + objectDomain.getActiveDraw() + " w_close_date=" + objectDomain.getCloseDate() + " w_close_hour=" + objectDomain.getCloseHour()
            + " w_next_draw=" + objectDomain.getNextDraw() + " w_open_date=" + objectDomain.getOpenDate() + " w_open_hour=" + objectDomain.getOpenHour()
            + " w_notes= " + objectDomain.getNotes() + " w_program=" + objectDomain.getProgram() + " w_price_type=" + objectDomain.getPriceType()
            + " w_price_message=" + objectDomain.getPriceMessage() + " w_simple_bet_price=" + objectDomain.getSimpleBetPrice() + " w_promotion_type="
            + objectDomain.getPromotionType() + " w_balance_amount=" + objectDomain.getBalanceAmount() + " w_balance_amount_game="
            + objectDomain.getBalanceAmountGame() + " w_balance_quantity_game=" + objectDomain.getBalanceQuantityGame()  + " w_algorithm=" + objectDomain.getAlgorithm() 
            + " w_bets=" + objectDomain.getBets() + " w_pay=" + objectDomain.getPay() + " w_draws=" + objectDomain.getDraws() + " w_cost=" + objectDomain.getCost());
}

        return objectDomain;
    }


	public GanagolSale findGanagolBetData(Integer id) throws Exception {
		LoggerApi.Log.info("id: " + id);
		GanagolSale objectDomain = new GanagolSale();
        try {
            objectDomain = beanProcedureDao.findProcedureGanagolBetData(id);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
        	if(objectDomain!=null){
        		LoggerApi.Log.info("resultQuery: "+objectDomain.toString());	
        	}else{
        		LoggerApi.Log.info("resultQuery: "+"null");	
        	}
        }
        return objectDomain;
	}


	@Override
	public Draw findInformationForDraw(Object[] params) throws Exception {
		Draw objectList=new Draw();
	     try {
	    	 	LoggerApi.Log.info("params:"+params.length);
	    	 	objectList= beanDrawDao.findWithCondition17(params);
				
				return objectList;
				
			} catch (Exception e) {
				LoggerApi.severe(e);			
				throw new Exception(e);	
				
			} finally{
				if(objectList!=null){
					LoggerApi.Log.info("objectList: "+objectList.toString());	
				}else{
					LoggerApi.Log.info("objectList: "+"null");
				}
				
			}
	}
 	
}