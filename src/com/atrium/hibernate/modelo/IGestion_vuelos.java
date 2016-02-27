package com.atrium.hibernate.modelo;

import java.util.Date;
import java.util.List;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Vuelos;

public interface IGestion_vuelos {

	public abstract List<Vuelos> consultarTodos();

	public abstract List<Vuelos> consultarPorCompania(
			String codigoCompañia);

	//public abstract List<Vuelos> consultar(String origen, String destino);

	public abstract List<Vuelos> consultarPorOrigen(AeropuertosId origen);

	public abstract List<Vuelos> consultarPorOrigenDestino(AeropuertosId origen, AeropuertosId destino);

	public abstract List<Vuelos> consultar_TodosCriterios(AeropuertosId origen, AeropuertosId destino,
			Integer numPasajeros, Date fecha, Date hora, boolean fecha_aprox);

}