package com.atrium.hibernate;

import java.util.Date;

/**
 * Usuarioavion entity. @author MyEclipse Persistence Tools
 */

public class Usuarioavion implements java.io.Serializable {

	// Fields

	private UsuarioavionId id;
	private Roles roles;
	private String nombreUsuario;
	private String apellidosUsuario;
	private String domicilioUsuario;
	private String ciudadUsuario;
	private String provinciaUsuario;
	private String paisUsuario;
	private String emailUsuario;
	private Date fechaAlta;
	private Date fechaBaja;
	private String carpetaDocumentacion;
	private String idioma;

	// Constructors

	/** default constructor */
	public Usuarioavion() {
	}

	/** minimal constructor */
	public Usuarioavion(UsuarioavionId id) {
		this.id = id;
	}

	/** full constructor */
	public Usuarioavion(UsuarioavionId id, Roles roles, String nombreUsuario,
			String apellidosUsuario, String domicilioUsuario,
			String ciudadUsuario, String provinciaUsuario, String paisUsuario,
			String emailUsuario, Date fechaAlta, Date fechaBaja,
			String carpetaDocumentacion, String idioma) {
		this.id = id;
		this.roles = roles;
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.domicilioUsuario = domicilioUsuario;
		this.ciudadUsuario = ciudadUsuario;
		this.provinciaUsuario = provinciaUsuario;
		this.paisUsuario = paisUsuario;
		this.emailUsuario = emailUsuario;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.carpetaDocumentacion = carpetaDocumentacion;
		this.idioma = idioma;
	}

	// Property accessors

	public UsuarioavionId getId() {
		return this.id;
	}

	public void setId(UsuarioavionId id) {
		this.id = id;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidosUsuario() {
		return this.apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getDomicilioUsuario() {
		return this.domicilioUsuario;
	}

	public void setDomicilioUsuario(String domicilioUsuario) {
		this.domicilioUsuario = domicilioUsuario;
	}

	public String getCiudadUsuario() {
		return this.ciudadUsuario;
	}

	public void setCiudadUsuario(String ciudadUsuario) {
		this.ciudadUsuario = ciudadUsuario;
	}

	public String getProvinciaUsuario() {
		return this.provinciaUsuario;
	}

	public void setProvinciaUsuario(String provinciaUsuario) {
		this.provinciaUsuario = provinciaUsuario;
	}

	public String getPaisUsuario() {
		return this.paisUsuario;
	}

	public void setPaisUsuario(String paisUsuario) {
		this.paisUsuario = paisUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getCarpetaDocumentacion() {
		return this.carpetaDocumentacion;
	}

	public void setCarpetaDocumentacion(String carpetaDocumentacion) {
		this.carpetaDocumentacion = carpetaDocumentacion;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}