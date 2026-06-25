package model;

/**
 * Clase que representa un tour turistico ofrecido por Llanquihue Tour.
 * Contiene una relacion de composicion con OperadorTuristico, ya que
 * un tour no puede existir sin un operador responsable asignado.
 *
 * @author Aurora Conforti
 * @version 1.0
 */
public class Tour {

    private String nombre;
    private String tipo;
    private double precio;
    private int cuposDisponibles;
    private OperadorTuristico operador;  // Composicion

    // ─────────────────────────────────────────
    // Constructores
    // ─────────────────────────────────────────

    public Tour() {
    }

    public Tour(String nombre, String tipo, double precio,
                int cuposDisponibles, OperadorTuristico operador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cuposDisponibles = cuposDisponibles;
        this.operador = operador;
    }

    // ─────────────────────────────────────────
    // Getters y Setters
    // ─────────────────────────────────────────

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public OperadorTuristico getOperador() {
        return operador;
    }

    public void setOperador(OperadorTuristico operador) {
        this.operador = operador;
    }

    // ─────────────────────────────────────────
    // Representacion en texto
    // ─────────────────────────────────────────

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Tipo: " + tipo + "\n" +
               "Precio: $" + precio + "\n" +
               "Cupos disponibles: " + cuposDisponibles + "\n" +
               "Operador: " + operador;
    }
}
