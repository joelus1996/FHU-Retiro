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
import pe.com.intralot.loto.layer.model.domain.Region;
import pe.com.intralot.loto.layer.model.persistence.dao.RegionDao;
import pe.com.intralot.loto.layer.service.client.bo.RegionBo;
import pe.com.intralot.loto.sale.lib.LoggerApi;
@Service
public class RegionBoImpl implements RegionBo{

	@Autowired
	private RegionDao regionDao;
	
	@Override	
	public List<Region> findRegion() throws Exception {
		
		List<Region> resultQueryList = new ArrayList<Region>();
		try {
			resultQueryList = regionDao.findRegion();
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
