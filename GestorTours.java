package service;

import model.OperadorTuristico;
import model.Tour;
import util.ValidadorDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase de servicio encargada de cargar los tours desde el archivo
 * tours.txt, validar los datos y ofrecer operaciones de filtrado
 * y busqueda sobre el catalogo.
 *
 * @author Aurora Conforti
 * @version 1.0
 */
public class GestorTours {

    private String rutaArchivo;
    private ArrayList<Tour> tours;

    // ─────────────────────────────────────────
    // Constructores
    // ─────────────────────────────────────────

    public GestorTours(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.tours = new ArrayList<>();
    }

    // ─────────────────────────────────────────
    // Carga de datos
    // ─────────────────────────────────────────

    /**
     * Carga los tours desde el archivo TXT.
     * Formato esperado: nombre;tipo;precio;cupos;nombreOperador;especialidadOperador
     *
     * @return Lista de tours cargados correctamente.
     */
    public ArrayList<Tour> cargarTours() {
        tours.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                procesarLinea(linea, numeroLinea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return tours;
    }

    /**
     * Procesa una linea individual del archivo, validando su formato
     * y los datos contenidos antes de crear el objeto Tour.
     */
    private void procesarLinea(String linea, int numeroLinea) {
        if (!ValidadorDatos.formatoLineaCorrecto(linea, 6)) {
            System.out.println("Linea " + numeroLinea + " ignorada: formato incorrecto.");
            return;
        }

        String[] datos = linea.split(";");
        try {
            String nombre = datos[0].trim();
            String tipo = datos[1].trim();
            double precio = Double.parseDouble(datos[2].trim());
            int cupos = Integer.parseInt(datos[3].trim());
            String nombreOperador = datos[4].trim();
            String especialidad = datos[5].trim();

            if (!ValidadorDatos.esTextoValido(nombre)
                    || !ValidadorDatos.esTextoValido(tipo)
                    || !ValidadorDatos.esNumeroPositivo(precio)
                    || !ValidadorDatos.esEnteroPositivo(cupos)
                    || !ValidadorDatos.esTextoValido(nombreOperador)) {
                System.out.println("Linea " + numeroLinea + " ignorada: datos invalidos.");
                return;
            }

            OperadorTuristico operador = new OperadorTuristico(nombreOperador, especialidad);
            Tour tour = new Tour(nombre, tipo, precio, cupos, operador);
            tours.add(tour);

        } catch (NumberFormatException e) {
            System.out.println("Linea " + numeroLinea + " ignorada: error en formato numerico.");
        }
    }

    // ─────────────────────────────────────────
    // Metodos de filtrado
    // ─────────────────────────────────────────

    /**
     * Filtra los tours por tipo (sin distinguir mayusculas).
     */
    public ArrayList<Tour> filtrarPorTipo(String tipo) {
        ArrayList<Tour> resultado = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(tour);
            }
        }
        return resultado;
    }

    /**
     * Filtra los tours con precio menor al valor indicado.
     */
    public ArrayList<Tour> filtrarPorPrecioMenorA(double precioMaximo) {
        ArrayList<Tour> resultado = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrecio() < precioMaximo) {
                resultado.add(tour);
            }
        }
        return resultado;
    }

    /**
     * Filtra los tours con cupos disponibles mayores al valor indicado.
     */
    public ArrayList<Tour> filtrarPorCuposMayorA(int cuposMinimos) {
        ArrayList<Tour> resultado = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getCuposDisponibles() > cuposMinimos) {
                resultado.add(tour);
            }
        }
        return resultado;
    }

    // ─────────────────────────────────────────
    // Metodos de busqueda
    // ─────────────────────────────────────────

    /**
     * Busca tours cuyo nombre contenga la palabra clave
     * (sin distinguir mayusculas).
     */
    public ArrayList<Tour> buscarPorNombre(String palabraClave) {
        ArrayList<Tour> resultado = new ArrayList<>();
        String clave = palabraClave.toLowerCase();
        for (Tour tour : tours) {
            if (tour.getNombre().toLowerCase().contains(clave)) {
                resultado.add(tour);
            }
        }
        return resultado;
    }
}
