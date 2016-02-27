package test.atrium.hibernate.modelo;


/**
 * Pruebas del servicio Gestion_aeropuertos
 */
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Aeropuertos;
import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.modelo.IGestion_aeropuertos;

public class Gestion_aeropuertos_test {

	//para conectar con hibernate
	private static IGestion_aeropuertos gestion_aeropuertos;
	private static ClassPathXmlApplicationContext context;

	private AeropuertosId aeropuertoOrigen;
	private AeropuertosId aeropuertoDestino;
	private List<Aeropuertos> lista;

    @BeforeClass public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
				//"/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_aeropuertos = (IGestion_aeropuertos)context.getBean("gestion_aeropuertos");
    }
	

	@Before
	public void SetUp() {
		//inicializo
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

		lista = gestion_aeropuertos.consultarTodos();
		Assert.assertTrue(
				"Comprobar operacion Aeropuertos:ConsultarTodos devuelve lista no vacia",
				lista.size() > 0);
	}

	/**
	 * Prueba que haya aeropuertos destino cuando el origen es Madrid
	 */
	@Test
	public void testConsultarPorOrigen() {
		lista = gestion_aeropuertos.consultarPorOrigen(aeropuertoOrigen);
		Assert.assertTrue(
				"Comprobar operacion Aeropuertos:ConsultarPorOrigen('MAD') devuelve lista no vacia",
				lista.size() > 0);
	}
	
	/**
	 * Prueba que haya aeropuertos destino cuando el destino es Barcelona
	 */

	@Test
	public void testConsultarPorDestino() {
		lista = gestion_aeropuertos.consultarPorDestino(aeropuertoDestino);
		Assert.assertTrue(
				"Comprobar operacion Aeropuertos:ConsultarPorDestino('BCN') devuelve lista no vacia",
				lista.size() > 0);
	}

}
