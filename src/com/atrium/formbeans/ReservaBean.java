package com.atrium.formbeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;
import org.icefaces.ace.event.UnselectEvent;

import com.atrium.hibernate.Aeropuertos;
import com.atrium.hibernate.CompañiasAereas;
import com.atrium.hibernate.Vuelos;
import com.atrium.hibernate.modelo.IGestion_aeropuertos;
import com.atrium.hibernate.modelo.IGestion_compañias;
import com.atrium.hibernate.modelo.IGestion_vuelos;
import com.atrium.utils.Ejecucion_Expresiones;

public class ReservaBean implements Serializable {

	private IGestion_aeropuertos gestion_aeropuertos;
	private IGestion_vuelos gestion_vuelos;
	private IGestion_compañias gestion_compañias;

	private List<Aeropuertos> lista_aeropuertos;
	private List<Vuelos> lista_vuelos;
	private List<CompañiasAereas> lista_c_aereas;

	private List<SelectItem> lista_compañias;
	private List<SelectItem> lista_numerosAdultos;
	private List<SelectItem> lista_numerosNiños;
	private List<SelectItem> lista_numerosBebes;

	// para el cuadro de busqueda de vuelos
	private String boton_pulsado;
	private boolean ayudaaeropuertos_visible;
	private boolean ayudavuelos_visible;

	private boolean diaMasMenos;
	private String idaYVuelta;

	private Aeropuertos origen;
	private Aeropuertos destino;

	private Date fechasalida;
	private Date fecharegreso;

	private Date horasalida;
	private Date horaregreso;

	private String adultos;
	private String niños;
	private String bebes;

	private String compañia;
	private String clase;

	// para el cuadro de resumen de compra
	private Vuelos vueloSeleccionIda;
	private Vuelos vueloSeleccionVuelta;
	private boolean btnContinuarCompraVisible;
	

	private String totalCompraValue;

	private String idaCompraCadenaOrigen;
	private String idaCompraCadenaFecha;
	private String idaCompraCadenaTotal;
	private String vueltaCompraCadenaOrigen;
	private String vueltaCompraCadenaFecha;
	private String vueltaCompraCadenaTotal;

	private boolean idaCompraVisible;
	private boolean vueltaCompraVisible;
	private boolean totalCompraVisible;
	private boolean resumenVisible;
	private boolean seleccionVueloError;

	// Accesores getters y setters

	public boolean isSeleccionVueloError() {
		return seleccionVueloError;
	}

	public String getIdaCompraCadenaOrigen() {
		return idaCompraCadenaOrigen;
	}

	public void setIdaCompraCadenaOrigen(String idaCompraCadenaOrigen) {
		this.idaCompraCadenaOrigen = idaCompraCadenaOrigen;
	}

	public String getIdaCompraCadenaFecha() {
		return idaCompraCadenaFecha;
	}

	public void setIdaCompraCadenaFecha(String idaCompraCadenaFecha) {
		this.idaCompraCadenaFecha = idaCompraCadenaFecha;
	}

	public String getIdaCompraCadenaTotal() {
		return idaCompraCadenaTotal;
	}

	public void setIdaCompraCadenaTotal(String idaCompraCadenaTotal) {
		this.idaCompraCadenaTotal = idaCompraCadenaTotal;
	}

	public String getVueltaCompraCadenaOrigen() {
		return vueltaCompraCadenaOrigen;
	}

	public void setVueltaCompraCadenaOrigen(String vueltaCompraCadenaOrigen) {
		this.vueltaCompraCadenaOrigen = vueltaCompraCadenaOrigen;
	}

	public String getVueltaCompraCadenaFecha() {
		return vueltaCompraCadenaFecha;
	}

	public void setVueltaCompraCadenaFecha(String vueltaCompraCadenaFecha) {
		this.vueltaCompraCadenaFecha = vueltaCompraCadenaFecha;
	}

	public String getVueltaCompraCadenaTotal() {
		return vueltaCompraCadenaTotal;
	}

	public void setVueltaCompraCadenaTotal(String vueltaCompraCadenaTotal) {
		this.vueltaCompraCadenaTotal = vueltaCompraCadenaTotal;
	}

	public void setSeleccionVueloError(boolean seleccionVueloError) {
		this.seleccionVueloError = seleccionVueloError;
	}

	public boolean isBtnContinuarCompraVisible() {
		return btnContinuarCompraVisible;
	}

	public void setBtnContinuarCompraVisible(boolean btnContinuarCompraVisible) {
		this.btnContinuarCompraVisible = btnContinuarCompraVisible;
	}

	public boolean isResumenVisible() {
		return resumenVisible;
	}

	public void setResumenVisible(boolean resumenVisible) {
		this.resumenVisible = resumenVisible;
	}

	/*public String getIdaCompraValue() {
		return idaCompraValue;
	}

	public void setIdaCompraValue(String idaCompraValue) {
		this.idaCompraValue = idaCompraValue;
	}

	public String getVueltaCompraValue() {
		return vueltaCompraValue;
	}

	public void setVueltaCompraValue(String vueltaCompraValue) {
		this.vueltaCompraValue = vueltaCompraValue;
	}*/

	public String getTotalCompraValue() {
		return totalCompraValue;
	}

	public void setTotalCompraValue(String totalCompraValue) {
		this.totalCompraValue = totalCompraValue;
	}

	public boolean isIdaCompraVisible() {
		return idaCompraVisible;
	}

	public void setIdaCompraVisible(boolean idaCompraVisible) {
		this.idaCompraVisible = idaCompraVisible;
	}

	public boolean isVueltaCompraVisible() {
		return vueltaCompraVisible;
	}

	public void setVueltaCompraVisible(boolean vueltaCompraVisible) {
		this.vueltaCompraVisible = vueltaCompraVisible;
	}

	public boolean isTotalCompraVisible() {
		return totalCompraVisible;
	}

	public void setTotalCompraVisible(boolean totalCompraVisible) {
		this.totalCompraVisible = totalCompraVisible;
	}

	public String getIdaYVuelta() {
		return idaYVuelta;
	}

	public void setIdaYVuelta(String idaYVuelta) {
		this.idaYVuelta = idaYVuelta;
	}

	public Vuelos getVueloSeleccionIda() {
		return vueloSeleccionIda;
	}

	public void setVueloSeleccionIda(Vuelos vueloSeleccionIda) {
		this.vueloSeleccionIda = vueloSeleccionIda;
	}

	public Vuelos getVueloSeleccionVuelta() {
		return vueloSeleccionVuelta;
	}

	public void setVueloSeleccionVuelta(Vuelos vueloSeleccionVuelta) {
		this.vueloSeleccionVuelta = vueloSeleccionVuelta;
	}

	public void setGestion_aeropuertos(IGestion_aeropuertos gestion_aeropuertos) {
		this.gestion_aeropuertos = gestion_aeropuertos;
	}

	public void setGestion_vuelos(IGestion_vuelos gestion_vuelos) {
		this.gestion_vuelos = gestion_vuelos;
	}

	public void setGestion_compañias(IGestion_compañias gestion_compañias) {
		this.gestion_compañias = gestion_compañias;
	}

	public List<CompañiasAereas> getLista_c_aereas() {
		return lista_c_aereas;
	}

	public void setLista_c_aereas(List<CompañiasAereas> lista_c_aereas) {
		this.lista_c_aereas = lista_c_aereas;
	}

	public List<Vuelos> getLista_vuelos() {
		return lista_vuelos;
	}

	public void setLista_vuelos(List<Vuelos> lista_vuelos) {
		this.lista_vuelos = lista_vuelos;
	}

	public List<SelectItem> getLista_numerosAdultos() {
		return lista_numerosAdultos;
	}

	public void setLista_numerosAdultos(List<SelectItem> lista_numerosAdultos) {
		this.lista_numerosAdultos = lista_numerosAdultos;
	}

	public List<SelectItem> getLista_numerosNiños() {
		return lista_numerosNiños;
	}

	public void setLista_numerosNiños(List<SelectItem> lista_numerosNiños) {
		this.lista_numerosNiños = lista_numerosNiños;
	}

	public List<SelectItem> getLista_numerosBebes() {
		return lista_numerosBebes;
	}

	public void setLista_numerosBebes(List<SelectItem> lista_numerosBebes) {
		this.lista_numerosBebes = lista_numerosBebes;
	}

	public boolean isAyudaaeropuertos_visible() {
		return ayudaaeropuertos_visible;
	}

	public void setAyudaaeropuertos_visible(boolean ayudaaeropuertos_visible) {
		this.ayudaaeropuertos_visible = ayudaaeropuertos_visible;
	}

	public List<Aeropuertos> getLista_aeropuertos() {
		return lista_aeropuertos;
	}

	public void setLista_aeropuertos(List<Aeropuertos> lista_aeropuertos) {
		this.lista_aeropuertos = lista_aeropuertos;
	}

	public List<SelectItem> getLista_compañias() {
		return lista_compañias;
	}

	public void setLista_compañias(List<SelectItem> lista_compañias) {
		this.lista_compañias = lista_compañias;
	}

	public boolean isAyudavuelos_visible() {
		return ayudavuelos_visible;
	}

	public void setAyudavuelos_visible(boolean ayudavuelos_visible) {
		this.ayudavuelos_visible = ayudavuelos_visible;
	}

	public boolean isDiaMasMenos() {
		return diaMasMenos;
	}

	public void setDiaMasMenos(boolean diaMasMenos) {
		this.diaMasMenos = diaMasMenos;
	}

	public Aeropuertos getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuertos origen) {
		this.origen = origen;
	}

	public Aeropuertos getDestino() {
		return destino;
	}

	public void setDestino(Aeropuertos destino) {
		this.destino = destino;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	public Date getFecharegreso() {
		return fecharegreso;
	}

	public void setFecharegreso(Date fecharegreso) {
		this.fecharegreso = fecharegreso;
	}

	public Date getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(Date horasalida) {
		this.horasalida = horasalida;
	}

	public Date getHoraregreso() {
		return horaregreso;
	}

	public void setHoraregreso(Date horaregreso) {
		this.horaregreso = horaregreso;
	}

	public String getAdultos() {
		return adultos;
	}

	public void setAdultos(String adultos) {
		this.adultos = adultos;
	}

	public String getNiños() {
		return niños;
	}

	public void setNiños(String niños) {
		this.niños = niños;
	}

	public String getBebes() {
		return bebes;
	}

	public void setBebes(String bebes) {
		this.bebes = bebes;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	// Fin accesores

	/**
	 * Constructor, inicializa el formulario
	 * 
	 */

	public ReservaBean() {

		// inicializa fecha a dia actual
		// fechasalida = new Date(System.currentTimeMillis());

		// para desarrollo, pongo fecha que hay en base de datos ya que esta muy
		// pobre en contenido

		Calendar c1 = GregorianCalendar.getInstance();
		c1.set(2016, Calendar.JANUARY, 5);
		fechasalida = c1.getTime();

		fecharegreso = new Date(System.currentTimeMillis());

		// inicializa boton de seleccion de aeropuerto
		origen = new Aeropuertos();
		origen.setNombreAeropuerto("Aeropuerto");

		destino = new Aeropuertos();
		destino.setNombreAeropuerto("Aeropuerto");

		diaMasMenos = true;
		idaYVuelta = "true";
		// rellena combos de adultos, niños, bebes

		lista_numerosAdultos = new ArrayList<>(0);
		lista_numerosNiños = new ArrayList<>(0);
		lista_numerosBebes = new ArrayList<>(0);
		lista_compañias = new ArrayList<>(0);
		SelectItem select = null;

		select = new SelectItem(1, "1 Adulto");
		lista_numerosAdultos.add(select);

		select = new SelectItem(1, "1 Niño");
		lista_numerosNiños.add(select);

		select = new SelectItem(1, "1 Bebe");
		lista_numerosBebes.add(select);
		for (Integer i = 2; i < 21; i++) {
			select = new SelectItem(i, String.valueOf(i) + " Adultos");
			lista_numerosAdultos.add(select);

			select = new SelectItem(i, String.valueOf(i) + " Niños");
			lista_numerosNiños.add(select);
		}

		for (Integer i = 2; i < 11; i++) {
			select = new SelectItem(i, String.valueOf(i) + " Bebes");
			lista_numerosBebes.add(select);
		}

		adultos = "1";

		// cuadro de resumen de compra
		resumenVisible = false;
		idaCompraVisible = false;
		vueltaCompraVisible = false;
		totalCompraVisible = false;
		seleccionVueloError = false;

	}

	/**
	 * Carga seleccion vuelo ida
	 * 
	 * @param evento
	 */

	public void cargar_SeleccionVuelo(SelectEvent evento) {
		if (evento.getComponent().getId().equals("tablavuelosIda")) {
			vueloSeleccionIda = (Vuelos) evento.getObject();
		}
		if (evento.getComponent().getId().equals("tablavuelosvuelta")) {
			vueloSeleccionVuelta = (Vuelos) evento.getObject();
		}
		refrescaTotalVuelos();
	}

	/**
	 * Descarga seleccion vuelo ida
	 * 
	 * @param evento
	 */

	public void descargar_SeleccionVuelo(UnselectEvent evento) {
		if (evento.getComponent().getId().equals("tablavuelosIda")) {
			vueloSeleccionIda = null;
		}
		if (evento.getComponent().getId().equals("tablavuelosvuelta")) {
			vueloSeleccionVuelta = null;
		}
		refrescaTotalVuelos();
	}

	/**
	 * Metodo para cortar la hora de un datetime
	 * 
	 * @param fecha
	 * @return
	 */

	public String truncateAHora(Date fecha) {
		// GregorianCalendar gcFecha = new GregorianCalendar();
		// gcFecha.clear();
		// gcFecha.setTime(fecha);
		SimpleDateFormat formatofecha = new SimpleDateFormat("HH:mm");

		return formatofecha.format(fecha.getTime());
	}

	/**
	 * Metodo para juntar campos separados de fecha y hora, necesaria ya que la
	 * base de datos tengo los campos separados
	 * 
	 * @param fecha
	 * @param hora
	 * @return
	 */
	public Date juntaFechaYHora(Date fecha, Date hora) {
		// operaciones fecha, junto los dos campos de la base de datos (fecha y
		// hora) del vuelo
		GregorianCalendar gcFecha = new GregorianCalendar();
		gcFecha.clear();
		gcFecha.setTime(fecha);

		GregorianCalendar gcHora = new GregorianCalendar();
		gcHora.clear();
		gcHora.setTime(hora);

		GregorianCalendar gcCompleta = new GregorianCalendar();
		gcCompleta.clear();
		gcCompleta.set(gcFecha.get(Calendar.YEAR), gcFecha.get(Calendar.MONTH),
				gcFecha.get(Calendar.DATE), gcHora.get(Calendar.HOUR),
				gcHora.get(Calendar.MINUTE), gcHora.get(Calendar.SECOND));

		return gcCompleta.getTime();
	}

	/**
	 * Muestra en el cuadro del total el resumen de ida, vuelta, y sumatorio
	 * 
	 * @param evento
	 */

	public void refrescaTotalVuelos() {
		Double totalIda = new Double(0);
		Double totalVuelta = new Double(0);

		// hago invisible el mensaje de error, por si existiera
		seleccionVueloError = false;

		// sumo numero de pasajeros totales, cuento adultos, niños y bebes por
		// igual
		Integer numeroPasajeros = Integer.parseInt(adultos)
				+ Integer.parseInt(niños) + Integer.parseInt(bebes);

		// sumatorio de (ida*pasajeros)+(vuelta*pasajeros)
		Double nuevoTotal = new Double(0);

		btnContinuarCompraVisible = true;
		totalCompraVisible = true;

		// checkear ida
		if (vueloSeleccionIda != null) {
			totalIda = vueloSeleccionIda.getTarifaIda() * numeroPasajeros;
			nuevoTotal += totalIda;
			idaCompraVisible = true;
			//idaCompraValue = "Ida: " + totalIda.toString() + " €";
			Date fecha_prueba = juntaFechaYHora(
					vueloSeleccionIda.getFechaSalida(),
					vueloSeleccionIda.getHoraSalida());

			SimpleDateFormat formatofecha = new SimpleDateFormat("EEE d MMM");

			idaCompraCadenaOrigen = vueloSeleccionIda
					.getAeropuertosByOrigenPaisFk().getCiudadAeropuerto()
					+ " a "
					+ vueloSeleccionIda.getAeropuertosByDestinoPaisFk()
							.getCiudadAeropuerto();
			idaCompraCadenaFecha = formatofecha.format(vueloSeleccionIda
					.getFechaSalida())
					+ " "
					+ " "
					+ truncateAHora(vueloSeleccionIda.getHoraSalida())
					+ " - "
					+ truncateAHora(vueloSeleccionIda.getHoraLlegada())
					+ " "
					+ vueloSeleccionIda.getStrVuelo();
			idaCompraCadenaTotal = numeroPasajeros + " x "
					+ vueloSeleccionIda.getTarifaIda() + " €   =   " + totalIda
					+ " €";

		} else {
			// no hay ida seleccionada, imposibilito continuar y aviso
			idaCompraVisible = false;
			btnContinuarCompraVisible = false;
			totalCompraVisible = false;
			seleccionVueloError = true;
			FacesContext.getCurrentInstance().addMessage(
					"totalvuelos:valorTotal",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"Debe seleccionar un vuelo de ida"));

		}

		// checkear vuelta
		if (vueloSeleccionVuelta != null) {
			totalVuelta = vueloSeleccionVuelta.getTarifaIda() * numeroPasajeros;
			//vueltaCompraValue = "Vuelta: " + totalVuelta.toString() + " €";
			nuevoTotal += totalVuelta;
			vueltaCompraVisible = true;

			SimpleDateFormat formatofecha = new SimpleDateFormat("EEE d MMM");

			vueltaCompraCadenaOrigen = vueloSeleccionVuelta
					.getAeropuertosByOrigenPaisFk().getCiudadAeropuerto()
					+ " a "
					+ vueloSeleccionVuelta.getAeropuertosByDestinoPaisFk()
							.getCiudadAeropuerto();
			vueltaCompraCadenaFecha = formatofecha.format(vueloSeleccionVuelta
					.getFechaSalida())
					+ " "
					+ truncateAHora(vueloSeleccionVuelta.getHoraSalida())
					+ " - "
					+ truncateAHora(vueloSeleccionVuelta.getHoraLlegada())
					+ " " + vueloSeleccionVuelta.getStrVuelo();
			vueltaCompraCadenaTotal = numeroPasajeros + " x "
					+ vueloSeleccionVuelta.getTarifaIda() + " €   =   "
					+ totalIda + " €";

		} else {
			// no hay vuelta seleccionada
			vueltaCompraVisible = false;

			if (idaYVuelta.equals("true")) {
				// deberia haberla
				// asique imposibilito continuar y aviso
				btnContinuarCompraVisible = false;
				totalCompraVisible = false;
				btnContinuarCompraVisible = false;
				seleccionVueloError = true;
				FacesContext.getCurrentInstance().addMessage(
						"totalvuelos:valorTotal",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"Debe seleccionar un vuelo de vuelta"));
			}

		}

		resumenVisible = (nuevoTotal != 0);// si no hay ni ida ni vuelta (osea,
											// total es valor 0),
											// desaparece directamente el
											// resumen

		totalCompraValue = "Total: " + nuevoTotal.toString() + " €";

		// si es de ida/vuelta, valido uno contra otro para que no coincida hora
		// ni vuelta sea anterior a ida
		if ((vueloSeleccionVuelta != null) && (vueloSeleccionIda != null)) {
			Date fechatotalSalida = juntaFechaYHora(
					vueloSeleccionIda.getFechaSalida(),
					vueloSeleccionIda.getHoraSalida());
			Date fechatotalVuelta = juntaFechaYHora(
					vueloSeleccionVuelta.getFechaSalida(),
					vueloSeleccionVuelta.getHoraSalida());
			// comprobar que vuelta no antes que la ida

			/*
			 * Date fechaCompleteIda = new
			 * Date(vueloSeleccionIda.getFechaSalida() .getTime());
			 */

			/*
			 * Calendar c1 = GregorianCalendar.getInstance(); c1.setTime(date);
			 * c1
			 * .set(vueloSeleccionIda.getFechaSalida().getYear(),Calendar.JANUARY
			 * ,5); fechasalida = c1.getTime();
			 */

			/*
			 * 
			 * fechaCompleteIda.setHours(vueloSeleccionIda.getHoraSalida()
			 * .getHours());
			 * fechaCompleteIda.setMinutes(vueloSeleccionIda.getHoraSalida()
			 * .getMinutes());
			 * 
			 * Date fechaCompleteVuelta = new Date(vueloSeleccionVuelta
			 * .getFechaSalida().getTime());
			 * fechaCompleteVuelta.setHours(vueloSeleccionVuelta.getHoraSalida()
			 * .getHours());
			 * fechaCompleteVuelta.setMinutes(vueloSeleccionVuelta.
			 * getHoraSalida() .getMinutes());
			 */
			if (fechatotalSalida.after(fechatotalVuelta)) // ida posterior a
															// la vuelta
			{
				seleccionVueloError = true;
				btnContinuarCompraVisible = false;
				FacesContext.getCurrentInstance().addMessage(
						"totalvuelos:valorTotal",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"La vuelta no puede ser anterior a la ida"));

			}
			if (fechatotalSalida.equals(fechatotalVuelta)) // ida igual a la
															// vuelta
			{
				seleccionVueloError = true;
				btnContinuarCompraVisible = false;
				FacesContext.getCurrentInstance().addMessage(
						"totalvuelos:valorTotal",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"La vuelta y la ida no pueden coincidir"));

			}
		}

	}

	/**
	 * Carga el aeropuerto seleccionado en la ventana modal CON DataTable y
	 * rellena compañias que hacen ese vuelo
	 * 
	 * @param id
	 */

	public void cargar_AeropuertoAyuda(SelectEvent evento) {

		ayudaaeropuertos_visible = false;
		if (boton_pulsado.equals("btnaorigen")) {
			origen = (Aeropuertos) evento.getObject();

		} else if (boton_pulsado.equals("btnadestino")) {
			destino = (Aeropuertos) evento.getObject();

		}

		// busca compañias con ese origen

		List<CompañiasAereas> lista = gestion_compañias.consultar_porOrigen(
				origen.getId(), destino.getId());

		SelectItem select;
		if (lista_compañias != null) {
			lista_compañias.clear();

		} else {
			lista_compañias = new ArrayList<>(0);
		}

		for (CompañiasAereas compañia : lista) {

			select = new SelectItem();
			select.setValue(compañia.getCodigoCompañia());
			select.setLabel(compañia.getNombreCompañia());

			lista_compañias.add(select);
		}

		compañia = lista_compañias.get(0).getValue().toString();
	}

	/**
	 * Carga el aeropuerto seleccionado en la ventana modal SIN DataTable y
	 * rellena compañias que hacen ese vuelo
	 * 
	 * @param id
	 */

	public void cargar_AeropuertoAyudaClick(Aeropuertos id) {

		ayudaaeropuertos_visible = false;

		if (boton_pulsado.equals("btnaorigen")) {
			origen = id;

		} else if (boton_pulsado.equals("btnadestino")) {
			destino = id;

		}

		// busca compañias con ese origen

		List<CompañiasAereas> lista = gestion_compañias.consultar_porOrigen(
				origen.getId(), destino.getId());

		SelectItem select;
		if (lista_compañias != null) {
			lista_compañias.clear();

		} else {
			lista_compañias = new ArrayList<>(0);
		}

		for (CompañiasAereas compañia : lista) {

			select = new SelectItem();
			select.setValue(compañia.getCodigoCompañia());
			select.setLabel(compañia.getNombreCompañia());

			lista_compañias.add(select);
		}

		compañia = lista_compañias.get(0).getValue().toString();
	}

	/**
	 * Listener de los botones para mostrar aeropuertos y enviar la busqueda
	 * 
	 * @param evento
	 */

	public void acciones(ActionEvent evento) {
		boton_pulsado = evento.getComponent().getId();
		if (boton_pulsado.equals("btnaorigen")) {
			// lo tengo preparado para buscar los origenes disponibles segun un
			// destino seleccionado
			// pero no tiene demasiado sentido asique comento esta parte del
			// codigo

			// if (destino.getId() != null) {
			lista_aeropuertos = gestion_aeropuertos.consultarPorDestino(null);

			/*
			 * } else
			 * 
			 * { lista_aeropuertos = Acceso_ApplicationContext.getBean(
			 * IGestion_aeropuertos.class).consultarTodos(); }
			 * 
			 * lista_aeropuertos = Acceso_ApplicationContext.getBean(
			 * IGestion_aeropuertos.class).consultarTodos();
			 */
			ayudaaeropuertos_visible = true;

		} else if (boton_pulsado.equals("btnadestino")) {

			if (origen.getId() != null) {
				lista_aeropuertos = gestion_aeropuertos
						.consultarPorOrigen(origen.getId());

			} else

			{
				lista_aeropuertos = gestion_aeropuertos.consultarTodos();
			}

			ayudaaeropuertos_visible = true;

		} else if (boton_pulsado.equals("btnborrar")) {

		} else if (boton_pulsado.equals("btnenviar")) {

			//limpio posibles selecciones de busqueda anteriores
			vueloSeleccionIda=null;
			vueloSeleccionVuelta=null;
			
			// si aun no tengo las compañias aereas, las cargo
			if (lista_c_aereas == null) {
				lista_c_aereas = gestion_compañias.consultarTodas();
			}

			Integer numPasajeros = Integer.valueOf(adultos)
					+ Integer.valueOf(niños) + Integer.valueOf(bebes);

			lista_vuelos = gestion_vuelos.consultar_TodosCriterios(
					origen.getId(), destino.getId(), numPasajeros, fechasalida,
					horasalida, diaMasMenos);

			if (lista_vuelos.size() > 0) {
				// va a ventana resultados
				// ayudavuelos_visible= (lista_vuelos.size()>0);
				ayudavuelos_visible = (idaYVuelta.equals("true"));
				Ejecucion_Expresiones.tratar_Expresion("#{cuerpoBean}",
						CuerpoBean.class)
						.setPagina("/xhtml/cuerpoVuelos.xhtml");
			} else {
				// saca mensaje de que no hay resultados
			}

		} else if (boton_pulsado.equals("btnvolver")) { // volver de la
														// seleccion de vuelos

			Ejecucion_Expresiones.tratar_Expresion("#{cuerpoBean}",
					CuerpoBean.class).setPagina("/xhtml/cuerpoBusqueda.xhtml");

		} else if (boton_pulsado.equals("btnVolverAVuelos")) { // volver a la
			// seleccion de vuelos

			Ejecucion_Expresiones.tratar_Expresion("#{cuerpoBean}",
					CuerpoBean.class).setPagina("/xhtml/cuerpoVuelos.xhtml");

		} else if (boton_pulsado.equals("btnContinuar")) { // continuar tras
															// seleccionar
															// vuelos

			Ejecucion_Expresiones.tratar_Expresion("#{cuerpoBean}",
					CuerpoBean.class).setPagina("/xhtml/registro.xhtml");

		}

	}

	/**
	 * Cierra ventana modal de seleccion de aeropuerto
	 * 
	 * @param evento
	 */

	public void cierre_AyudaAeropuertos(AjaxBehaviorEvent evento) {
		ayudaaeropuertos_visible = false;
	}

	/**
	 * Resuelve la compañia aerea a partir del id
	 * 
	 * @param id
	 * @return
	 */

	public CompañiasAereas getCompañiaById(String id) {
		CompañiasAereas resultado = null;

		for (CompañiasAereas compañia : lista_c_aereas) {
			if (compañia.getCodigoCompañia().equals(id)) {
				resultado = compañia;
				break;
			}
		}
		return resultado;

	}
}
