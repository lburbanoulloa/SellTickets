package test.atrium.hibernate.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.modelo.IGestion_municipios;

public class Gestion_municipios_test {

	//para conectar con hibernate
	private static IGestion_municipios gestion_municipios;
	private static ClassPathXmlApplicationContext context;

	private List<Municipios> lista;

    @BeforeClass public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
				//"/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_municipios = (IGestion_municipios)context.getBean("gestion_municipios");
    }
	


    /**
     * Prueba el listado completo
     */
	@Test
	public void testConsultarTodos() {		
		lista = gestion_municipios.consultarTodos();
		Assert.assertTrue( 
				"Comprobar operacion Municipios:ConsultarTodos devuelve lista no vacia",
				lista.size() > 0);
	}	

}
