package model;

/**
 * Clase que representa al operador turistico local encargado de ejecutar un tour.
 * Llanquihue Tour trabaja junto a operadores locales, guias y proveedores de
 * transporte, por lo que cada Tour necesita estar asociado a un operador.
 *
 * Esta clase se utiliza en una relacion de composicion dentro de la clase Tour:
 * un Tour no puede existir sin tener asignado un OperadorTuristico responsable.
 *
 * @author Aurora Conforti
 * @version 1.0
 */
public class OperadorTuristico {

    // ─────────────────────────────────────────────
    // Atributos privados (encapsulamiento)
    // ─────────────────────────────────────────────

    /** Nombre del operador o guia turistico. */
    private String nombre;

    /** Especialidad del operador: gastronomico, lacustre, cultural, aventura. */
    private String especialidad;

    /** Telefono de contacto del operador. */
    private String telefonoContacto;

    /** Anios de experiencia del operador en la zona. */
    private int aniosExperiencia;

    // ─────────────────────────────────────────────
    // Constructor sin parametros
    // ─────────────────────────────────────────────

    /**
     * Constructor por defecto con valores predeterminados.
     */
    public OperadorTuristico() {
        this.nombre           = "Sin asignar";
        this.especialidad     = "General";
        this.telefonoContacto = "Sin contacto";
        this.aniosExperiencia = 0;
    }

    // ─────────────────────────────────────────────
    // Constructor con parametros
    // ─────────────────────────────────────────────

    /**
     * Constructor con parametros para inicializar todos los atributos del operador.
     *
     * @param nombre           Nombre del operador.
     * @param especialidad     Especialidad turistica del operador.
     * @param telefonoContacto Telefono de contacto.
     * @param aniosExperiencia Anios de experiencia en la zona.
     */
    public OperadorTuristico(String nombre, String especialidad,
                              String telefonoContacto, int aniosExperiencia) {
        this.nombre           = nombre;
        this.especialidad     = especialidad;
        this.telefonoContacto = telefonoContacto;
        this.aniosExperiencia = aniosExperiencia;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────

    /** @return nombre del operador. */
    public String getNombre() { return nombre; }

    /** @return especialidad del operador. */
    public String getEspecialidad() { return especialidad; }

    /** @return telefono de contacto del operador. */
    public String getTelefonoContacto() { return telefonoContacto; }

    /** @return anios de experiencia del operador. */
    public int getAniosExperiencia() { return aniosExperiencia; }

    // ─────────────────────────────────────────────
    // Setters
    // ─────────────────────────────────────────────

    /** @param nombre Nombre a asignar. */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @param especialidad Especialidad a asignar. */
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    /** @param telefonoContacto Telefono a asignar. */
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    /** @param aniosExperiencia Anios de experiencia a asignar. */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    // ─────────────────────────────────────────────
    // toString
    // ─────────────────────────────────────────────

    /**
     * Retorna una representacion legible del operador turistico.
     * @return String con los datos del operador.
     */
    @Override
    public String toString() {
        return nombre + " (" + especialidad + ", " + aniosExperiencia + " anios exp., " + telefonoContacto + ")";
    }
}
