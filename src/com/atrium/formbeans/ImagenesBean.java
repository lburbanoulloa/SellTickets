package com.atrium.formbeans;

import java.io.File;
import java.io.Serializable;
import java.util.Random;

import com.atrium.spring.Acceso_ApplicationContext;

public class ImagenesBean implements Serializable {
	private String imagencambiante;
	private String miniimagencambiante;
	private String tabla_imagenes[];



	public String getImagencambiante() {
		return imagencambiante;
	}

	public void setImagencambiante(String imagencambiante) {
		this.imagencambiante = imagencambiante;
	}

	
	
	public String getMiniimagencambiante() {
		return miniimagencambiante;
	}

	public void setMiniimagencambiante(String miniimagencambiante) {
		this.miniimagencambiante = miniimagencambiante;
	}

	public ImagenesBean() {
		cargaListaImagenes();
	}
	
	/**
	 * Carrusel de imagenes como fondo general de la aplicacion
	 */

	public void cargaListaImagenes() {
		
		String carpeta_principal_usuario = Acceso_ApplicationContext
				.getServletContext().getRealPath("/resources");
		File carpeta = new File(carpeta_principal_usuario+"/imagenes/turismo/");
		tabla_imagenes = carpeta.list();
		
		Random posicion_aleatoria = new Random();
		Integer imagen = 0;
		// REPETIMOS HASTA QUE EL CONTENIDO DE LA TABLA NO SEA NULO Y TENGAMOS
		// UNA IMAGEN A MOSTRAR
		do {
			imagen = posicion_aleatoria.nextInt(tabla_imagenes.length);
		} while (tabla_imagenes[imagen] == null);

		miniimagencambiante=tabla_imagenes[imagen];
		imagencambiante = "/resources/imagenes/turismo/"
				+ miniimagencambiante;		
	}

	



}
