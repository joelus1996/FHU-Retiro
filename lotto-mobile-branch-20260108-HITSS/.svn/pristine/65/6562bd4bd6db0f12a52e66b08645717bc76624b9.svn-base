package pe.com.intralot.loto.layer.controller.game.ganadiario.boimpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobil
 *
 */
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.controller.game.ganadiario.bo.GanadiarioBetBo;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioSale;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;

@Service("beanGanadiarioBetBo")
public class GanadiarioBetBoImpl implements GanadiarioBetBo {

    //protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private ProcedureDao beanProcedureDao;
    @Autowired
    private DrawDao beanDrawDao;

    @SuppressWarnings("rawtypes")
    public HashMap[] getNumberConsecutive() throws Exception {
    	HashMap[] objectMap =null;
        try {
        	LoggerApi.Log.info("");
            objectMap = beanProcedureDao.getNumberConsecutiveGanadiario();
            return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        }finally{
        	if(objectMap!=null){
        		LoggerApi.Log.info("objectMap: "+objectMap.length);
        	}else{
        		LoggerApi.Log.info("objectMap: "+"null");
        	}
        	 
        	  }
    }

    public Draw getDrawsGanadiario() throws Exception {
    	Draw objectPojo = new Draw();
        try {
        	LoggerApi.Log.info("");
            objectPojo = beanDrawDao.findWithCondition06();
            if(objectPojo.getDrawPk().getDrawId()>5000) objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId()-5000);
            else objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId());
            return objectPojo;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        }finally{
        	if(objectPojo!=null){
        		LoggerApi.Log.info("objectPojo: "+objectPojo.toString());
        	}else{
        		LoggerApi.Log.info("objectPojo: "+"null");
        	}
        	  
        	 }
    }

    public Draw getDataCloseDateGame() throws Exception {
    	Draw objectPojo =new Draw();
    	try {
        	LoggerApi.Log.info("");
            objectPojo = beanDrawDao.findWithCondition07();
            if(objectPojo.getDrawPk().getDrawId()>5000) objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId()-5000);
            else objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId());
            return objectPojo;
        } catch (NullPointerException e) {
        	return null;
        } catch (Exception e) {
           LoggerApi.severe(e);
            throw new Exception(e);
        }finally{
        	if(objectPojo!=null){
        		LoggerApi.Log.info("objectPojo: "+objectPojo.toString());	
        	}else{
        		LoggerApi.Log.info("objectPojo: "+"null");
        	}
        	 
        }
    }

    public GanadiarioSale findGanadiarioBetData(Integer id) throws Exception {
    	LoggerApi.Log.info("id: " + id);
        GanadiarioSale resultQuery = new GanadiarioSale();
        try {
            resultQuery = beanProcedureDao.findProcedureGanadiarioBetData(id);
            if(resultQuery.getLastDraw()>5000) resultQuery.setDrwid(resultQuery.getLastDraw()-5000);
			else resultQuery.setDrwid(resultQuery.getLastDraw());
            return resultQuery;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        	if(resultQuery!=null){
        		LoggerApi.Log.info("resultQuery: "+resultQuery.toString());	
        	}else{
        		LoggerApi.Log.info("resultQuery: "+"null");	
        	}
        }
    }

	@Override
	public String[] findGanadiarioNextDraw() throws Exception {		
    	LoggerApi.Log.info("findGanadiarioBetData");
    	String[] resultQuery = null;
        try {
            resultQuery = beanProcedureDao.findGanadiarioNextDraw();
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally { 
            LoggerApi.Log.info("resultQuery="+resultQuery);
        } 
        return resultQuery;	    
	}
	
	@Override
	public boolean isSubscriptionAllowedGoIn(String user) {
		boolean isKabalaSubscription = Boolean.valueOf(ConnectionFactory.operationProperty("ganadiarioSubscriptionEnabled", Constantes.contextSale).trim()).booleanValue();
	       boolean isAllowed = false;
	       String kabalaSubscriptionUsers = String.valueOf(ConnectionFactory.operationProperty("ganadiarioSubscriptionUsers", Constantes.contextSale)).toString().trim();
	       if (isKabalaSubscription == false) {
	           if (kabalaSubscriptionUsers != null && !kabalaSubscriptionUsers.equals("")) {
	               String[] subscriptionUsers = kabalaSubscriptionUsers.split(",");
	               for (String subscriptionUser : subscriptionUsers)
	                   if (subscriptionUser.equals(user)) {
	                       isAllowed = true;
	                       break;
	                   }
	           }
	       } else isAllowed = true;
	    return isAllowed; 		
	}
	
	public boolean isPopup3x5solesActive() {
    	boolean active = false;
    	try {
    		Calendar calendarHoy = Calendar.getInstance();
    		Calendar StartPopup = Calendar.getInstance();
			Calendar EndPopup = Calendar.getInstance();
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    		String strStartPopup = String.valueOf(ConnectionFactory.operationProperty("startPopupGD3x5", Constantes.contextSale)).toString().trim();
        	String strEndPopup = String.valueOf(ConnectionFactory.operationProperty("endPopupGD3x5", Constantes.contextSale)).toString().trim();
        	StartPopup.setTime(formato.parse(strStartPopup));
        	EndPopup.setTime(formato.parse(strEndPopup));
			if(calendarHoy.after(StartPopup) && calendarHoy.before(EndPopup) )
				active = true;
    	}catch (Exception e) {
        	LoggerApi.severe(e); 
        }
    	
    	return active;
    }
}