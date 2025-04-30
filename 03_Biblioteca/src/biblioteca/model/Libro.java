package biblioteca.model;

import biblioteca.enums.EstadoRecurso;

public class Libro extends RecursoBiblioteca {
	private String autor;
	


	/** 
	 * Constructor para la clase Libro.
	 * 
	 * @param id --> Identificador único del libro.
	 * @param titulo --> Título del libro.
	 * @param autor --> Autor del libro.
	 */
	public Libro(String id, String titulo, String autor) {
		super(id, titulo);
		this.autor = autor;
	}
	
	

	/**
	 * public String getAutor() {
	 * --> Obtiene el autor del Libro.
	 * 
	 * @return --> El autor del Libro.
	 */
	public String getAutor() {
		return autor;
	}




	/** 
	 * Implementación del método abstracto descripcion() para la clase
	 * Libro.
	 * Devuelve una cadena con todos los detalles del Libro.
	 * 
	 * @return --> Una cadena con el ID, Título y Autor del Libro.
	 */
	@Override
	public String descripcion() {
		return "Libro [ID: " + getId() + 
				", Título: " + getTitulo() + 
				", Autor: " + autor + 
				", Estado: " + getEstado() + "]";
	}
}
