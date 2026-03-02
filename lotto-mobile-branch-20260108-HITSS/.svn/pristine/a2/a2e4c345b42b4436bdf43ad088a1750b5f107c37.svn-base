package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.persistence.dao.PromSorteoDao;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureGetFlagClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureGetTicketsClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureInsertClient;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureListFechaPromo;
import pe.com.intralot.loto.layer.model.pojo.PromProcedureListTicketClient;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.HibernateBaseDaoImpl;

@Repository
public class PromSorteoDaoImpl extends HibernateBaseDaoImpl implements PromSorteoDao {
	
	@Override
	public PromProcedureInsertClient insertClient(String codPromo, Integer clientId, String promoChannel) throws Exception {
		LoggerApi.Log.info("cid=" + clientId);
        List<PromProcedureInsertClient> resultQuery = new ArrayList<PromProcedureInsertClient>();
        PromProcedureInsertClient objectDomain = new PromProcedureInsertClient();
        try {
            Object[] values = new Object[3];
            values[0] = codPromo;
            values[1] = clientId;
            values[2] = promoChannel;
            resultQuery = super.findForNamed("PROMSORTEO_INSERTCLIENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        }
        return objectDomain;
	}

	@Override
	public PromProcedureGetFlagClient getFlagClient(String codPromo, int clientId) throws Exception {
		LoggerApi.Log.info("cid=" + clientId);
        List<PromProcedureGetFlagClient> resultQuery = new ArrayList<PromProcedureGetFlagClient>();
        PromProcedureGetFlagClient objectDomain = new PromProcedureGetFlagClient();
        try {
            Object[] values = new Object[2];
            values[0] = codPromo;
            values[1] = clientId;
            resultQuery = super.findForNamed("PROMSORTEO_GETFLAGCLIENT", values);
            objectDomain = DataAccessUtils.uniqueResult(resultQuery);
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        }
        return objectDomain;
	}
	
	@Override
	public List<PromProcedureGetTicketsClient> getTicketsClient(String codPromo, int clientId) throws Exception {
		LoggerApi.Log.info("cid=" + clientId);
        List<PromProcedureGetTicketsClient> resultQuery = new ArrayList<PromProcedureGetTicketsClient>();
        try {
            Object[] values = new Object[2];
            values[0] = codPromo;
            values[1] = clientId;
            resultQuery = super.findForNamed("PROMSORTEO_GETTICKETSCLIENT", values); 
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        }
        return resultQuery;
	}

	@Override
	public List<PromProcedureListTicketClient> getListTicketsClient(String codPromo, int clientId) throws Exception {
		LoggerApi.Log.info("cid=" + clientId);
        List<PromProcedureListTicketClient> resultQuery = new ArrayList<PromProcedureListTicketClient>();
        try {
            Object[] values = new Object[2];
            values[0] = codPromo;
            values[1] = clientId;
            resultQuery = super.findForNamed("PROMSORTEO_GETLISTTICKETSCLIENT", values); 
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        }
        return resultQuery;
	}

	@Override
	public List<PromProcedureListFechaPromo> getListFechaPromo(String codPromo) throws Exception {
		LoggerApi.Log.info("codPromo=" + codPromo);
        List<PromProcedureListFechaPromo> resultQuery = new ArrayList<PromProcedureListFechaPromo>();
        try {
            Object[] values = new Object[1];
            values[0] = codPromo;
            resultQuery = super.findForNamed("PROMSORTEO_GETLISTFECHAPROMO", values); 
        } catch (Exception e) {
        	LoggerApi.severe(e);
            throw e;
        }
        return resultQuery;
	}
	
}
