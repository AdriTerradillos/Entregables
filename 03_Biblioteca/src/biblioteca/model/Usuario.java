package biblioteca.model;

public class Usuario {
	private String id;
	private String nombre;
	
	/**
	 * Constructor para clase Usuario.
	 * 
	 * @param id --> Identificador único del usuario.
	 * @param nombre --> Nombre del usuario.
	 */
	public Usuario(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	/**
	 * public String getId() {
	 * --> Obtiene el identificador único del usuario.
	 * 
	 * @return --> El ID del usuario.
	 */
	public String getId() {
		return id;
	}
	
	
	/**
	 * public String getNombre() {
	 * --> Obtiene el nombre del usuario.
	 * 
	 * @return nombre --> El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [ID: " + getId() +
				", Nombre: " + getNombre() + "]";
 	}
}
	
	


