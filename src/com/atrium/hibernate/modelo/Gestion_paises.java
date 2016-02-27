package com.atrium.hibernate.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.DAO.PaisDAO;

public class Gestion_paises implements IGestion_paises, Comparator<Pais> {
	private PaisDAO paisDAO;



	public void setPaisDAO(PaisDAO paisDAO) {
		this.paisDAO = paisDAO;
	}

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_paises#consultarTodos()
	 */
	@Override
	public List<Pais> consultarTodos() {
		List<Pais> lista=paisDAO.findAll();
		Collections.sort(lista, this);
		return lista;
	}

	@Override
	public int compare(Pais o1, Pais o2) {
		// TODO Auto-generated method stub
		return o1.getPaisNombre().compareTo(o2.getPaisNombre());
	}
}
