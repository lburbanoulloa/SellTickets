package test.atrium.hibernate.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.modelo.IGestion_provincias;

public class Gestion_provincias_test {

	// para conectar con hibernate
	private static IGestion_provincias gestion_provincias;
	private static ClassPathXmlApplicationContext context;

	private List<Provincias> lista;

	@BeforeClass
	public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
		// "/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_provincias = (IGestion_provincias) context
				.getBean("gestion_provincias");
	}

	/**
	 * Prueba el listado completo
	 */

	@Test
	public void testConsultarTodos() {

		lista = gestion_provincias.consultarTodas();
		Assert.assertTrue(
				"Comprobar operacion Provincias:ConsultarTodos devuelve lista no vacia",
				lista.size() > 0);
	}

}
