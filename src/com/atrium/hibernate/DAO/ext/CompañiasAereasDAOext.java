package com.atrium.hibernate.DAO.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.CompañiasAereas;
import com.atrium.hibernate.DAO.CompañiasAereasDAO;

public class CompañiasAereasDAOext extends CompañiasAereasDAO {

	public List<CompañiasAereas> consultar_porOrigen(AeropuertosId origen,
			AeropuertosId destino) {

		DetachedCriteria consulta = DetachedCriteria
				.forClass(CompañiasAereas.class);

		consulta.createAlias("vueloses", "v")
				.createAlias("v.aeropuertosByOrigenPaisFk", "ao")
				.add(Restrictions.eq("ao.id.codigoAeropuerto", origen
						.getCodigoAeropuerto().toString()));

		if (destino != null) {
			consulta = consulta.createAlias("v.aeropuertosByDestinoPaisFk",
					"ad").add(
					Restrictions.eq("ad.id.codigoAeropuerto", destino
							.getCodigoAeropuerto().toString()));
		}

		consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<CompañiasAereas> lista_comps = getHibernateTemplate()
				.findByCriteria(consulta);

		return lista_comps;

	}

}
