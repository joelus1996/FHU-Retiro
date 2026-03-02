package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.persistence.dao.ParameterDao;
import pe.com.intralot.loto.sale.lib.LoggerApi;
import pe.com.intralot.loto.layer.model.pojo.Parameter;

/**
 * <p>
 * NOMBRE: ClientDaoImpl.java
 * <br></p>
 * <p>
 * FUNCION: Implementación del objeto de acceso a datos de la cuenta
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   Celso Larico     02/06/2020  First comment
 * </pre>
 * <br></p>
 */

@Component("beanParameterDao")
public class ParameterDaoImpl extends HibernateDaoSupport implements ParameterDao {

	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public ParameterDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
		//logger.debug("Entrando a " +  this.getClass().getName()+ ".ClientDaoImpl");
		this.setHibernateTemplate(hibernateTemplate);
	}
	
	
	@Transactional(readOnly = false)
	public Parameter findByPk(String pk) throws 
	Exception{ 
		//LoggerApi.Log.info("findByPk pk =" + pk);
		
		Parameter resultQuery=new Parameter();
		try {
			
			resultQuery= getHibernateTemplate().get(Parameter.class,pk);
		    
			return resultQuery;
			
		} catch (Exception e) {
			LoggerApi.severe(e);	
			throw new Exception(e);
			
		} finally {

		}	    
		
	}
	
}