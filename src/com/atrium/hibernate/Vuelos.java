package com.atrium.hibernate;

import java.util.Date;

/**
 * Vuelos entity. @author MyEclipse Persistence Tools
 */

public class Vuelos implements java.io.Serializable {

	// Fields

	private String codigoVuelo;
	private Aeropuertos aeropuertosByDestinoPaisFk;
	private CompañiasAereas compañiasAereas;
	private Aeropuertos aeropuertosByOrigenPaisFk;
	private String strVuelo;
	private Date fechaSalida;
	private Date fechaLlegada;
	private Date horaSalida;
	private Date horaLlegada;
	private Short numeroPasajeros;
	private Short asientosVendidos;
	private Double tarifaIda;
	private Double tarifaVuelta;
	private Double tarifaIdavuelta;

	// Constructors

	/** default constructor */
	public Vuelos() {
	}

	/** minimal constructor */
	public Vuelos(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	/** full constructor */
	public Vuelos(String codigoVuelo, Aeropuertos aeropuertosByDestinoPaisFk,
			CompañiasAereas compañiasAereas,
			Aeropuertos aeropuertosByOrigenPaisFk, String strVuelo,
			Date fechaSalida, Date fechaLlegada, Date horaSalida,
			Date horaLlegada, Short numeroPasajeros, Short asientosVendidos,
			Double tarifaIda, Double tarifaVuelta, Double tarifaIdavuelta) {
		this.codigoVuelo = codigoVuelo;
		this.aeropuertosByDestinoPaisFk = aeropuertosByDestinoPaisFk;
		this.compañiasAereas = compañiasAereas;
		this.aeropuertosByOrigenPaisFk = aeropuertosByOrigenPaisFk;
		this.strVuelo = strVuelo;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.numeroPasajeros = numeroPasajeros;
		this.asientosVendidos = asientosVendidos;
		this.tarifaIda = tarifaIda;
		this.tarifaVuelta = tarifaVuelta;
		this.tarifaIdavuelta = tarifaIdavuelta;
	}

	// Property accessors

	public String getCodigoVuelo() {
		return this.codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public Aeropuertos getAeropuertosByDestinoPaisFk() {
		return this.aeropuertosByDestinoPaisFk;
	}

	public void setAeropuertosByDestinoPaisFk(
			Aeropuertos aeropuertosByDestinoPaisFk) {
		this.aeropuertosByDestinoPaisFk = aeropuertosByDestinoPaisFk;
	}

	public CompañiasAereas getCompañiasAereas() {
		return this.compañiasAereas;
	}

	public void setCompañiasAereas(CompañiasAereas compañiasAereas) {
		this.compañiasAereas = compañiasAereas;
	}

	public Aeropuertos getAeropuertosByOrigenPaisFk() {
		return this.aeropuertosByOrigenPaisFk;
	}

	public void setAeropuertosByOrigenPaisFk(
			Aeropuertos aeropuertosByOrigenPaisFk) {
		this.aeropuertosByOrigenPaisFk = aeropuertosByOrigenPaisFk;
	}

	public String getStrVuelo() {
		return this.strVuelo;
	}

	public void setStrVuelo(String strVuelo) {
		this.strVuelo = strVuelo;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaLlegada() {
		return this.fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Date getHoraLlegada() {
		return this.horaLlegada;
	}

	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Short getNumeroPasajeros() {
		return this.numeroPasajeros;
	}

	public void setNumeroPasajeros(Short numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}

	public Short getAsientosVendidos() {
		return this.asientosVendidos;
	}

	public void setAsientosVendidos(Short asientosVendidos) {
		this.asientosVendidos = asientosVendidos;
	}

	public Double getTarifaIda() {
		return this.tarifaIda;
	}

	public void setTarifaIda(Double tarifaIda) {
		this.tarifaIda = tarifaIda;
	}

	public Double getTarifaVuelta() {
		return this.tarifaVuelta;
	}

	public void setTarifaVuelta(Double tarifaVuelta) {
		this.tarifaVuelta = tarifaVuelta;
	}

	public Double getTarifaIdavuelta() {
		return this.tarifaIdavuelta;
	}

	public void setTarifaIdavuelta(Double tarifaIdavuelta) {
		this.tarifaIdavuelta = tarifaIdavuelta;
	}

}