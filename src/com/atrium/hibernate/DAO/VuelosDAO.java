package com.atrium.hibernate.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.Vuelos;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vuelos entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Vuelos
 * @author MyEclipse Persistence Tools
 */
public class VuelosDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(VuelosDAO.class);
	// property constants
	public static final String STR_VUELO = "strVuelo";
	public static final String NUMERO_PASAJEROS = "numeroPasajeros";
	public static final String ASIENTOS_VENDIDOS = "asientosVendidos";
	public static final String TARIFA_IDA = "tarifaIda";
	public static final String TARIFA_VUELTA = "tarifaVuelta";
	public static final String TARIFA_IDAVUELTA = "tarifaIdavuelta";

	protected void initDao() {
		// do nothing
	}

	public void save(Vuelos transientInstance) {
		log.debug("saving Vuelos instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vuelos persistentInstance) {
		log.debug("deleting Vuelos instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vuelos findById(java.lang.String id) {
		log.debug("getting Vuelos instance with id: " + id);
		try {
			Vuelos instance = (Vuelos) getHibernateTemplate().get(
					"com.atrium.hibernate.Vuelos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vuelos instance) {
		log.debug("finding Vuelos instance by example");
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
		log.debug("finding Vuelos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Vuelos as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStrVuelo(Object strVuelo) {
		return findByProperty(STR_VUELO, strVuelo);
	}

	public List findByNumeroPasajeros(Object numeroPasajeros) {
		return findByProperty(NUMERO_PASAJEROS, numeroPasajeros);
	}

	public List findByAsientosVendidos(Object asientosVendidos) {
		return findByProperty(ASIENTOS_VENDIDOS, asientosVendidos);
	}

	public List findByTarifaIda(Object tarifaIda) {
		return findByProperty(TARIFA_IDA, tarifaIda);
	}

	public List findByTarifaVuelta(Object tarifaVuelta) {
		return findByProperty(TARIFA_VUELTA, tarifaVuelta);
	}

	public List findByTarifaIdavuelta(Object tarifaIdavuelta) {
		return findByProperty(TARIFA_IDAVUELTA, tarifaIdavuelta);
	}

	public List findAll() {
		log.debug("finding all Vuelos instances");
		try {
			String queryString = "from Vuelos";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vuelos merge(Vuelos detachedInstance) {
		log.debug("merging Vuelos instance");
		try {
			Vuelos result = (Vuelos) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vuelos instance) {
		log.debug("attaching dirty Vuelos instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vuelos instance) {
		log.debug("attaching clean Vuelos instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VuelosDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VuelosDAO) ctx.getBean("VuelosDAO");
	}
}