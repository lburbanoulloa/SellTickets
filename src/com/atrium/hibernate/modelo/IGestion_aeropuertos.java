package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Aeropuertos;
import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Municipios;

public interface IGestion_aeropuertos {

	public abstract List<Aeropuertos> consultarPorCiudad(Municipios ciudadAeropuerto);

	public abstract List<Aeropuertos> consultarTodos();

	public abstract List<Aeropuertos> consultarPorOrigen(AeropuertosId origen);

	public abstract List<Aeropuertos> consultarPorDestino(AeropuertosId destino);


}