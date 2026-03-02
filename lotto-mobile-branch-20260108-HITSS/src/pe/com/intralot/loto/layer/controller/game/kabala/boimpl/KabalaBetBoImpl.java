package pe.com.intralot.loto.layer.controller.game.kabala.boimpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.controller.game.kabala.bo.KabalaBetBo;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.persistence.dao.ProcedureDao;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.KabalaChChSale;
import pe.com.intralot.loto.layer.model.pojo.KabalaSale;
import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.Constantes;

@Service("beanKabalaBetBo")
public class KabalaBetBoImpl implements KabalaBetBo {

    //protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DrawDao beanDrawDao;
    @Autowired
    private ProcedureDao beanProcedureDao;
    /*@Autowired
    private ViewDAO beanViewDAO;*/

    @SuppressWarnings("rawtypes")
    public HashMap[] getNumberConsecutive() throws Exception {
        HashMap[] objectMap = null;
        try {
            LoggerApi.Log.info("");
            //objectMap = beanProcedureDao.getNumberConsecutiveTinka();
            objectMap = beanProcedureDao.getNumberConsecutiveKabala();
            return objectMap;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (objectMap != null)
                LoggerApi.Log.info("objectMap: " + objectMap.length);
            else
                LoggerApi.Log.info("objectMap: " + "null");
        }
    }

    public Draw getDataCloseDateGame() throws Exception {
        Draw objectPojo = new Draw();
        try {
            LoggerApi.Log.info("");
            objectPojo = beanDrawDao.findAllWithCondition14();
            if(objectPojo.getDrawPk().getDrawId()>5000) objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId()-5000);
            else objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId());
            return objectPojo;
        } catch (NullPointerException e) {
        	return null;
        }  catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (objectPojo != null)
                LoggerApi.Log.info("objectPojo: " + objectPojo.toString());
            else
                LoggerApi.Log.info("objectPojo: " + "null");
        }
    }

    public Draw getDrawsKabala01() throws Exception {
        Draw objectPojo = new Draw();
        try {
            LoggerApi.Log.info("");
            objectPojo = beanDrawDao.findAllWithCondition15();
            if(objectPojo.getDrawPk().getDrawId()>5000) objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId()-5000);
            else objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId());
            return objectPojo;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (objectPojo != null)
                LoggerApi.Log.info("objectPojo: " + objectPojo.toString());
            else
                LoggerApi.Log.info("objectPojo: " + "null");
        }
    }

    public Draw getDrawsKabala02() throws Exception {
        Draw objectPojo = new Draw();
        try {
            LoggerApi.Log.info("");
            objectPojo = beanDrawDao.findAllWithCondition16();
            if(objectPojo.getDrawPk().getDrawId()>5000) objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId()-5000);
            else objectPojo.setDrwid(objectPojo.getDrawPk().getDrawId());
            return objectPojo;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (objectPojo != null)
                LoggerApi.Log.info("objectPojo: " + objectPojo.toString());
            else
                LoggerApi.Log.info("objectPojo: " + "null");
        }
    } 

    public KabalaSale findKabalaBetData(Integer id) throws Exception {
    	LoggerApi.Log.info("id: " + id);
        KabalaSale resultQuery = new KabalaSale();
        try {
            resultQuery = beanProcedureDao.findProcedureKabalaBetData(id);
            if(resultQuery.getLastDraw()>5000) resultQuery.setDrwid(resultQuery.getLastDraw()-5000);
			else resultQuery.setDrwid(resultQuery.getLastDraw());
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally { 
            LoggerApi.Log.info("resultQuery="+resultQuery);
        } 
        return resultQuery;
    }
    
    public KabalaChChSale findKabalaBetDataChCh(Integer id) throws Exception {
    	LoggerApi.Log.info("id: " + id);
    	KabalaChChSale resultQuery = new KabalaChChSale();
        try {
            resultQuery = beanProcedureDao.findProcedureKabalaBetDataChCh(id);
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally { 
            LoggerApi.Log.info("resultQuery="+resultQuery);
        } 
        return resultQuery;
    }

	@Override
	public String[] findKabalaNextDraw() throws Exception {
		LoggerApi.Log.info("findKabalaBetData");
    	String[] resultQuery = null;
        try {
            resultQuery = beanProcedureDao.findKabalaNextDraw();
        } catch (Exception e) {
            LoggerApi.severe(e);
        } finally { 
            LoggerApi.Log.info("resultQuery="+resultQuery);
        } 
        return resultQuery;
	}
	
	@Override
	public boolean isSubscriptionAllowedGoIn(String user) {
		boolean isKabalaSubscription = Boolean.valueOf(ConnectionFactory.operationProperty("kabalaSubscriptionEnabled", Constantes.contextSale).trim()).booleanValue();
	       boolean isAllowed = false;
	       String kabalaSubscriptionUsers = String.valueOf(ConnectionFactory.operationProperty("kabalaSubscriptionUsers", Constantes.contextSale)).toString().trim();
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
}
