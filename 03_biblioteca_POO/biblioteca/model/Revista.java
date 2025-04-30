package biblioteca.model;

	
	public class Revista extends RecursoBiblioteca {
	    private int numeroEdicion;

	    public Revista(String id, String titulo, int numeroEdicion) {
	        super(id, titulo);
	        this.numeroEdicion = numeroEdicion;
	    }

	    @Override
	    public String descripcion() {
	        return "Revista [ID=" + getId() + ", Título=" + getTitulo() + ", Edición=" + numeroEdicion + ", Estado=" + getEstado() + "]";
	    }
	}

