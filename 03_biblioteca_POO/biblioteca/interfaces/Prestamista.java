package biblioteca.interfaces;



	public interface Prestamista {
	    /**
	     * Permite prestar un recurso bibliotecario a un usuario, si el recurso está disponible.
	     * @param recurso El recurso a prestar.
	     * @param usuario El usuario que toma prestado el recurso.
	     * @return true si el préstamo se realizó con éxito, false en caso contrario.
	     */
	    boolean prestar(biblioteca.model.RecursoBiblioteca recurso, biblioteca.model.Usuario usuario);

	    /**
	     * Permite devolver un recurso bibliotecario que ha sido previamente prestado.
	     * @param recurso El recurso a devolver.
	     * @return true si la devolución se realizó con éxito, false en caso contrario.
	     */

	    boolean devolver(biblioteca.model.RecursoBiblioteca recurso);
	}

