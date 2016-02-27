package test.atrium.hibernate.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.Compa�iasAereas;
import com.atrium.hibernate.modelo.IGestion_compa�ias;

public class Gestion_compa�ias_test {

	//para conectar con hibernate
	private static IGestion_compa�ias gestion_compa�ias;
	private static ClassPathXmlApplicationContext context;

	private AeropuertosId aeropuertoOrigen;
	private AeropuertosId aeropuertoDestino;
	private List<Compa�iasAereas> lista;

    @BeforeClass public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
				//"/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_compa�ias = (IGestion_compa�ias)context.getBean("gestion_compa�ias");
    }
	

	@Before
	public void SetUp() {
		//inicializo 
		aeropuertoOrigen = new AeropuertosId();
		aeropuertoOrigen.setPais("ESPA�A");
		aeropuertoOrigen.setCodigoAeropuerto("MAD");

		aeropuertoDestino = new AeropuertosId();
		aeropuertoDestino.setPais("ESPA�A");
		aeropuertoDestino.setCodigoAeropuerto("BCN");			

	}

	
	/**
	 * Prueba el listado completo
	 */
	@Test
	public void testConsultarTodas() {

		lista = gestion_compa�ias.consultarTodas();
		Assert.assertTrue(
				"Comprobar operacion Compa�ias:ConsultarTodos devuelve lista no vacia",
				lista.size() > 0);
	}

	/**
	 * Prueba que haya compa�ias aereas que vuelen desde Madrid a Barcelona
	 */
	@Test
	public void testConsultarPor_Origen() {
		lista = gestion_compa�ias.consultar_porOrigen(aeropuertoOrigen,aeropuertoDestino);
		Assert.assertTrue(
				"Comprobar operacion Compa�ias:ConsultarPorOrigen('MAD','BCN') devuelve lista no vacia",
				lista.size() > 0);
	}


}
