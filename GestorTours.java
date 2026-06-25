package model;

/**
 * Clase que representa un tour ofrecido por la agencia Llanquihue Tour.
 * Contiene los datos principales del tour: nombre, tipo, precio y cupos disponibles.
 *
 * Aplica una relacion de composicion con la clase OperadorTuristico: cada Tour
 * tiene asignado un operador responsable de ejecutarlo, reflejando la red de
 * colaboracion real entre la agencia y los operadores locales de la zona.
 *
 * @author Aurora Conforti
 * @version 2.0
 */
public class Tour {

    // ─────────────────────────────────────────────
    // Atributos privados (encapsulamiento)
    // ─────────────────────────────────────────────

    /** Nombre descriptivo del tour. */
    private String nombre;

    /** Tipo de tour: gastronomico, lacustre, cultural, aventura, etc. */
    private String tipo;

    /** Precio del tour en pesos chilenos. */
    private int precio;

    /** Cantidad de cupos disponibles para el tour. */
    private int cuposDisponibles;

    /**
     * Operador turistico responsable de ejecutar el tour.
     * Relacion de composicion: un Tour siempre tiene un OperadorTuristico asociado.
     */
    private OperadorTuristico operador;

    // ─────────────────────────────────────────────
    // Constructor sin parametros
    // ─────────────────────────────────────────────

    /**
     * Constructor por defecto con valores predeterminados.
     * El operador se inicializa con sus valores por defecto.
     */
    public Tour() {
        this.nombre           = "Sin nombre";
        this.tipo             = "Sin tipo";
        this.precio           = 0;
        this.cuposDisponibles = 0;
        this.operador         = new OperadorTuristico();
    }

    // ─────────────────────────────────────────────
    // Constructor con parametros
    // ─────────────────────────────────────────────

    /**
     * Constructor con parametros para inicializar todos los atributos del tour,
     * incluyendo el operador turistico asociado.
     *
     * @param nombre           Nombre del tour.
     * @param tipo             Tipo de tour.
     * @param precio           Precio en pesos chilenos.
     * @param cuposDisponibles Cupos disponibles.
     * @param operador         Operador turistico responsable del tour.
     */
    public Tour(String nombre, String tipo, int precio, int cuposDisponibles,
                OperadorTuristico operador) {
        this.nombre           = nombre;
        this.tipo             = tipo;
        this.precio           = precio;
        this.cuposDisponibles = cuposDisponibles;
        this.operador         = operador;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────

    /** @return nombre del tour. */
    public String getNombre() { return nombre; }

    /** @return tipo del tour. */
    public String getTipo() { return tipo; }

    /** @return precio del tour. */
    public int getPrecio() { return precio; }

    /** @return cupos disponibles del tour. */
    public int getCuposDisponibles() { return cuposDisponibles; }

    /** @return operador turistico asociado al tour. */
    public OperadorTuristico getOperador() { return operador; }

    // ─────────────────────────────────────────────
    // Setters
    // ─────────────────────────────────────────────

    /** @param nombre Nombre a asignar. */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @param tipo Tipo a asignar. */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Establece el precio del tour, validando que sea un valor positivo.
     * @param precio Precio a asignar.
     */
    public void setPrecio(int precio) {
        try {
            if (precio < 0) {
                throw new IllegalArgumentException("El precio no puede ser negativo.");
            }
            this.precio = precio;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al asignar precio: " + e.getMessage());
            this.precio = 0;
        }
    }

    /**
     * Establece los cupos disponibles del tour, validando que sea un valor positivo.
     * @param cuposDisponibles Cupos a asignar.
     */
    public void setCuposDisponibles(int cuposDisponibles) {
        try {
            if (cuposDisponibles < 0) {
                throw new IllegalArgumentException("Los cupos no pueden ser negativos.");
            }
            this.cuposDisponibles = cuposDisponibles;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al asignar cupos: " + e.getMessage());
            this.cuposDisponibles = 0;
        }
    }

    /** @param operador Operador turistico a asignar. */
    public void setOperador(OperadorTuristico operador) { this.operador = operador; }

    // ─────────────────────────────────────────────
    // toString
    // ─────────────────────────────────────────────

    /**
     * Retorna una representacion legible del tour, incluyendo los datos
     * del operador turistico asociado (relacion de composicion).
     * @return String con los datos del tour.
     */
    @Override
    public String toString() {
        return "  Nombre   : " + nombre +
               "\n  Tipo     : " + tipo +
               "\n  Precio   : $" + String.format("%,d", precio) +
               "\n  Cupos    : " + cuposDisponibles +
               "\n  Operador : " + operador.toString();
    }
}
