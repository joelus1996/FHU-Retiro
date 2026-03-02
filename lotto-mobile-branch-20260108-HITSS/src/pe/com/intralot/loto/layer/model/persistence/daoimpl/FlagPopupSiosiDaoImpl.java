package pe.com.intralot.loto.layer.model.persistence.daoimpl;

/**
 * @author:   Celso Larico
 * @rol:	  Coordinador de desarrollo
 * @proyecto: 
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.pojo.ViewFlagPopupSiosi;
import pe.com.intralot.loto.layer.model.persistence.dao.FlagPopupSiosiDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@Component("beanFlagPopupSiosiDao")
public class FlagPopupSiosiDaoImpl extends HibernateDaoSupport implements FlagPopupSiosiDao {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public FlagPopupSiosiDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
		//logger.debug("Entrando a " +  this.getClass().getName()+ ".ClientDaoImpl");
		this.setHibernateTemplate(hibernateTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ViewFlagPopupSiosi getFlagPopup() throws Exception {

		List<ViewFlagPopupSiosi> resultQuery = new ArrayList<ViewFlagPopupSiosi>();
		ViewFlagPopupSiosi objectDomain = new ViewFlagPopupSiosi();

		try {

			String queryString = "FROM ViewFlagPopupSiosi";

			resultQuery = getHibernateTemplate().find(queryString); 
			objectDomain = (ViewFlagPopupSiosi) DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));

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