package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Compa�iasAereas;
import com.atrium.hibernate.Pais;

public interface IGestion_compa�ias {

	public abstract List<Compa�iasAereas> consultarTodas();

	public abstract List<Compa�iasAereas> consultarPorPais(Pais paisCompa�ia);

	public abstract List<Compa�iasAereas> consultar_porOrigen(AeropuertosId origen,AeropuertosId destino);

}