package com.atrium.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Compa�iasAereas entity. @author MyEclipse Persistence Tools
 */

public class Compa�iasAereas implements java.io.Serializable {

	// Fields

	private String codigoCompa�ia;
	private String nombreCompa�ia;
	private String paisCompa�ia;
	private Set vueloses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Compa�iasAereas() {
	}

	/** minimal constructor */
	public Compa�iasAereas(String codigoCompa�ia) {
		this.codigoCompa�ia = codigoCompa�ia;
	}

	/** full constructor */
	public Compa�iasAereas(String codigoCompa�ia, String nombreCompa�ia,
			String paisCompa�ia, Set vueloses) {
		this.codigoCompa�ia = codigoCompa�ia;
		this.nombreCompa�ia = nombreCompa�ia;
		this.paisCompa�ia = paisCompa�ia;
		this.vueloses = vueloses;
	}

	// Property accessors

	public String getCodigoCompa�ia() {
		return this.codigoCompa�ia;
	}

	public void setCodigoCompa�ia(String codigoCompa�ia) {
		this.codigoCompa�ia = codigoCompa�ia;
	}

	public String getNombreCompa�ia() {
		return this.nombreCompa�ia;
	}

	public void setNombreCompa�ia(String nombreCompa�ia) {
		this.nombreCompa�ia = nombreCompa�ia;
	}

	public String getPaisCompa�ia() {
		return this.paisCompa�ia;
	}

	public void setPaisCompa�ia(String paisCompa�ia) {
		this.paisCompa�ia = paisCompa�ia;
	}

	public Set getVueloses() {
		return this.vueloses;
	}

	public void setVueloses(Set vueloses) {
		this.vueloses = vueloses;
	}

}