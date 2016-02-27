package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Pais;

public interface IGestion_paises {

	public abstract List<Pais> consultarTodos();

}