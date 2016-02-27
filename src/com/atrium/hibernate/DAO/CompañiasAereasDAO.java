package com.atrium.hibernate.DAO;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.Compa�iasAereas;

/**
 * A data access object (DAO) providing persistence and search support for
 * Compa�iasAereas entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Compa�iasAereas
 * @author MyEclipse Persistence Tools
 */
public class Compa�iasAereasDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(Compa�iasAereasDAO.class);
	// property constants
	public static final String NOMBRE_COMPA�IA = "nombreCompa�ia";
	public static final String PAIS_COMPA�IA = "paisCompa�ia";

	protected void initDao() {
		// do nothing
	}

	public void save(Compa�iasAereas transientInstance) {
		log.debug("saving Compa�iasAereas instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Compa�iasAereas persistentInstance) {
		log.debug("deleting Compa�iasAereas instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Compa�iasAereas findById(java.lang.String id) {
		log.debug("getting Compa�iasAereas instance with id: " + id);
		try {
			Compa�iasAereas instance = (Compa�iasAereas) getHibernateTemplate()
					.get("com.atrium.hibernate.Compa�iasAereas", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Compa�iasAereas instance) {
		log.debug("finding Compa�iasAereas instance by example");
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
		log.debug("finding Compa�iasAereas instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Compa�iasAereas as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNombreCompa�ia(Object nombreCompa�ia) {
		return findByProperty(NOMBRE_COMPA�IA, nombreCompa�ia);
	}

	public List findByPaisCompa�ia(Object paisCompa�ia) {
		return findByProperty(PAIS_COMPA�IA, paisCompa�ia);
	}

	public List findAll() {
		log.debug("finding all Compa�iasAereas instances");
		try {
			String queryString = "from Compa�iasAereas";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Compa�iasAereas merge(Compa�iasAereas detachedInstance) {
		log.debug("merging Compa�iasAereas instance");
		try {
			Compa�iasAereas result = (Compa�iasAereas) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Compa�iasAereas instance) {
		log.debug("attaching dirty Compa�iasAereas instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Compa�iasAereas instance) {
		log.debug("attaching clean Compa�iasAereas instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Compa�iasAereasDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (Compa�iasAereasDAO) ctx.getBean("Compa�iasAereasDAO");
	}
}