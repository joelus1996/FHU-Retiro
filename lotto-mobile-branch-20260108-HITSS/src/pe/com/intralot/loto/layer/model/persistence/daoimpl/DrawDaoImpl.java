package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.persistence.dao.DrawDao;
import pe.com.intralot.loto.layer.model.pojo.Draw;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetData;
import pe.com.intralot.loto.layer.model.pojo.GanagolProcedureBetDataMobile;
import pe.com.intralot.loto.sale.lib.LoggerApi;
/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */
@Component("beanDrawDao")
public class DrawDaoImpl extends HibernateDaoSupport implements DrawDao {

    //protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    public DrawDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
        //logger.debug("Entrando a " + this.getClass().getName() + ".DrawDaoImpl");
        this.setHibernateTemplate(hibernateTemplate);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition01() throws Exception {
        Draw resultQuery = new Draw();
        try {
            LoggerApi.Log.info("findAllWithCondition01");
            String queryString = " from Draw as d" + " where d.drawPk.gameId=44 "
                    + " and d.drawPk.drawId=( select max(da.drawPk.drawId) from Draw as da where da.drawPk.gameId=44" + " and da.drOficial=1)" + " and d.drOficial=1";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition01 resultQuery =" + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition01 resultQuery =" + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition02() throws Exception {
        LoggerApi.Log.info("findAllWithCondition02");
        Draw resultQuery = new Draw();
        try {
            String queryString = " from Draw as d" + " where d.drawPk.gameId=44 " + " and d.drawPk.drawId = ( "
                    + " select min(dw.drawPk.drawId) from Draw as dw where dw.drawPk.gameId=44" + " and  dw.drawDate > ( "
                    + " select max(dd.drawDate) from Draw as dd where dd.drawPk.gameId=44 and dd.drawFlag=1 ))";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition02 resultQuery =" + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition02 resultQuery =" + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition03() throws Exception {
        LoggerApi.Log.info("findAllWithCondition03");
        Draw resultQuery = new Draw();
        try {
            String queryString = " from Draw as d"
                    + " where d.drawPk.gameId=44 "
                    + " and to_date(to_char(d.openDate,'YYYY MM DD')||' '||lpad(d.openHour,2,'0')||' '||lpad(d.openMinute,2,'0')||' 00','YYYY MM DD HH24 MI SS') < sysdate"
                    + " and to_date(to_char(d.closeDate,'YYYY MM DD')||' '||lpad(d.closeHour,2,'0')||' '||lpad(d.closeMinute,2,'0')||' 00','YYYY MM DD HH24 MI SS')  > sysdate"
                    + " and d.closeDate is not null " + " and d.closeHour is not null" + " and d.closeMinute is not null" + " and d.openDate is not null"
                    + " and d.openHour is not null" + " and d.openMinute is not null";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition03 resultQuery =" + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition03 resultQuery =" + "null");
        }
    }

    /*
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition04() throws Exception {
        LoggerApi.Log.info("");
        Draw resultQuery = new Draw();
        try {
            String queryString01 = " select min(d.drawPk.drawId)" + " from Draw as d" + " where "
                    + " to_date(to_char(coalesce(d.closeDate,dr_date),'YYYYMMDD')||lpad(d.closeHour,2,'0')||lpad(d.closeMinute,2,'0'),'YYYYMMDDHH24MI') >= sysdate"
                    + " and d.drawPk.gameId=4 " + " and coalesce(d.closeDate,d.drawDate) is not null";
            Object params[] = new Object[1];
            params[0] = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString01));
            String queryString02 = " from Draw as d" + " where d.drawPk.gameId=4 " + " and d.drawPk.drawId = ?";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString02, params));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            ;
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("resultQuery =" + resultQuery.toString());
            else
                LoggerApi.Log.info("resultQuery =" + "null");
        }
    }
    */
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition04() throws Exception {
        LoggerApi.Log.info("ddi.findAllWithCondition04");
        Draw resultQuery1 = new Draw();
        Draw resultQuery2 = new Draw();
        SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
        try {
            String queryString01 = " select min(d.drawPk.drawId)" + " from Draw as d" + " where "
                    + " to_date(to_char(coalesce(d.closeDate,dr_date),'YYYYMMDD')||lpad(d.closeHour,2,'0')||lpad(d.closeMinute,2,'0'),'YYYYMMDDHH24MI') >= sysdate"
                    + " and d.drawPk.gameId=4 " + " and coalesce(d.closeDate,d.drawDate) is not null";
            Object params[] = new Object[1];
            params[0] = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString01));
            String queryString02 = " from Draw as d" + " where d.drawPk.gameId=4 " + " and d.drawPk.drawId = ?";
            resultQuery1 = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString02, params));
            //System.out.println("Jackpot="+resultQuery.getJackpot());
            resultQuery1.setCloseDate1(df.format(resultQuery1.getCloseDate()));
            LoggerApi.Log.info("resultQuery1.getJackpot() =" + resultQuery1.getJackpot());
            if(resultQuery1.getJackpot()==null||resultQuery1.getJackpot()==0) {
            	LoggerApi.Log.info("INGRESA CUANDO EL JACKPOT ES NULL O 0");
            	boolean flag = true;
            	//Object obj = new Object();
            	//double jackpot = 0;
            	int drawid = Integer.parseInt(params[0].toString());
            	while(flag) {
	            	drawid = drawid-1;
	            	params[0] = drawid;
	            	 LoggerApi.Log.info("drawid - 1 =" + drawid);
	            	String queryString03 = " from Draw as d where d.drawPk.gameId=4 and d.drawPk.drawId = "+drawid;
	            	resultQuery2 = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString03));
	            	//jackpot = (resultQuery2!=null&&resultQuery2.getJackpot()!=null)?resultQuery2.getJackpot():0;
	                if(resultQuery2!=null&&resultQuery2.getJackpot()!=null&&resultQuery2.getJackpot()>0) {
	                	flag = false;
	                	//System.out.println("Jackpot="+jackpot+" Drawid="+params[0]);
	                	resultQuery1.setDrawId2(resultQuery2.getDrawPk().getDrawId());
	                	resultQuery1.setJackpot2(resultQuery2.getJackpot());
	                	resultQuery1.setCloseDate2(df.format(resultQuery2.getCloseDate()));
	                	resultQuery1.setCloseHour2(resultQuery2.getCloseHour());
	                	resultQuery1.setCloseMinute2(resultQuery2.getCloseMinute());
	                }
            	}	
            }
            
            if(resultQuery1.getDrawId2() == null) {  
            	resultQuery1.setDrawId2(99);
            	resultQuery1.setJackpot2(99.99);
            }
            
            return resultQuery1;
        } catch (Exception e) {
            LoggerApi.severe(e);
            ;
            throw new Exception(e);
        } finally {
            if (resultQuery1 != null) {
                LoggerApi.Log.info("ddi.findAllWithCondition04 resultQuery1 =" + resultQuery1.toString());
            	if (resultQuery2!=null) LoggerApi.Log.info("ddi.findAllWithCondition04 resultQuery2 =" + resultQuery2.toString());
            }
            else {
                LoggerApi.Log.info("ddi.findAllWithCondition04 resultQuery =" + "null");
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition05() throws Exception {
        LoggerApi.Log.info("findAllWithCondition05");
        Draw resultQuery = new Draw();
        try {
            String queryString = " from Draw as d" + " where d.drawPk.gameId=4 " + " and d.drOficial = 1";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition05 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition05 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findWithCondition06() throws Exception {
        LoggerApi.Log.info("findWithCondition06");
        Draw resultQuery = new Draw();
        try {
            String queryString = " from Draw as d" + " where d.drawPk.gameId=164 "
                    + " and d.drawPk.drawId =( select max(da.drawPk.drawId) from Draw as da where da.drawPk.gameId=164" + " and da.drOficial=1)";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findWithCondition06 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findWithCondition06 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findWithCondition07() throws Exception {
        LoggerApi.Log.info("findWithCondition07");
        Draw resultQuery = new Draw();
        SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
        try {
            String queryString = " from Draw as d"
                    + " where d.drawPk.gameId=164 "
                    + " and to_date(to_char(d.openDate,'YYYY MM DD')||' '||lpad(d.openHour,2,'0')||' '||lpad(d.openMinute,2,'0')||' 00','YYYY MM DD HH24 MI SS') < sysdate"
                    + " and to_date(to_char(d.closeDate,'YYYY MM DD')||' '||lpad(d.closeHour,2,'0')||' '||lpad(d.closeMinute,2,'0')||' 00','YYYY MM DD HH24 MI SS')  > sysdate"
                    + " and d.closeDate is not null " + " and d.closeHour is not null" + " and d.closeMinute is not null" + " and d.openDate is not null"
                    + " and d.openHour is not null" + " and d.openMinute is not null" + " and d.drawPk.drawId > 300";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            resultQuery.setCloseDate1(df.format(resultQuery.getCloseDate()));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findWithCondition07 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findWithCondition07 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<Draw> findWithCondition08() throws Exception {
        LoggerApi.Log.info("findWithCondition08");
        List<Draw> resultQuery = new ArrayList<Draw>();
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(Draw.class);
            criteria.setProjection(Projections.alias(
                    Projections.distinct(Projections.sqlProjection("trunc(DR_DATE) as drawDate", new String[] { "drawDate" }, new Type[] { Hibernate.DATE })), "date"));
            criteria.add(Restrictions.eq("drawPk.gameId", 1121));
            criteria.add(Restrictions.isNotNull("result"));
            criteria.add(Restrictions.sqlRestriction("trunc(DR_DATE) <= trunc(sysdate)"));
            criteria.addOrder(Order.desc("date"));
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 4);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findWithCondition08 resultQuery = " + resultQuery.size());
            else
                LoggerApi.Log.info("findWithCondition08 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<Draw> findWithCondition09(Object[] params) throws Exception {
        LoggerApi.Log.info("findWithCondition09");
        List<Draw> resultQuery = new ArrayList<Draw>();
        try {
            String queryString = " from " + " Draw as d" + " where " + " d.drawPk.gameId = ?" + " and d.result is not null" + " and to_char(d.drawDate,'DD/MM/YYYY')= ?"
                    + " order by d.drawPk.drawId desc";
            resultQuery = getHibernateTemplate().find(queryString, params);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findWithCondition09 resultQuery = " + resultQuery.size());
            else
                LoggerApi.Log.info("findWithCondition09 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<Draw> findWithCondition10() throws Exception {
        LoggerApi.Log.info("findWithCondition10");
        List<Draw> resultQuery = new ArrayList<Draw>();
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(Draw.class);
            criteria.setProjection(Projections.alias(
                    Projections.distinct(Projections.sqlProjection("trunc(DR_DATE) as drawDate", new String[] { "drawDate" }, new Type[] { Hibernate.DATE })), "date"));
            criteria.add(Restrictions.eq("drawFlag", 1));
            criteria.add(Restrictions.eq("drawPk.gameId", 5209));
            criteria.add(Restrictions.isNotNull("result"));
            criteria.add(Restrictions.sqlRestriction("trunc(DR_DATE) <= trunc(sysdate)"));
            criteria.addOrder(Order.desc("date"));
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 4);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findWithCondition10 resultQuery = " + resultQuery.size());
            else
                LoggerApi.Log.info("findWithCondition10 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition11() throws Exception {
        LoggerApi.Log.info("findAllWithCondition11");
        Draw resultQuery = new Draw();
        SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
        try {
            String queryString = " from Draw as d" + " where d.drawPk.gameId=41 " + " and  d.openDate + nvl(d.openHour,23)/24 + nvl(d.openMinute,59)/24/6 < sysdate"
                    + " and nvl(d.closeDate,d.drawDate) + nvl(d.closeHour,21)/24 + nvl(d.closeMinute,30)/24/60  > sysdate";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            resultQuery.setCloseDate1(df.format(resultQuery.getCloseDate()));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition11 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition11 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition12() throws Exception {
        LoggerApi.Log.info("findAllWithCondition12");
        Draw resultQuery = new Draw();
        SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
        try {
            String queryString = " from Draw as d" + " where d.drawPk.gameId=41 "
                    + " and d.drawPk.drawId=( select max(da.drawPk.drawId) from Draw as da where da.drawPk.gameId=41" + " and da.result is not null)"
                    + " and d.result is not null";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            resultQuery.setCloseDate1(df.format(resultQuery.getCloseDate()));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition12 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition12 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition13() throws Exception {
        LoggerApi.Log.info("findAllWithCondition13");
        Draw resultQuery = new Draw();
        SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
        try {
            String queryString = " from Draw as d" + " where d.drawPk.gameId=41 " + " and d.drawPk.drawId = ( "
                    + " select min(dw.drawPk.drawId) from Draw as dw where dw.drawPk.gameId=41" + " and  dw.drawDate > ( "
                    + " select max(dd.drawDate) from Draw as dd where dd.drawPk.gameId=41 and dd.drawFlag=1 ))";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            resultQuery.setCloseDate1(df.format(resultQuery.getCloseDate()));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition13 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition13 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition14() throws Exception {
        LoggerApi.Log.info("findAllWithCondition14");
        Draw resultQuery = new Draw();
        int count = 0;
        SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
        try {
            /*String queryString = " from Draw as d" + " where d.drawPk.gameId=42 "
                    + " and d.drawPk.drawId=( select max(da.drawPk.drawId) from Draw as da where da.drawPk.gameId=42" + " and da.drOficial=1)" + " and d.drOficial=1";*/
        	String queryString = "select count(*) from Draw d " +
				 	"where d.drawPk.gameId = 42 " +
				 	" and trunc(d.openDate) + d.openHour/24  + d.openMinute/24/60 < sysdate " +
				 	" and trunc(d.closeDate) + d.closeHour/24  + d.closeMinute/24/60  > sysdate";
        	count = Integer.valueOf(DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString)).toString()).intValue();
        	LoggerApi.Log.info("OpenDraw = " + count);
        	if(count==0){
        		queryString = "from Draw d " +
            		 	"where d.drawPk.gameId = 42 " +
            		 	" and d.drawPk.drawId = (select min(dd.drawPk.drawId) from Draw dd " +
    		            "        where dd.drawPk.gameId = 42 " +
    		            "        and trunc(dd.openDate) + dd.openHour/24  + dd.openMinute/24/60 > sysdate )";
        	} else {
	        	queryString = "from Draw d " +
					 	"where d.drawPk.gameId = 42 " +
					 	" and trunc(d.openDate) + d.openHour/24  + d.openMinute/24/60 < sysdate " +
					 	" and trunc(d.closeDate) + d.closeHour/24  + d.closeMinute/24/60  > sysdate";
        	}
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            resultQuery.setCloseDate1(df.format(resultQuery.getCloseDate()));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition14 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition14 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition15() throws Exception {
        LoggerApi.Log.info("findAllWithCondition15");
        Draw resultQuery = new Draw();
        SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
        try {
            String queryString = " from Draw as d" + " where d.drawPk.gameId=42 "
                    + " and d.drawPk.drawId=( select max(da.drawPk.drawId) from Draw as da where da.drawPk.gameId=42" + " and da.result is not null)"
                    + " and d.result is not null";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            resultQuery.setCloseDate1(df.format(resultQuery.getCloseDate()));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition15 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition15 resultQuery = " + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public Draw findAllWithCondition16() throws Exception {
        LoggerApi.Log.info("findAllWithCondition16");
        Draw resultQuery = new Draw();
        try {
            String queryString = " from Draw as d" + " where d.drawPk.gameId=42 " + " and d.drawPk.drawId = ( "
                    + " select min(dw.drawPk.drawId) from Draw as dw where dw.drawPk.gameId=42" + " and  dw.drawDate > ( "
                    + " select max(dd.drawDate) from Draw as dd where dd.drawPk.gameId=42 and dd.drawFlag=1 ))";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findAllWithCondition16 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findAllWithCondition16 resultQuery = " + "null");
        }
    }
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public GanagolProcedureBetData findGanagolBetData(Integer p_clientId) throws Exception {

		LoggerApi.Log.info("cid= " + p_clientId+" findGanagolBetData");
		List<GanagolProcedureBetData> resultQuery = new ArrayList<GanagolProcedureBetData>();
		GanagolProcedureBetData objectDomain = new GanagolProcedureBetData();

		try {
			Object[] values = new Object[1];
			values[0] = p_clientId;
			resultQuery = getHibernateTemplate().findByNamedQuery("GANAGOLSALE_BETDATA", values);
			objectDomain = (GanagolProcedureBetData) DataAccessUtils.uniqueResult(resultQuery);

		} catch (Exception e) {
			LoggerApi.severe(e);
			throw e;
		} finally {
			if (objectDomain != null) {
				LoggerApi.Log.info("findGanagolBetData w_status= " + objectDomain.getStatus() + 
						"w_message= " + objectDomain.getMessage() + 
						"w_prize= " + objectDomain.getPrize() + 
						"w_active_draw= " + objectDomain.getActiveDraw() + 
						"w_close_date= " + objectDomain.getCloseDate() + 
						"w_close_hour= " + objectDomain.getCloseHour() + 
						"w_next_draw= "	+ objectDomain.getNextDraw() + 
						"w_open_date= " + objectDomain.getOpenDate() + 
						"w_open_hour= " + objectDomain.getOpenHour() + 
						"w_notes= "	+ objectDomain.getNotes() + 
						"w_program= " + objectDomain.getProgram() + 
						"w_price_type= " + objectDomain.getPriceType() + 
						"w_price_message= "	+ objectDomain.getPriceMessage() + 
						"w_simple_bet_price= " + objectDomain.getSimpleBetPrice() + 
						"w_promotion_type= " + objectDomain.getPromotionType() +
						"w_balance_amount= " + objectDomain.getBalanceAmount() + 
						"w_balance_amount_game= " + objectDomain.getBalanceAmountGame() + 
						"w_algorithm= " + objectDomain.getAlgorithm() +
						"w_bets= " + objectDomain.getBets() + 
						"w_pay= " + objectDomain.getPay() + 
						"w_draws= " + objectDomain.getDraws()+ 
						"w_cost= " + objectDomain.getCost());
			}
		}
		return objectDomain;
	}
    
    @SuppressWarnings("unchecked")
   	@Transactional(readOnly = false)
   	public GanagolProcedureBetDataMobile findGanagolBetDataMobile(Integer p_clientId) throws Exception {

   		LoggerApi.Log.info("cid= " + p_clientId+" findGanagolBetData");
   		List<GanagolProcedureBetDataMobile> resultQuery = new ArrayList<GanagolProcedureBetDataMobile>();
   		GanagolProcedureBetDataMobile objectDomain = new GanagolProcedureBetDataMobile();

   		try {
   			Object[] values = new Object[1];
   			values[0] = p_clientId;
   			resultQuery = getHibernateTemplate().findByNamedQuery("GANAGOLSALE_BETDATA_MOBILE", values);
   			objectDomain = (GanagolProcedureBetDataMobile) DataAccessUtils.uniqueResult(resultQuery);
   			System.out.println("Ganagolsale_betdata : "+resultQuery.toString());

   		} catch (Exception e) {
   			LoggerApi.severe(e);
   			throw e;
   		} finally {
   			if (objectDomain != null) {
   				LoggerApi.Log.info("findGanagolBetData w_status= " + objectDomain.getStatus() + 
   						"w_message= " + objectDomain.getMessage() + 
   						"w_prize= " + objectDomain.getPrize() + 
   						"w_active_draw= " + objectDomain.getActiveDraw() + 
   						"w_close_date= " + objectDomain.getCloseDate() + 
   						"w_close_hour= " + objectDomain.getCloseHour() + 
   						"w_next_draw= "	+ objectDomain.getNextDraw() + 
   						"w_open_date= " + objectDomain.getOpenDate() + 
   						"w_open_hour= " + objectDomain.getOpenHour() + 
   						"w_notes= "	+ objectDomain.getNotes() + 
   						"w_program= " + objectDomain.getProgram() + 
   						"w_price_type= " + objectDomain.getPriceType() + 
   						"w_price_message= "	+ objectDomain.getPriceMessage() + 
   						"w_simple_bet_price= " + objectDomain.getSimpleBetPrice() + 
   						"w_promotion_type= " + objectDomain.getPromotionType() +
   						"w_balance_amount= " + objectDomain.getBalanceAmount() + 
   						"w_balance_amount_game= " + objectDomain.getBalanceAmountGame() + 
   						"w_algorithm= " + objectDomain.getAlgorithm() +
   						"w_bets= " + objectDomain.getBets() + 
   						"w_pay= " + objectDomain.getPay() + 
   						"w_draws= " + objectDomain.getDraws()+ 
   						"w_cost= " + objectDomain.getCost());
   			}
   		}
   		return objectDomain;
   	}
    

	public Draw getKineloLastResult() throws Exception {
		//LoggerApi.Log.info("getKineloLastResult");
        Draw resultQuery = new Draw();
        try {
           	String queryString = " from Draw as d" + " where d.drawPk.gameId=1121 and d.drawDate > (sysdate - (10/1440)) and d.drawDate <= (sysdate - (5/1440))";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("getKineloLastResult resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("getKineloLastResult resultQuery = " + "null");
        }
	}

	public List<Draw> getKineloLastResultByFecha(String fechaMinima, String fechaMaxima) throws Exception {
		//LoggerApi.Log.info("getKineloLastResultByFecha");
		List<Draw> resultQuery = new ArrayList<Draw>();
        try {
           	String queryString = " from Draw as d" + " where d.drawPk.gameId=1121 and d.drawDate>=TO_DATE('"+fechaMinima+"','DD/MM/YYYY HH24:MI:SS')"+ " and d.drawDate < TO_DATE('"+fechaMaxima+"','DD/MM/YYYY HH24:MI:SS') order by d.drawDate desc";
            resultQuery =  getHibernateTemplate().find(queryString);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("getKineloLastResultByFecha resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("getKineloLastResultByFecha resultQuery = " + "null");
        }
	}

	@Override
	public Draw findWithCondition17(Object[] params) throws Exception {
		LoggerApi.Log.info("findWithCondition09");
        Draw resultQuery = new Draw();
        try {
            String queryString = " from " + " Draw as d" + " where" + " d.drawPk.drawId = ?" + " and d.drawPk.gameId = 4" + " and d.result is not null" + " and to_char(d.drawDate,'DD/MM/YYYY')= ?"
                    + " order by d.drawPk.drawId desc";
            resultQuery = DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString, params));
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("findWithCondition09 resultQuery = " + resultQuery.toString());
            else
                LoggerApi.Log.info("findWithCondition09 resultQuery = " + "null");
        }
	}
}