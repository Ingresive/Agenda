package org.iesalandalus.programacion.agenda;

import java.util.regex.Pattern;

public class Contacto {

	private static final String ER_TELEFONO = "[69][0-9]{8}";
	private static final String ER_CORREO = "[^@]{1,}@[a-zA-Z]{1,}\\.[a-zA-Z]{1,5}";

	private String nombre;
	private String telefono;
	private String correo;

	public Contacto(String nombre, String correo, String telefono) {

	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {

		if (nombre != null && nombre != "") {
			this.nombre = nombre;
		} else {
			throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");

		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {

		if (telefono != null && telefono != "") {
			if (Pattern.matches(ER_TELEFONO, telefono)) {
				this.telefono = telefono;
			} else {
				throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
			}

		} else {
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");

		}

	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {

		if (correo != null && correo != "") {
			if (Pattern.matches(ER_CORREO, correo)) {
				this.correo = correo;
			} else {
				throw new IllegalArgumentException("El correo no tiene un formato válido.");

			}
		} else {
			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
		}

	}

}
