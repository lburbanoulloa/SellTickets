package com.atrium.formbeans;

import java.io.Serializable;

import javax.faces.event.ValueChangeEvent;

/**
 * Componente para almacenar el tema seleccionado dinamicamente por el usuario
 * para visualizar la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 21-1-2016.
 * 
 */
public class Temas_Bean implements Serializable {

	private String tema_seleccionado;

	public Temas_Bean() {
		System.out.println("soy temas bean");
	}

	// ACCESORES PARA JSF
	public String getTema_seleccionado() {
		return tema_seleccionado;
	}

	public void setTema_seleccionado(String tema_seleccionado) {
		this.tema_seleccionado = tema_seleccionado;
	}

}
