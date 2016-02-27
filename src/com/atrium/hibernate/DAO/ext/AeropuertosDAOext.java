package com.atrium.hibernate.DAO.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Aeropuertos;
import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.DAO.AeropuertosDAO;

public class AeropuertosDAOext extends AeropuertosDAO {

	public List<Aeropuertos> consultar_OrigenesPorDestino(AeropuertosId destino) {

		DetachedCriteria consulta = DetachedCriteria
				.forClass(Aeropuertos.class).createCriteria(
						"vuelosesForOrigenPaisFk");

		if (destino != null) {
			consulta.add(Restrictions.eq(
					"aeropuertosByDestinoPaisFk.id.codigoAeropuerto", destino
							.getCodigoAeropuerto().toString()));
		}

		consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Aeropuertos> lista_Aeropuertos = getHibernateTemplate()
				.findByCriteria(consulta);

		return lista_Aeropuertos;

	}

	public List<Aeropuertos> consultar_DestinosPorOrigen(AeropuertosId origen) {
		DetachedCriteria consulta = DetachedCriteria
				.forClass(Aeropuertos.class).createCriteria(
						"vuelosesForDestinoPaisFk");

		if (origen != null) {
			consulta.add(Restrictions.eq(
					"aeropuertosByOrigenPaisFk.id.codigoAeropuerto", origen
							.getCodigoAeropuerto().toString()));
		}

		consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Aeropuertos> lista_Aeropuertos = getHibernateTemplate()
				.findByCriteria(consulta);

		return lista_Aeropuertos;

	}
}
