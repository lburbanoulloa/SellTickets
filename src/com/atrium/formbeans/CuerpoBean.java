package com.atrium.formbeans;

import java.io.Serializable;

public class CuerpoBean implements Serializable {

	private String pagina;

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	/**
	 * Cargo la pagina dentro de la plantilla, que inicalmente es el formulario
	 * de busqueda. Posteriormente sera recargado por la seleccion de vuelos
	 */
	public CuerpoBean() {
		pagina = "/xhtml/cuerpoBusqueda.xhtml";
		// pagina="/xhtml/imagenes.xhtml";

	}

}
