package com.atrium.hibernate.DAO;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.Aeropuertos;
import com.atrium.hibernate.AeropuertosId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Aeropuertos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Aeropuertos
 * @author MyEclipse Persistence Tools
 */
public class AeropuertosDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AeropuertosDAO.class);
	// property constants
	public static final String CIUDAD_AEROPUERTO = "ciudadAeropuerto";
	public static final String NOMBRE_AEROPUERTO = "nombreAeropuerto";

	protected void initDao() {
		// do nothing
	}

	public void save(Aeropuertos transientInstance) {
		log.debug("saving Aeropuertos instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Aeropuertos persistentInstance) {
		log.debug("deleting Aeropuertos instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aeropuertos findById(com.atrium.hibernate.AeropuertosId id) {
		log.debug("getting Aeropuertos instance with id: " + id);
		try {
			Aeropuertos instance = (Aeropuertos) getHibernateTemplate().get(
					"com.atrium.hibernate.Aeropuertos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Aeropuertos instance) {
		log.debug("finding Aeropuertos instance by example");
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
		log.debug("finding Aeropuertos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Aeropuertos as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCiudadAeropuerto(Object ciudadAeropuerto) {
		return findByProperty(CIUDAD_AEROPUERTO, ciudadAeropuerto);
	}

	public List findByNombreAeropuerto(Object nombreAeropuerto) {
		return findByProperty(NOMBRE_AEROPUERTO, nombreAeropuerto);
	}

	public List findAll() {
		log.debug("finding all Aeropuertos instances");
		try {
			String queryString = "from Aeropuertos";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Aeropuertos merge(Aeropuertos detachedInstance) {
		log.debug("merging Aeropuertos instance");
		try {
			Aeropuertos result = (Aeropuertos) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Aeropuertos instance) {
		log.debug("attaching dirty Aeropuertos instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Aeropuertos instance) {
		log.debug("attaching clean Aeropuertos instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AeropuertosDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AeropuertosDAO) ctx.getBean("AeropuertosDAO");
	}
}