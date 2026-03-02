package pe.com.intralot.loto.layer.controller.game.tinka.boimpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */

import java.util.HashMap;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.controller.game.tinka.bo.TinkaBetBo;
import pe.com.intralot.loto.layer.model.pojo.ViewFlagPopupSiosi;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.persistence.dao.FlagPopupSiosiDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.TinkaSale;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;

@Service("beanTinkaBetBo")
public class TinkaBetBoImpl implements TinkaBetBo {
	
	//protected final Log logger = LogFactory.getLog(getClass());
 
	@Autowired
	private DrawDao beanDrawDao;
 
	@Autowired
	private ProcedureDao beanProcedureDao;
	
	@Autowired
	private FlagPopupSiosiDao flagPopupSiosiDao;
 
	/*@Autowired
	private ViewDAO beanViewDAO;*/
	
	@SuppressWarnings("rawtypes")
	public  HashMap[] getNumberConsecutive() throws Exception { 
		HashMap[] objectMap=null;
		try {
			LoggerApi.Log.info("");
			
			objectMap= beanProcedureDao.getNumberConsecutiveTinka();
			return objectMap;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally{
			if(objectMap!=null){
				LoggerApi.Log.info("objectMap: "+objectMap.length);
			}else{
				LoggerApi.Log.info("objectMap: "+"null");
			}
			
			}
	
	}


	
	public Draw getDataCloseDateGame() throws Exception {
		Draw objectPojo=new Draw();
	   try {
			LoggerApi.Log.info("");
			
			objectPojo= beanDrawDao.findAllWithCondition11();
			
			return  objectPojo;
			
		} catch (NullPointerException e) {
        	return null;
        }  catch (Exception e) {
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


	
	public Draw getDrawsTinka01() throws Exception {
		Draw objectPojo=new Draw();
	    try {
	    	LoggerApi.Log.info("");
			objectPojo= beanDrawDao.findAllWithCondition12();
			return  objectPojo;
			
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


	
	public Draw getDrawsTinka02() throws Exception {
		Draw objectPojo=new Draw();
	   try {
			LoggerApi.Log.info("");
			objectPojo= beanDrawDao.findAllWithCondition13();
			return  objectPojo;
			
		} catch (Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);	
			
		} finally {
			if(objectPojo!=null){
				LoggerApi.Log.info("objectPojo: "+objectPojo.toString());	
			}else{
				LoggerApi.Log.info("objectPojo: "+"null");
			}
			
			}
	
	
	}
	
    public TinkaSale findTinkaBetData(Integer id) throws Exception {
    	LoggerApi.Log.info("id: " + id);
    	TinkaSale resultQuery = new TinkaSale();
        try {
            resultQuery = beanProcedureDao.findProcedureTinkaBetData(id);
            if(resultQuery.getLastDraw()>5000) resultQuery.setDrwid(resultQuery.getLastDraw()-5000);
			else resultQuery.setDrwid(resultQuery.getLastDraw());
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally { 
            LoggerApi.Log.info("resultQuery="+resultQuery);
        } 
        return resultQuery;
    }
    
    public String[] findTinkaNextDraw() throws Exception {
    	LoggerApi.Log.info("findTinkaBetData");
    	String[] resultQuery = null;
        try {
            resultQuery = beanProcedureDao.findTinkaNextDraw();
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally { 
            LoggerApi.Log.info("resultQuery="+resultQuery);
        } 
        return resultQuery;
    }

    public boolean isPopupSiosiActive() {        
    	String valueFlag = (ConnectionFactory.operationProperty("flagPromoTinka", Constantes.contextCardWeb)!=null && !String.valueOf(ConnectionFactory.operationProperty("flagPromoTinka", Constantes.contextCardWeb)).toString().trim().equals(""))?String.valueOf(ConnectionFactory.operationProperty("flagPromoTinka", Constantes.contextCardWeb)).toString().trim():"0";
    	boolean isFlagPromoTinka = BooleanUtils.toBoolean(Integer.parseInt(valueFlag.trim()));
        boolean isActive = false;
        try {
	        if (isFlagPromoTinka) {
	        	ViewFlagPopupSiosi viewFlagPopupSiosi = flagPopupSiosiDao.getFlagPopup();
	        	if( BooleanUtils.toBoolean(viewFlagPopupSiosi.getFlagPopup()) ) {
	        		isActive = true;
	        	}	        	
	        } 
        } catch (Exception e) {
        	LoggerApi.severe(e); 
        } finally {
        }
        return isActive;
    }

    public boolean isPopup3x12Active() {
    	boolean isPopup3x12Active = false;
    	try {
    		Calendar calendarHoy = Calendar.getInstance();
    		Calendar StartPopupTinka3x12 = Calendar.getInstance();
			Calendar EndPopupTinka3x12 = Calendar.getInstance();
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    		String str_StartPopupTinka3x12 = String.valueOf(ConnectionFactory.operationProperty("startPopupTinka3x12", Constantes.contextSale)).toString().trim();
        	String str_EndPopupTinka3x12 = String.valueOf(ConnectionFactory.operationProperty("endPopupTinka3x12", Constantes.contextSale)).toString().trim();
        	StartPopupTinka3x12.setTime(formato.parse(str_StartPopupTinka3x12));
        	EndPopupTinka3x12.setTime(formato.parse(str_EndPopupTinka3x12));
			if(calendarHoy.after(StartPopupTinka3x12) && calendarHoy.before(EndPopupTinka3x12) )
				isPopup3x12Active = true;
    	}catch (Exception e) {
        	LoggerApi.severe(e); 
        }
    	
    	return isPopup3x12Active;
    }
}