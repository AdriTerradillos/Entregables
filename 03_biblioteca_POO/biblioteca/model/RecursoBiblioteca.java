package biblioteca.model;

	import biblioteca.enums.EstadoRecurso;


	public abstract class RecursoBiblioteca {
	    private String id;
	    private String titulo;
	    private EstadoRecurso estado;

	    public RecursoBiblioteca(String id, String titulo) {
	        this.id = id;
	        this.titulo = titulo;
	        this.estado = EstadoRecurso.DISPONIBLE; // Por defecto, al crearse está disponible
	    }

	    public String getId() {
	        return id;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public EstadoRecurso getEstado() {
	        return estado;
	    }

	    public void setEstado(EstadoRecurso estado) {
	        this.estado = estado;
	    }

	    public abstract String descripcion();
	}

