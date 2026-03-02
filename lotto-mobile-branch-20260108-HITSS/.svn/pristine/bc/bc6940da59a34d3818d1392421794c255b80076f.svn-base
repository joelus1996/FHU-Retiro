package pe.com.intralot.loto.layer.controller.client.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.controller.client.bo.DeportesVirtualesBo;
import pe.com.intralot.loto.layer.model.persistence.dao.DeportesVirtualesDao;
import pe.com.intralot.loto.layer.model.pojo.DeportesvirtualesProcedureGetEventsTraduction;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class DeportesVirtualesBoImpl implements DeportesVirtualesBo{
	
	@Autowired
    private DeportesVirtualesDao deportesVirtualesDao;
	
	@Override
	public DeportesvirtualesProcedureGetEventsTraduction getEventsTraduction(String playlistId) throws Exception {
		
    	DeportesvirtualesProcedureGetEventsTraduction objectDomain = new DeportesvirtualesProcedureGetEventsTraduction();
        try {
            objectDomain = deportesVirtualesDao.getEventsTraduction(playlistId);
        } catch (Exception e) {
        	LoggerApi.Log.info( e.getMessage());
	    	e.printStackTrace();
        }
        return objectDomain;

	}

}
