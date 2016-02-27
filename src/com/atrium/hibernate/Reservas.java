package com.atrium.hibernate;

import java.util.Date;

/**
 * Reservas entity. @author MyEclipse Persistence Tools
 */

public class Reservas implements java.io.Serializable {

	// Fields

	private String localizadorReserva;
	private String codigoVuelo;
	private String nombreClave;
	private String password;
	private String tipoPasaje;
	private Double tarifaPagada;
	private String tarjetaCredito;
	private String tarjetaCreditoDigito;
	private Date fechaReserva;
	private Date horaReserva;
	private String documentacionTipo;
	private String documentacionNumero;
	private Byte numeroMaletas;
	private Date horaLimiteCheking;

	// Constructors

	/** default constructor */
	public Reservas() {
	}

	/** minimal constructor */
	public Reservas(String localizadorReserva) {
		this.localizadorReserva = localizadorReserva;
	}

	/** full constructor */
	public Reservas(String localizadorReserva, String codigoVuelo,
			String nombreClave, String password, String tipoPasaje,
			Double tarifaPagada, String tarjetaCredito,
			String tarjetaCreditoDigito, Date fechaReserva, Date horaReserva,
			String documentacionTipo, String documentacionNumero,
			Byte numeroMaletas, Date horaLimiteCheking) {
		this.localizadorReserva = localizadorReserva;
		this.codigoVuelo = codigoVuelo;
		this.nombreClave = nombreClave;
		this.password = password;
		this.tipoPasaje = tipoPasaje;
		this.tarifaPagada = tarifaPagada;
		this.tarjetaCredito = tarjetaCredito;
		this.tarjetaCreditoDigito = tarjetaCreditoDigito;
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.documentacionTipo = documentacionTipo;
		this.documentacionNumero = documentacionNumero;
		this.numeroMaletas = numeroMaletas;
		this.horaLimiteCheking = horaLimiteCheking;
	}

	// Property accessors

	public String getLocalizadorReserva() {
		return this.localizadorReserva;
	}

	public void setLocalizadorReserva(String localizadorReserva) {
		this.localizadorReserva = localizadorReserva;
	}

	public String getCodigoVuelo() {
		return this.codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public String getNombreClave() {
		return this.nombreClave;
	}

	public void setNombreClave(String nombreClave) {
		this.nombreClave = nombreClave;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoPasaje() {
		return this.tipoPasaje;
	}

	public void setTipoPasaje(String tipoPasaje) {
		this.tipoPasaje = tipoPasaje;
	}

	public Double getTarifaPagada() {
		return this.tarifaPagada;
	}

	public void setTarifaPagada(Double tarifaPagada) {
		this.tarifaPagada = tarifaPagada;
	}

	public String getTarjetaCredito() {
		return this.tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	public String getTarjetaCreditoDigito() {
		return this.tarjetaCreditoDigito;
	}

	public void setTarjetaCreditoDigito(String tarjetaCreditoDigito) {
		this.tarjetaCreditoDigito = tarjetaCreditoDigito;
	}

	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getHoraReserva() {
		return this.horaReserva;
	}

	public void setHoraReserva(Date horaReserva) {
		this.horaReserva = horaReserva;
	}

	public String getDocumentacionTipo() {
		return this.documentacionTipo;
	}

	public void setDocumentacionTipo(String documentacionTipo) {
		this.documentacionTipo = documentacionTipo;
	}

	public String getDocumentacionNumero() {
		return this.documentacionNumero;
	}

	public void setDocumentacionNumero(String documentacionNumero) {
		this.documentacionNumero = documentacionNumero;
	}

	public Byte getNumeroMaletas() {
		return this.numeroMaletas;
	}

	public void setNumeroMaletas(Byte numeroMaletas) {
		this.numeroMaletas = numeroMaletas;
	}

	public Date getHoraLimiteCheking() {
		return this.horaLimiteCheking;
	}

	public void setHoraLimiteCheking(Date horaLimiteCheking) {
		this.horaLimiteCheking = horaLimiteCheking;
	}

}