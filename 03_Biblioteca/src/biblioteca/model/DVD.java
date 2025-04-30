package biblioteca.model;

import biblioteca.enums.EstadoRecurso;

public class DVD  extends RecursoBiblioteca {
	private int duracionMinutos;
	
	/**
	 * Constructor clase DVD
	 * 
	 * @param id --> Identificador único del DVD.
	 * @param Titulo --> Título del DVD.
	 * @param duracionMin --> Duración del DVD en minutos.
	 */
	
	public DVD(String id, String titulo, int duracionMinutos) {
		super(id, titulo);
		this.duracionMinutos = duracionMinutos;}



/** 
 * Obtiene la duración del DVD en minutos --> @return duracionMinutos
**/
public int getDuracionMinutos() {
	return duracionMinutos;
}

/** 
 * Implementación del método abstracto descripcion() para la
 * clase DVD.
 * Devuelve una cadena con todos los detalles del DVD.
 * 
 * @RETURN --> Una cadena con el ID, Título y duración del DVD.
 */
@Override
public String descripcion() {
	return "DVD [ID: " + getId() +
			", Título: " + getTitulo() +
			", Duración: " + duracionMinutos + "min" +
			", Estado: " + getEstado() + "]";
}
}
