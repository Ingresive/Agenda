package org.iesalandalus.programacion.agenda;

public class Agenda {
	
	private static final int MAX_CONTACTOS = 50;
	
	private int numContactos;
	
	private Contacto[] contactos ;
	
	/*  CONSTRUCTOR  */
	
	public Agenda () {
		
		contactos = new Contacto[MAX_CONTACTOS];
		
	}
	
	
	/*    MÉTODOS GET   */
	
	public Contacto[] getContactos() {
		
		return contactos;
		
			
	}

	public int getNumContactos () {
		
		return numContactos;
	}
	
	
}
