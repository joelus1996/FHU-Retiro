package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
 * @author:   Victor Farro Veramendi
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.intralot.loto.layer.model.domain.Province;
import pe.com.intralot.loto.layer.model.domain.ViewProvinciaList;
import pe.com.intralot.loto.layer.model.persistence.dao.ProvinceDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class ProvinceDaoImpl extends HibernateBaseDaoImpl implements ProvinceDao {

	@Override
	public List<Province> findProvince() throws Exception {
		List<Province> resultQueryList = new ArrayList<Province>();

		try {
			String queryString = "FROM Province p ORDER BY p.provinceName ASC";
			resultQueryList = super.find(queryString);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}

	@Override
	public List<ViewProvinciaList> findViewProvinciaList() throws Exception {
		List<ViewProvinciaList> resultQueryList = new ArrayList<ViewProvinciaList>();
		try {
			String queryString = "FROM ViewProvinciaList p ORDER BY p.provinceName ASC";
			resultQueryList = super.find(queryString);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) {
				LoggerApi.Log.info("size= " + resultQueryList.size());
			}
		}
		return resultQueryList;
	}

}
