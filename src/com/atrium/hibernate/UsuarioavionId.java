package com.atrium.hibernate;

/**
 * UsuarioavionId entity. @author MyEclipse Persistence Tools
 */

public class UsuarioavionId implements java.io.Serializable {

	// Fields

	private String nombreClave;
	private String password;

	// Constructors

	/** default constructor */
	public UsuarioavionId() {
	}

	/** full constructor */
	public UsuarioavionId(String nombreClave, String password) {
		this.nombreClave = nombreClave;
		this.password = password;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsuarioavionId))
			return false;
		UsuarioavionId castOther = (UsuarioavionId) other;

		return ((this.getNombreClave() == castOther.getNombreClave()) || (this
				.getNombreClave() != null && castOther.getNombreClave() != null && this
				.getNombreClave().equals(castOther.getNombreClave())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNombreClave() == null ? 0 : this.getNombreClave()
						.hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		return result;
	}

}