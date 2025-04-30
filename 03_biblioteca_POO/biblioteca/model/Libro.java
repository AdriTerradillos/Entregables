package biblioteca.model;

	public class Libro extends RecursoBiblioteca {
	    private String autor;

	    public Libro(String id, String titulo, String autor) {
	        super(id, titulo);
	        this.autor = autor;
	    }

	    @Override
	    public String descripcion() {
	        return "Libro [ID=" + getId() + ", Título=" + getTitulo() + ", Autor=" + autor + ", Estado=" + getEstado() + "]";
	    }
	}

