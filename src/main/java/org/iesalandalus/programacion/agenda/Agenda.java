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
	
	
	/*    M�TODOS GET   */
	
	public Contacto[] getContactos() {
		
		return contactos;
		
			
	}

	public int getNumContactos () {
		
		return numContactos;
	}
	
	
	/*    M�TODO A�ADIR   */
	
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
	
	
	/*  M�TODO BUSCAR   */
	
	public Contacto buscar(String nombreContacto) {

		if (buscarIndiceCliente(nombreContacto) != 51) {

			return contactos[buscarIndiceCliente(nombreContacto)];

		}

		return null;

	}
	
	private int buscarIndiceCliente(String nombreClienteABuscar) {

		for (int k = 0; k < numContactos; k++) {

			if (contactos[k].getNombre().equals(nombreClienteABuscar)) {

				return k;
			}

		}   return  51;

	}
	
	
	
	
}
