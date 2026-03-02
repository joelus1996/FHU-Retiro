package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.domain.ActivarPromo;

import pe.com.intralot.loto.layer.model.persistence.dao.ActivarPromoDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class ActivarPromoDaoImpl extends HibernateBaseDaoImpl implements ActivarPromoDao{
		
	@Transactional(readOnly = false)
	public List<ActivarPromo> findPromo() throws Exception {
		List<ActivarPromo> actPromo = new ArrayList<ActivarPromo>();
		try {
		String queryString = "FROM ActivarPromo";
		actPromo = super.find(queryString);			
		} catch (Exception e) {
			LoggerApi.severe(e);
		} finally {
			if(actPromo != null)
				LoggerApi.Log.info("Lista_Provincias");
		}
		return actPromo;
	}
	
	
	

}
