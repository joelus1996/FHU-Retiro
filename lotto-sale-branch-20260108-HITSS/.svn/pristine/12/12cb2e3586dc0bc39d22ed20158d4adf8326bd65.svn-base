package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
 * @author:   Celso Larico
 * @rol:	  Coordinador de desarrollo
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.domain.ViewFlagPopupSiosi;
import pe.com.intralot.loto.layer.model.persistence.dao.FlagPopupSiosiDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.util.HibernateBaseDaoImpl;

@Repository
public class FlagPopupSiosiDaoImpl extends HibernateBaseDaoImpl implements FlagPopupSiosiDao {

	@Override
	@Transactional(readOnly = false)
	public ViewFlagPopupSiosi getFlagPopup() throws Exception {

		List<ViewFlagPopupSiosi> resultQuery = new ArrayList<ViewFlagPopupSiosi>();
		ViewFlagPopupSiosi objectDomain = new ViewFlagPopupSiosi();

		try {

			String queryString = "FROM ViewFlagPopupSiosi";

			resultQuery = super.find(queryString);
			objectDomain = (ViewFlagPopupSiosi) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("flagPopupSiosi= " + objectDomain.getFlagPopup());
			}
		}

		return objectDomain;
	}


}