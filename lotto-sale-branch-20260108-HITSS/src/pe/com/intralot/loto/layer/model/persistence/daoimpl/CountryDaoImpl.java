package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.model.persistence.dao.CountryDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 */
@Repository
public class CountryDaoImpl extends HibernateBaseDaoImpl implements CountryDao {

	@Override
	public List<Country> findCountry() throws Exception {
		List<Country> resultQueryList = new ArrayList<Country>();
		try {
			String queryString = "FROM Country c ORDER BY c.countryName ASC";
			resultQueryList = super.findCache(queryString);
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (resultQueryList != null) 
				LoggerApi.Log.info("size=" + resultQueryList.size());			
		}
		return resultQueryList;
	}
}
