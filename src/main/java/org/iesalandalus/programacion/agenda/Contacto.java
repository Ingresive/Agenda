package org.iesalandalus.programacion.agenda;


import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Contacto {

	private static final String ER_TELEFONO = "[69][0-9]{8}";
	private static final String ER_CORREO = "[^@]{1,}@[a-zA-Z]{1,}\\.[a-zA-Z]{1,5}";

	private String nombre;
	private String telefono;
	private String correo;
	

	
	/*                   CONSTRUCTOR                 */
	
	
	public Contacto(String nombre, String telefono, String correo) {
		this.setNombre(nombre);
		this.setTelefono(telefono);
		this.setCorreo(correo);

		
	}

	
	
	/*                GET Y SET                        */
	
	
	public String getNombre() {
		return this.nombre;
	}

	private void setNombre(String nombre) {
		boolean existe =false;
		do {
			existe=true;
			
		} while (this.nombre != null);
		
		 

		if (nombre != null && nombre != "" && existe == true) {
			this.nombre = nombre;
		} else {
			throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");

		}
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {

		if (telefono != null && telefono != "") {
			
			if (Pattern.matches(ER_TELEFONO, telefono)) {
				
				this.telefono = telefono;
			} else {
				throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
			}

		}else{
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
		}

	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		
		if  (correo != null && correo != "") {
			
			if (Pattern.matches(ER_CORREO, correo)) {
				this.correo = correo;
			} else {
				throw new IllegalArgumentException("El correo no tiene un formato válido.");
				}
		}else{

			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
			}
		
	    }

		
	
/*                METODO PARA LAS INICIALES              */

	private String getIniciales() {

		StringTokenizer iniciales = new StringTokenizer(nombre);

		String inicial = "";

		while (iniciales.hasMoreTokens()) {

			inicial += iniciales.nextToken().substring(0, 1);

		}
		return inicial.toUpperCase();

	}


	

	@Override
	public String toString() {
		return  getIniciales() + " [" + telefono + ", " +  correo +"]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}



	





	

	
}
