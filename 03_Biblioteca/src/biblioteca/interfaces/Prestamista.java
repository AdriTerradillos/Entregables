package biblioteca.interfaces;

import biblioteca.model.RecursoBiblioteca;
import biblioteca.model.Usuario;
import.biblioteca.model.Usuario;

public interface Prestamista {
	/**
	 * Permite prestar un recurso bibliotecario a un usuario si el recurso está disponible
	 * 
	 * @param recurso --> El recurso bibliotecario a prestar.
	 * @param usuario --> El usuario que toma prestado el recurso.
	 * @return --> Si el préstamo se realizó con éxito "true", en caso contrario "false".
	 */
	
	boolean prestar(RecursoBiblioteca recurso, Usuario usuario);
	
	/**
	 * Permite devolver un recurso bibliotecario que ha sido previamente prestado.
	 * 
	 * @param --> El recurso bibliotecario a devolver.
	 * @return --> Si el préstamo se realizó con éxito, "true". En caso contrario, "false".
	 */
	
	boolean devolver (RecursoBiblioteca recurso);

	/**
	 * Implementación del método prestar de la interfaz Prestamista.
	 * Permite prestar un recurso  un usuario si el recurso está disponible y el usuario existe en el registro.
	 * 
	 * @param recurso --> El recurso a prestar.
	 * @param usuario --> El usuario que tomará prestado el recurso.
	 * @return true --> Si el préstamo se realizó con exito. En caso contrario "false".
	 */
	boolean prestar(RecursoBiblioteca recurso, Usuario usuario);
	

}
