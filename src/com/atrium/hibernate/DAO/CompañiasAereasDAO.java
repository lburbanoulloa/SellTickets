package com.atrium.hibernate.DAO;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.CompañiasAereas;

/**
 * A data access object (DAO) providing persistence and search support for
 * CompañiasAereas entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.CompañiasAereas
 * @author MyEclipse Persistence Tools
 */
public class CompañiasAereasDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CompañiasAereasDAO.class);
	// property constants
	public static final String NOMBRE_COMPAÑIA = "nombreCompañia";
	public static final String PAIS_COMPAÑIA = "paisCompañia";

	protected void initDao() {
		// do nothing
	}

	public void save(CompañiasAereas transientInstance) {
		log.debug("saving CompañiasAereas instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompañiasAereas persistentInstance) {
		log.debug("deleting CompañiasAereas instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompañiasAereas findById(java.lang.String id) {
		log.debug("getting CompañiasAereas instance with id: " + id);
		try {
			CompañiasAereas instance = (CompañiasAereas) getHibernateTemplate()
					.get("com.atrium.hibernate.CompañiasAereas", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompañiasAereas instance) {
		log.debug("finding CompañiasAereas instance by example");
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
		log.debug("finding CompañiasAereas instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CompañiasAereas as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNombreCompañia(Object nombreCompañia) {
		return findByProperty(NOMBRE_COMPAÑIA, nombreCompañia);
	}

	public List findByPaisCompañia(Object paisCompañia) {
		return findByProperty(PAIS_COMPAÑIA, paisCompañia);
	}

	public List findAll() {
		log.debug("finding all CompañiasAereas instances");
		try {
			String queryString = "from CompañiasAereas";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompañiasAereas merge(CompañiasAereas detachedInstance) {
		log.debug("merging CompañiasAereas instance");
		try {
			CompañiasAereas result = (CompañiasAereas) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompañiasAereas instance) {
		log.debug("attaching dirty CompañiasAereas instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompañiasAereas instance) {
		log.debug("attaching clean CompañiasAereas instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompañiasAereasDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompañiasAereasDAO) ctx.getBean("CompañiasAereasDAO");
	}
}