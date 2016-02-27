package com.atrium.hibernate.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.hibernate.Aeropuertos;
import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.DAO.ext.AeropuertosDAOext;

public class Gestion_aeropuertos implements IGestion_aeropuertos,
		Comparator<Aeropuertos> {

	private AeropuertosDAOext aeropuertosDAO;

	public void setAeropuertosDAO(AeropuertosDAOext aeropuertosDAO) {
		this.aeropuertosDAO = aeropuertosDAO;
	}

	@Override
	public List<Aeropuertos> consultarTodos() {
		List<Aeropuertos> lista = aeropuertosDAO.findAll();
		Collections.sort(lista, this);
		return lista;
	}

	@Override
	public List<Aeropuertos> consultarPorCiudad(Municipios ciudadAeropuerto) {
		List<Aeropuertos> lista = aeropuertosDAO
				.findByCiudadAeropuerto(ciudadAeropuerto);
		Collections.sort(lista, this);
		return lista;
	}

	@Override
	public int compare(Aeropuertos o1, Aeropuertos o2) {
		// TODO Auto-generated method stub
		return o1.getCiudadAeropuerto().compareTo(o2.getCiudadAeropuerto());
	}
	
	@Override
	public List<Aeropuertos> consultarPorOrigen(AeropuertosId origen) {
		List<Aeropuertos> lista = aeropuertosDAO
				.consultar_DestinosPorOrigen(origen);
		Collections.sort(lista, this);
		return lista;
	}
	
	@Override
	public List<Aeropuertos> consultarPorDestino(AeropuertosId destino) {
		List<Aeropuertos> lista = aeropuertosDAO
				.consultar_OrigenesPorDestino(destino);
		Collections.sort(lista, this);
		return lista;
	}	

}
