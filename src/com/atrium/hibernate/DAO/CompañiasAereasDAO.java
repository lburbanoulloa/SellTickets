package com.atrium.hibernate.DAO;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.CompaņiasAereas;

/**
 * A data access object (DAO) providing persistence and search support for
 * CompaņiasAereas entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.CompaņiasAereas
 * @author MyEclipse Persistence Tools
 */
public class CompaņiasAereasDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CompaņiasAereasDAO.class);
	// property constants
	public static final String NOMBRE_COMPAŅIA = "nombreCompaņia";
	public static final String PAIS_COMPAŅIA = "paisCompaņia";

	protected void initDao() {
		// do nothing
	}

	public void save(CompaņiasAereas transientInstance) {
		log.debug("saving CompaņiasAereas instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompaņiasAereas persistentInstance) {
		log.debug("deleting CompaņiasAereas instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompaņiasAereas findById(java.lang.String id) {
		log.debug("getting CompaņiasAereas instance with id: " + id);
		try {
			CompaņiasAereas instance = (CompaņiasAereas) getHibernateTemplate()
					.get("com.atrium.hibernate.CompaņiasAereas", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompaņiasAereas instance) {
		log.debug("finding CompaņiasAereas instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CompaņiasAereas instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CompaņiasAereas as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNombreCompaņia(Object nombreCompaņia) {
		return findByProperty(NOMBRE_COMPAŅIA, nombreCompaņia);
	}

	public List findByPaisCompaņia(Object paisCompaņia) {
		return findByProperty(PAIS_COMPAŅIA, paisCompaņia);
	}

	public List findAll() {
		log.debug("finding all CompaņiasAereas instances");
		try {
			String queryString = "from CompaņiasAereas";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompaņiasAereas merge(CompaņiasAereas detachedInstance) {
		log.debug("merging CompaņiasAereas instance");
		try {
			CompaņiasAereas result = (CompaņiasAereas) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompaņiasAereas instance) {
		log.debug("attaching dirty CompaņiasAereas instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompaņiasAereas instance) {
		log.debug("attaching clean CompaņiasAereas instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompaņiasAereasDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompaņiasAereasDAO) ctx.getBean("CompaņiasAereasDAO");
	}
}