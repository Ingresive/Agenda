package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;

public class Agenda {
	
	private static final int MAX_CONTACTOS = 50;
	
	private int numContactos = 0;
	
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
	
	
	/*    MÉTODO AÑADIR   */
	
	public void anadir(Contacto contacto) throws OperationNotSupportedException{
		
		
		do {
		
		contactos[buscarPrimerIndiceComprobandoExistencia(contacto)] = contacto;
		numContactos += 1;
		
		}while(indiceNoSuperaTamano(numContactos));
		
		
		
	}
	
	private int buscarPrimerIndiceComprobandoExistencia(Contacto indiceContacto) throws OperationNotSupportedException {

		int indice = '0';

		for (Contacto contacto : contactos) {

			indice++;

			do {

				throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");

			} while (contacto.equals(indiceContacto));

		}
		
		return indice;
	}
	
	
	private boolean indiceNoSuperaTamano(int indiceTamano) {
		
		boolean noSuperaTamano;
		indiceTamano = numContactos;
		
		if (indiceTamano< MAX_CONTACTOS) {
			
			noSuperaTamano = true;
			
		}else {
			
			noSuperaTamano = false;
		}
		
		return noSuperaTamano;
		
	}
	
	
	
	
	
	
	
	
	
	
}
