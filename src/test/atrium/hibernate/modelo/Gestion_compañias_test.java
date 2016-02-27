package test.atrium.hibernate.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.CompañiasAereas;
import com.atrium.hibernate.modelo.IGestion_compañias;

public class Gestion_compañias_test {

	//para conectar con hibernate
	private static IGestion_compañias gestion_compañias;
	private static ClassPathXmlApplicationContext context;

	private AeropuertosId aeropuertoOrigen;
	private AeropuertosId aeropuertoDestino;
	private List<CompañiasAereas> lista;

    @BeforeClass public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
				//"/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_compañias = (IGestion_compañias)context.getBean("gestion_compañias");
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
	public void testConsultarTodas() {

		lista = gestion_compañias.consultarTodas();
		Assert.assertTrue(
				"Comprobar operacion Compañias:ConsultarTodos devuelve lista no vacia",
				lista.size() > 0);
	}

	/**
	 * Prueba que haya compañias aereas que vuelen desde Madrid a Barcelona
	 */
	@Test
	public void testConsultarPor_Origen() {
		lista = gestion_compañias.consultar_porOrigen(aeropuertoOrigen,aeropuertoDestino);
		Assert.assertTrue(
				"Comprobar operacion Compañias:ConsultarPorOrigen('MAD','BCN') devuelve lista no vacia",
				lista.size() > 0);
	}


}
