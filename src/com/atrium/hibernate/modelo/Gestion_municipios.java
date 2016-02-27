package com.atrium.hibernate.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.DAO.MunicipiosDAO;

public class Gestion_municipios implements IGestion_municipios, Comparator<Municipios> {

	private MunicipiosDAO municipiosDAO;

	public void setMunicipiosDAO(MunicipiosDAO municipiosDAO) {
		this.municipiosDAO = municipiosDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_municipios#consultarTodos()
	 */
	@Override
	public List<Municipios> consultarTodos () {
		List<Municipios> lista=municipiosDAO.findAll();
		Collections.sort(lista,  this);
		return lista;
		
	}

	@Override
	public int compare(Municipios o1, Municipios o2) {
		// TODO Auto-generated method stub
		return o1.getMunicipio().compareTo(o2.getMunicipio());
	}
	
}
