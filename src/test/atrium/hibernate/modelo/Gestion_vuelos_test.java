package test.atrium.hibernate.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Vuelos;
import com.atrium.hibernate.modelo.IGestion_vuelos;

public class Gestion_vuelos_test {

	// para conectar con hibernate
	private static IGestion_vuelos gestion_vuelos;
	private static ClassPathXmlApplicationContext context;

	private AeropuertosId aeropuertoOrigen;
	private AeropuertosId aeropuertoDestino;
	private List<Vuelos> lista;

	@BeforeClass
	public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
		// "/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_vuelos = (IGestion_vuelos) context.getBean("gestion_vuelos");
	}

	@Before
	public void SetUp() {
		// inicializo
		aeropuertoOrigen = new AeropuertosId();
		aeropuertoOrigen.setPais("ESPAÑA");
		aeropuertoOrigen.setCodigoAeropuerto("MAD");

		aeropuertoDestino = new AeropuertosId();
		aeropuertoDestino.setPais("ESPAÑA");
		aeropuertoDestino.setCodigoAeropuerto("BCN");

	}

	/**
	 * Prueba el listado completo
	 */
	@Test
	public void testConsultarTodos() {

		lista = gestion_vuelos.consultarTodos();
		Assert.assertTrue(
				"Comprobar operacion Vuelos:ConsultarTodos devuelve lista no vacia",
				lista.size() > 0);
	}

	/**
	 * Prueba el listado de vuelos con origen Madrid
	 */
	@Test
	public void testConsultarPorOrigen() {
		lista = gestion_vuelos.consultarPorOrigen(aeropuertoOrigen);
		Assert.assertTrue(
				"Comprobar operacion Vuelos:ConsultarPorOrigen('MAD') devuelve lista no vacia",
				lista.size() > 0);
	}

	/**
	 * Prueba el listado de vuelos con origen Madrid y destino Barcelona
	 */
	@Test
	public void testConsultarPorDestino() {
		lista = gestion_vuelos.consultarPorOrigenDestino(aeropuertoOrigen,
				aeropuertoDestino);
		Assert.assertTrue(
				"Comprobar operacion ConsultarPorDestino('BCN') devuelve lista no vacia",
				lista.size() > 0);
	}

	/**
	 * Prueba el listado de vuelos para origen Madrid destino Barcelona al menos
	 * una plaza libre fecha 05/01/2016 sin hora establecida margen de +-1 dia
	 * (entre el 04/01/2016 y el 06/01/2016)
	 */
	@Test
	public void testConsultar_TodosCriterios() {

		Calendar c1 = GregorianCalendar.getInstance();
		c1.set(2016, Calendar.JANUARY, 5);
		Date fechasalida = c1.getTime();

		lista = gestion_vuelos.consultar_TodosCriterios(aeropuertoOrigen,
				aeropuertoDestino, 1, fechasalida, null, true);
		Assert.assertTrue(
				"Comprobar operacion Consultar_TodosCriterios('MAD','BCN',1pasajero,04/01/2016,00:00,aproximacion de +-1dia=true ) devuelve lista no vacia",
				lista.size() > 0);
	}

	/**
	 * Prueba el listado de vuelos para la compañia Iberia
	 */
	@Test
	public void testConsultarPorCompañia() {
		lista = gestion_vuelos.consultarPorCompania("IB");
		Assert.assertTrue(
				"Comprobar operacion ConsultarPorCompñia('IBE') devuelve lista no vacia",
				lista.size() > 0);
	}

}
