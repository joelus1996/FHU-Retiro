package pe.com.intralot.loto.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings({ "unchecked", "rawtypes" })
public class HibernateBaseDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private SessionFactory sessionFactoryBDTrans;
    
    @Autowired
    private DataSource dataSource;

    // @Autowired
    // private HibernateDaoSupport hibernateDaoSupport;
    public <T> void save(T entity) {
    	Session s = this.sessionFactory.openSession();
    	Transaction t = s.beginTransaction();
        //this.getCurrentSession().persist(entity);
    	s.persist(entity);
        t.commit();
        s.close();
    }

    public <T> void saveOrUpdate(T entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public <T> void update(T entity) {
        this.getCurrentSession().update(entity);
    }

    public int update(String queryString, Object[] arg1) {
        Query query = this.getCurrentSession().createQuery(queryString);
        if (arg1 != null)
            for (int i = 0; i < arg1.length; i++)
                query.setParameter(i, arg1[i]);
        return query.executeUpdate();
    }

    public <T> void delete(T entity) {
        this.getCurrentSession().delete(entity);
    }

    public <T> void deleteForId(Class entity, Object id) {
        this.delete(this.findForId(entity, id));
    }

    public <T> T findForId(Class entity, Object id) {
        return (T) this.getCurrentSession().get(entity, (Serializable) id);
    }

    public <T> List<T> find(String queryString) {
        return this.getCurrentSession().createQuery(queryString).list();
    }

    public <T> List<T> findCache(String queryString) {
        return this.getCurrentSession().createQuery(queryString).setCacheable(true).list();
    }

    public <T> List<T> findAll(Class entity) {
        return this.getCurrentSession().createQuery("from " + entity.getName()).list();
    }

    public <T> List<T> findForSql(String queryString, Class entity) {
        return this.getCurrentSession().createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(entity)).list();
    }

    public <T> List<T> find(String queryString, Object[] arg1) {
        Query query = this.getCurrentSession().createQuery(queryString);
        if (arg1 != null && arg1.length > 0)
            for (int i = 0; i < arg1.length; i++)
                query.setParameter(i, arg1[i]);
        return query.list();
    }

    public <T> List<T> findForNamed(String queryName, Object[] arg1) {
        Query query = this.getCurrentSession().getNamedQuery(queryName);
        if (arg1 != null && arg1.length > 0)
            for (int i = 0; i < arg1.length; i++)
                query.setParameter(i, arg1[i]);
        return query.list();
    }

    public <T> List<T> findForNamedCache(String queryName, Object[] arg1) {
        SQLQuery query = (SQLQuery)this.getCurrentSession().getNamedQuery(queryName);
        if (arg1 != null && arg1.length > 0)
            for (int i = 0; i < arg1.length; i++)
                query.setParameter(i, arg1[i]);
        return query.list();
    }
 
    public <T> List<T> findForNamedSetCache(String queryName, Object[] arg1) {
        SQLQuery query = (SQLQuery)this.getCurrentSession().getNamedQuery(queryName).setCacheable(true);
        if (arg1 != null && arg1.length > 0)
            for (int i = 0; i < arg1.length; i++)
                query.setParameter(i, arg1[i]);
        return query.list();
    } 

    // dbtrans
    public <T> List<T> findForNamedBdTrans(String queryName, Object[] arg1) {
    	Session session = null;
    	try {
    		session = this.getCurrentSessionBdTrans();
            Query query = session.getNamedQuery(queryName);
            if (arg1 != null && arg1.length > 0)
                for (int i = 0; i < arg1.length; i++)
                    query.setParameter(i, arg1[i]);
            return query.list();
    		
    	} finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }	

    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected final Session getCurrentSessionBdTrans() {
        return sessionFactoryBDTrans.openSession();
    }    
    
    protected final Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    /*
     * protected final HibernateTemplate getTemplate() throws SQLException { return hibernateDaoSupport.getHibernateTemplate(); }
     */
}
