package test.atrium.hibernate.modelo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Usuarioavion;
import com.atrium.hibernate.modelo.IGestion_usuarios;

public class Gestion_usuarios_test {

	//para conectar con hibernate
	private static IGestion_usuarios gestion_usuarios;
	private static ClassPathXmlApplicationContext context;

    @BeforeClass public static void conectarHibernate() {
		// inicio hibernate
		context = new ClassPathXmlApplicationContext(
				//"/com/atrium/spring/modelo.xml");
				"/test/atrium/hibernate/modelo/modelo_test.xml");
		gestion_usuarios = (IGestion_usuarios)context.getBean("gestion_usuarios");
    }
	
    /**
     * Prueba registro de usuario con los datos ok
     */
	@Test
	public void testRegistro_ok() {
		Usuarioavion user =new Usuarioavion();
		gestion_usuarios.altaUsuario(user);
		Assert.assertNotNull( 
				"Comprobar operacion Usuarios:registro con datos ok",
				user);
	}	

    /**
     * Prueba registro de usuario con los datos mal
     */
	@Test
	public void testRegistro_wrong() {
		Usuarioavion user =new Usuarioavion();
		gestion_usuarios.altaUsuario(user);
		Assert.assertNull( 
				"Comprobar operacion Usuarios:registro con datos mal",
				user);
	}	
	
    /**
     * Prueba registro de usuario que ya exista
     */
	@Test
	public void testRegistro_yaExiste() {
		Usuarioavion user =new Usuarioavion();
		gestion_usuarios.altaUsuario(user);
		Assert.assertNull( 
				"Comprobar operacion Usuarios:registro de datos ya existentes",
				user);
	}	
	
    /**
     * Prueba login con datos ok
     */
	@Test
	public void testGetUser_ok() {		
		Usuarioavion user = gestion_usuarios.getUser("", "");
		Assert.assertNotNull( 
				"Comprobar operacion Usuarios:login con usuario correcto",
				user);
	}	
	
    /**
     * Prueba login con datos mal
     */
	@Test
	public void testGetUser_wrong() {		
		Usuarioavion user  = gestion_usuarios.getUser("", "");
		Assert.assertNull ( 
				"Comprobar operacion Usuarios:login con usuario incorrecto",
				user);
	}		

}
