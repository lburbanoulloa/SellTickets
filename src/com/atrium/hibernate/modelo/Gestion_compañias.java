package com.atrium.hibernate.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.CompañiasAereas;
import com.atrium.hibernate.Pais;
import com.atrium.hibernate.DAO.ext.CompañiasAereasDAOext;

public class Gestion_compañias implements IGestion_compañias, Comparator<CompañiasAereas> {

	private CompañiasAereasDAOext compañiasAereasDAO;

	

	public void setCompañiasAereasDAO(CompañiasAereasDAOext compañiasAereasDAO) {
		this.compañiasAereasDAO = compañiasAereasDAO;
	}

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_compañias#consultarTodas()
	 */
	@Override
	public List<CompañiasAereas> consultarTodas() {
		List<CompañiasAereas> lista= compañiasAereasDAO.findAll();
		Collections.sort(lista, this);
		return lista;
	}

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_compañias#consultarPorPais(com.atrium.hibernate.Pais)
	 */
	@Override
	public List<CompañiasAereas> consultarPorPais(Pais paisCompañia) {
		List<CompañiasAereas> lista= compañiasAereasDAO.findByPaisCompañia(paisCompañia);
		Collections.sort(lista, this);
		return lista;
	}

	@Override
	public int compare(CompañiasAereas o1, CompañiasAereas o2) {
		// TODO Auto-generated method stub
		return o1.getNombreCompañia().compareTo(o2.getNombreCompañia());
	}
	
	@Override
	public List<CompañiasAereas> consultar_porOrigen(AeropuertosId origen,AeropuertosId destino){
		List<CompañiasAereas> lista= compañiasAereasDAO.consultar_porOrigen(origen,destino);
		Collections.sort(lista, this);
		return lista;
	}

}
