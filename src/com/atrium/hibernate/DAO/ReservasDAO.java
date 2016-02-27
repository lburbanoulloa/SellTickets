package com.atrium.hibernate.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.Reservas;

/**
 * A data access object (DAO) providing persistence and search support for
 * Reservas entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Reservas
 * @author MyEclipse Persistence Tools
 */
public class ReservasDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ReservasDAO.class);
	// property constants
	public static final String CODIGO_VUELO = "codigoVuelo";
	public static final String NOMBRE_CLAVE = "nombreClave";
	public static final String PASSWORD = "password";
	public static final String TIPO_PASAJE = "tipoPasaje";
	public static final String TARIFA_PAGADA = "tarifaPagada";
	public static final String TARJETA_CREDITO = "tarjetaCredito";
	public static final String TARJETA_CREDITO_DIGITO = "tarjetaCreditoDigito";
	public static final String DOCUMENTACION_TIPO = "documentacionTipo";
	public static final String DOCUMENTACION_NUMERO = "documentacionNumero";
	public static final String NUMERO_MALETAS = "numeroMaletas";

	protected void initDao() {
		// do nothing
	}

	public void save(Reservas transientInstance) {
		log.debug("saving Reservas instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Reservas persistentInstance) {
		log.debug("deleting Reservas instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Reservas findById(java.lang.String id) {
		log.debug("getting Reservas instance with id: " + id);
		try {
			Reservas instance = (Reservas) getHibernateTemplate().get(
					"com.atrium.hibernate.Reservas", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Reservas instance) {
		log.debug("finding Reservas instance by example");
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
		log.debug("finding Reservas instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Reservas as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCodigoVuelo(Object codigoVuelo) {
		return findByProperty(CODIGO_VUELO, codigoVuelo);
	}

	public List findByNombreClave(Object nombreClave) {
		return findByProperty(NOMBRE_CLAVE, nombreClave);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByTipoPasaje(Object tipoPasaje) {
		return findByProperty(TIPO_PASAJE, tipoPasaje);
	}

	public List findByTarifaPagada(Object tarifaPagada) {
		return findByProperty(TARIFA_PAGADA, tarifaPagada);
	}

	public List findByTarjetaCredito(Object tarjetaCredito) {
		return findByProperty(TARJETA_CREDITO, tarjetaCredito);
	}

	public List findByTarjetaCreditoDigito(Object tarjetaCreditoDigito) {
		return findByProperty(TARJETA_CREDITO_DIGITO, tarjetaCreditoDigito);
	}

	public List findByDocumentacionTipo(Object documentacionTipo) {
		return findByProperty(DOCUMENTACION_TIPO, documentacionTipo);
	}

	public List findByDocumentacionNumero(Object documentacionNumero) {
		return findByProperty(DOCUMENTACION_NUMERO, documentacionNumero);
	}

	public List findByNumeroMaletas(Object numeroMaletas) {
		return findByProperty(NUMERO_MALETAS, numeroMaletas);
	}

	public List findAll() {
		log.debug("finding all Reservas instances");
		try {
			String queryString = "from Reservas";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Reservas merge(Reservas detachedInstance) {
		log.debug("merging Reservas instance");
		try {
			Reservas result = (Reservas) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Reservas instance) {
		log.debug("attaching dirty Reservas instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Reservas instance) {
		log.debug("attaching clean Reservas instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ReservasDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ReservasDAO) ctx.getBean("ReservasDAO");
	}
}