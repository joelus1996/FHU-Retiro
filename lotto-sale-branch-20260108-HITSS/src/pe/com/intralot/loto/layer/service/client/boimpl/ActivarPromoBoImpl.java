package pe.com.intralot.loto.layer.service.client.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.ActivarPromo;

import pe.com.intralot.loto.layer.model.persistence.dao.ActivarPromoDao;

import pe.com.intralot.loto.layer.service.client.bo.ActivarPromoBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;

@Service
public class ActivarPromoBoImpl implements ActivarPromoBo{
	
	@Autowired
	private ActivarPromoDao activarPromoDao;

	@Override
	public List<ActivarPromo> findPromo() throws Exception {
		List<ActivarPromo> resultQuery = new ArrayList<ActivarPromo>();
		
	 	try {
	 		resultQuery = activarPromoDao.findPromo();			
			
	        return resultQuery;
		} catch(Exception e) {
			LoggerApi.severe(e);			
			throw new Exception(e);
		} finally {	
			if(resultQuery!=null){
				LoggerApi.Log.info("resultQuery: "+resultQuery.size());	
			}else{
				LoggerApi.Log.info("resultQuery: "+"null");
			}
			
		}
	}

}
