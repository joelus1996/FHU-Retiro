package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import pe.com.intralot.loto.layer.model.domain.DrawItem;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawItemDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

/**
 * @author: Zolanch Tavara Sandon
 * @rol: Analista Programador
 * @proyecto:
 * 
 */
@Repository
public class DrawItemDaoImpl extends HibernateBaseDaoImpl implements DrawItemDao {

	@Override
	public DrawItem findByIdByGameId(Integer drawId, Integer gameID) throws Exception {
		LoggerApi.Log.info("drawId= " + drawId + " gameID= " + gameID);

		List<DrawItem> resultQuery = new ArrayList<DrawItem>();
		DrawItem objectDomain = new DrawItem();

		try {

			Object[] values = new Object[2];
			values[0] = drawId;
			values[1] = gameID;

			String queryString = " FROM " + " 		DrawItem d " + " WHERE " + " 	  	d.id.drawId = ?" + " AND " + " 	  	d.id.gameId = ?";

			resultQuery = super.find(queryString, values);

			objectDomain = (DrawItem) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("diResult=" + objectDomain.getDiResult() + "diLocalName=" + objectDomain.getDiLocalName());
			}
		}
		return objectDomain;
	}

}
