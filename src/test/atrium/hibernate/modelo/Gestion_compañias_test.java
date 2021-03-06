package test.atrium.hibernate.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.AeropuertosId;
import com.atrium.hibernate.CompaņiasAereas;
import com.atrium.hibernate.modelo.IGestion_compaņias;

public class Gestion_compaņias_test {

	//para conectar con hibernate
	private static IGestion_compaņias gestion_compaņias;
	private static ClassPathXmlApplicationContext context;

	private AeropuertosId aeropuertoOrigen;
	private AeropuertosId aeropuertoDestino;
	private List<CompaņiasAereas> lista;

    @BeforeClass public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
				//"/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_compaņias = (IGestion_compaņias)context.getBean("gestion_compaņias");
    }
	

	@Before
	public void SetUp() {
		//inicializo 
		aeropuertoOrigen = new AeropuertosId();
		aeropuertoOrigen.setPais("ESPAŅA");
		aeropuertoOrigen.setCodigoAeropuerto("MAD");

		aeropuertoDestino = new AeropuertosId();
		aeropuertoDestino.setPais("ESPAŅA");
		aeropuertoDestino.setCodigoAeropuerto("BCN");			

	}

	
	/**
	 * Prueba el listado completo
	 */
	@Test
	public void testConsultarTodas() {

		lista = gestion_compaņias.consultarTodas();
		Assert.assertTrue(
				"Comprobar operacion Compaņias:ConsultarTodos devuelve lista no vacia",
				lista.size() > 0);
	}

	/**
	 * Prueba que haya compaņias aereas que vuelen desde Madrid a Barcelona
	 */
	@Test
	public void testConsultarPor_Origen() {
		lista = gestion_compaņias.consultar_porOrigen(aeropuertoOrigen,aeropuertoDestino);
		Assert.assertTrue(
				"Comprobar operacion Compaņias:ConsultarPorOrigen('MAD','BCN') devuelve lista no vacia",
				lista.size() > 0);
	}


}
