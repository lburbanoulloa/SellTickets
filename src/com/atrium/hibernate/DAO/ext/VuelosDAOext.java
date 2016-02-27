package com.atrium.hibernate.DAO.ext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Vuelos;
import com.atrium.hibernate.DAO.VuelosDAO;

public class VuelosDAOext extends VuelosDAO {
	public List<Vuelos> consultar_Criterio(AeropuertosId origen,
			AeropuertosId destino) {

		DetachedCriteria consulta = DetachedCriteria.forClass(Vuelos.class);
		if (origen != null) {
			consulta.setFetchMode("aeropuertosByOrigenPaisFk", FetchMode.JOIN);
			consulta.setFetchMode("aeropuertosByOrigenPaisFk.aeropuertos",
					FetchMode.JOIN);
			consulta.add(Restrictions.eq(
					"aeropuertosByOrigenPaisFk.id.codigoAeropuerto", origen
							.getCodigoAeropuerto().toString()));

		}

		if (destino != null) {
			consulta.setFetchMode("aeropuertosByDestinoPaisFk", FetchMode.JOIN);
			consulta.setFetchMode("aeropuertosByDestinoPaisFk.aeropuertos",
					FetchMode.JOIN);
			consulta.add(Restrictions.eq(
					"aeropuertosByDestinoPaisFk.id.codigoAeropuerto", destino
							.getCodigoAeropuerto().toString()));

		}

		consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Vuelos> lista_vuelos = getHibernateTemplate().findByCriteria(
				consulta);

		return lista_vuelos;
	}

	public List<Vuelos> consultar_TodosCriterios(AeropuertosId origen,
			AeropuertosId destino, Integer numPasajeros, Date fecha, Date hora,
			boolean fecha_aprox) {

		DetachedCriteria consulta = DetachedCriteria.forClass(Vuelos.class);
		if (origen != null) {
			consulta.setFetchMode("aeropuertosByOrigenPaisFk", FetchMode.JOIN);
			consulta.setFetchMode("aeropuertosByOrigenPaisFk.aeropuertos",
					FetchMode.JOIN);
			consulta.add(Restrictions.eq(
					"aeropuertosByOrigenPaisFk.id.codigoAeropuerto", origen
							.getCodigoAeropuerto().toString()));

		}

		if (destino != null) {
			consulta.setFetchMode("aeropuertosByDestinoPaisFk", FetchMode.JOIN);
			consulta.setFetchMode("aeropuertosByDestinoPaisFk.aeropuertos",
					FetchMode.JOIN);
			consulta.add(Restrictions.eq(
					"aeropuertosByDestinoPaisFk.id.codigoAeropuerto", destino
							.getCodigoAeropuerto().toString()));

		}

		// fecha salida entre el dia anterior y el dia posterior, para dar mas
		// margen
		
		if (fecha_aprox) {
			Calendar calendar;

			calendar = Calendar.getInstance();
			calendar.setTime(fecha);
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			

			
			java.sql.Date fecha_anterior =new java.sql.Date( calendar.getTime().getTime());
	

			calendar = Calendar.getInstance();
			calendar.setTime(fecha);
			calendar.add(Calendar.DAY_OF_YEAR, 2);
			
			
			java.sql.Date fecha_posterior =new java.sql.Date( calendar.getTime().getTime());

			consulta.add(Restrictions.between("fechaSalida", fecha_anterior,
					fecha_posterior));
		} else {
			// fecha exacta, tengo que ver entre la fecha pedida y un dia mas, ya que el formato largo del los datos me fastidian con la hora
			

			java.sql.Date fecha_anterior =new java.sql.Date( fecha.getTime());
	

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha);
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			
			
			java.sql.Date fecha_posterior =new java.sql.Date( calendar.getTime().getTime());

			consulta.add(Restrictions.between("fechaSalida", fecha_anterior,
					fecha_posterior));
        
			 			
		}
		
		//falta la hora

		// numero de pasajeros en database tiene que ser superior a numPasajeros
		consulta.add(Restrictions.ge("numeroPasajeros", numPasajeros.shortValue() ));

		consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		consulta.addOrder(Order.asc("horaSalida"));
		
		List<Vuelos> lista_vuelos = getHibernateTemplate().findByCriteria(
				consulta);

		return lista_vuelos;
	}

	public List<Vuelos> consultar_porOrigen(AeropuertosId origen) {
		DetachedCriteria consulta = DetachedCriteria.forClass(Vuelos.class);
		consulta.setFetchMode("aeropuertosByOrigenPaisFk", FetchMode.JOIN);
		consulta.setFetchMode("aeropuertosByOrigenPaisFk.aeropuertos",
				FetchMode.JOIN);
		consulta.add(Restrictions.eq(
				"aeropuertosByOrigenPaisFk.id.codigoAeropuerto", origen
						.getCodigoAeropuerto().toString()));
		consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Vuelos> lista_vuelos = getHibernateTemplate().findByCriteria(
				consulta);

		return lista_vuelos;

	}

}
