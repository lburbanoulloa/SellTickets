package com.atrium.hibernate;

/**
 * AeropuertosId entity. @author MyEclipse Persistence Tools
 */

public class AeropuertosId implements java.io.Serializable {

	// Fields

	private String codigoAeropuerto;
	private String pais;

	// Constructors

	/** default constructor */
	public AeropuertosId() {
	}

	/** full constructor */
	public AeropuertosId(String codigoAeropuerto, String pais) {
		this.codigoAeropuerto = codigoAeropuerto;
		this.pais = pais;
	}

	// Property accessors

	public String getCodigoAeropuerto() {
		return this.codigoAeropuerto;
	}

	public void setCodigoAeropuerto(String codigoAeropuerto) {
		this.codigoAeropuerto = codigoAeropuerto;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AeropuertosId))
			return false;
		AeropuertosId castOther = (AeropuertosId) other;

		return ((this.getCodigoAeropuerto() == castOther.getCodigoAeropuerto()) || (this
				.getCodigoAeropuerto() != null
				&& castOther.getCodigoAeropuerto() != null && this
				.getCodigoAeropuerto().equals(castOther.getCodigoAeropuerto())))
				&& ((this.getPais() == castOther.getPais()) || (this.getPais() != null
						&& castOther.getPais() != null && this.getPais()
						.equals(castOther.getPais())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoAeropuerto() == null ? 0 : this
						.getCodigoAeropuerto().hashCode());
		result = 37 * result
				+ (getPais() == null ? 0 : this.getPais().hashCode());
		return result;
	}

}