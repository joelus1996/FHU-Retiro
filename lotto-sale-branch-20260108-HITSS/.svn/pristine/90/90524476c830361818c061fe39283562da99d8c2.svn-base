package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.Region;
import pe.com.intralot.loto.layer.model.persistence.dao.RegionDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class RegionDaoImpl extends HibernateBaseDaoImpl implements RegionDao {

    @Override
    public List<Region> findRegion() throws Exception {
        List<Region> resultQueryList = new ArrayList<Region>();
        try {
            String queryString = "FROM Region r ORDER BY r.regionName ASC";
            resultQueryList = super.findCache(queryString);
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw e;
        } finally {
            if (resultQueryList != null)
                LoggerApi.Log.info("size= " + resultQueryList.size());
        }
        return resultQueryList;
    }
}
