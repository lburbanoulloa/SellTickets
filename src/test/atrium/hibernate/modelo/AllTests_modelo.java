package test.atrium.hibernate.modelo;

/**
 * Suite de clases de prueba de la capa modelo
 * 
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Gestion_aeropuertos_test.class, Gestion_compañias_test.class,
		Gestion_municipios_test.class, Gestion_paises_test.class,
		Gestion_provincias_test.class, Gestion_vuelos_test.class })
public class AllTests_modelo {

}
