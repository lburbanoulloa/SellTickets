package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.CompaņiasAereas;
import com.atrium.hibernate.Pais;

public interface IGestion_compaņias {

	public abstract List<CompaņiasAereas> consultarTodas();

	public abstract List<CompaņiasAereas> consultarPorPais(Pais paisCompaņia);

	public abstract List<CompaņiasAereas> consultar_porOrigen(AeropuertosId origen,AeropuertosId destino);

}