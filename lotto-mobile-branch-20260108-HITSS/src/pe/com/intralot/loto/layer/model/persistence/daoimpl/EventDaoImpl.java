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

import pe.com.intralot.loto.layer.model.persistence.dao.EventDao;
import pe.com.intralot.loto.layer.model.pojo.Event;
import pe.com.intralot.loto.layer.model.pojo.TeapuestoV;
import pe.com.intralot.loto.sale.lib.LoggerApi;
/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */
@Component("beanEventDao")
public class EventDaoImpl extends HibernateDaoSupport implements EventDao {

	//protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	public EventDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
		//logger.debug("Entrando a " +  this.getClass().getName()+ ".EventDaoImpl");
		this.setHibernateTemplate(hibernateTemplate);
	}


	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<TeapuestoV> findWithCondition01() throws 
	Exception{
		List<TeapuestoV>  resultQuery = new ArrayList<TeapuestoV>();
		try {			
			LoggerApi.Log.info("ei.findWithCondition01");
			
			String queryString = "From Event1";	
		
						
		/*
			String queryString =
					" from " + 
					" Event as e" +
					" where " + 
					" e.loResult is null " +				
			        " and (trunc(e.datePrincipal) + decode(sign(e.closeHour - 9),-1,e.closeHour+24,e.closeHour)/24 + e.closeMinute/24/60 >= (sysdate)) " +
			        " and (trunc(e.datePrincipal) + e.closeHour/24 + e.closeMinute/24/60 <= (sysdate + 3) or e.minimum = 1 ) " +
			        " and (te_team_local is not null and te_team_visitor is not null)  and rownum<=5 "  +
					" order by e.minimum asc,e.datePrincipal asc";	
		*/
		    resultQuery=getHibernateTemplate().find(queryString);
			return resultQuery;
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
			
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("ei.findWithCondition01 size=" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("ei.findWithCondition01 size: null");
			}
			
				}
	
		
	}

	@SuppressWarnings("unchecked")	
	@Transactional(readOnly = false)
	public Event findWithCondition02(Object[] params) throws 
	Exception{
		Event resultQuery = new Event();
		try {
			LoggerApi.Log.info("ei.findWithCondition02");
			
			String queryString =
					" from " + 
					" Event as e" +
					" where " + 
					"     e.loResult is null " +				
			        " and (trunc(e.datePrincipal) + decode(sign(e.closeHour - 9),-1,e.closeHour+24,e.closeHour)/24 + e.closeMinute/24/60 >= (sysdate)) " +
			        " and (trunc(e.datePrincipal) + e.closeHour/24 + e.closeMinute/24/60 <= (sysdate + 3) or e.minimum = 1 ) " +
			        " and (te_team_local is not null and te_team_visitor is not null) " + 		      
					" and e.eventpk.event= ?"+
					" and e.eventpk.draw= ?"+
					" and e.eventpk.game= ?";
					
			resultQuery= DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString,params));	
			return resultQuery;
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
			
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("ei.findWithCondition02 resultQuery: "+resultQuery.toString());	
			}else{
				LoggerApi.Log.info("ei.findWithCondition02 resultQuery: "+"null");
			}
			
		}
				
	
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Event> findWithCondition03() throws 
	Exception{
		List<Event>  resultQuery=new ArrayList<Event>();
		try {
			LoggerApi.Log.info("ei.findWithCondition03");
			
			String queryString = 
					" select " +	
					" distinct e.eventpk.draw " +
					" ,e.datePrincipal " +				
					" from " +
					" Event as e" +
					" where " + 			
					"  te_status = 'ACT' " +				
			        " and te_event_status = 'Active'  " +
			        " and (trunc(e.datePrincipal) + e.closeHour/24 + e.closeMinute/24/60 >= sysdate ) " +
					" order by trunc(e.datePrincipal) asc";
			
			resultQuery=getHibernateTemplate().find(queryString);
			return resultQuery;			
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);		
			
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("ei.findWithCondition03 size=" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("ei.findWithCondition03 size=" + "null");
			}
			
			
			}		
	}



	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Event> findWithCondition04(Object[] params) throws 
	Exception{
		List<Event> resultQuery=new ArrayList<Event>();
		try {
			LoggerApi.Log.info("ei.findWithCondition04");	
			
			String queryString =
					" from " + 
					" Event as e" +
					" where " + 
					"     e.loResult is null " +		
			        " and (trunc(e.datePrincipal) + decode(sign(e.closeHour - 9),-1,e.closeHour+24,e.closeHour)/24 + e.closeMinute/24/60 >= (sysdate)) " +
			        " and (trunc(e.datePrincipal) + e.closeHour/24 + e.closeMinute/24/60 <= (sysdate + 3) or e.minimum = 1 ) " +
			        " and (te_team_local is not null and te_team_visitor is not null) "+  
			        " and e.minimum= ?"+				        
			        " order by trunc(e.datePrincipal) asc";		
			
			resultQuery=getHibernateTemplate().find(queryString,params);
			return resultQuery; 
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("ei.findWithCondition04 size=" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("ei.findWithCondition04 size=" + "null");
			}
			
		
			
		}

	}

	@SuppressWarnings("unchecked")	
	@Transactional(readOnly = false)
	public List<Event> findWithCondition05(Object[] params) throws 
	Exception {
		List<Event> resultQuery=new ArrayList<Event>();
		try {
			LoggerApi.Log.info("ei.findWithCondition05");	
			
			String queryString =
					" from " + 
					" Event as e" +
					" where " + 
					"     e.loResult is null " +		
			        " and (trunc(e.datePrincipal) + decode(sign(e.closeHour - 9),-1,e.closeHour+24,e.closeHour)/24 + e.closeMinute/24/60 >= (sysdate)) " +
			        " and (trunc(e.datePrincipal) + e.closeHour/24 + e.closeMinute/24/60 <= (sysdate + 3) or e.minimum = 1 ) " +
			        " and (te_team_local is not null and te_team_visitor is not null) "+		       
				    " and to_char(e.datePrincipal,'DD/MM/YYYY')= ? "+				   		        
			        " order by (concat(e.closeHour,e.closeMinute)) asc";	
			
			resultQuery=getHibernateTemplate().find(queryString,params);
			return resultQuery;					
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
			
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("ei.findWithCondition05 size=" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("ei.findWithCondition05 size=" + "null");
			}
			
		}

	}
	
	
	@SuppressWarnings("unchecked")	
	@Transactional(readOnly = false)
	public List<Event> findWithCondition06() throws 
	Exception {
		List<Event> resultQuery=new ArrayList<Event>();
		try {
			LoggerApi.Log.info("ei.findWithCondition06");	
			/*
			DetachedCriteria criteria = DetachedCriteria.forClass(Event.class,"e");
			criteria.createAlias("teapuestoItems", "teapuesto");

			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("e.datePrincipal"));
			criteria.setProjection(proList);
			criteria.setProjection(Projections.groupProperty("e.datePrincipal"));
			criteria.addOrder(Order.asc("e.datePrincipal"));
			
			resultQuery=getHibernateTemplate().findByCriteria(criteria,0,4); */


			String queryString = 
					" select " +	
					" distinct  e.datePrincipal " +				
					" from " +
					" Event as e" +
					" where " + 
					"     e.loResult is not null " +		
			        " and (e.datePrincipal >= trunc(sysdate - 4)) " +
			        " order by (e.datePrincipal) asc";	
			
			resultQuery=getHibernateTemplate().find(queryString);
			
			return resultQuery;					
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
			
		} finally{
			if(resultQuery!=null){
				LoggerApi.Log.info("ei.findWithCondition06 size=" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("ei.findWithCondition06 size=" + "null");
			}
		}

	}
	
	@SuppressWarnings("unchecked")	
	@Transactional(readOnly = false)
	public List<Event> findWithCondition07(Object[] params) throws 
	Exception {
		List<Event> resultQuery=new ArrayList<Event>();
		try {
			LoggerApi.Log.info("ei.findWithCondition07");	
			
				String queryString =
					" select "+
					" e.eventpk.event, "+
				    " e.teamLocal, "+
				    " e.teamVisitor, "+
				    " i.localScore, "+
				    " i.visitorScore, "+
				    " e.result,"+	
				    " e.datePrincipal"+
					" from " + 
					" Event e inner join e.teapuestoItems as i" +				
					" where " + 							       
			        " i.item = 2"+
			        " and to_char(e.datePrincipal,'DD/MM/YYYY')= ? "+		        
			        " order by e.eventpk.event desc";
			
			resultQuery=getHibernateTemplate().find(queryString,params);
			return resultQuery;					
			
		} catch (Exception e) {
			LoggerApi.severe(e);
			throw new Exception(e);
		} finally {
			if(resultQuery!=null){
				LoggerApi.Log.info("ei.findWithCondition07 size=" + resultQuery.size());	
			}else{
				LoggerApi.Log.info("ei.findWithCondition07 size=null");
			}
			
			
		}

	}
}