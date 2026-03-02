package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pe.com.intralot.loto.layer.model.persistence.dao.DrawItemDao;
import pe.com.intralot.loto.layer.model.pojo.DrawItem;
import pe.com.intralot.loto.sale.lib.LoggerApi;
/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */
@Component("beanDrawItemDao")
public class DrawItemDaoImpl extends HibernateDaoSupport implements DrawItemDao {

	//protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public DrawItemDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
		//logger.debug("Entrando a " +  this.getClass().getName()+ ".DrawDaoImpl");
		this.setHibernateTemplate(hibernateTemplate);
	}

	
	@SuppressWarnings("unchecked")	
	@Transactional(readOnly = false)
	public List<DrawItem> findWithCondition01(Object[] params) throws 
	Exception {
		LoggerApi.Log.info("di.findWithCondition01");
		List<DrawItem> resultQuery=new ArrayList<DrawItem>();
		
		try {
			String queryString =										    
					" from " + 
					" DrawItem as d " +				
					" where " + 							       
			        " d.drawpk.drawId = ? "+			        	        
			        " order by d.drawpk.item asc ";
			
			resultQuery=getHibernateTemplate().find(queryString,params);
			return resultQuery;					
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
			
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("di.findWithCondition01 resultQuery =" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("di.findWithCondition01 resultQuery =" + "null");
			}
			
		}

	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<DrawItem> findAllWithCondition02() throws 
	Exception{
		LoggerApi.Log.info("di.findAllWithCondition02");
		List<DrawItem> resultQuery=new ArrayList<DrawItem>();
		
	    try {
	    	
			String queryString01 =
					            " select min(d.drawPk.drawId)"+
					            " from Draw as d"+
	                            " where " +
	                            " to_date(to_char(coalesce(d.closeDate,dr_date),'YYYYMMDD')||lpad(d.closeHour,2,'0')||lpad(d.closeMinute,2,'0'),'YYYYMMDDHH24MI') >= sysdate"+
	                            " and d.drawPk.gameId=4 " +
	                            " and coalesce(d.closeDate,d.drawDate) is not null";
			
			Object params[]=new Object[1];
			
			params[0]=DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString01));
		
			String queryString02 =
								" from DrawItem as d"+
			                    " where d.drawpk.gameId=4 "+
			                    " and d.drawpk.drawId = ?"+
			                    " order by d.drawpk.item"; 
			
			resultQuery=getHibernateTemplate().find(queryString02,params);
		return resultQuery;		
			
	    } catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
			
        } finally {
        	if(resultQuery!=null){
				LoggerApi.Log.info("di.findAllWithCondition02 resultQuery =" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("di.findAllWithCondition02 resultQuery =" + "null");
			}
		
		}
		
	
	}





}