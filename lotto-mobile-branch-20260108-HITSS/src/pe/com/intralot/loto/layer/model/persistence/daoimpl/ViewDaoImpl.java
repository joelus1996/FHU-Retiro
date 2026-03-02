package pe.com.intralot.loto.layer.model.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intralot.loto.layer.model.persistence.dao.ViewDAO;
import pe.com.intralot.loto.layer.model.pojo.ElreventonList;
import pe.com.intralot.loto.layer.model.pojo.GanadiarioList;
import pe.com.intralot.loto.layer.model.pojo.GanagolList;
import pe.com.intralot.loto.layer.model.pojo.KabalaList;
import pe.com.intralot.loto.layer.model.pojo.Super3List;
import pe.com.intralot.loto.layer.model.pojo.TinkaList;
import pe.com.intralot.loto.sale.lib.LoggerApi;
/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador Web Java
 * @proyecto: lotto-mobile
 *
 */
@Component("beanViewDao")
public class ViewDaoImpl extends HibernateDaoSupport implements ViewDAO {

    //protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    public ViewDaoImpl(@Qualifier("hibernateTemplate") HibernateTemplate hibernateTemplate) {
        //logger.debug("Entrando a " + this.getClass().getName() + ".ViewDaoImpl");
        this.setHibernateTemplate(hibernateTemplate);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<TinkaList> findWithCondition01() throws Exception {
        List<TinkaList> resultQuery = new ArrayList<TinkaList>();
        try {
            LoggerApi.Log.info("vi.findWithCondition01");
            DetachedCriteria criteria = DetachedCriteria.forClass(TinkaList.class);
            criteria.add(Restrictions.eq("game", 44));
            criteria.addOrder(Order.desc("rawid"));
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 7);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("vi.findWithCondition01 resultQuery =" + resultQuery.size());
            else
                LoggerApi.Log.info("vi.findWithCondition01 resultQuery =" + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<GanadiarioList> findWithCondition02() throws Exception {
        List<GanadiarioList> resultQuery = new ArrayList<GanadiarioList>();
        try {
            LoggerApi.Log.info("vi.findWithCondition02");
            DetachedCriteria criteria = DetachedCriteria.forClass(GanadiarioList.class);
            criteria.addOrder(Order.desc("rawid"));
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 14);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("vi.findWithCondition02 resultQuery =" + resultQuery.size());
            else
                LoggerApi.Log.info("vi.findWithCondition02 resultQuery =" + "null"); 
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<GanagolList> findWithCondition03() throws Exception {
        List<GanagolList> resultQuery = new ArrayList<GanagolList>();
        try {
            LoggerApi.Log.info("vi.findWithCondition03");
            DetachedCriteria criteria = DetachedCriteria.forClass(GanagolList.class);
            criteria.addOrder(Order.desc("rawid"));
            
            //se filtra que result sea no nulo
            Disjunction disjunction = Restrictions.disjunction();
            disjunction.add(Restrictions.isNotNull("result"));
            criteria.add(disjunction);
            //fin filtro
            
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 4);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("vi.findWithCondition03 resultQuery =" + resultQuery.size());
            else
                LoggerApi.Log.info("vi.findWithCondition03 resultQuery =" + "null"); 
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<KabalaList> findWithCondition04() throws Exception {
        List<KabalaList> resultQuery = new ArrayList<KabalaList>();
        try {
            LoggerApi.Log.info("vi.findWithCondition04");
            DetachedCriteria criteria = DetachedCriteria.forClass(KabalaList.class);
            criteria.addOrder(Order.desc("rawid"));
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 10);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("vi.findWithCondition04 resultQuery =" + resultQuery.size());
            else
                LoggerApi.Log.info("vi.findWithCondition04 resultQuery =" + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<Super3List> findWithCondition05() throws Exception {
        List<Super3List> resultQuery = new ArrayList<Super3List>();
        try {
            LoggerApi.Log.info("vi.findWithCondition05");
            DetachedCriteria criteria = DetachedCriteria.forClass(Super3List.class);
            criteria.addOrder(Order.desc("rawid"));
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 15);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("vi.findWithCondition05 resultQuery =" + resultQuery.size());
            else
                LoggerApi.Log.info("vi.findWithCondition05 resultQuery =" + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<ElreventonList> findWithCondition06() throws Exception {
        List<ElreventonList> resultQuery = new ArrayList<ElreventonList>();
        try {
            LoggerApi.Log.info("vi.findWithCondition06");
            DetachedCriteria criteria = DetachedCriteria.forClass(ElreventonList.class);
            criteria.addOrder(Order.desc("rawid"));
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 15);
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("vi.findWithCondition06 resultQuery =" + resultQuery.size());
            else
                LoggerApi.Log.info("vi.findWithCondition06 resultQuery =" + "null");
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<TinkaList> findWithCondition07() throws Exception {
        List<TinkaList> resultQuery = new ArrayList<TinkaList>();
        //List<TinkaList> resultQueryTk_Tm = new ArrayList<TinkaList>();
        try {
            LoggerApi.Log.info("vi.findWithCondition07");
            DetachedCriteria criteria = DetachedCriteria.forClass(TinkaList.class);
            //DetachedCriteria criteriatm = DetachedCriteria.forClass(TinkaList.class);
            //criteria.add(Restrictions.eq("game", 41));
            criteria.addOrder(Order.desc("rawid"));
            //criteriatm.add(Restrictions.eq("game", 44));
            //criteriatm.addOrder(Order.desc("rawid"));
            resultQuery = getHibernateTemplate().findByCriteria(criteria, 0, 15);//, 1);
            /*resultQueryTk_Tm = getHibernateTemplate().findByCriteria(criteriatm, 0, 14);
            for (int i = 0; i < resultQueryTk_Tm.size(); i++)
                resultQuery.add(resultQueryTk_Tm.get(i));*/
            return resultQuery;
        } catch (Exception e) {
            LoggerApi.severe(e);
            throw new Exception(e);
        } finally {
            if (resultQuery != null)
                LoggerApi.Log.info("vi.findWithCondition07 resultQuery =" + resultQuery.size());
            else
                LoggerApi.Log.info("vi.findWithCondition07 resultQuery = null");
            //LoggerApi.Log.info("Salir al metodo: findWithCondition07. Estado: Satisfactorio");
            //LoggerApi.Log.info("Salir de la clase: ViewDaoImpl.");
        }
    }
}