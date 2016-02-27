package test.atrium.hibernate.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.modelo.IGestion_paises;

public class Gestion_paises_test {

	// para conectar con hibernate
	private static IGestion_paises gestion_paises;
	private static ClassPathXmlApplicationContext context;

	private List<Pais> lista;

	@BeforeClass
	public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
		// "/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_paises = (IGestion_paises) context.getBean("gestion_paises");
	}

	/**
	 * Prueba el listado completo
	 */
	@Test
	public void testConsultarTodos() {

		lista = gestion_paises.consultarTodos();
		Assert.assertTrue(
				"Comprobar operacion Pais:ConsultarTodos devuelve lista no vacia",
				lista.size() > 0);
	}

}
