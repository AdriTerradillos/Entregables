package biblioteca.app;

import biblioteca.enums.EstadoRecurso;
import biblioteca.interfaces.Prestamista;
import biblioteca.model.RecursoBiblioteca;
import biblioteca.model.Libro;
import biblioteca.model.Revista;
import biblioteca.model.DVD;
import biblioteca.model.Usuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime; // Importar la clase LocalDateTime para manejar fechas y horas

/**
 * Clase que gestiona la biblioteca, implementando la interfaz Prestamista.
 * Contiene la lógica para prestar y devolver recursos, así como para gestionar los usuarios y los recursos.
 */
public class BibliotecaManager implements Prestamista {
    private Map<String, RecursoBiblioteca> recursos;
    private Map<String, Usuario> usuarios;
    private Map<RecursoBiblioteca, Usuario> prestamosActivos;
    private Map<RecursoBiblioteca, String> registroDevoluciones;

    /**
     * Constructor de la clase BibliotecaManager.
     * Inicializa los mapas de recursos, usuarios, préstamos activos y registro de devoluciones.
     */
    public BibliotecaManager() {
        this.recursos = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.prestamosActivos = new HashMap<>();
        this.registroDevoluciones = new HashMap<>();
    }

    /**
     * Agrega un nuevo recurso a la biblioteca.
     *
     * @param recurso El recurso a agregar.
     */
    public void agregarRecurso(RecursoBiblioteca recurso) {
        this.recursos.put(recurso.getId(), recurso);
    }

    /**
     * Agrega un nuevo usuario a la biblioteca.
     *
     * @param usuario El usuario a agregar.
     */
    public void agregarUsuario(Usuario usuario) {
        this.usuarios.put(usuario.getId(), usuario);
    }

    /**
     * Implementación del método prestar de la interfaz Prestamista.
     * Permite prestar un recurso a un usuario si el recurso está disponible y el usuario existe en el registro.
     *
     * @param recurso El recurso a prestar.
     * @param usuario El usuario que tomará prestado el recurso.
     * @return true Si el préstamo se realizó con éxito. En caso contrario, false.
     */
    @Override
    public boolean prestar(RecursoBiblioteca recurso, Usuario usuario) {
        if (recurso == null || usuario == null) {
            System.out.println("Error: Recurso o usuario no válido.");
            return false;
        }
        if (!recursos.containsKey(recurso.getId())) {
            System.out.println("Error: El recurso con Id " + recurso.getId() + " no existe en la biblioteca.");
            return false;
        }
        if (!usuarios.containsKey(usuario.getId())) {
            System.out.println("Error: El usuario con Id " + usuario.getId() + " no está registrado.");
            return false;
        }
        if (recurso.getEstado() == EstadoRecurso.DISPONIBLE) {
            recurso.setEstado(EstadoRecurso.PRESTADO);
            prestamosActivos.put(recurso, usuario);
            System.out.println("Préstamo completado: El recurso '" +
                    recurso.getTitulo() +
                    "' [Id: " + recurso.getId() + "] se ha prestado a " +
                    usuario.getNombre() +
                    " [Id: " + usuario.getId() + "]");
            return true;
        } else {
            System.out.println("Error: El recurso '" + recurso.getTitulo() + "' [Id: " + recurso.getId() + "] "
                    + "no está disponible. ESTADO ACTUAL: " + recurso.getEstado());
            return false;
        }
    }

    /**
     * Implementación del método devolver de la interfaz Prestamista.
     * Permite devolver un recurso previamente prestado.
     *
     * @param recurso El recurso a devolver.
     * @return true Si la devolución se realizó con éxito. En caso contrario, false.
     */
    @Override
    public boolean devolver(RecursoBiblioteca recurso) {
        if (recurso == null) {
            System.out.println("Error: Recurso no válido.");
            return false;
        }
        if (!recursos.containsKey(recurso.getId())) {
            System.out.println("Error: El recurso con Id " + recurso.getId() +
                    " no existe en la biblioteca.");
            return false;
        }
        if (recurso.getEstado() == EstadoRecurso.PRESTADO && prestamosActivos.containsKey(recurso)) {
            recurso.setEstado(EstadoRecurso.DISPONIBLE);
            Usuario usuario = prestamosActivos.remove(recurso);
            registroDevoluciones.put(recurso, LocalDateTime.now().toString()); // Almacenar la fecha y hora de la devolución
            System.out.println("Devolución exitosa: El recurso '" + recurso.getTitulo() + "' [Id: " + recurso.getId() + "] ha sido devuelto por " +
                    usuario.getNombre() + " [Id: " + usuario.getId() + "]");
            return true;
        } else if (recurso.getEstado() == EstadoRecurso.DISPONIBLE) {
            System.out.println("Error: El recurso '" + recurso.getTitulo() + "' [Id: " + recurso.getId() +
                    "] no se encuentra actualmente prestado.");
            return false;
        } else {
            System.out.println("Error: El recurso '" + recurso.getTitulo() + "' [Id: " + recurso.getId() + "] no se encuentra actualmente prestado.");
            return false; // Añadido para manejar el caso donde el libro no está prestado
        }
    }

    /**
     * Lista todos los recursos bibliotecarios con su estado actual.
     */
    public void listarRecursos() {
        System.out.println("\n--- Listado de Recursos ---");
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos registrados en la biblioteca.");
            return;
        }
        for (RecursoBiblioteca recurso : recursos.values()) {
            System.out.println(recurso.descripcion());
        }
        System.out.println("-----------------------------------------\n");
    }

    /**
     * Muestra los recursos que se encuentran actualmente en préstamo.
     */
    public void mostrarRecursosEnPrestamo() {
        System.out.println("\n--- Recursos en Préstamo ---");
        if (prestamosActivos.isEmpty()) {
            System.out.println("No hay recursos actualmente en préstamo.");
            return;
        }
        for (Map.Entry<RecursoBiblioteca, Usuario> entry : prestamosActivos.entrySet()) {
            RecursoBiblioteca recurso = entry.getKey();
            Usuario usuario = entry.getValue();
            System.out.println("[Recurso: " + recurso.getTitulo() + "]" + ", [Id: " + recurso.getId() + "]"
                    + ", [Usuario: " + usuario.getNombre() + "]" + ", [Id: " + usuario.getId() + "]");
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * Muestra el registro de devoluciones de recursos.
     */
    public void mostrarRegistroDevoluciones() {
        System.out.println("\n--- Registro de Devoluciones ---");
        if (registroDevoluciones.isEmpty()) {
            System.out.println("No hay devoluciones registradas.");
            return;
        }
        for (Map.Entry<RecursoBiblioteca, String> entry : registroDevoluciones.entrySet()) {
            RecursoBiblioteca recurso = entry.getKey();
            String fechaHoraDevolucion = entry.getValue(); // Obtener la fecha y hora de la devolución
            System.out.println("[Recurso: " + recurso.getTitulo() + " [Id: " + recurso.getId() + "]" + ", Fecha y Hora de Devolución: " + fechaHoraDevolucion);
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * Método principal que simula la interacción con la biblioteca a través de la consola.
     *
     * @param args Argumentos en línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BibliotecaManager biblioteca = new BibliotecaManager();

        // Crear algunos recursos y usuarios para hacer funcionar el sistema
        Libro libro1 = new Libro("L1-01", "A un pasito de la Gloria", "Adrián Terradillos");
        Libro libro2 = new Libro("L1-02", "El Abad Oscuro", "Jorge Gutierrez Puentes");
        Revista revista1 = new Revista("R2-01", "National Geographic", 245);
        Revista revista2 = new Revista("R2-02", "HOLA!", 21);
        DVD dvd1 = new DVD("D3-01", "Hobbit: La Desolación de Smouth", 3);
        DVD dvd2 = new DVD("D3-02", "La Bella y la Bestia", 2);
        Usuario usuario1 = new Usuario("U0-01", "Miguel Cuevas Salgado");
        Usuario usuario2 = new Usuario("U0-02", "Elena Gutierrez Fuentes");
        Usuario usuario3 = new Usuario("U0-03", "Jaime Fernandez Lopez");
        Usuario usuario4 = new Usuario("U0-04", "Alejandra Herrero Lopez");

        biblioteca.agregarRecurso(libro1);
        biblioteca.agregarRecurso(libro2);
        biblioteca.agregarRecurso(revista1);
        biblioteca.agregarRecurso(revista2);
        biblioteca.agregarRecurso(dvd1);
        biblioteca.agregarRecurso(dvd2);
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.agregarUsuario(usuario3);
        biblioteca.agregarUsuario(usuario4);

        System.out.println("Bienvenidos al Sistema de Gestion de la Biblioteca Municipal de Vaquilla");

        while (true) {
            System.out.println("\n--- Menu de Opciones ---");
            System.out.println("1. Prestar recurso");
            System.out.println("2. Devolver recurso");
            System.out.println("3. Listar recurso");
            System.out.println("4. Mostrar recursos en prestamo");
            System.out.println("5. Mostrar registro de devoluciones");
            System.out.println("6. Salir");

            System.out.print("Ingrese su opcion: ");
            String opcion = scan.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        System.out.print("Ingrese el Id del recurso a prestar: ");
                        String idRecursoPrestar = scan.nextLine();
                        System.out.print("Ingrese el Id del usuario que tomara el prestamo: ");
                        String idUsuarioPrestar = scan.nextLine();
                        RecursoBiblioteca recursoPrestar = biblioteca.recursos.get(idRecursoPrestar);
                        Usuario usuarioPrestar = biblioteca.usuarios.get(idUsuarioPrestar);
                        biblioteca.prestar(recursoPrestar, usuarioPrestar);
                        break;
                    case "2":
                        System.out.print("Ingrese el Id del recurso a devolver: ");
                        String idRecursoDevolver = scan.nextLine();
                        RecursoBiblioteca recursoDevolver = biblioteca.recursos.get(idRecursoDevolver);
                        biblioteca.devolver(recursoDevolver);
                        break;
                    case "3":
                        biblioteca.listarRecursos();
                        break;
                    case "4":
                        biblioteca.mostrarRecursosEnPrestamo();
                        break;
                    case "5":
                        biblioteca.mostrarRegistroDevoluciones();
                        break;
                    case "6":
                        System.out.println("Gracias por utilizar el Sistema de la Biblioteca. ¡Hasta la proxima!");
                        scan.close();
                        return;
                    default:
                        System.out.println("Opcion no valida. Por favor, ingrese un numero del 1 al 6.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }
    }
}

