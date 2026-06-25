package app;

import model.Tour;
import service.GestorTours;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal del sistema de gestion de tours de Llanquihue Tour.
 * Carga los datos desde el archivo tours.txt a traves de GestorTours,
 * muestra el catalogo completo, aplica filtros automaticos y permite
 * al usuario realizar una busqueda interactiva por nombre desde la consola.
 *
 * @author Aurora Conforti
 * @version 2.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   LLANQUIHUE TOUR - Catalogo de Tours");
        System.out.println("   Agencia de Turismo - Region de Los Lagos");
        System.out.println("==========================================");
        System.out.println();

        // ─────────────────────────────────────────
        // Paso 1: Cargar datos desde el archivo TXT
        // ─────────────────────────────────────────
        GestorTours gestor = new GestorTours("resources/tours.txt");
        ArrayList<Tour> listaTours = gestor.cargarTours();

        System.out.println("Total de tours cargados: " + listaTours.size());
        System.out.println();

        if (listaTours.isEmpty()) {
            System.out.println("No hay tours disponibles. Revise el archivo de datos.");
            return;
        }

        // ─────────────────────────────────────────
        // Paso 2: Mostrar todos los tours
        // ─────────────────────────────────────────
        System.out.println("==========================================");
        System.out.println("   TODOS LOS TOURS DISPONIBLES");
        System.out.println("==========================================");
        mostrarListado(listaTours);

        // ─────────────────────────────────────────
        // Paso 3: Filtrar tours GASTRONOMICOS
        // ─────────────────────────────────────────
        System.out.println();
        System.out.println("==========================================");
        System.out.println("   FILTRO: TOURS GASTRONOMICOS");
        System.out.println("==========================================");
        ArrayList<Tour> toursGastronomicos = gestor.filtrarPorTipo("gastronomico");
        mostrarListadoOMensajeVacio(toursGastronomicos, "No se encontraron tours gastronomicos.");

        // ─────────────────────────────────────────
        // Paso 4: Filtrar tours con precio menor a $40.000
        // ─────────────────────────────────────────
        System.out.println();
        System.out.println("==========================================");
        System.out.println("   FILTRO: TOURS CON PRECIO MENOR A $40.000");
        System.out.println("==========================================");
        ArrayList<Tour> toursEconomicos = gestor.filtrarPorPrecioMenorA(40000);
        mostrarListadoOMensajeVacio(toursEconomicos, "No se encontraron tours en ese rango de precio.");

        // ─────────────────────────────────────────
        // Paso 5: Filtrar tours con cupos disponibles mayores a 5
        // ─────────────────────────────────────────
        System.out.println();
        System.out.println("==========================================");
        System.out.println("   FILTRO: TOURS CON MAS DE 5 CUPOS");
        System.out.println("==========================================");
        ArrayList<Tour> toursConCupos = gestor.filtrarPorCuposMayorA(5);
        mostrarListadoOMensajeVacio(toursConCupos, "No se encontraron tours con cupos disponibles.");

        // ─────────────────────────────────────────
        // Paso 6: Busqueda interactiva por nombre
        // ─────────────────────────────────────────
        System.out.println();
        System.out.println("==========================================");
        System.out.println("   BUSQUEDA INTERACTIVA POR NOMBRE");
        System.out.println("==========================================");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese una palabra clave para buscar un tour (o presione Enter para omitir): ");

        try {
            String busqueda = teclado.nextLine();

            if (busqueda != null && !busqueda.trim().isEmpty()) {
                ArrayList<Tour> resultados = gestor.buscarPorNombre(busqueda);
                mostrarListadoOMensajeVacio(resultados,
                        "No se encontraron tours que coincidan con '" + busqueda + "'.");
            } else {
                System.out.println("Busqueda omitida por el usuario.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al leer la busqueda: " + e.getMessage());
        } finally {
            teclado.close();
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("   Fin del catalogo - Llanquihue Tour");
        System.out.println("==========================================");
    }

    // ─────────────────────────────────────────────
    // Metodos auxiliares de presentacion por consola
    // ─────────────────────────────────────────────

    private static void mostrarListado(ArrayList<Tour> tours) {
        for (int i = 0; i < tours.size(); i++) {
            System.out.println("Tour #" + (i + 1));
            System.out.println(tours.get(i).toString());
            System.out.println("------------------------------------------");
        }
    }

    private static void mostrarListadoOMensajeVacio(ArrayList<Tour> tours, String mensajeSiVacio) {
        if (tours.isEmpty()) {
            System.out.println("  " + mensajeSiVacio);
        } else {
            mostrarListado(tours);
            System.out.println("Total encontrados: " + tours.size());
        }
    }
}
