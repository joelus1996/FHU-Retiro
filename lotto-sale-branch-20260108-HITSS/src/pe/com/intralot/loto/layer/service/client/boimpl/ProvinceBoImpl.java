package pe.com.intralot.loto.layer.service.client.boimpl;

/**
 * @author:   Victor Farro Veramendi
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.intralot.loto.layer.model.domain.Province;
import pe.com.intralot.loto.layer.model.domain.ViewProvinciaList;
import pe.com.intralot.loto.layer.model.persistence.dao.ProvinceDao;
import pe.com.intralot.loto.layer.service.client.bo.ProvinceBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;
@Service
public class ProvinceBoImpl implements ProvinceBo{
	
	@Autowired
	private ProvinceDao provinceDao;

	@Override
	public List<Province> findProvince() throws Exception {
		List<Province> resultQueryList = new ArrayList<Province>();
		try {
			resultQueryList = provinceDao.findProvince();
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
			resultQueryList = provinceDao.findViewProvinciaList();
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
