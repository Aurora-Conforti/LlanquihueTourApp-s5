package util;

/**
 * Clase utilitaria que centraliza los metodos de validacion
 * reutilizables en todo el sistema (texto, numeros, formato de lineas).
 *
 * @author Aurora Conforti
 * @version 1.0
 */
public class ValidadorDatos {

    /**
     * Valida que un texto no sea nulo ni este vacio (trim).
     *
     * @param texto Cadena a validar.
     * @return true si el texto es valido, false en caso contrario.
     */
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida que un numero sea positivo (mayor a cero).
     *
     * @param numero Valor a validar.
     * @return true si el numero es positivo, false en caso contrario.
     */
    public static boolean esNumeroPositivo(double numero) {
        return numero > 0;
    }

    /**
     * Valida que un numero entero sea positivo.
     *
     * @param numero Valor a validar.
     * @return true si el numero es positivo, false en caso contrario.
     */
    public static boolean esEnteroPositivo(int numero) {
        return numero > 0;
    }

    /**
     * Valida que una linea leida del archivo tenga la cantidad
     * esperada de campos separados por punto y coma.
     *
     * @param linea              Linea leida del archivo.
     * @param cantidadEsperada   Cantidad de campos esperados.
     * @return true si la linea tiene el formato correcto.
     */
    public static boolean formatoLineaCorrecto(String linea, int cantidadEsperada) {
        if (!esTextoValido(linea)) {
            return false;
        }
        String[] partes = linea.split(";");
        return partes.length == cantidadEsperada;
    }
}
