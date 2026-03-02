package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.persistence.dao.DeportesVirtualesDao;
import pe.com.intralot.loto.layer.model.pojo.DeportesvirtualesProcedureGetEventsTraduction;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.utils.HibernateBaseDaoImpl;

@Repository
public class DeportesVirtualesDaoImpl extends HibernateBaseDaoImpl implements DeportesVirtualesDao {
	
	
	@Override
	public DeportesvirtualesProcedureGetEventsTraduction getEventsTraduction(String playlistId) throws Exception {
		LoggerApi.Log.info("getEventsTraduction playlistId=" + playlistId);
		
		List<DeportesvirtualesProcedureGetEventsTraduction> resultQuery = new ArrayList<DeportesvirtualesProcedureGetEventsTraduction>();
		DeportesvirtualesProcedureGetEventsTraduction objectDomain = new DeportesvirtualesProcedureGetEventsTraduction();
		
		try {
			Object[] values = new Object[1];
	        values[0] = playlistId;
	        resultQuery = super.findForNamed("DEPORTESVIRTUALESSALE_GETEVENTSTRADUCTION", values);
			objectDomain = (DeportesvirtualesProcedureGetEventsTraduction) DataAccessUtils.uniqueResult(resultQuery);

	        if (resultQuery != null)
	            LoggerApi.Log.info("getEventsTraduction size=" + resultQuery.size()+ " traduction="+objectDomain.getPlaylistTraduction());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
        return objectDomain;
	}

}
