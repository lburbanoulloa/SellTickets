package com.atrium.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Aeropuertos entity. @author MyEclipse Persistence Tools
 */

public class Aeropuertos implements java.io.Serializable {

	// Fields

	private AeropuertosId id;
	private String ciudadAeropuerto;
	private String nombreAeropuerto;
	private Set vuelosesForOrigenPaisFk = new HashSet(0);
	private Set vuelosesForDestinoPaisFk = new HashSet(0);

	// Constructors

	/** default constructor */
	public Aeropuertos() {
	}

	/** minimal constructor */
	public Aeropuertos(AeropuertosId id) {
		this.id = id;
	}

	/** full constructor */
	public Aeropuertos(AeropuertosId id, String ciudadAeropuerto,
			String nombreAeropuerto, Set vuelosesForOrigenPaisFk,
			Set vuelosesForDestinoPaisFk) {
		this.id = id;
		this.ciudadAeropuerto = ciudadAeropuerto;
		this.nombreAeropuerto = nombreAeropuerto;
		this.vuelosesForOrigenPaisFk = vuelosesForOrigenPaisFk;
		this.vuelosesForDestinoPaisFk = vuelosesForDestinoPaisFk;
	}

	// Property accessors

	public AeropuertosId getId() {
		return this.id;
	}

	public void setId(AeropuertosId id) {
		this.id = id;
	}

	public String getCiudadAeropuerto() {
		return this.ciudadAeropuerto;
	}

	public void setCiudadAeropuerto(String ciudadAeropuerto) {
		this.ciudadAeropuerto = ciudadAeropuerto;
	}

	public String getNombreAeropuerto() {
		return this.nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

	public Set getVuelosesForOrigenPaisFk() {
		return this.vuelosesForOrigenPaisFk;
	}

	public void setVuelosesForOrigenPaisFk(Set vuelosesForOrigenPaisFk) {
		this.vuelosesForOrigenPaisFk = vuelosesForOrigenPaisFk;
	}

	public Set getVuelosesForDestinoPaisFk() {
		return this.vuelosesForDestinoPaisFk;
	}

	public void setVuelosesForDestinoPaisFk(Set vuelosesForDestinoPaisFk) {
		this.vuelosesForDestinoPaisFk = vuelosesForDestinoPaisFk;
	}

}