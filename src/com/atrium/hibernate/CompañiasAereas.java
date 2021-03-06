package com.atrium.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * CompaņiasAereas entity. @author MyEclipse Persistence Tools
 */

public class CompaņiasAereas implements java.io.Serializable {

	// Fields

	private String codigoCompaņia;
	private String nombreCompaņia;
	private String paisCompaņia;
	private Set vueloses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CompaņiasAereas() {
	}

	/** minimal constructor */
	public CompaņiasAereas(String codigoCompaņia) {
		this.codigoCompaņia = codigoCompaņia;
	}

	/** full constructor */
	public CompaņiasAereas(String codigoCompaņia, String nombreCompaņia,
			String paisCompaņia, Set vueloses) {
		this.codigoCompaņia = codigoCompaņia;
		this.nombreCompaņia = nombreCompaņia;
		this.paisCompaņia = paisCompaņia;
		this.vueloses = vueloses;
	}

	// Property accessors

	public String getCodigoCompaņia() {
		return this.codigoCompaņia;
	}

	public void setCodigoCompaņia(String codigoCompaņia) {
		this.codigoCompaņia = codigoCompaņia;
	}

	public String getNombreCompaņia() {
		return this.nombreCompaņia;
	}

	public void setNombreCompaņia(String nombreCompaņia) {
		this.nombreCompaņia = nombreCompaņia;
	}

	public String getPaisCompaņia() {
		return this.paisCompaņia;
	}

	public void setPaisCompaņia(String paisCompaņia) {
		this.paisCompaņia = paisCompaņia;
	}

	public Set getVueloses() {
		return this.vueloses;
	}

	public void setVueloses(Set vueloses) {
		this.vueloses = vueloses;
	}

}