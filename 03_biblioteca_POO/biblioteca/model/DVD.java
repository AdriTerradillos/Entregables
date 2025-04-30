package biblioteca.model;

	public class DVD extends RecursoBiblioteca {
	    private int duracionMinutos;

	    public DVD(String id, String titulo, int duracionMinutos) {
	        super(id, titulo);
	        this.duracionMinutos = duracionMinutos;
	    }

	    @Override
	    public String descripcion() {
	        return "DVD [ID=" + getId() + ", Título=" + getTitulo() + ", Duración=" + duracionMinutos + " minutos, Estado=" + getEstado() + "]";
	    }
	}
	// aquí muestro la colección total de los DVD´s.
