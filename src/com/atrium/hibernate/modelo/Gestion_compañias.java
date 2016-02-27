package com.atrium.hibernate.modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Compa�iasAereas;
import com.atrium.hibernate.Pais;
import com.atrium.hibernate.DAO.ext.Compa�iasAereasDAOext;

public class Gestion_compa�ias implements IGestion_compa�ias, Comparator<Compa�iasAereas> {

	private Compa�iasAereasDAOext compa�iasAereasDAO;

	

	public void setCompa�iasAereasDAO(Compa�iasAereasDAOext compa�iasAereasDAO) {
		this.compa�iasAereasDAO = compa�iasAereasDAO;
	}

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_compa�ias#consultarTodas()
	 */
	@Override
	public List<Compa�iasAereas> consultarTodas() {
		List<Compa�iasAereas> lista= compa�iasAereasDAO.findAll();
		Collections.sort(lista, this);
		return lista;
	}

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_compa�ias#consultarPorPais(com.atrium.hibernate.Pais)
	 */
	@Override
	public List<Compa�iasAereas> consultarPorPais(Pais paisCompa�ia) {
		List<Compa�iasAereas> lista= compa�iasAereasDAO.findByPaisCompa�ia(paisCompa�ia);
		Collections.sort(lista, this);
		return lista;
	}

	@Override
	public int compare(Compa�iasAereas o1, Compa�iasAereas o2) {
		// TODO Auto-generated method stub
		return o1.getNombreCompa�ia().compareTo(o2.getNombreCompa�ia());
	}
	
	@Override
	public List<Compa�iasAereas> consultar_porOrigen(AeropuertosId origen,AeropuertosId destino){
		List<Compa�iasAereas> lista= compa�iasAereasDAO.consultar_porOrigen(origen,destino);
		Collections.sort(lista, this);
		return lista;
	}

}
