package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Reservas;
import com.atrium.hibernate.DAO.ReservasDAO;

public class Gestion_reservas implements IGestion_reservas {

	private ReservasDAO reservasDAO;

	public void setReservasDAO(ReservasDAO reservasDAO) {
		this.reservasDAO = reservasDAO;
	}

	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_reservas#alta(com.atrium.hibernate.Reservas)
	 */
	@Override
	public void alta(Reservas reserva) {
		reservasDAO.save(reserva);

	}

}
