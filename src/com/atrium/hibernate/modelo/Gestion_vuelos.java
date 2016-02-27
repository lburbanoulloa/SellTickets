package com.atrium.hibernate.modelo;

import java.util.Date;
import java.util.List;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Vuelos;
import com.atrium.hibernate.DAO.ext.VuelosDAOext;

public class Gestion_vuelos implements IGestion_vuelos {

	private VuelosDAOext vuelosDAO;

	public void setVuelosDAO(VuelosDAOext vuelosDAO) {
		this.vuelosDAO = vuelosDAO;
	}

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_vuelos#consultarTodos()
	 */
	@Override
	public List<Vuelos> consultarTodos() {
		return vuelosDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_vuelos#consultarPorCompania(com.atrium.hibernate.CompañiasAereas)
	 */
	@Override
	public List<Vuelos> consultarPorCompania(String codigoCompañia) {
		return vuelosDAO.findByProperty("compañiasAereas.codigoCompañia", codigoCompañia);
	}
	
	
	@Override
	public List<Vuelos> consultarPorOrigenDestino(AeropuertosId origen, AeropuertosId destino)  {
		return vuelosDAO.consultar_Criterio(origen, destino);
	}
	

	
	@Override
	public List<Vuelos> consultarPorOrigen(AeropuertosId origen)  {
		return vuelosDAO.consultar_porOrigen(origen);
	}

	@Override
	public List<Vuelos> consultar_TodosCriterios(AeropuertosId origen,
			AeropuertosId destino, Integer numPasajeros, Date fecha, Date hora,
			boolean fecha_aprox) {
		
		return vuelosDAO.consultar_TodosCriterios(origen,destino,numPasajeros,fecha,hora,fecha_aprox);
		
	}
		
	
	

}
