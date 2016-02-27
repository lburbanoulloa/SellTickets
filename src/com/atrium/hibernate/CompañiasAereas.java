package com.atrium.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * CompañiasAereas entity. @author MyEclipse Persistence Tools
 */

public class CompañiasAereas implements java.io.Serializable {

	// Fields

	private String codigoCompañia;
	private String nombreCompañia;
	private String paisCompañia;
	private Set vueloses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CompañiasAereas() {
	}

	/** minimal constructor */
	public CompañiasAereas(String codigoCompañia) {
		this.codigoCompañia = codigoCompañia;
	}

	/** full constructor */
	public CompañiasAereas(String codigoCompañia, String nombreCompañia,
			String paisCompañia, Set vueloses) {
		this.codigoCompañia = codigoCompañia;
		this.nombreCompañia = nombreCompañia;
		this.paisCompañia = paisCompañia;
		this.vueloses = vueloses;
	}

	// Property accessors

	public String getCodigoCompañia() {
		return this.codigoCompañia;
	}

	public void setCodigoCompañia(String codigoCompañia) {
		this.codigoCompañia = codigoCompañia;
	}

	public String getNombreCompañia() {
		return this.nombreCompañia;
	}

	public void setNombreCompañia(String nombreCompañia) {
		this.nombreCompañia = nombreCompañia;
	}

	public String getPaisCompañia() {
		return this.paisCompañia;
	}

	public void setPaisCompañia(String paisCompañia) {
		this.paisCompañia = paisCompañia;
	}

	public Set getVueloses() {
		return this.vueloses;
	}

	public void setVueloses(Set vueloses) {
		this.vueloses = vueloses;
	}

}