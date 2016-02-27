package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.CompañiasAereas;
import com.atrium.hibernate.Pais;

public interface IGestion_compañias {

	public abstract List<CompañiasAereas> consultarTodas();

	public abstract List<CompañiasAereas> consultarPorPais(Pais paisCompañia);

	public abstract List<CompañiasAereas> consultar_porOrigen(AeropuertosId origen,AeropuertosId destino);

}