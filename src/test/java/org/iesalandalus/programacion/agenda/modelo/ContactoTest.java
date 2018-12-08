package org.iesalandalus.programacion.agenda.modelo;

import static org.junit.Assert.*;

import org.iesalandalus.programacion.agenda.Contacto;
import org.junit.Test;

public class ContactoTest {
	
	private static final String MENSAJE_EXCEPCION = "Deber铆a haber saltado la excepci贸n.";

	@Test
	public void constructorValidoTest() {
		Contacto contacto = new Contacto("Jos茅 Ram贸n", "950112233", "joseramon.jimenez@iesalandalus.org");
		assertEquals("Jos茅 Ram贸n", contacto.getNombre());
		assertEquals("950112233", contacto.getTelefono());
		assertEquals("joseramon.jimenez@iesalandalus.org", contacto.getCorreo());
		contacto = new Contacto("Andr茅s", "650112233", "andres66@servidor.com");
		assertEquals("Andr茅s", contacto.getNombre());
		assertEquals("650112233", contacto.getTelefono());
		assertEquals("andres66@servidor.com", contacto.getCorreo());
	}
	
	@Test
	public void constructorNombreNoValidoTest() {
		Contacto contacto = null;
		try {
			contacto = new Contacto(null, "950112233", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El nombre de un contacto no puede ser nulo o vac韔.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("", "950112233", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El nombre de un contacto no puede ser nulo o vac韔.", e.getMessage());
			assertNull(contacto);
		}
	}
	
	@Test
	public void constructorTelefonoNoValidoTest() {
		Contacto contacto = null;
		try {
			contacto = new Contacto("Jos茅 Ram贸n", null, "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El tel閒ono de un contacto no puede ser nulo o vac韔.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El tel閒ono de un contacto no puede ser nulo o vac韔.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "555112233", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El tel閒ono no tiene un formato v醠ido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "95011223", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El tel閒ono no tiene un formato v醠ido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "9501122334", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El tel閒ono no tiene un formato v醠ido.", e.getMessage());
			assertNull(contacto);
		}
	}
	
	@Test
	public void constructorCorreoNoValidoTest() {
		Contacto contacto = null;
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "950112233", null);
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo de un contacto no puede ser nulo o vac韔.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "950112233", "");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo de un contacto no puede ser nulo o vac韔.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "950112233", "joseramon.jimenez");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo no tiene un formato v醠ido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "950112233", "joseramon.jimenez@iesalandalus");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo no tiene un formato v醠ido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "950112233", "joseramon.jimenez@ies-alandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo no tiene un formato v醠ido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("Jos茅 Ram贸n", "950112233", "joseramon.jimenez@iesalandalus1.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo no tiene un formato v醠ido.", e.getMessage());
			assertNull(contacto);
		}
	}
	
	//No pruebo los m茅todos get y set ya que est谩n cubiertos en las pruebas anteriores
	
	@Test
	public void toStringTest() {
		Contacto contacto = new Contacto("Jos茅 Ram贸n", "950112233", "joseramon.jimenez@iesalandalus.org");
		assertEquals("JR [950112233, joseramon.jimenez@iesalandalus.org]", contacto.toString());
		contacto = new Contacto("jos茅      ram贸n  jim茅nez", "950112233", "joseramon.jimenez@iesalandalus.org");
		assertEquals("JRJ [950112233, joseramon.jimenez@iesalandalus.org]", contacto.toString());
	}
	
	@Test
	public void igualdadTest() {
		Contacto contacto1 = new Contacto("Jos茅 Ram贸n", "950112233", "joseramon.jimenez@iesalandalus.org");
		Contacto contacto2 = new Contacto("Jos茅 Ram贸n", "999123123", "joseramon.jimenez@iesalandalus.org");
		Contacto contacto3 = new Contacto("jos茅 ram贸n", "999123123", "joseramon.jimenez@iesalandalus.org");
		Contacto contacto4 = new Contacto("Jose Ramon", "999123123", "joseramon.jimenez@iesalandalus.org");
		assertNotEquals(contacto1, null);
		assertNotEquals(contacto1, "Prueba");
		assertNotEquals(contacto1, contacto4);
		assertEquals(contacto1, contacto2);
		assertEquals(contacto1, contacto3);
	}

}
