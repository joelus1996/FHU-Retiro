package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.persistence.dao.ClientTicketLotos5Dao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
/**
 * @author:   Celso Larico
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 * 
 */
@Component("beanClientTicketLotos5Dao")
public class ClientTicketLotos5DaoImpl extends HibernateDaoSupport implements ClientTicketLotos5Dao {

	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public ClientTicketLotos5DaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
		//logger.debug("Entrando a " +  this.getClass().getName()+ ".ClientDaoImpl");
		this.setHibernateTemplate(hibernateTemplate);
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String findTicketIdByCoupon(String couponId) throws 
	Exception{ 
		//LoggerApi.Log.info("findTicketIdByCoupon couponId =" + couponId);
		String resultQuery= null;
		try {			
			Object params[] = new Object[2];
			params[0] = 3;
			params[1] = couponId;
			String queryString ="select ct.ticketId from ClientTicketLotos5 as ct WHERE  ct.ctIflexChannel = ? AND  ct.ctIflexPlacebetId = ?";			
		resultQuery= String.valueOf(DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString,params)));	
		return resultQuery;
		} catch (Exception e) {
			LoggerApi.severe(e);		
			throw new Exception(e);
		} finally {
			/*
			if(resultQuery!=null){
				LoggerApi.Log.info("findTicketIdByCoupon resultQuery =" + resultQuery.toString());	
			}else{
				LoggerApi.Log.info("findTicketIdByCoupon resultQuery =" + "null");
			}
			*/
		}
	}

}