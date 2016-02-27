package com.atrium.hibernate.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.DAO.ProvinciasDAO;

public class Gestion_provincias implements IGestion_provincias, Comparator<Provincias> {
	
	private ProvinciasDAO provinciasDAO;

	public void setProvinciasDAO(ProvinciasDAO provinciasDAO) {
		this.provinciasDAO = provinciasDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_provincias#consultarTodas()
	 */
	@Override
	public List<Provincias> consultarTodas () {
		List<Provincias> lista= provinciasDAO.findAll();
		Collections.sort(lista,this);
		return lista;
	}

	@Override
	public int compare(Provincias o1, Provincias o2) {
		// TODO Auto-generated method stub
		return o1.getProvincia().compareTo(o2.getProvincia());
	}

}
