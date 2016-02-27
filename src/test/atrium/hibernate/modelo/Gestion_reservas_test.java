package test.atrium.hibernate.modelo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Reservas;
import com.atrium.hibernate.modelo.IGestion_reservas;

public class Gestion_reservas_test {

	//para conectar con hibernate
	private static IGestion_reservas gestion_reservas;
	private static ClassPathXmlApplicationContext context;
	

    @BeforeClass public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
				//"/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_reservas = (IGestion_reservas)context.getBean("gestion_reservas");
    }
	


    /**
     * Prueba el alta de una reserva
     */
	@Test
	public void testAltaReserva() {	
		Reservas reserva=new Reservas();
		gestion_reservas.alta(reserva);
		Assert.assertNotNull( 
				"Comprobar operacion Reservas:alta",
				reserva);
	}	

}
