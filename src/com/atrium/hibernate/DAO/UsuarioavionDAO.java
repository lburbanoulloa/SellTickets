package com.atrium.hibernate.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.Usuarioavion;
import com.atrium.hibernate.UsuarioavionId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuarioavion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Usuarioavion
 * @author MyEclipse Persistence Tools
 */
public class UsuarioavionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UsuarioavionDAO.class);
	// property constants
	public static final String NOMBRE_USUARIO = "nombreUsuario";
	public static final String APELLIDOS_USUARIO = "apellidosUsuario";
	public static final String DOMICILIO_USUARIO = "domicilioUsuario";
	public static final String CIUDAD_USUARIO = "ciudadUsuario";
	public static final String PROVINCIA_USUARIO = "provinciaUsuario";
	public static final String PAIS_USUARIO = "paisUsuario";
	public static final String EMAIL_USUARIO = "emailUsuario";
	public static final String CARPETA_DOCUMENTACION = "carpetaDocumentacion";
	public static final String IDIOMA = "idioma";

	protected void initDao() {
		// do nothing
	}

	public void save(Usuarioavion transientInstance) {
		log.debug("saving Usuarioavion instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Usuarioavion persistentInstance) {
		log.debug("deleting Usuarioavion instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuarioavion findById(com.atrium.hibernate.UsuarioavionId id) {
		log.debug("getting Usuarioavion instance with id: " + id);
		try {
			Usuarioavion instance = (Usuarioavion) getHibernateTemplate().get(
					"com.atrium.hibernate.Usuarioavion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Usuarioavion instance) {
		log.debug("finding Usuarioavion instance by example");
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
		log.debug("finding Usuarioavion instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Usuarioavion as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNombreUsuario(Object nombreUsuario) {
		return findByProperty(NOMBRE_USUARIO, nombreUsuario);
	}

	public List findByApellidosUsuario(Object apellidosUsuario) {
		return findByProperty(APELLIDOS_USUARIO, apellidosUsuario);
	}

	public List findByDomicilioUsuario(Object domicilioUsuario) {
		return findByProperty(DOMICILIO_USUARIO, domicilioUsuario);
	}

	public List findByCiudadUsuario(Object ciudadUsuario) {
		return findByProperty(CIUDAD_USUARIO, ciudadUsuario);
	}

	public List findByProvinciaUsuario(Object provinciaUsuario) {
		return findByProperty(PROVINCIA_USUARIO, provinciaUsuario);
	}

	public List findByPaisUsuario(Object paisUsuario) {
		return findByProperty(PAIS_USUARIO, paisUsuario);
	}

	public List findByEmailUsuario(Object emailUsuario) {
		return findByProperty(EMAIL_USUARIO, emailUsuario);
	}

	public List findByCarpetaDocumentacion(Object carpetaDocumentacion) {
		return findByProperty(CARPETA_DOCUMENTACION, carpetaDocumentacion);
	}

	public List findByIdioma(Object idioma) {
		return findByProperty(IDIOMA, idioma);
	}

	public List findAll() {
		log.debug("finding all Usuarioavion instances");
		try {
			String queryString = "from Usuarioavion";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuarioavion merge(Usuarioavion detachedInstance) {
		log.debug("merging Usuarioavion instance");
		try {
			Usuarioavion result = (Usuarioavion) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuarioavion instance) {
		log.debug("attaching dirty Usuarioavion instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuarioavion instance) {
		log.debug("attaching clean Usuarioavion instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsuarioavionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UsuarioavionDAO) ctx.getBean("UsuarioavionDAO");
	}
}