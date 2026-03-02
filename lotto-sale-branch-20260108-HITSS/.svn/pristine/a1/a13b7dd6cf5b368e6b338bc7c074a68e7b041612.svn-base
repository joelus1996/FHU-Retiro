package pe.com.intralot.loto.layer.service.client.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intralot.loto.layer.model.domain.Country;
import pe.com.intralot.loto.layer.model.persistence.dao.CountryDao;
import pe.com.intralot.loto.layer.service.client.bo.CountryBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;
@Service
public class CountryBoImpl implements CountryBo{
	
	@Autowired
	private CountryDao countryDao;

	@Override
	public List<Country> findCountry() throws Exception {
		List<Country> resultQueryList = new ArrayList<Country>();
		try {
			resultQueryList = countryDao.findCountry();
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
