package util;

import java.io.File;
import java.util.Scanner;

/**
 * Clase utilitaria que centraliza los métodos de validación 
 * reutilizables en todo el sistema.
 *
 * @author Aurora Conforti
 * @version 2.0
 */
public class ValidadorDatos {

    // ─────────────────────────────────────────
    // Validaciones de Texto y Formatos
    // ─────────────────────────────────────────

    /**
     * Valida que un texto no sea nulo ni esté vacío (trim).
     */
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida que una línea leída del archivo tenga la cantidad 
     * esperada de campos separados por punto y coma.
     */
    public static boolean formatoLineaCorrecto(String linea, int cantidadEsperada) {
        if (!esTextoValido(linea)) {
            return false;
        }
        String[] partes = linea.split(";");
        return partes.length == cantidadEsperada;
    }

    // ─────────────────────────────────────────
    // Validaciones Numéricas
    // ─────────────────────────────────────────

    /**
     * Valida que un número decimal sea estrictamente positivo.
     */
    public static boolean esNumeroPositivo(double numero) {
        return numero > 0;
    }

    /**
     * Valida que un número entero sea estrictamente positivo.
     */
    public static boolean esEnteroPositivo(int numero) {
        return numero > 0;
    }

    /**
     * Valida que un número entero esté dentro de un rango específico (inclusivo).
     * @param min Valor mínimo permitido.
     * @param max Valor máximo permitido.
     */
    public static boolean estaEnRango(int numero, int min, int max) {
        return numero >= min && numero <= max;
    }

    // ─────────────────────────────────────────
    // Validaciones de Archivos
    // ─────────────────────────────────────────

    /**
     * Verifica si un archivo existe en la ruta especificada.
     * @param ruta Ruta del archivo a verificar.
     * @return true si el archivo existe y es legible.
     */
    public static boolean existeArchivo(String ruta) {
        File archivo = new File(ruta);
        return archivo.exists() && archivo.isFile() && archivo.canRead();
    }

    // ────────────────────────────────────────
    // Validaciones de Entrada de Usuario (Consola)
    // ─────────────────────────────────────────

    /**
     * Lee un número entero positivo desde la consola, validando 
     * que el usuario no ingrese letras o números negativos.
     * Se repite la petición hasta que el dato sea válido.
     * 
     * @param scanner Objeto Scanner activo.
     * @param mensaje Mensaje a mostrar al usuario.
     * @return El número entero válido ingresado.
     */
    public static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean valido = false;
        
        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine().trim());
                if (esEnteroPositivo(numero)) {
                    valido = true;
                } else {
                    System.out.println("⚠️ Error: El número debe ser mayor a 0. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("️ Error: Debe ingresar un número válido (sin letras ni símbolos).");
            }
        }
        return numero;
    }

    /**
     * Lee un texto no vacío desde la consola.
     */
    public static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        String texto = "";
        boolean valido = false;
        
        while (!valido) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (esTextoValido(texto)) {
                valido = true;
            } else {
                System.out.println("⚠️ Error: El texto no puede estar vacío. Intente nuevamente.");
            }
        }
        return texto;
    }
}
