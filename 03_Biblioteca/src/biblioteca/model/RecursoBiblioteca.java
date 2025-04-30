package biblioteca.model;
import biblioteca.enums.EstadoRecurso;

public abstract class RecursoBiblioteca {
	private String id; // muestra el identificador de mi recurso.
	private String titulo; // muestra el título de mi recurso.
	private EstadoRecurso estado; // muestra el estado de mi recurso.
	
	
	
	/**
	 * Constructor para la clase abstracta RecursoBiblioteca.
	 * 
	 * @param id --> Identificador único del recurso.
	 * @param titulo --> Título del recurso.
	 * 
	 */
public RecursoBiblioteca(String id, String titulo) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.estado = estado;
}


// agrego los getters y setters de los atributos de mi constructor.


/** 
 * public String getId() {
 * --> Obtiene el identificador único del recurso.
 * 
 * @return --> El ID del recurso.
 */
	public String getId() {
		return id;
	}

	
	/**
	 * public String getTitulo() {
	 * --> Obtener el título del recurso.
	 * 
	 *@return --> El título del recurso.
	 */
	public String getTitulo() {
		return titulo;
	}

	
	/** public EstadoRecurso getEstado() {
	 * --> Obtiene el estado actual del recurso.
	 * 
	 * @return --> El estado del recurso (DISPONIBLE, PRESTADO, RESERVADO)
	 */
	public EstadoRecurso getEstado() {
		return estado;
	}
	
	
	/**
	 * public void setEstado(EstadoRecurso estado) {
	 * --> Establece el estado del recurso.
	 * 
	 * @param estado --> El nuevo estado del recurso.
	 */
	public void setEstado(EstadoRecurso estado) {
		this.estado = estado;
	} 
	
	
	/**
	 * Método abstracto para obtener una descripción detallada del recurso.
	 * Cada subclase debe implementar este método para incluir sus atributos específicos.
	 * 
	 * @return --> Una cadena de texto con la descripción del recurso
	 */
	public abstract String descripcion();


	public String getNombre() {
		// TODO Auto-generated method stub
		return getNombre();
	}



}
