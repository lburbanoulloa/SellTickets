package com.atrium.hibernate.DAO.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Compa�iasAereas;
import com.atrium.hibernate.DAO.Compa�iasAereasDAO;

public class Compa�iasAereasDAOext extends Compa�iasAereasDAO {

	public List<Compa�iasAereas> consultar_porOrigen(AeropuertosId origen,
			AeropuertosId destino) {

		DetachedCriteria consulta = DetachedCriteria
				.forClass(Compa�iasAereas.class);

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
		List<Compa�iasAereas> lista_comps = getHibernateTemplate()
				.findByCriteria(consulta);

		return lista_comps;

	}

}
