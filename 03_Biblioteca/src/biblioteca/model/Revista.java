package biblioteca.model;

import biblioteca.enums.EstadoRecurso;

public class Revista extends RecursoBiblioteca {
	private int numeroEdicion;

	
	/**
	 * Contructor
	 * 
	 * @param id --> Identificador único de la revista.
	 * @param titulo --> Título de la revista.
	 * @param numeroEdicion --> Número de edición de la revista.
	 */
	public Revista(String id, String titulo, int numeroEdicion) {
		super(id, titulo);
		this.numeroEdicion = numeroEdicion;
	}
	

	
/** 
 * public int getNumeroEdicion() {
 * Obtiene el número de la edición de la revista.
 * 
 * @return --> El número de la edición de la revista.
 */
	public int getNumeroEdicion() {
		return numeroEdicion;
	}
	
	


	/** 
	 * Implementación del método abstracto descripcion() para la clase Revista.
	 * Devuelve una cadena con todos los detalles de la revista.
	 * 
	 * @return --> Una cadena con el ID, Título, y el Número de edición de la revista.
	 */
	@Override
	public String descripcion() {
		return "Revista [ID: " + getId() +
				", Título: " + getTitulo() +
				", Edición: " + numeroEdicion() +
				", Estado: " + getEstado() + "]";
		}


	private String numeroEdicion() {
		// TODO Auto-generated method stub
		return null;
	}
}
